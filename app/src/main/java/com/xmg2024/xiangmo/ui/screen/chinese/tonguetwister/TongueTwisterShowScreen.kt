/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.tonguetwister

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.xmg2024.xiangmo.data.database.entity.chinese.TongueTwisterEntity
import com.xmg2024.xiangmo.ui.component.SimpleScaffold

@Composable
fun TongueTwisterShowRoute(
    viewModel: TongueTwisterShowViewModel = hiltViewModel(),
    onBackClick: () -> Unit
) {
    val tongueTwister by viewModel.tongueTwister.collectAsState(initial = null)

    TongueTwisterShowScreen(
        onBackClick = onBackClick,
        tongueTwister = tongueTwister,
    )
}

@Composable
private fun TongueTwisterShowScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    tongueTwister: TongueTwisterEntity?,
) {
    tongueTwister?.let { entity ->
        SimpleScaffold(
            onBackClick = onBackClick,
            title = entity.title
        ) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    modifier = modifier.padding(16.dp),
                    text = entity.content,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}