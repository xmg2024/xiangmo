/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.proverb

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.xmg2024.xiangmo.data.database.entity.chinese.ProverbEntity
import com.xmg2024.xiangmo.ui.component.SimpleScaffold

@Composable
fun ProverbBookmarksRoute(
    viewModel: ProverbBookmarksViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
    onItemClick: (Int) -> Unit
) {
    val pagingItems = viewModel.proverbEntityCollections.collectAsLazyPagingItems()

    ProverbBookmarksScreen(
        onBackClick = onBackClick,
        onItemClick = onItemClick,
        items = pagingItems
    )
}

@Composable
private fun ProverbBookmarksScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onItemClick: (Int) -> Unit,
    items: LazyPagingItems<ProverbEntity>
) {
    SimpleScaffold(onBackClick = onBackClick, title = "收藏") {
        LazyColumn {
            items(
                count = items.itemCount
            ) {
                items[it]?.let { entity ->
                    Column(
                        modifier = modifier
                            .fillMaxWidth()
                            .clickable {
                                onItemClick(entity.id)
                            }
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(text = entity.content)
                    }
                }
            }
        }
    }
}