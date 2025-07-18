/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.knowledge

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.xmg2024.xiangmo.data.database.entity.chinese.KnowledgeEntity
import com.xmg2024.xiangmo.ui.component.SimpleScaffold

@Composable
fun KnowledgeBookmarksRoute(
    viewModel: KnowledgeBookmarksViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
    onItemClick: (Int) -> Unit
) {
    val knowledgeEntityCollections = viewModel.collections.collectAsLazyPagingItems()

    KnowledgeBookmarksScreen(
        onBackClick = onBackClick,
        onItemClick = onItemClick,
        items = knowledgeEntityCollections
    )
}

@Composable
private fun KnowledgeBookmarksScreen(
    onBackClick: () -> Unit,
    onItemClick: (Int) -> Unit,
    items: LazyPagingItems<KnowledgeEntity>
) {
    SimpleScaffold(onBackClick = onBackClick, title = "收藏") {
        LazyColumn {
            items(
                count = items.itemCount
            ) {
                items[it]?.let { entity ->
                    Card(
                        modifier = Modifier.padding(horizontal = 18.dp, vertical = 8.dp),
                        onClick = { onItemClick(entity.id) }
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            Text(text = entity.content)
                        }
                    }
                }
            }
        }
    }
}