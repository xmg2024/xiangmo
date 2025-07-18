/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.idiom

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ReadMore
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.xmg2024.xiangmo.data.database.entity.chinese.IdiomCollectionEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.IdiomEntity
import com.xmg2024.xiangmo.ui.component.SimpleScaffold
import com.xmg2024.xiangmo.ui.screen.chinese.idiom.components.IdiomPanel
import kotlin.math.abs

@Composable
fun IdiomIndexRoute(
    viewModel: IdiomIndexViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
    onReadMoreClick: () -> Unit,
    onBookmarksClick: () -> Unit,
    onSearchClick: () -> Unit,
) {
    val idiom by viewModel.idiom.collectAsState(initial = null)
    val idiomCollectionEntity by viewModel.idiomCollectionEntity.collectAsState(initial = null)

    IdiomIndexScreen(
        idiom = idiom,
        idiomCollectionEntity = idiomCollectionEntity,
        onBackClick = onBackClick,
        onReadMoreClick = onReadMoreClick,
        onBookmarksClick = onBookmarksClick,
        onSearchClick = onSearchClick,
        onRefresh = { viewModel.getRandomIdiom() },
        setCollect = { viewModel.collect(it) },
        setUncollect = { viewModel.uncollect(it) },
        getIdiomCollectionEntity = {
            viewModel.getIdiomCollectionEntity(it)
        }
    )
}

@Composable
private fun IdiomIndexScreen(
    modifier: Modifier = Modifier,
    idiom: IdiomEntity?,
    idiomCollectionEntity: IdiomCollectionEntity?,
    onBackClick: () -> Unit,
    onReadMoreClick: () -> Unit,
    onBookmarksClick: () -> Unit,
    onSearchClick: () -> Unit,
    onRefresh: () -> Unit,
    setCollect: (Int) -> Unit,
    setUncollect: (Int) -> Unit,
    getIdiomCollectionEntity: (Int) -> Unit,
) {
    SimpleScaffold(
        onBackClick = onBackClick,
        title = "成语",
        actions = {
            IconButton(onClick = onBookmarksClick) {
                Icon(imageVector = Icons.Outlined.Bookmarks, contentDescription = "收藏")
            }
            IconButton(onClick = onReadMoreClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ReadMore,
                    contentDescription = "阅读"
                )
            }
            IconButton(onClick = onSearchClick) {
                Icon(imageVector = Icons.Default.Search, contentDescription = "查找")
            }
        },
        bottomBar = {
            BottomAppBar(
                floatingActionButton = {
                    FloatingActionButton(onClick = onRefresh) {
                        Icon(imageVector = Icons.Default.Refresh, contentDescription = "刷新")
                    }
                },
                actions = {
                    Row(
                        modifier = Modifier.padding(horizontal = 16.dp)
                    ) {
                        IconButton(
                            onClick = {
                                idiom?.let { entity ->
                                    if (idiomCollectionEntity != null) {
                                        setUncollect(entity.id)
                                    } else {
                                        setCollect(entity.id)
                                    }
                                }
                            }
                        ) {
                            if (idiomCollectionEntity != null) {
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
            )
        }
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .draggable(
                    state = rememberDraggableState {},
                    orientation = Orientation.Horizontal,
                    onDragStarted = {},
                    onDragStopped = { velocity ->
                        if (velocity < 0 && abs(velocity) > 500f) {
                            onRefresh()
                        } else if (velocity > 0 && abs(velocity) > 500f) {
                            onRefresh()
                        }
                    }
                )
        ) {
            idiom?.let { entity ->
                LaunchedEffect(entity) {
                    getIdiomCollectionEntity(entity.id)
                }
                IdiomPanel(idiom = entity)
            }
        }
    }
}