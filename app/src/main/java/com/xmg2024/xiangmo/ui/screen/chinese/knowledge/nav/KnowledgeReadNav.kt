/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.knowledge.nav

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.xmg2024.xiangmo.ui.screen.chinese.knowledge.ChineseKnowledgeReadRoute

private const val ROUTE = "chinese_knowledge_read"

fun NavController.navigateToChineseKnowledgeReadScreen() {
    this.navigate(ROUTE)
}

fun NavGraphBuilder.chineseKnowledgeReadScreen(
    onBackClick: () -> Unit,
) {
    composable(ROUTE) {
        ChineseKnowledgeReadRoute(
            onBackClick = onBackClick,
        )
    }
}