/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.wisecrack

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.xmg2024.xiangmo.data.database.entity.chinese.WisecrackCollectionEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.WisecrackEntity
import com.xmg2024.xiangmo.ui.component.SimpleScaffold
import com.xmg2024.xiangmo.ui.screen.chinese.wisecrack.components.ChineseWisecrackPanel

@Composable
fun ChineseWisecrackShowRoute(
    viewModel: WisecrackShowViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
    onCaptureClick: (Int) -> Unit,
) {

    val chineseWisecrack by viewModel.wisecrack.collectAsState()
    val chineseWisecrackCollectionEntity by viewModel.chineseWisecrackCollectionEntity.collectAsState()

    ChineseWisecrackShowScreen(
        onBackClick = onBackClick,
        onCaptureClick = onCaptureClick,
        chineseCrack = chineseWisecrack,
        wisecrackCollectionEntity = chineseWisecrackCollectionEntity,
        setUncollect = { viewModel.setUncollect(it) },
        setCollect = { viewModel.setCollect(it) },
    )
}

@Composable
private fun ChineseWisecrackShowScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onCaptureClick: (Int) -> Unit,
    chineseCrack: WisecrackEntity?,
    wisecrackCollectionEntity: WisecrackCollectionEntity?,
    setUncollect: (Int) -> Unit,
    setCollect: (Int) -> Unit,
) {
    chineseCrack?.let { entity ->
        SimpleScaffold(
            onBackClick = onBackClick,
            title = "歇后语",
            actions = {
                IconButton(onClick = { onCaptureClick(entity.id) }) {
                    Icon(imageVector = Icons.Outlined.Photo, contentDescription = null)
                }
            },
            bottomBar = {
                BottomAppBar {
                    Row(
                        modifier = modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        if (wisecrackCollectionEntity == null) {
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
            ChineseWisecrackPanel(
                entity = entity,
            )
        }
    }
}