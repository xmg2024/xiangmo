/*
 *  This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 *  For the full copyright and license information, please view the LICENSE
 *  file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.character

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.xmg2024.xiangmo.data.database.entity.chinese.DictionaryEntity
import com.xmg2024.xiangmo.ui.component.SimpleScaffold

@Composable
fun CharacterBookmarksRoute(
    viewModel: CharacterBookmarksViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
    onItemClick: (Int) -> Unit
) {
    val items = viewModel.items.collectAsLazyPagingItems()

    CharacterBookmarksScreen(onBackClick = onBackClick, onItemClick = onItemClick, items = items)
}

@Composable
private fun CharacterBookmarksScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onItemClick: (Int) -> Unit,
    items: LazyPagingItems<DictionaryEntity>
) {
    SimpleScaffold(onBackClick = onBackClick, title = "收藏") {
        LazyVerticalGrid(
            modifier = modifier.padding(16.dp),
            columns = GridCells.Fixed(3)
        ) {
            items(
                count = items.itemCount,
            ) { index: Int ->
                val entity = items[index]
                entity?.let {
                    Card(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                        onClick = { onItemClick(entity.id) }
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth(),
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            entity.pinyin?.let {
                                Text(text = entity.pinyin)
                            }
                            Text(text = entity.char)
                        }
                    }
                }
            }
        }
    }
}