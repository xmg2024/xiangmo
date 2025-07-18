/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.poetry.nav

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.xmg2024.xiangmo.ui.screen.chinese.poetry.ModernPoetryShowRoute
import java.net.URLDecoder
import java.net.URLEncoder
import kotlin.text.Charsets.UTF_8

internal const val modernPoetryShowIdArg = "id"
private const val base = "chinese_modern_poetry_show"
private const val ROUTE = "$base/{$modernPoetryShowIdArg}"

internal class ModernPoetryShowArgs(val id: String) {
    constructor(savedStateHandle: SavedStateHandle) : this(
        URLDecoder.decode(checkNotNull(savedStateHandle[modernPoetryShowIdArg]), UTF_8.name())
    )
}

fun NavController.navigateToChineseModernPoetryShowScreen(id: Int) {
    val encodedId = URLEncoder.encode(id.toString(), UTF_8.name())

    this.navigate("$base/$encodedId") {
        launchSingleTop = true
    }
}

fun NavGraphBuilder.chineseModernPoetryShowScreen(
    onBackClick: () -> Unit,
) {
    composable(
        route = ROUTE,
        arguments = listOf(
            navArgument(modernPoetryShowIdArg) { type = NavType.StringType }
        )
    ) {
        ModernPoetryShowRoute(
            onBackClick = onBackClick
        )
    }
}