/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.classicalliterature.people

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.xmg2024.xiangmo.data.database.entity.classicalliterature.PeopleEntity
import com.xmg2024.xiangmo.ui.component.SimpleScaffold
import com.xmg2024.xiangmo.ui.screen.classicalliterature.people.components.PeoplePanel

@Composable
fun PeopleShowRoute(
    viewModel: PeopleShowViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
) {
    val people by viewModel.people.collectAsState(initial = null)

    PeopleShowScreen(
        onBackClick = onBackClick,
        people = people
    )
}

@Composable
private fun PeopleShowScreen(
    onBackClick: () -> Unit,
    people: PeopleEntity?
) {
    SimpleScaffold(
        onBackClick = onBackClick,
        title = "人物资料"
    ) {
        people?.let {
            PeoplePanel(people = it)
        }
    }
}