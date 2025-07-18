/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.classicalliterature.writing

import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.xmg2024.xiangmo.data.database.entity.classicalliterature.WritingEntity
import com.xmg2024.xiangmo.data.model.AppStatus
import com.xmg2024.xiangmo.ui.component.CaptureScaffold
import com.xmg2024.xiangmo.data.model.traditionalculture.Color as ChineseColor

@Composable
fun WritingCaptureRoute(
    viewModel: WritingCaptureViewModel = hiltViewModel(),
    onBackClick: () -> Unit
) {
    val writing by viewModel.writing.collectAsState()
    val chineseColors by viewModel.colors.collectAsState(initial = emptyList())
    val appStatus by viewModel.appStatus.collectAsState(null)

    LaunchedEffect(Unit) {
        viewModel.getColors()
    }

    appStatus?.let { status: AppStatus ->
        Log.i("WritingCaptureRoute", appStatus.toString())
        WritingCaptureScreen(
            onBackClick = onBackClick,
            writing = writing,
            textColor = status.captureTextColor,
            onTextColorChange = { viewModel.setCaptureColor(it) },
            backgroundColor = status.captureBackgroundColor,
            onBackgroundColorChange = { viewModel.setCaptureBackgroundColor(it) },
            colors = chineseColors
        )
    }
}

@Composable
private fun WritingCaptureScreen(
    onBackClick: () -> Unit,
    textColor: String,
    onTextColorChange: (String) -> Unit,
    backgroundColor: String,
    onBackgroundColorChange: (String) -> Unit,
    writing: WritingEntity?,
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

        Log.i("WritingCaptureScreen", "颜色改变了, $textColor, $tColor")
        writing?.let { entity ->
            val content = buildString {
                entity.clauses.mapIndexed { _, clause ->
                    if (entity.type != "文") {
                        append(clause.content)
                        append("\n")
                    } else {
                        append(clause.content)
                    }

                    if (clause.breakAfter != null) {
                        append("\n")
                    }
                }
            }
            Text(
                text = entity.title.content,
                style = MaterialTheme.typography.titleLarge,
                color = tColor
            )
            Text(
                text = "${entity.dynasty}·${entity.author}",
                style = MaterialTheme.typography.titleSmall,
                color = tColor
            )
            Text(
                text = content,
                style = MaterialTheme.typography.bodyLarge,
                color = tColor
            )
        }
    }
}