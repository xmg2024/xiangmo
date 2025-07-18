/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.ui.screen.chinese.idiom.nav

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.hefengbao.jingmo.ui.screen.chinese.idiom.IdiomRoute
import java.net.URLDecoder
import java.net.URLEncoder

@VisibleForTesting
internal const val idiomIdArg = "idiomId"
private const val base = "chinese_idiom_show"
private const val ROUTE_IDIOM_SHOW = "$base/{$idiomIdArg}"

internal class IdiomShowArgs(val idiomId: String) {
    constructor(savedStateHandle: SavedStateHandle) :
            this(
                URLDecoder.decode(
                    checkNotNull(savedStateHandle[idiomIdArg]),
                    Charsets.UTF_8.name()
                )
            )
}

fun NavController.navigateToChineseIdiomShowScreen(id: String) {
    val encodedId = URLEncoder.encode(id, Charsets.UTF_8.name())
    this.navigate("$base/$encodedId") {
        launchSingleTop = true
    }
}

fun NavGraphBuilder.chineseIdiomShowScreen(
    onBackClick: () -> Unit,
    onCaptureClick: (Int) -> Unit,
) {
    composable(
        route = ROUTE_IDIOM_SHOW,
        arguments = listOf(
            navArgument(idiomIdArg) { type = NavType.StringType }
        )
    ) {
        IdiomRoute(
            onBackClick = onBackClick,
            onCaptureClick = onCaptureClick,
        )
    }
}