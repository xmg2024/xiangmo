/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.ui.screen.chinese.wisecrack.nav

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.hefengbao.jingmo.ui.screen.chinese.wisecrack.ChineseWisecrackCaptureRoute
import java.net.URLDecoder
import java.net.URLEncoder
import kotlin.text.Charsets.UTF_8

@VisibleForTesting
internal const val chineseWisecrackCaptureIdArg = "chineseWisecrackId"
private const val base = "chinese_wisecrack_capture"
private const val ROUTE = "$base/{$chineseWisecrackCaptureIdArg}"

internal class ChineseWisecrackCaptureArgs(val chineseWisecrackId: String) {
    constructor(savedStateHandle: SavedStateHandle) :
            this(
                URLDecoder.decode(
                    checkNotNull(savedStateHandle[chineseWisecrackCaptureIdArg]),
                    UTF_8.name()
                )
            )
}

fun NavController.navigateToChineseWisecrackCaptureScreen(id: String) {
    val encodedId = URLEncoder.encode(id, UTF_8.name())
    this.navigate("$base/$encodedId") {
        launchSingleTop = true
    }
}

fun NavGraphBuilder.chineseWisecrackCaptureScreen(
    onBackClick: () -> Unit
) {
    composable(
        route = ROUTE,
        arguments = listOf(
            navArgument(chineseWisecrackCaptureIdArg) { type = NavType.StringType }
        )
    ) {
        ChineseWisecrackCaptureRoute(
            onBackClick = onBackClick
        )
    }
}