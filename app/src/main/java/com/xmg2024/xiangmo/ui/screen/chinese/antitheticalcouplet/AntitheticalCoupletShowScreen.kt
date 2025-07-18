/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.antitheticalcouplet

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
import com.xmg2024.xiangmo.data.database.entity.chinese.AntitheticalCoupletCollectionEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.AntitheticalCoupletEntity
import com.xmg2024.xiangmo.ui.component.SimpleScaffold
import com.xmg2024.xiangmo.ui.screen.chinese.antitheticalcouplet.components.AntitheticalCoupletPanel

@Composable
fun AntitheticalCoupletShowRoute(
    onBackClick: () -> Unit,
    onCaptureClick: (Int) -> Unit,
    viewModel: AntitheticalCoupletShowViewModel = hiltViewModel()
) {
    val antitheticalCouplet by viewModel.antitheticalCouplet.collectAsState()
    val antitheticalCoupletCollection by viewModel.antitheticalCoupletCollection.collectAsState()

    AntitheticalCoupletShowScreen(
        onBackClick = onBackClick,
        onCaptureClick = onCaptureClick,
        antitheticalCouplet = antitheticalCouplet,
        antitheticalCoupletCollection = antitheticalCoupletCollection,
        setUncollect = { viewModel.setUncollect(it) },
        setCollect = { viewModel.setCollect(it) }
    )
}

@Composable
private fun AntitheticalCoupletShowScreen(
    onBackClick: () -> Unit,
    onCaptureClick: (Int) -> Unit,
    antitheticalCouplet: AntitheticalCoupletEntity?,
    antitheticalCoupletCollection: AntitheticalCoupletCollectionEntity?,
    setUncollect: (Int) -> Unit,
    setCollect: (Int) -> Unit
) {

    antitheticalCouplet?.let { entity ->
        SimpleScaffold(
            onBackClick = onBackClick,
            title = "对联",
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
                                if (antitheticalCoupletCollection != null) {
                                    setUncollect(entity.id)
                                } else {
                                    setCollect(entity.id)
                                }
                            }
                        ) {
                            if (antitheticalCoupletCollection != null) {
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
            AntitheticalCoupletPanel(antitheticalCouplet = antitheticalCouplet)
        }
    }
}