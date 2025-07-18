/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.classicalliterature.people

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.xmg2024.xiangmo.data.database.entity.classicalliterature.PeopleEntity
import com.xmg2024.xiangmo.ui.component.SimpleScaffold
import com.xmg2024.xiangmo.ui.screen.classicalliterature.people.components.PeoplePanel
import kotlin.math.abs

@Composable
fun PeopleIndexRoute(
    viewModel: PeopleIndexViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
    onSearchClick: () -> Unit,
) {
    val people by viewModel.people.collectAsState(initial = null)

    LaunchedEffect(Unit) {
        viewModel.getRandomPeople()
    }

    PeopleIndexScreen(
        onBackClick = onBackClick,
        onSearchClick = onSearchClick,
        people = people,
        onFabClick = {
            viewModel.getRandomPeople()
        }
    )
}

@Composable
private fun PeopleIndexScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onSearchClick: () -> Unit,
    people: PeopleEntity?,
    onFabClick: () -> Unit
) {
    SimpleScaffold(
        onBackClick = onBackClick,
        title = "人物",
        actions = {
            IconButton(onClick = onSearchClick) {
                Icon(imageVector = Icons.Default.Search, contentDescription = "查找")
            }
        },
        bottomBar = {
            BottomAppBar(
                actions = {},
                floatingActionButton = {
                    if (people !== null) {
                        FloatingActionButton(onClick = onFabClick) {
                            Icon(imageVector = Icons.Default.Refresh, contentDescription = "刷新")
                        }
                    }
                }
            )
        }
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .draggable(
                    state = rememberDraggableState {},
                    orientation = Orientation.Horizontal,
                    onDragStarted = {},
                    onDragStopped = { velocity ->
                        if (velocity < 0 && abs(velocity) > 500f) {
                            onFabClick()
                        } else if (velocity > 0 && abs(velocity) > 500f) {
                            onFabClick()
                        }
                    }
                )
        ) {
            people?.let {
                PeoplePanel(people = it)
            }
        }
    }
}