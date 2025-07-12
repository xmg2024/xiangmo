/*
 * This file is part of the 京墨（jingmo）APP.
 *
 * (c) 贺丰宝（hefengbao） <hefengbao@foxmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.ui.screen.chinese.lyric

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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hefengbao.jingmo.data.database.entity.chinese.LyricCollectionEntity
import com.hefengbao.jingmo.data.database.entity.chinese.LyricEntity
import com.hefengbao.jingmo.ui.component.SimpleScaffold
import com.hefengbao.jingmo.ui.screen.chinese.lyric.components.LyricPanel
import kotlin.math.abs

@Composable
fun LyricIndexRoute(
    viewModel: LyricIndexViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
    onBookmarksClick: () -> Unit,
    onReadMoreClick: () -> Unit,
    onSearchClick: () -> Unit,
) {
    val lyricEntity by viewModel.lyricEntity.collectAsState(initial = null)
    val lyricCollectionEntity by viewModel.lyricCollectionEntity.collectAsState(initial = null)

    LyricIndexScreen(
        onBackClick = onBackClick,
        onBookmarksClick = onBookmarksClick,
        onReadMoreClick = onReadMoreClick,
        onSearchClick = onSearchClick,
        lyricEntity = lyricEntity,
        lyricCollectionEntity = lyricCollectionEntity,
        setCollect = { viewModel.collect(it) },
        setUncollect = { viewModel.uncollect(it) },
        refresh = { viewModel.random() },
        isCollect = { viewModel.isCollect(it) }
    )
}

@Composable
private fun LyricIndexScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onBookmarksClick: () -> Unit,
    onReadMoreClick: () -> Unit,
    onSearchClick: () -> Unit,
    lyricEntity: LyricEntity?,
    lyricCollectionEntity: LyricCollectionEntity?,
    setCollect: (Int) -> Unit,
    setUncollect: (Int) -> Unit,
    refresh: () -> Unit,
    isCollect: (Int) -> Unit,
) {
    SimpleScaffold(
        onBackClick = onBackClick,
        title = "歌词",
        actions = {
            IconButton(onClick = onBookmarksClick) {
                Icon(imageVector = Icons.Outlined.Bookmarks, contentDescription = "收藏夹")
            }
            IconButton(onClick = onReadMoreClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Default.ReadMore,
                    contentDescription = "阅读更多"
                )
            }
            IconButton(onClick = onSearchClick) {
                Icon(imageVector = Icons.Default.Search, contentDescription = "搜索")
            }
        },
        bottomBar = {
            lyricEntity?.let {

                isCollect(lyricEntity.id)

                BottomAppBar(
                    actions = {
                        Row(
                            modifier = modifier.padding(horizontal = 16.dp)
                        ) {
                            if (lyricCollectionEntity != null) {
                                IconButton(onClick = { setUncollect(lyricEntity.id) }) {
                                    Icon(
                                        imageVector = Icons.Default.Bookmark,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.primary
                                    )
                                }
                            } else {
                                IconButton(onClick = { setCollect(lyricEntity.id) }) {
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
            lyricEntity?.let { entity -> LyricPanel(entity = entity) }
        }
    }
}