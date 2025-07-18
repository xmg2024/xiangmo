/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.character

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.xmg2024.xiangmo.common.util.ClipboardUtil
import com.xmg2024.xiangmo.data.database.entity.chinese.DictionaryCollectionEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.DictionaryEntity
import com.xmg2024.xiangmo.ui.component.BackgroundTitle
import com.xmg2024.xiangmo.ui.component.SimpleScaffold

@Composable
fun CharacterShowRoute(
    viewModel: CharacterShowViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
) {
    val character by viewModel.character.collectAsState()
    val characterCollection by viewModel.characterCollection.collectAsState()
    val context = LocalContext.current

    CharacterShowScreen(
        context = context,
        onBackClick = onBackClick,
        character = character,
        characterCollection = characterCollection,
        setUncollect = { viewModel.setUncollect(it) },
        setCollect = { viewModel.setCollect(it) }
    )
}

@Composable
private fun CharacterShowScreen(
    modifier: Modifier = Modifier,
    context: Context,
    onBackClick: () -> Unit,
    character: DictionaryEntity?,
    characterCollection: DictionaryCollectionEntity?,
    setUncollect: (Int) -> Unit,
    setCollect: (Int) -> Unit
) {
    character?.let { entity ->
        SimpleScaffold(
            onBackClick = onBackClick,
            title = entity.char,
            bottomBar = {
                BottomAppBar {
                    Row(
                        modifier = Modifier.padding(horizontal = 16.dp)
                    ) {
                        IconButton(
                            onClick = {
                                if (characterCollection != null) {
                                    setUncollect(entity.id)
                                } else {
                                    setCollect(entity.id)
                                }
                            }
                        ) {
                            if (characterCollection != null) {
                                Icon(
                                    imageVector = Icons.Default.Bookmark,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.primary
                                )
                            } else {
                                Icon(
                                    imageVector = Icons.Default.BookmarkBorder,
                                    contentDescription = null
                                )
                            }
                        }
                    }
                }
            }
        ) {
            LazyColumn(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = entity.char, style = MaterialTheme.typography.displayLarge)
                        IconButton(
                            onClick = {
                                ClipboardUtil.textCopyThenPost(context, entity.char)
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.ContentCopy,
                                contentDescription = "复制"
                            )
                        }
                    }
                }
                item {
                    SelectionContainer {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            entity.pinyin?.let {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                                ) {
                                    BackgroundTitle(title = "拼音")
                                    Text(text = it)
                                }
                            }
                            entity.wubi?.let {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                                ) {
                                    BackgroundTitle(title = "五笔")
                                    Text(text = it)
                                }
                            }
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                BackgroundTitle(title = "总笔画")
                                Text(text = "${entity.stroke}画")
                            }
                        }
                    }
                }
                entity.simpleExplanation?.let {
                    item {
                        SelectionContainer {
                            Column(
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                BackgroundTitle(title = "简要释义")
                                Text(
                                    text = it.replace("<br><br><br>", "")
                                        .replace("<br><br>", "<br>")
                                        .replace("<br>", "\n\n")
                                )
                                Text(
                                    text = "💡 1 - 横，2 - 竖，3 - 撇，4 -捺，5 - 折，提为横，点为捺，竖勾为竖，横折为折，竖提为折。",
                                    style = MaterialTheme.typography.labelMedium
                                )
                            }
                        }
                    }
                }
                entity.explanation?.let {
                    item {
                        SelectionContainer {
                            Column(
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                BackgroundTitle(title = "详细释义")
                                Text(
                                    text = it.replace("<br><br><br>", "")
                                        .replace("<br><br>", "<br>")
                                        .replace("<br>", "\n\n")
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}