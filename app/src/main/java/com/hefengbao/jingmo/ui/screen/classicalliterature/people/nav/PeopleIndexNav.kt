/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.ui.screen.classicalliterature.people.nav

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.hefengbao.jingmo.ui.screen.classicalliterature.people.PeopleIndexRoute

private const val ROUTE = "classical_literature_people_index"
private const val ROUTE_GRAPH = "classical_literature_people_index_graph"

fun NavController.navigateToClassicalLiteraturePeopleGraph() {
    this.navigate(ROUTE)
}

fun NavGraphBuilder.classicalLiteraturePeopleGraph(
    onBackClick: () -> Unit,
    onSearchClick: () -> Unit,
    nestGraph: NavGraphBuilder.() -> Unit
) {
    navigation(
        startDestination = ROUTE,
        route = ROUTE_GRAPH
    ) {
        composable(ROUTE) {
            PeopleIndexRoute(
                onBackClick = onBackClick,
                onSearchClick = onSearchClick
            )
        }
        nestGraph()
    }
}