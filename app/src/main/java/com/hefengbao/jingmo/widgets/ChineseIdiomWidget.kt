/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.widgets

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.cornerRadius
import androidx.glance.appwidget.lazy.LazyColumn
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.padding
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import com.hefengbao.jingmo.data.repository.chinese.IdiomRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ChineseIdiomWidgetReceiver : GlanceAppWidgetReceiver() {

    @Inject
    lateinit var repository: IdiomRepository

    override val glanceAppWidget: GlanceAppWidget
        get() = IdiomWidget(repository)
}

class IdiomWidget(
    val repository: IdiomRepository
) : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            Content()
        }
    }

    @Composable
    private fun Content(modifier: GlanceModifier = GlanceModifier) {
        val idiom by repository.random().collectAsState(initial = null)
        Column(
            modifier = modifier.fillMaxSize()
                .background(GlanceTheme.colors.background)
                .padding(16.dp)
                .cornerRadius(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            idiom?.let { entity ->
                LazyColumn {
                    item {
                        Text(
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = GlanceTheme.colors.onBackground
                            ),
                            text = entity.pinyin
                        )
                    }
                    item {
                        Text(
                            modifier = modifier.padding(4.dp),
                            style = TextStyle(
                                fontSize = 18.sp,
                                color = GlanceTheme.colors.onBackground
                            ),
                            text = entity.word
                        )
                    }
                    item {
                        entity.explanation?.let {
                            Text(
                                modifier = modifier.padding(top = 8.dp),
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    color = GlanceTheme.colors.onBackground
                                ),
                                text = it
                            )
                        }
                    }
                }
            }
        }
    }
}