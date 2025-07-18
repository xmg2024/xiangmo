/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.knowledge

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.xmg2024.xiangmo.data.database.entity.chinese.KnowledgeCollectionEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.KnowledgeEntity
import com.xmg2024.xiangmo.ui.component.SimpleScaffold
import com.xmg2024.xiangmo.ui.screen.chinese.knowledge.components.KnowledgePanel

@Composable
fun KnowledgeShowRoute(
    viewModel: KnowledgeShowViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
) {
    val knowledgeEntity by viewModel.knowledgeEntity.collectAsState(initial = null)
    val knowledgeCollectionEntity by viewModel.knowledgeCollectionEntity.collectAsState(initial = null)

    LyricShowScreen(
        onBackClick = onBackClick,
        knowledgeEntity = knowledgeEntity,
        knowledgeCollectionEntity = knowledgeCollectionEntity,
        setCollect = { viewModel.collect(it) },
        setUncollect = { viewModel.uncollect(it) }
    )
}

@Composable
private fun LyricShowScreen(
    onBackClick: () -> Unit,
    knowledgeEntity: KnowledgeEntity?,
    knowledgeCollectionEntity: KnowledgeCollectionEntity?,
    setCollect: (Int) -> Unit,
    setUncollect: (Int) -> Unit,
) {
    knowledgeEntity?.let { entity ->
        SimpleScaffold(
            onBackClick = onBackClick,
            title = "知识卡片",
            bottomBar = {
                BottomAppBar {
                    Row(
                        modifier = Modifier.padding(horizontal = 16.dp)
                    ) {
                        if (knowledgeCollectionEntity == null) {
                            IconButton(onClick = { setCollect(entity.id) }) {
                                Icon(
                                    imageVector = Icons.Default.BookmarkBorder,
                                    contentDescription = null
                                )
                            }
                        } else {
                            IconButton(onClick = { setUncollect(entity.id) }) {
                                Icon(
                                    imageVector = Icons.Default.Bookmark,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.primary
                                )
                            }
                        }
                    }
                }
            }
        ) {
            KnowledgePanel(entity = entity)
        }
    }
}