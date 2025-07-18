/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.knowledge

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ReadMore
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Bookmarks
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
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
import kotlin.math.abs

@Composable
fun ChineseKnowledgeIndexRoute(
    viewModel: KnowledgeIndexViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
    onSearchClick: () -> Unit,
    onBookmarksClick: () -> Unit,
    onReadMoreClick: () -> Unit,
) {
    val knowledgeEntity by viewModel.knowledgeEntity.collectAsState(initial = null)
    val knowledgeCollectionEntity by viewModel.knowledgeCollectionEntity.collectAsState(initial = null)

    ChineseKnowledgeReadScreen(
        onBackClick = onBackClick,
        onBookmarksClick = onBookmarksClick,
        onReadMoreClick = onReadMoreClick,
        onSearchClick = onSearchClick,
        knowledgeEntity = knowledgeEntity,
        knowledgeCollectionEntity = knowledgeCollectionEntity,
        setCollect = { viewModel.collect(it) },
        setUncollect = { viewModel.uncollect(it) },
        isCollect = { viewModel.isCollect(it) },
        refresh = { viewModel.random() }
    )
}

@Composable
private fun ChineseKnowledgeReadScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onBookmarksClick: () -> Unit,
    onReadMoreClick: () -> Unit,
    onSearchClick: () -> Unit,
    knowledgeEntity: KnowledgeEntity?,
    knowledgeCollectionEntity: KnowledgeCollectionEntity?,
    setCollect: (Int) -> Unit,
    setUncollect: (Int) -> Unit,
    isCollect: (Int) -> Unit,
    refresh: () -> Unit,
) {
    SimpleScaffold(
        onBackClick = onBackClick,
        title = "知识卡片",
        actions = {
            IconButton(onClick = onBookmarksClick) {
                Icon(imageVector = Icons.Outlined.Bookmarks, contentDescription = "收藏夹")
            }
            IconButton(onClick = onReadMoreClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.ReadMore,
                    contentDescription = "进入阅读"
                )
            }
            IconButton(onClick = onSearchClick) {
                Icon(imageVector = Icons.Default.Search, contentDescription = "搜索")
            }
        },
        bottomBar = {
            knowledgeEntity?.let { entity ->
                BottomAppBar(
                    actions = {
                        Row(
                            modifier = modifier.padding(horizontal = 16.dp)
                        ) {
                            if (knowledgeCollectionEntity != null) {
                                IconButton(onClick = { setUncollect(entity.id) }) {
                                    Icon(
                                        imageVector = Icons.Default.Bookmark,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.primary
                                    )
                                }
                            } else {
                                IconButton(onClick = { setCollect(entity.id) }) {
                                    Icon(
                                        imageVector = Icons.Default.BookmarkBorder,
                                        contentDescription = null
                                    )
                                }
                            }
                        }
                    },
                    floatingActionButton = {
                        FloatingActionButton(onClick = refresh) {
                            Icon(imageVector = Icons.Default.Refresh, contentDescription = "")
                        }
                    }
                )
            }
        }
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .draggable(
                    state = rememberDraggableState {},
                    orientation = Orientation.Horizontal,
                    onDragStarted = {},
                    onDragStopped = {
                        if (it < 0 && abs(it) > 500f) {
                            refresh()
                        } else if (it > 0 && abs(it) > 500f) {
                            refresh()
                        }
                    }
                )
        ) {
            knowledgeEntity?.let { entity ->
                isCollect(entity.id)
                KnowledgePanel(entity = entity)
            }
        }
    }
}