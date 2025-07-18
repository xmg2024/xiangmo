/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.ui.screen.chinese.riddle

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hefengbao.jingmo.data.database.entity.chinese.RiddleEntity
import com.hefengbao.jingmo.ui.component.SimpleSearchScaffold

@Composable
fun RiddleSearchRoute(
    viewModel: RiddleSearchViewModel = hiltViewModel(),
    onBackClick: () -> Unit
) {
    val list by viewModel.list.collectAsState(initial = emptyList())

    RiddleSearchScreen(
        onBackClick = onBackClick,
        onSearch = { viewModel.search(it) },
        list = list
    )
}

@Composable
private fun RiddleSearchScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onSearch: (String) -> Unit,
    list: List<RiddleEntity>
) {
    var query by remember { mutableStateOf("") }

    SimpleSearchScaffold(
        onBackClick = onBackClick,
        query = query,
        onQueryChange = {
            query = it
            if (query.isNotEmpty()) {
                onSearch(query)
            }
        },
        onSearch = onSearch
    ) {
        LazyColumn(
            modifier = modifier
                .fillMaxWidth()
        ) {
            itemsIndexed(
                items = list
            ) { _: Int, item: RiddleEntity ->
                Card(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Column(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text(text = item.puzzle)
                        Text(text = item.answer)
                    }
                }
            }
        }
    }
}