/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.traditionalculture.color

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import androidx.hilt.navigation.compose.hiltViewModel
import com.xmg2024.xiangmo.common.util.ClipboardUtil
import com.xmg2024.xiangmo.ui.component.SimpleScaffold
import com.xmg2024.xiangmo.data.model.traditionalculture.Color as ChineseColor

@Composable
fun ColorShowRoute(
    viewModel: ColorShowViewModel = hiltViewModel(),
    onBackClick: () -> Unit
) {
    val chineseColor by viewModel.color.collectAsState(initial = null)
    ColorShowScreen(
        onBackClick = onBackClick,
        color = chineseColor
    )
}

@Composable
private fun ColorShowScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    color: ChineseColor?
) {
    color?.let {
        SimpleScaffold(
            onBackClick = onBackClick,
            title = color.name
        ) {
            val context = LocalContext.current
            Card(
                modifier = modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .clickable {
                        ClipboardUtil.textCopyThenPost(context, color.hex)
                    },
                colors = CardDefaults.cardColors(
                    containerColor = Color(color.hex.toColorInt())
                )
            ) {
                val fontColor = if (color.isBright) Color.Black else Color.White

                Column(
                    modifier = modifier.padding(32.dp)
                ) {
                    Text(
                        text = color.pinyin,
                        color = fontColor
                    )
                    Text(
                        text = "${color.name}（${color.traName}）",
                        style = MaterialTheme.typography.titleLarge,
                        color = fontColor
                    )
                    Column(
                        modifier = modifier
                            .padding(top = 48.dp)
                            .width(150.dp)
                    ) {
                        Row {
                            Text(
                                text = "C",
                                modifier = modifier.weight(1f),
                                color = fontColor,
                                fontStyle = FontStyle.Italic
                            )
                            Text(
                                text = color.cmyk[0].toString(),
                                modifier = modifier.weight(3f),
                                textAlign = TextAlign.End,
                                color = fontColor,
                                fontWeight = FontWeight.ExtraBold
                            )
                        }
                        Row {
                            Text(
                                text = "M",
                                modifier = modifier.weight(1f),
                                color = fontColor,
                                fontStyle = FontStyle.Italic
                            )
                            Text(
                                text = color.cmyk[1].toString(),
                                modifier = modifier.weight(3f),
                                textAlign = TextAlign.End,
                                color = fontColor,
                                fontWeight = FontWeight.ExtraBold
                            )
                        }
                        Row {
                            Text(
                                text = "Y",
                                modifier = modifier.weight(1f),
                                color = fontColor,
                                fontStyle = FontStyle.Italic
                            )
                            Text(
                                text = color.cmyk[2].toString(),
                                modifier = modifier.weight(3f),
                                textAlign = TextAlign.End,
                                color = fontColor,
                                fontWeight = FontWeight.ExtraBold
                            )
                        }
                        Row {
                            Text(
                                text = "K",
                                modifier = modifier.weight(1f),
                                color = fontColor,
                                fontStyle = FontStyle.Italic
                            )
                            Text(
                                text = color.cmyk[3].toString(),
                                modifier = modifier.weight(3f),
                                textAlign = TextAlign.End,
                                color = fontColor,
                                fontWeight = FontWeight.ExtraBold
                            )
                        }
                    }
                    Column(
                        modifier = modifier
                            .padding(top = 16.dp)
                            .width(150.dp)
                    ) {
                        Row {
                            Text(
                                text = "R",
                                modifier = modifier.weight(1f),
                                color = fontColor,
                                fontStyle = FontStyle.Italic
                            )
                            Text(
                                text = color.rgb[0].toString(),
                                modifier = modifier.weight(3f),
                                textAlign = TextAlign.End,
                                color = fontColor,
                                fontWeight = FontWeight.ExtraBold
                            )
                        }
                        Row {
                            Text(
                                text = "G",
                                modifier = modifier.weight(1f),
                                color = fontColor,
                                fontStyle = FontStyle.Italic
                            )
                            Text(
                                text = color.rgb[1].toString(),
                                modifier = modifier.weight(3f),
                                textAlign = TextAlign.End,
                                color = fontColor,
                                fontWeight = FontWeight.ExtraBold
                            )
                        }
                        Row {
                            Text(
                                text = "B",
                                modifier = modifier.weight(1f),
                                color = fontColor,
                                fontStyle = FontStyle.Italic
                            )
                            Text(
                                text = color.rgb[2].toString(),
                                modifier = modifier.weight(3f),
                                textAlign = TextAlign.End,
                                color = fontColor,
                                fontWeight = FontWeight.ExtraBold
                            )
                        }
                    }

                    Row(
                        modifier = modifier
                            .padding(top = 16.dp)
                            .width(150.dp),
                    ) {
                        Text(
                            text = "HEX",
                            modifier = modifier.weight(1f),
                            color = fontColor,
                            fontStyle = FontStyle.Italic
                        )
                        Text(
                            modifier = modifier.weight(3f),
                            text = color.hex,
                            color = fontColor,
                            fontWeight = FontWeight.ExtraBold,
                            textAlign = TextAlign.End
                        )
                    }
                }
            }
        }
    }
}