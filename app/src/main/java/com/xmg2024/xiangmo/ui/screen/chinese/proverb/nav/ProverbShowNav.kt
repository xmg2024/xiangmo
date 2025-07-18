/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.proverb.nav

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.xmg2024.xiangmo.ui.screen.chinese.proverb.ProverbShowRoute
import java.net.URLDecoder
import java.net.URLEncoder
import kotlin.text.Charsets.UTF_8

internal const val proverbShowIdArg = "id"
private const val base = "chinese_proverb_show"
private const val ROUTE = "$base/{$proverbShowIdArg}"

internal class ProverbShowArgs(val id: String) {
    constructor(savedStateHandle: SavedStateHandle) : this(
        URLDecoder.decode(checkNotNull(savedStateHandle[proverbShowIdArg]), UTF_8.name())
    )
}

fun NavController.navigateToChineseProverbShowScreen(id: String) {
    val encodedId = URLEncoder.encode(id, UTF_8.name())

    this.navigate("$base/$encodedId") {
        launchSingleTop = true
    }
}

fun NavGraphBuilder.chineseProverbShowScreen(
    onBackClick: () -> Unit,
) {
    composable(
        route = ROUTE,
        arguments = listOf(
            navArgument(proverbShowIdArg) { type = NavType.StringType }
        )
    ) {
        ProverbShowRoute(
            onBackClick = onBackClick
        )
    }
}