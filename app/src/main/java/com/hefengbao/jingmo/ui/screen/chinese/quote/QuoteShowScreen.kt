/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.ui.screen.chinese.quote

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
import com.hefengbao.jingmo.data.database.entity.chinese.QuoteCollectionEntity
import com.hefengbao.jingmo.data.database.entity.chinese.QuoteEntity
import com.hefengbao.jingmo.ui.component.SimpleScaffold
import com.hefengbao.jingmo.ui.screen.chinese.quote.components.QuotePanel

@Composable
fun QuoteShowRoute(
    viewModel: QuoteShowViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
) {
    val entity by viewModel.entity.collectAsState(initial = null)
    val collectionEntity by viewModel.collectionEntity.collectAsState(initial = null)

    QuoteShowScreen(
        onBackClick = onBackClick,
        entity = entity,
        collectionEntity = collectionEntity,
        setCollect = { viewModel.collect(it) },
        setUncollect = { viewModel.uncollect(it) }
    )
}

@Composable
private fun QuoteShowScreen(
    onBackClick: () -> Unit,
    entity: QuoteEntity?,
    collectionEntity: QuoteCollectionEntity?,
    setCollect: (Int) -> Unit,
    setUncollect: (Int) -> Unit,
) {
    entity?.let {
        SimpleScaffold(
            onBackClick = onBackClick,
            title = "句子",
            bottomBar = {
                BottomAppBar {
                    Row(
                        modifier = Modifier.padding(horizontal = 16.dp)
                    ) {
                        if (collectionEntity == null) {
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
            QuotePanel(entity = entity)
        }
    }
}