/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) 贺丰宝（hefengbao） <hefengbao@foxmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.ui.screen.chinese.expression

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hefengbao.jingmo.data.database.entity.chinese.ExpressionCollectionEntity
import com.hefengbao.jingmo.data.database.entity.chinese.ExpressionEntity
import com.hefengbao.jingmo.ui.component.SimpleScaffold
import com.hefengbao.jingmo.ui.screen.chinese.expression.components.ExpressionPanel

@Composable
fun ChineseExpressionShowRoute(
    onBackClick: () -> Unit,
    viewModel: ExpressionShowViewModel = hiltViewModel()
) {
    val expression by viewModel.expression.collectAsState()
    val expressionCollectionEntity by viewModel.expressionCollectionEntity.collectAsState()

    ChineseExpressionShowScreen(
        onBackClick = onBackClick,
        expression = expression,
        expressionCollectionEntity = expressionCollectionEntity,
        setUncollect = { viewModel.setUncollect(it) },
        setCollect = { viewModel.setCollect(it) }
    )
}

@Composable
private fun ChineseExpressionShowScreen(
    onBackClick: () -> Unit,
    expression: ExpressionEntity?,
    expressionCollectionEntity: ExpressionCollectionEntity?,
    setUncollect: (Int) -> Unit,
    setCollect: (Int) -> Unit,
) {
    expression?.let { entity ->
        SimpleScaffold(
            onBackClick = onBackClick, title = "词语",
            bottomBar = {
                BottomAppBar(
                    actions = {
                        Row(
                            modifier = Modifier.padding(horizontal = 16.dp)
                        ) {
                            IconButton(
                                onClick = {
                                    if (expressionCollectionEntity != null) {
                                        setUncollect(entity.id)
                                    } else {
                                        setCollect(entity.id)
                                    }
                                }
                            ) {
                                if (expressionCollectionEntity != null) {
                                    Icon(
                                        imageVector = Icons.Default.Bookmark,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.primary
                                    )
                                } else {
                                    Icon(
                                        imageVector = Icons.Default.BookmarkBorder,
                                        contentDescription = null
                                    )
                                }
                            }
                        }
                    }
                )
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                ExpressionPanel(entity = entity)
            }
        }
    }
}