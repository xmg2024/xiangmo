/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.classicalliterature.writing

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.xmg2024.xiangmo.data.database.entity.classicalliterature.WritingEntity
import com.xmg2024.xiangmo.ui.component.SimpleScaffold

@Composable
fun WritingBookmarksRoute(
    viewModel: WritingBookmarksViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
    onItemClick: (id: Int) -> Unit
) {
    val writings = viewModel.writings.collectAsLazyPagingItems()

    WritingBookmarksScreen(
        onBackClick = onBackClick,
        writings = writings,
        onItemClick = onItemClick
    )
}

@Composable
private fun WritingBookmarksScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    writings: LazyPagingItems<WritingEntity>,
    onItemClick: (id: Int) -> Unit
) {
    SimpleScaffold(
        onBackClick = onBackClick,
        title = "收藏列表"
    ) {
        LazyColumn(
            modifier = modifier.fillMaxWidth()
        ) {
            items(
                count = writings.itemCount
            ) {
                writings[it]?.let { entity ->
                    Column(
                        modifier = modifier
                            .fillMaxWidth()
                            .clickable {
                                onItemClick(entity.id)
                            }
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = entity.title.content,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Text(
                            text = "${entity.type} ${entity.dynasty}·${entity.author}",
                            color = Color.DarkGray,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}