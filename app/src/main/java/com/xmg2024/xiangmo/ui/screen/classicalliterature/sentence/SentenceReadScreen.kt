/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.classicalliterature.sentence

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.outlined.Photo
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.xmg2024.xiangmo.data.database.entity.classicalliterature.SentenceCollectionEntity
import com.xmg2024.xiangmo.data.database.entity.classicalliterature.SentenceEntity
import com.xmg2024.xiangmo.ui.component.SimpleScaffold
import kotlin.math.abs

@Composable
fun SentenceReadRoute(
    viewModel: SentenceReadViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
    onCaptureClick: (Int) -> Unit,
) {

    val prevId by viewModel.prevId.collectAsState()
    val nextId by viewModel.nextId.collectAsState()
    val sentence by viewModel.sentence.collectAsState()
    val sentenceCollectionEntity by viewModel.sentenceCollectionEntity.collectAsState()

    SentenceReadScreen(
        onBackClick = onBackClick,
        onCaptureClick = onCaptureClick,
        sentence = sentence,
        sentenceCollectionEntity = sentenceCollectionEntity,
        prevId = prevId,
        nextId = nextId,
        setCurrentId = { viewModel.setCurrentId(it) },
        setUncollect = { viewModel.setUncollect(it) },
        setCollect = { viewModel.setCollect(it) },
        setLastReadId = { viewModel.setLastReadId(it) },
    )
}

@Composable
private fun SentenceReadScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onCaptureClick: (Int) -> Unit,
    sentence: SentenceEntity?,
    sentenceCollectionEntity: SentenceCollectionEntity?,
    prevId: Int?,
    nextId: Int?,
    setCurrentId: (Int) -> Unit,
    setUncollect: (Int) -> Unit,
    setCollect: (Int) -> Unit,
    setLastReadId: (Int) -> Unit,
) {
    SimpleScaffold(
        onBackClick = onBackClick,
        title = "诗文名句",
        actions = {
            sentence?.let {
                IconButton(onClick = { onCaptureClick(sentence.id) }) {
                    Icon(imageVector = Icons.Outlined.Photo, contentDescription = null)
                }
            }
        },
        bottomBar = {
            BottomAppBar(
                actions = {
                    Row(
                        modifier = modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            onClick = {
                                setCurrentId(prevId!!)
                            },
                            enabled = prevId != null
                        ) {
                            Icon(
                                modifier = modifier.padding(8.dp),
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = null
                            )
                        }
                        IconButton(
                            onClick = {
                                sentence?.let {
                                    if (sentenceCollectionEntity != null) {
                                        setUncollect(it.id)
                                    } else {
                                        setCollect(it.id)
                                    }
                                }
                            }
                        ) {
                            if (sentenceCollectionEntity != null) {
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
                        IconButton(
                            modifier = modifier.padding(8.dp),
                            onClick = {
                                setCurrentId(nextId!!)
                            },
                            enabled = nextId != null
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                                contentDescription = null
                            )
                        }
                    }
                },
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
                            nextId?.let {
                                setCurrentId(nextId)
                            }
                        } else if (velocity > 0 && abs(velocity) > 500f) {
                            prevId?.let {
                                setCurrentId(prevId)
                            }
                        }
                    }
                )
        ) {
            sentence?.let {
                LaunchedEffect(it) {
                    setLastReadId(sentence.id)
                }
                Row(
                    modifier = modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                    ) {
                        sentence.content.split("，", "。", "？", "！", "、").map {

                            Column {
                                it.toCharArray().map { char ->
                                    Text(
                                        text = char.toString(),
                                        style = TextStyle.Default.copy(fontSize = 24.sp)
                                    )
                                }
                            }
                        }
                    }
                    Column {
                        sentence.from.replace("《", "﹁")
                            .replace("》", "﹂")
                            .toCharArray()
                            .map { text ->
                                Text(text = text.toString())
                            }
                    }
                }
            }
        }
    }
}