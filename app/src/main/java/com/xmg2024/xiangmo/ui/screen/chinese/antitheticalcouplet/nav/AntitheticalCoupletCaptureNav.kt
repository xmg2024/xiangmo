/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.antitheticalcouplet.nav

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.xmg2024.xiangmo.ui.screen.chinese.antitheticalcouplet.AntitheticalCoupletCaptureRoute
import java.net.URLDecoder
import java.net.URLEncoder
import kotlin.text.Charsets.UTF_8

@VisibleForTesting
internal const val antitheticalCoupletCaptureIdArg = "antitheticalCoupletId"
private const val base = "chinese_antithetical_couplet_capture"
private const val ROUTE = "$base/{$antitheticalCoupletCaptureIdArg}"

internal class AntitheticalCoupletCaptureArgs(val antitheticalCoupletId: String) {
    constructor(savedStateHandle: SavedStateHandle) :
            this(
                URLDecoder.decode(
                    checkNotNull(savedStateHandle[antitheticalCoupletCaptureIdArg]),
                    UTF_8.name()
                )
            )
}

fun NavController.navigateToChineseAntitheticalCoupletCaptureScreen(id: String) {
    val encodedId = URLEncoder.encode(id, UTF_8.name())
    this.navigate("$base/$encodedId") {
        launchSingleTop = true
    }
}

fun NavGraphBuilder.chineseAntitheticalCoupletCaptureScreen(
    onBackClick: () -> Unit
) {
    composable(
        route = ROUTE,
        arguments = listOf(
            navArgument(antitheticalCoupletCaptureIdArg) { type = NavType.StringType }
        )
    ) {
        AntitheticalCoupletCaptureRoute(
            onBackClick = onBackClick
        )
    }
}