/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.traditionalculture.solarterm

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Launch
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.xmg2024.xiangmo.data.model.traditionalculture.SolarTerm
import com.xmg2024.xiangmo.ui.component.BackgroundTitle
import com.xmg2024.xiangmo.ui.component.SimpleScaffold

@Composable
fun SolarTermShowRoute(
    viewModel: SolarTermShowViewModel = hiltViewModel(),
    onBackClick: () -> Unit
) {
    val solarTerm by viewModel.solarTerm.collectAsState(initial = null)

    SolarTermShowScreen(onBackClick = onBackClick, solarTerm = solarTerm)
}

@Composable
private fun SolarTermShowScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    solarTerm: SolarTerm?
) {
    val uriHandler = LocalUriHandler.current

    solarTerm?.run {
        SimpleScaffold(
            onBackClick = onBackClick,
            title = solarTerm.name,
            actions = {
                IconButton(
                    onClick = {
                        uriHandler.openUri(solarTerm.url)
                    }
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.Launch,
                        contentDescription = "访问百度百科了解更多"
                    )
                }
            }
        ) {
            Column(
                modifier = modifier
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                if (solarTerm.alias != "") {
                    SolarTermItem(label = "别名", text = solarTerm.alias)
                }
                SolarTermItem(label = "介绍", text = solarTerm.desc)
            }
        }
    }
}

@Composable
private fun SolarTermItem(
    modifier: Modifier = Modifier,
    label: String,
    text: String
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        BackgroundTitle(title = label)
        Text(text = text, modifier = modifier.fillMaxWidth())
    }
}