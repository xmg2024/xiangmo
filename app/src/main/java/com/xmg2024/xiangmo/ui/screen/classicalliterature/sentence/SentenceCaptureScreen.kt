/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.classicalliterature.sentence

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.xmg2024.xiangmo.data.database.entity.classicalliterature.SentenceEntity
import com.xmg2024.xiangmo.ui.component.CaptureScaffold
import com.xmg2024.xiangmo.data.model.traditionalculture.Color as ChineseColor

@Composable
fun SentenceCaptureRoute(
    viewModel: SentenceCaptureViewModel = hiltViewModel(),
    onBackClick: () -> Unit
) {
    val sentence by viewModel.sentence.collectAsState(initial = null)
    val chineseColors by viewModel.colors.collectAsState(initial = emptyList())
    val appStatus by viewModel.appStatus.collectAsState(null)

    LaunchedEffect(Unit) {
        viewModel.getColors()
    }

    appStatus?.let { status ->
        SentenceCaptureScreen(
            onBackClick = onBackClick,
            sentence = sentence,
            textColor = status.captureTextColor,
            onTextColorChange = { viewModel.setCaptureColor(it) },
            backgroundColor = status.captureBackgroundColor,
            onBackgroundColorChange = { viewModel.setCaptureBackgroundColor(it) },
            colors = chineseColors
        )
    }
}

@Composable
private fun SentenceCaptureScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    textColor: String,
    onTextColorChange: (String) -> Unit,
    backgroundColor: String,
    onBackgroundColorChange: (String) -> Unit,
    sentence: SentenceEntity?,
    colors: List<ChineseColor>
) {
    CaptureScaffold(
        colors = colors,
        onBackClick = onBackClick,
        textColor = textColor,
        onTextColorChange = onTextColorChange,
        backgroundColor = backgroundColor,
        onBackgroundColorChange = onBackgroundColorChange
    ) {
        val tColor = if (textColor == "white") Color.White else Color.Black

        sentence?.let { entity ->
            Row(
                modifier = modifier
                    .fillMaxSize()
                    .padding(vertical = 64.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    entity.content.split("，", "。", "？", "！").map {

                        Column {
                            it.toCharArray().map { char ->
                                Text(
                                    text = char.toString(),
                                    style = TextStyle.Default.copy(fontSize = 24.sp),
                                    color = tColor
                                )
                            }
                        }
                    }
                }
                Column {
                    entity.from.replace("《", "﹁")
                        .replace("》", "﹂")
                        .toCharArray()
                        .map {
                            Text(text = it.toString(), color = tColor)
                        }
                }
            }
        }
    }
}