/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.wisecrack.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.xmg2024.xiangmo.data.database.entity.chinese.WisecrackEntity

@Composable
fun ChineseWisecrackPanel(
    modifier: Modifier = Modifier,
    entity: WisecrackEntity,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp, 16.dp, 16.dp, 96.dp)
            .verticalScroll(rememberScrollState()),
    ) {
        SelectionContainer {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = entity.riddle,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "—— ${entity.answer}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}