/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.antitheticalcouplet.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.xmg2024.xiangmo.data.database.entity.chinese.AntitheticalCoupletEntity
import com.xmg2024.xiangmo.ui.component.BackgroundTitle

@Composable
fun AntitheticalCoupletPanel(
    modifier: Modifier = Modifier,
    antitheticalCouplet: AntitheticalCoupletEntity,
) {
    SelectionContainer {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = antitheticalCouplet.body,
            )
            antitheticalCouplet.description?.let {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    BackgroundTitle(title = "说明")
                    Text(
                        text = it,
                    )
                }
            }
        }
    }
}