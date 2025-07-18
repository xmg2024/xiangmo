/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.wisecrack

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.xmg2024.xiangmo.data.database.entity.chinese.WisecrackEntity
import com.xmg2024.xiangmo.ui.component.SimpleSearchScaffold

@Composable
fun ChineseWisecrackSearchRoute(
    viewModel: WisecrackSearchViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
    onItemClick: (id: Int) -> Unit
) {
    val list by viewModel.searchWisecrackList.collectAsState(initial = emptyList())

    ChineseWisecrackSearchScreen(
        onBackClick = onBackClick,
        list = list,
        onSearch = { viewModel.search(it) },
        onItemClick = onItemClick
    )
}

@Composable
private fun ChineseWisecrackSearchScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    list: List<WisecrackEntity>,
    onSearch: (String) -> Unit,
    onItemClick: (id: Int) -> Unit
) {
    var query by rememberSaveable {
        mutableStateOf("")
    }

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
                .fillMaxWidth(),
        ) {
            itemsIndexed(
                items = list,
            ) { index, item ->
                Text(
                    modifier = modifier
                        .clickable {
                            onItemClick(item.id)
                        }
                        .padding(16.dp)
                        .fillMaxWidth(),
                    text = item.riddle,
                )
                if (index != list.lastIndex) {
                    Divider(thickness = 0.5.dp)
                }
            }
        }
    }
}