/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.idiom

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.outlined.Photo
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
import com.xmg2024.xiangmo.data.database.entity.chinese.IdiomCollectionEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.IdiomEntity
import com.xmg2024.xiangmo.ui.component.SimpleScaffold
import com.xmg2024.xiangmo.ui.screen.chinese.idiom.components.IdiomPanel

@Composable
fun IdiomRoute(
    onBackClick: () -> Unit,
    onCaptureClick: (Int) -> Unit,
    viewModel: IdiomShowViewModel = hiltViewModel()
) {
    val idiom by viewModel.idiom.collectAsState()
    val idiomCollectionEntity by viewModel.idiomCollectionEntity.collectAsState()

    IdiomScreen(
        onBackClick = onBackClick,
        onCaptureClick = onCaptureClick,
        idiom = idiom,
        idiomCollectionEntity = idiomCollectionEntity,
        setUncollect = { viewModel.setUncollect(it) },
        setCollect = { viewModel.setCollect(it) }
    )
}

@Composable
private fun IdiomScreen(
    onBackClick: () -> Unit,
    onCaptureClick: (Int) -> Unit,
    idiom: IdiomEntity?,
    idiomCollectionEntity: IdiomCollectionEntity?,
    setUncollect: (Int) -> Unit,
    setCollect: (Int) -> Unit
) {

    idiom?.let { entity ->
        SimpleScaffold(
            onBackClick = onBackClick,
            title = entity.word,
            actions = {
                IconButton(onClick = { onCaptureClick(entity.id) }) {
                    Icon(imageVector = Icons.Outlined.Photo, contentDescription = null)
                }
            },
            bottomBar = {
                BottomAppBar {
                    Row(
                        modifier = Modifier.padding(horizontal = 16.dp)
                    ) {
                        IconButton(
                            onClick = {
                                if (idiomCollectionEntity != null) {
                                    setUncollect(entity.id)
                                } else {
                                    setCollect(entity.id)
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
            }
        ) {
            IdiomPanel(idiom = entity)
        }
    }
}