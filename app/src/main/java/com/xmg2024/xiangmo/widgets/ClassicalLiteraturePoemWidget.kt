/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.widgets

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
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import com.xmg2024.xiangmo.data.repository.classicalliterature.WritingRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ClassicalLiteraturePoemWidgetReceiver : GlanceAppWidgetReceiver() {

    @Inject
    lateinit var repository: WritingRepository

    override val glanceAppWidget: GlanceAppWidget
        get() = PoemWidget(repository)
}

class PoemWidget(
    val repository: WritingRepository
) : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {

        provideContent {
            GlanceTheme {
                Content()
            }
        }
    }

    @Composable
    private fun Content(modifier: GlanceModifier = GlanceModifier) {
        val poem by repository.get((1..1000000).random()).collectAsState(initial = null)

        Column(
            modifier = modifier.fillMaxSize()
                .background(GlanceTheme.colors.background)
                .padding(16.dp)
                .cornerRadius(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            poem?.let {
                val content = buildString {
                    it.clauses.mapIndexed { index, clause ->
                        if (it.type == "词") {// 词
                            append(clause.content)
                        } else { //律诗 绝句
                            append(clause.content)

                            if (index % 2 == 1) {
                                append("\n")
                            }
                        }
                        if (clause.breakAfter != null) {
                            append("\n")
                        }
                    }
                }
                LazyColumn(
                    horizontalAlignment = Alignment.Horizontal.CenterHorizontally,
                ) {
                    item {
                        Text(
                            text = it.title.content,
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = GlanceTheme.colors.onBackground
                            )
                        )
                    }
                    item {
                        Text(
                            modifier = modifier.padding(top = 8.dp),
                            text = "${it.dynasty}·${it.author}",
                            style = TextStyle(
                                fontSize = 12.sp,
                                color = GlanceTheme.colors.onBackground
                            )
                        )
                    }
                    item {
                        Text(
                            modifier = modifier.padding(top = 8.dp),
                            text = content,
                            style = TextStyle(
                                fontSize = 18.sp,
                                color = GlanceTheme.colors.onBackground
                            )
                        )
                    }
                }
            }
        }
    }
}