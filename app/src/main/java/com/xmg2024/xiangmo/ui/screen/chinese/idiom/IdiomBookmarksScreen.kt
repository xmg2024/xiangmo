/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.idiom

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.xmg2024.xiangmo.data.database.entity.chinese.IdiomEntity
import com.xmg2024.xiangmo.ui.component.SimpleScaffold

@Composable
fun IdiomBookmarksRoute(
    viewModel: IdiomBookmarksViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
    onItemClick: (Int) -> Unit,
) {
    val bookmarks = viewModel.bookmarks.collectAsLazyPagingItems()

    IdiomBookmarksScreen(
        onBackClick = onBackClick,
        bookmarks = bookmarks,
        onItemClick = onItemClick
    )
}

@Composable
private fun IdiomBookmarksScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    bookmarks: LazyPagingItems<IdiomEntity>,
    onItemClick: (Int) -> Unit,
) {
    SimpleScaffold(onBackClick = onBackClick, title = "收藏列表") {
        LazyColumn {
            items(
                count = bookmarks.itemCount
            ) {
                bookmarks[it]?.let { entity ->
                    Text(
                        modifier = modifier
                            .fillMaxWidth()
                            .clickable {
                                onItemClick(entity.id)
                            }
                            .padding(16.dp),
                        text = entity.word,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}