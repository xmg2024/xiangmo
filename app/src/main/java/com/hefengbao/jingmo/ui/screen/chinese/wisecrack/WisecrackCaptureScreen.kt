/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.ui.screen.chinese.wisecrack

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hefengbao.jingmo.data.database.entity.chinese.WisecrackEntity
import com.hefengbao.jingmo.ui.component.CaptureScaffold
import com.hefengbao.jingmo.data.model.traditionalculture.Color as ChineseColor

@Composable
fun ChineseWisecrackCaptureRoute(
    viewModel: WisecrackCaptureViewModel = hiltViewModel(),
    onBackClick: () -> Unit
) {
    val chineseWisecrack by viewModel.chineseWisecrack.collectAsState()
    val chineseColors by viewModel.colors.collectAsState(initial = emptyList())
    val appStatus by viewModel.appStatus.collectAsState(null)

    LaunchedEffect(Unit) {
        viewModel.getColors()
    }

    appStatus?.let { status ->
        ChineseWisecrackCaptureScreen(
            onBackClick = onBackClick,
            chineseWisecrack = chineseWisecrack,
            textColor = status.captureTextColor,
            onTextColorChange = { viewModel.setCaptureColor(it) },
            backgroundColor = status.captureBackgroundColor,
            onBackgroundColorChange = { viewModel.setCaptureBackgroundColor(it) },
            colors = chineseColors
        )
    }
}

@Composable
private fun ChineseWisecrackCaptureScreen(
    onBackClick: () -> Unit,
    textColor: String,
    onTextColorChange: (String) -> Unit,
    backgroundColor: String,
    onBackgroundColorChange: (String) -> Unit,
    chineseWisecrack: WisecrackEntity?,
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
        chineseWisecrack?.let { entity ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 96.dp, horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = entity.riddle,
                    style = MaterialTheme.typography.bodyLarge,
                    color = tColor
                )
                Text(
                    text = "—— ${entity.answer}",
                    style = MaterialTheme.typography.bodyLarge,
                    color = tColor
                )
            }
        }
    }
}