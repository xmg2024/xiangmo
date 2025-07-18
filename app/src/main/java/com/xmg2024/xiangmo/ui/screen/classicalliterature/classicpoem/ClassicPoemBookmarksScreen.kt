/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.classicalliterature.classicpoem

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
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
import com.xmg2024.xiangmo.data.database.entity.classicalliterature.ClassicPoemEntity
import com.xmg2024.xiangmo.ui.component.SimpleScaffold

@Composable
fun ClassicPoemBookmarksRoute(
    viewModel: ClassicPoemBookmarksViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
    onReadClick: (Int) -> Unit
) {
    val poems = viewModel.poems.collectAsLazyPagingItems()

    ClassicPoemBookmarksScreen(
        onBackClick = onBackClick,
        onReadClick = onReadClick,
        poems = poems
    )
}

@Composable
private fun ClassicPoemBookmarksScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onReadClick: (Int) -> Unit,
    poems: LazyPagingItems<ClassicPoemEntity>
) {
    SimpleScaffold(onBackClick = onBackClick, title = "收藏列表") {
        LazyColumn {
            items(
                count = poems.itemCount
            ) {
                poems[it]?.let { entity ->
                    Column(
                        modifier = modifier
                            .fillMaxWidth()
                            .clickable {
                                onReadClick(entity.id)
                            }
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        Text(text = entity.title)
                        Text(
                            text = "${entity.dynasty}·${entity.writer}",
                            style = MaterialTheme.typography.titleSmall
                        )
                        Text(
                            text = entity.collection,
                            style = MaterialTheme.typography.labelSmall.copy(
                                brush = null,
                                alpha = .5f
                            )
                        )
                    }
                }
            }
        }
    }
}