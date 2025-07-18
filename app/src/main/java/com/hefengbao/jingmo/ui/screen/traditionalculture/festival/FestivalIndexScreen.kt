/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) 贺丰宝（hefengbao） <hefengbao@foxmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.ui.screen.traditionalculture.festival

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hefengbao.jingmo.data.model.traditionalculture.Festival
import com.hefengbao.jingmo.ui.component.SimpleScaffold

@Composable
fun FestivalIndexRoute(
    viewModel: FestivalIndexViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
    onItemClick: (Int) -> Unit,
) {
    LaunchedEffect(Unit) {
        viewModel.getList()
    }

    val festivals by viewModel.festivals.collectAsState(initial = emptyList())

    FestivalIndexScreen(
        onBackClick = onBackClick,
        onItemClick = onItemClick,
        festivals = festivals
    )
}

@Composable
private fun FestivalIndexScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onItemClick: (Int) -> Unit,
    festivals: List<Festival>
) {
    SimpleScaffold(onBackClick = onBackClick, title = "传统节日") {
        LazyColumn(
            modifier = modifier.fillMaxWidth(),
            content = {
                itemsIndexed(
                    items = festivals,
                    key = { _: Int, item: Festival -> item.id }
                ) { _: Int, item: Festival ->
                    Text(
                        text = item.name,
                        modifier = modifier
                            .fillMaxWidth()
                            .clickable {
                                onItemClick(item.id)
                            }
                            .padding(16.dp)
                    )
                }
            }
        )
    }
}