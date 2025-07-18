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
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
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
import com.xmg2024.xiangmo.data.database.entity.chinese.KnowledgeEntity
import com.xmg2024.xiangmo.ui.component.SimpleSearchScaffold

@Composable
fun KnowledgeSearchRoute(
    viewModel: KnowledgeSearchViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
    onItemClick: (Int) -> Unit,
) {
    val knowledgeEntityCollections by viewModel.knowledgeEntityCollections.collectAsState(initial = emptyList())

    KnowledgeSearchScreen(
        onBackClick = onBackClick,
        onItemClick = onItemClick,
        onSearch = { viewModel.onQueryChange(it) },
        items = knowledgeEntityCollections
    )
}

@Composable
private fun KnowledgeSearchScreen(
    onBackClick: () -> Unit,
    onItemClick: (Int) -> Unit,
    onSearch: (String) -> Unit,
    items: List<KnowledgeEntity>
) {
    var query by rememberSaveable {
        mutableStateOf("")
    }

    SimpleSearchScaffold(
        onBackClick = onBackClick,
        query = query,
        onQueryChange = {
            query = it
            onSearch(query)
        },
        onSearch = onSearch
    ) {
        LazyColumn {
            items(
                items = items
            ) { entity ->
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