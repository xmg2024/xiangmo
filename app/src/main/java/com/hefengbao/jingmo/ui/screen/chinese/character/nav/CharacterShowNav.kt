/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.ui.screen.chinese.character.nav

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.hefengbao.jingmo.ui.screen.chinese.character.CharacterShowRoute
import java.net.URLDecoder
import java.net.URLEncoder
import kotlin.text.Charsets.UTF_8

internal const val characterShowArgsCharacterArg = "character"
private const val base = "chinese_character_show"
private const val ROUTE = "$base/{$characterShowArgsCharacterArg}"

internal class CharacterShowArgs(val id: String) {
    constructor(savedStateHandle: SavedStateHandle) :
            this(
                URLDecoder.decode(savedStateHandle[characterShowArgsCharacterArg], UTF_8.name()),
            )
}

fun NavController.navigateToChineseCharacterShowScreen(id: String) {
    val encodeId = URLEncoder.encode(id, UTF_8.name())
    this.navigate("$base/$encodeId") {
        launchSingleTop = true
    }
}

fun NavGraphBuilder.chineseCharacterShowScreen(
    onBackClick: () -> Unit,
) {
    composable(
        route = ROUTE,
        arguments = listOf(
            navArgument(characterShowArgsCharacterArg) { type = NavType.StringType },
        )
    ) {
        CharacterShowRoute(onBackClick = onBackClick)
    }
}
