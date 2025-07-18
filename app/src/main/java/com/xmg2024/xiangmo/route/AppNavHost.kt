/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.route

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.xmg2024.xiangmo.ui.screen.china.worldcultureheritage.nav.chinaWorldCultureHeritageGraph
import com.xmg2024.xiangmo.ui.screen.china.worldcultureheritage.nav.chinaWorldCultureHeritageShowScreen
import com.xmg2024.xiangmo.ui.screen.china.worldcultureheritage.nav.navigateToChinaWorldCultureHeritageGraph
import com.xmg2024.xiangmo.ui.screen.china.worldcultureheritage.nav.navigateToChinaWorldCultureHeritageShowScreen
import com.xmg2024.xiangmo.ui.screen.chinese.antitheticalcouplet.nav.chineseAntitheticalCoupletBookmarksScreen
import com.xmg2024.xiangmo.ui.screen.chinese.antitheticalcouplet.nav.chineseAntitheticalCoupletCaptureScreen
import com.xmg2024.xiangmo.ui.screen.chinese.antitheticalcouplet.nav.chineseAntitheticalCoupletIndexGraph
import com.xmg2024.xiangmo.ui.screen.chinese.antitheticalcouplet.nav.chineseAntitheticalCoupletReadScreen
import com.xmg2024.xiangmo.ui.screen.chinese.antitheticalcouplet.nav.chineseAntitheticalCoupletSearchScreen
import com.xmg2024.xiangmo.ui.screen.chinese.antitheticalcouplet.nav.chineseAntitheticalCoupletShowScreen
import com.xmg2024.xiangmo.ui.screen.chinese.antitheticalcouplet.nav.navigateToChineseAntitheticalCoupletBookmarksScreen
import com.xmg2024.xiangmo.ui.screen.chinese.antitheticalcouplet.nav.navigateToChineseAntitheticalCoupletCaptureScreen
import com.xmg2024.xiangmo.ui.screen.chinese.antitheticalcouplet.nav.navigateToChineseAntitheticalCoupletIndexGraph
import com.xmg2024.xiangmo.ui.screen.chinese.antitheticalcouplet.nav.navigateToChineseAntitheticalCoupletReadScreen
import com.xmg2024.xiangmo.ui.screen.chinese.antitheticalcouplet.nav.navigateToChineseAntitheticalCoupletSearchScreen
import com.xmg2024.xiangmo.ui.screen.chinese.antitheticalcouplet.nav.navigateToChineseAntitheticalCoupletShowScreen
import com.xmg2024.xiangmo.ui.screen.chinese.character.nav.chineseCharacterBookmarksScreen
import com.xmg2024.xiangmo.ui.screen.chinese.character.nav.chineseCharacterIndexGraph
import com.xmg2024.xiangmo.ui.screen.chinese.character.nav.chineseCharacterPinyinIndexScreen
import com.xmg2024.xiangmo.ui.screen.chinese.character.nav.chineseCharacterRadicalIndexScreen
import com.xmg2024.xiangmo.ui.screen.chinese.character.nav.chineseCharacterSearchListScreen
import com.xmg2024.xiangmo.ui.screen.chinese.character.nav.chineseCharacterShowScreen
import com.xmg2024.xiangmo.ui.screen.chinese.character.nav.chineseCharacterStrokeIndexScreen
import com.xmg2024.xiangmo.ui.screen.chinese.character.nav.chineseCharacterStrokeScreen
import com.xmg2024.xiangmo.ui.screen.chinese.character.nav.navigateToChineseCharacterBookmarksScreen
import com.xmg2024.xiangmo.ui.screen.chinese.character.nav.navigateToChineseCharacterIndexGraph
import com.xmg2024.xiangmo.ui.screen.chinese.character.nav.navigateToChineseCharacterPinyinIndexScreen
import com.xmg2024.xiangmo.ui.screen.chinese.character.nav.navigateToChineseCharacterRadicalIndexScreen
import com.xmg2024.xiangmo.ui.screen.chinese.character.nav.navigateToChineseCharacterSearchListScreen
import com.xmg2024.xiangmo.ui.screen.chinese.character.nav.navigateToChineseCharacterShowScreen
import com.xmg2024.xiangmo.ui.screen.chinese.character.nav.navigateToChineseCharacterStrokeIndexScreen
import com.xmg2024.xiangmo.ui.screen.chinese.character.nav.navigateToChineseCharacterStrokeScreen
import com.xmg2024.xiangmo.ui.screen.chinese.expression.nav.chineseExpressionBookmarksScreen
import com.xmg2024.xiangmo.ui.screen.chinese.expression.nav.chineseExpressionGraph
import com.xmg2024.xiangmo.ui.screen.chinese.expression.nav.chineseExpressionSearchScreen
import com.xmg2024.xiangmo.ui.screen.chinese.expression.nav.chineseExpressionShowScreen
import com.xmg2024.xiangmo.ui.screen.chinese.expression.nav.navigateToChineseExpressionBookmarksScreen
import com.xmg2024.xiangmo.ui.screen.chinese.expression.nav.navigateToChineseExpressionGraph
import com.xmg2024.xiangmo.ui.screen.chinese.expression.nav.navigateToChineseExpressionSearchScreen
import com.xmg2024.xiangmo.ui.screen.chinese.expression.nav.navigateToChineseExpressionShow
import com.xmg2024.xiangmo.ui.screen.chinese.idiom.nav.chineseIdiomBookmarksScreen
import com.xmg2024.xiangmo.ui.screen.chinese.idiom.nav.chineseIdiomCaptureScreen
import com.xmg2024.xiangmo.ui.screen.chinese.idiom.nav.chineseIdiomIndexGraph
import com.xmg2024.xiangmo.ui.screen.chinese.idiom.nav.chineseIdiomReadScreen
import com.xmg2024.xiangmo.ui.screen.chinese.idiom.nav.chineseIdiomSearchScreen
import com.xmg2024.xiangmo.ui.screen.chinese.idiom.nav.chineseIdiomShowScreen
import com.xmg2024.xiangmo.ui.screen.chinese.idiom.nav.navigateToChineseIdiomBookmarksScreen
import com.xmg2024.xiangmo.ui.screen.chinese.idiom.nav.navigateToChineseIdiomCaptureScreen
import com.xmg2024.xiangmo.ui.screen.chinese.idiom.nav.navigateToChineseIdiomIndexGraph
import com.xmg2024.xiangmo.ui.screen.chinese.idiom.nav.navigateToChineseIdiomReadScreen
import com.xmg2024.xiangmo.ui.screen.chinese.idiom.nav.navigateToChineseIdiomSearchScreen
import com.xmg2024.xiangmo.ui.screen.chinese.idiom.nav.navigateToChineseIdiomShowScreen
import com.xmg2024.xiangmo.ui.screen.chinese.knowledge.nav.chineseKnowledgeBookmarksScreen
import com.xmg2024.xiangmo.ui.screen.chinese.knowledge.nav.chineseKnowledgeIndexGraph
import com.xmg2024.xiangmo.ui.screen.chinese.knowledge.nav.chineseKnowledgeReadScreen
import com.xmg2024.xiangmo.ui.screen.chinese.knowledge.nav.chineseKnowledgeSearchScreen
import com.xmg2024.xiangmo.ui.screen.chinese.knowledge.nav.chineseKnowledgeShowScreen
import com.xmg2024.xiangmo.ui.screen.chinese.knowledge.nav.navigateToChineseKnowSearchScreen
import com.xmg2024.xiangmo.ui.screen.chinese.knowledge.nav.navigateToChineseKnowledgeBookmarksScreen
import com.xmg2024.xiangmo.ui.screen.chinese.knowledge.nav.navigateToChineseKnowledgeIndexGraph
import com.xmg2024.xiangmo.ui.screen.chinese.knowledge.nav.navigateToChineseKnowledgeReadScreen
import com.xmg2024.xiangmo.ui.screen.chinese.knowledge.nav.navigateToChineseKnowledgeShowScreen
import com.xmg2024.xiangmo.ui.screen.chinese.lyric.nav.chineseLyricBookmarksScreen
import com.xmg2024.xiangmo.ui.screen.chinese.lyric.nav.chineseLyricIndexGraph
import com.xmg2024.xiangmo.ui.screen.chinese.lyric.nav.chineseLyricReadScreen
import com.xmg2024.xiangmo.ui.screen.chinese.lyric.nav.chineseLyricSearchScreen
import com.xmg2024.xiangmo.ui.screen.chinese.lyric.nav.chineseLyricShowScreen
import com.xmg2024.xiangmo.ui.screen.chinese.lyric.nav.navigateToChineseLyricBookmarksScreen
import com.xmg2024.xiangmo.ui.screen.chinese.lyric.nav.navigateToChineseLyricIndexGraph
import com.xmg2024.xiangmo.ui.screen.chinese.lyric.nav.navigateToChineseLyricReadScreen
import com.xmg2024.xiangmo.ui.screen.chinese.lyric.nav.navigateToChineseLyricSearchScreen
import com.xmg2024.xiangmo.ui.screen.chinese.lyric.nav.navigateToChineseLyricShowScreen
import com.xmg2024.xiangmo.ui.screen.chinese.poetry.nav.chineseModernPoetryBookmarksScreen
import com.xmg2024.xiangmo.ui.screen.chinese.poetry.nav.chineseModernPoetryIndexGraph
import com.xmg2024.xiangmo.ui.screen.chinese.poetry.nav.chineseModernPoetryReadScreen
import com.xmg2024.xiangmo.ui.screen.chinese.poetry.nav.chineseModernPoetrySearchScreen
import com.xmg2024.xiangmo.ui.screen.chinese.poetry.nav.chineseModernPoetryShowScreen
import com.xmg2024.xiangmo.ui.screen.chinese.poetry.nav.navigateToChineseModernPoetryBookmarksScreen
import com.xmg2024.xiangmo.ui.screen.chinese.poetry.nav.navigateToChineseModernPoetryIndexGraph
import com.xmg2024.xiangmo.ui.screen.chinese.poetry.nav.navigateToChineseModernPoetryReadScreen
import com.xmg2024.xiangmo.ui.screen.chinese.poetry.nav.navigateToChineseModernPoetrySearchScreen
import com.xmg2024.xiangmo.ui.screen.chinese.poetry.nav.navigateToChineseModernPoetryShowScreen
import com.xmg2024.xiangmo.ui.screen.chinese.proverb.nav.chineseProverbBookmarksScreen
import com.xmg2024.xiangmo.ui.screen.chinese.proverb.nav.chineseProverbIndexGraph
import com.xmg2024.xiangmo.ui.screen.chinese.proverb.nav.chineseProverbReadScreen
import com.xmg2024.xiangmo.ui.screen.chinese.proverb.nav.chineseProverbSearchScreen
import com.xmg2024.xiangmo.ui.screen.chinese.proverb.nav.chineseProverbShowScreen
import com.xmg2024.xiangmo.ui.screen.chinese.proverb.nav.navigateToChineseProverbBookmarksScreen
import com.xmg2024.xiangmo.ui.screen.chinese.proverb.nav.navigateToChineseProverbIndexGraph
import com.xmg2024.xiangmo.ui.screen.chinese.proverb.nav.navigateToChineseProverbReadScreen
import com.xmg2024.xiangmo.ui.screen.chinese.proverb.nav.navigateToChineseProverbSearchScreen
import com.xmg2024.xiangmo.ui.screen.chinese.proverb.nav.navigateToChineseProverbShowScreen
import com.xmg2024.xiangmo.ui.screen.chinese.quote.nav.chineseQuoteBookmarksScreen
import com.xmg2024.xiangmo.ui.screen.chinese.quote.nav.chineseQuoteIndexGraph
import com.xmg2024.xiangmo.ui.screen.chinese.quote.nav.chineseQuoteReadScreen
import com.xmg2024.xiangmo.ui.screen.chinese.quote.nav.chineseQuoteSearchScreen
import com.xmg2024.xiangmo.ui.screen.chinese.quote.nav.chineseQuoteShowScreen
import com.xmg2024.xiangmo.ui.screen.chinese.quote.nav.navigateToChineseQuoteBookmarksScreen
import com.xmg2024.xiangmo.ui.screen.chinese.quote.nav.navigateToChineseQuoteIndexGraph
import com.xmg2024.xiangmo.ui.screen.chinese.quote.nav.navigateToChineseQuoteReadScreen
import com.xmg2024.xiangmo.ui.screen.chinese.quote.nav.navigateToChineseQuoteSearchScreen
import com.xmg2024.xiangmo.ui.screen.chinese.quote.nav.navigateToChineseQuoteShowScreen
import com.xmg2024.xiangmo.ui.screen.chinese.riddle.nav.chineseRiddleIndexGraph
import com.xmg2024.xiangmo.ui.screen.chinese.riddle.nav.chineseRiddleInfoScreen
import com.xmg2024.xiangmo.ui.screen.chinese.riddle.nav.chineseRiddleReadScreen
import com.xmg2024.xiangmo.ui.screen.chinese.riddle.nav.chineseRiddleSearchScreen
import com.xmg2024.xiangmo.ui.screen.chinese.riddle.nav.navigateToChineseRiddleIndexGraph
import com.xmg2024.xiangmo.ui.screen.chinese.riddle.nav.navigateToChineseRiddleInfoScreen
import com.xmg2024.xiangmo.ui.screen.chinese.riddle.nav.navigateToChineseRiddleReadScreen
import com.xmg2024.xiangmo.ui.screen.chinese.riddle.nav.navigateToChineseRiddleSearchScreen
import com.xmg2024.xiangmo.ui.screen.chinese.tonguetwister.nav.chineseTongueTwisterIndexGraph
import com.xmg2024.xiangmo.ui.screen.chinese.tonguetwister.nav.chineseTongueTwisterShowScreen
import com.xmg2024.xiangmo.ui.screen.chinese.tonguetwister.nav.navigateToChineseTongueTwisterIndexGraph
import com.xmg2024.xiangmo.ui.screen.chinese.tonguetwister.nav.navigateToChineseTongueTwisterShowScreen
import com.xmg2024.xiangmo.ui.screen.chinese.wisecrack.nav.chineseWisecrackBookmarksScreen
import com.xmg2024.xiangmo.ui.screen.chinese.wisecrack.nav.chineseWisecrackCaptureScreen
import com.xmg2024.xiangmo.ui.screen.chinese.wisecrack.nav.chineseWisecrackIndexGraph
import com.xmg2024.xiangmo.ui.screen.chinese.wisecrack.nav.chineseWisecrackReadScreen
import com.xmg2024.xiangmo.ui.screen.chinese.wisecrack.nav.chineseWisecrackSearchScreen
import com.xmg2024.xiangmo.ui.screen.chinese.wisecrack.nav.chineseWisecrackShowScreen
import com.xmg2024.xiangmo.ui.screen.chinese.wisecrack.nav.navigateToChineseWisecrackBookmarksScreen
import com.xmg2024.xiangmo.ui.screen.chinese.wisecrack.nav.navigateToChineseWisecrackCaptureScreen
import com.xmg2024.xiangmo.ui.screen.chinese.wisecrack.nav.navigateToChineseWisecrackIndexGraph
import com.xmg2024.xiangmo.ui.screen.chinese.wisecrack.nav.navigateToChineseWisecrackReadScreen
import com.xmg2024.xiangmo.ui.screen.chinese.wisecrack.nav.navigateToChineseWisecrackSearchScreen
import com.xmg2024.xiangmo.ui.screen.chinese.wisecrack.nav.navigateToChineseWisecrackShowScreen
import com.xmg2024.xiangmo.ui.screen.classicalliterature.classicpoem.nav.classicalLiteratureClassicPoemBookmarksGraph
import com.xmg2024.xiangmo.ui.screen.classicalliterature.classicpoem.nav.classicalLiteratureClassicPoemIndexGraph
import com.xmg2024.xiangmo.ui.screen.classicalliterature.classicpoem.nav.classicalLiteratureClassicPoemReadScreen
import com.xmg2024.xiangmo.ui.screen.classicalliterature.classicpoem.nav.classicalLiteratureClassicPoemSearchScreen
import com.xmg2024.xiangmo.ui.screen.classicalliterature.classicpoem.nav.classicalLiteratureClassicPoemShowScreen
import com.xmg2024.xiangmo.ui.screen.classicalliterature.classicpoem.nav.navigateToClassicalLiteratureClassicPoemBookmarksGraph
import com.xmg2024.xiangmo.ui.screen.classicalliterature.classicpoem.nav.navigateToClassicalLiteratureClassicPoemIndexGraph
import com.xmg2024.xiangmo.ui.screen.classicalliterature.classicpoem.nav.navigateToClassicalLiteratureClassicPoemReadScreen
import com.xmg2024.xiangmo.ui.screen.classicalliterature.classicpoem.nav.navigateToClassicalLiteratureClassicPoemSearchScreen
import com.xmg2024.xiangmo.ui.screen.classicalliterature.classicpoem.nav.navigateToClassicalLiteratureClassicPoemShowScreen
import com.xmg2024.xiangmo.ui.screen.classicalliterature.people.nav.classicalLiteraturePeopleGraph
import com.xmg2024.xiangmo.ui.screen.classicalliterature.people.nav.classicalLiteraturePeopleSearchGraph
import com.xmg2024.xiangmo.ui.screen.classicalliterature.people.nav.classicalLiteraturePeopleShowScreen
import com.xmg2024.xiangmo.ui.screen.classicalliterature.people.nav.navigateToClassicalLiteraturePeopleGraph
import com.xmg2024.xiangmo.ui.screen.classicalliterature.people.nav.navigateToClassicalLiteraturePeopleSearchGraph
import com.xmg2024.xiangmo.ui.screen.classicalliterature.people.nav.navigateToClassicalLiteraturePeopleShowScreen
import com.xmg2024.xiangmo.ui.screen.classicalliterature.sentence.nav.classicalLiteratureSentenceBookmarksScreen
import com.xmg2024.xiangmo.ui.screen.classicalliterature.sentence.nav.classicalLiteratureSentenceCaptureScreen
import com.xmg2024.xiangmo.ui.screen.classicalliterature.sentence.nav.classicalLiteratureSentenceIndexGraph
import com.xmg2024.xiangmo.ui.screen.classicalliterature.sentence.nav.classicalLiteratureSentenceReadScreen
import com.xmg2024.xiangmo.ui.screen.classicalliterature.sentence.nav.classicalLiteratureSentenceSearchScreen
import com.xmg2024.xiangmo.ui.screen.classicalliterature.sentence.nav.navigateToClassicalLiteratureSentenceBookmarksScreen
import com.xmg2024.xiangmo.ui.screen.classicalliterature.sentence.nav.navigateToClassicalLiteratureSentenceCaptureScreen
import com.xmg2024.xiangmo.ui.screen.classicalliterature.sentence.nav.navigateToClassicalLiteratureSentenceIndexGraph
import com.xmg2024.xiangmo.ui.screen.classicalliterature.sentence.nav.navigateToClassicalLiteratureSentenceReadScreen
import com.xmg2024.xiangmo.ui.screen.classicalliterature.sentence.nav.navigateToClassicalLiteratureSentenceSearchScreen
import com.xmg2024.xiangmo.ui.screen.classicalliterature.writing.nav.classicalLiteratureWritingBookmarksScreen
import com.xmg2024.xiangmo.ui.screen.classicalliterature.writing.nav.classicalLiteratureWritingCaptureScreen
import com.xmg2024.xiangmo.ui.screen.classicalliterature.writing.nav.classicalLiteratureWritingIndexGraph
import com.xmg2024.xiangmo.ui.screen.classicalliterature.writing.nav.classicalLiteratureWritingReadScreen
import com.xmg2024.xiangmo.ui.screen.classicalliterature.writing.nav.classicalLiteratureWritingSearchScreen
import com.xmg2024.xiangmo.ui.screen.classicalliterature.writing.nav.classicalLiteratureWritingShowScreen
import com.xmg2024.xiangmo.ui.screen.classicalliterature.writing.nav.navigateToClassicalLiteratureWritingBookmarksScreen
import com.xmg2024.xiangmo.ui.screen.classicalliterature.writing.nav.navigateToClassicalLiteratureWritingCaptureScreen
import com.xmg2024.xiangmo.ui.screen.classicalliterature.writing.nav.navigateToClassicalLiteratureWritingIndexGraph
import com.xmg2024.xiangmo.ui.screen.classicalliterature.writing.nav.navigateToClassicalLiteratureWritingReadScreen
import com.xmg2024.xiangmo.ui.screen.classicalliterature.writing.nav.navigateToClassicalLiteratureWritingSearchScreen
import com.xmg2024.xiangmo.ui.screen.classicalliterature.writing.nav.navigateToClassicalLiteratureWritingShowScreen
import com.xmg2024.xiangmo.ui.screen.home.nav.ROUTE_HOME_GRAPH
import com.xmg2024.xiangmo.ui.screen.home.nav.homeGraph
import com.xmg2024.xiangmo.ui.screen.link.nav.linkIndexScreen
import com.xmg2024.xiangmo.ui.screen.link.nav.navigateToLinkIndexScreen
import com.xmg2024.xiangmo.ui.screen.settings.nav.aboutScreen
import com.xmg2024.xiangmo.ui.screen.settings.nav.homeItemManagerScreen
import com.xmg2024.xiangmo.ui.screen.settings.nav.importScreen
import com.xmg2024.xiangmo.ui.screen.settings.nav.navigateToAboutScreen
import com.xmg2024.xiangmo.ui.screen.settings.nav.navigateToHomeItemManagerScreen
import com.xmg2024.xiangmo.ui.screen.settings.nav.navigateToImportScreen
import com.xmg2024.xiangmo.ui.screen.settings.nav.navigateToPrivacyScreen
import com.xmg2024.xiangmo.ui.screen.settings.nav.navigateToSettingsDataScreen
import com.xmg2024.xiangmo.ui.screen.settings.nav.navigateToSettingsGraph
import com.xmg2024.xiangmo.ui.screen.settings.nav.privacyScreen
import com.xmg2024.xiangmo.ui.screen.settings.nav.settingsDataScreen
import com.xmg2024.xiangmo.ui.screen.settings.nav.settingsGraph
import com.xmg2024.xiangmo.ui.screen.traditionalculture.calendar.nav.navigateToTraditionalCultureCalendarGraph
import com.xmg2024.xiangmo.ui.screen.traditionalculture.calendar.nav.traditionalCultureCalendarGraph
import com.xmg2024.xiangmo.ui.screen.traditionalculture.color.nav.navigateToTraditionalCultureColorIndexGraph
import com.xmg2024.xiangmo.ui.screen.traditionalculture.color.nav.navigateToTraditionalCultureColorShowScreen
import com.xmg2024.xiangmo.ui.screen.traditionalculture.color.nav.traditionalCultureColorIndexGraph
import com.xmg2024.xiangmo.ui.screen.traditionalculture.color.nav.traditionalCultureColorShowScreen
import com.xmg2024.xiangmo.ui.screen.traditionalculture.festival.nav.navigateToTraditionalCultureFestivalIndexGraph
import com.xmg2024.xiangmo.ui.screen.traditionalculture.festival.nav.navigateToTraditionalCultureFestivalShowScreen
import com.xmg2024.xiangmo.ui.screen.traditionalculture.festival.nav.traditionalCultureFestivalIndexGraph
import com.xmg2024.xiangmo.ui.screen.traditionalculture.festival.nav.traditionalCultureFestivalShowScreen
import com.xmg2024.xiangmo.ui.screen.traditionalculture.solarterm.nav.navigateToTraditionalCultureSolarTermIndexGraph
import com.xmg2024.xiangmo.ui.screen.traditionalculture.solarterm.nav.navigateToTraditionalCultureSolarTermShowScreen
import com.xmg2024.xiangmo.ui.screen.traditionalculture.solarterm.nav.traditionalCultureSolarTermIndexGraph
import com.xmg2024.xiangmo.ui.screen.traditionalculture.solarterm.nav.traditionalCultureSolarTermShowScreen

@Composable
fun AppNavHost(
    navController: NavHostController
) {
    val animationTime = 500

    NavHost(
        navController = navController,
        startDestination = ROUTE_HOME_GRAPH,
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { it },
                animationSpec = tween(durationMillis = animationTime)
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.End,
                animationSpec = tween(durationMillis = animationTime)
            )
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(durationMillis = animationTime)
            )
        }
    ) {
        homeGraph(
            onChinaWorldCultureHeritageClick = { navController.navigateToChinaWorldCultureHeritageGraph() },
            onChineseAntitheticalCoupletClick = { navController.navigateToChineseAntitheticalCoupletIndexGraph() },
            onChineseCharacterClick = { navController.navigateToChineseCharacterIndexGraph() },
            onChineseExpressionClick = { navController.navigateToChineseExpressionGraph() },
            onChineseIdiomClick = { navController.navigateToChineseIdiomIndexGraph() },
            onChineseKnowledgeClick = { navController.navigateToChineseKnowledgeIndexGraph() },
            onChineseLyricClick = { navController.navigateToChineseLyricIndexGraph() },
            onChineseModernPoetryClick = navController::navigateToChineseModernPoetryIndexGraph,
            onChineseProverbClick = { navController.navigateToChineseProverbIndexGraph() },
            onChineseQuoteClick = navController::navigateToChineseQuoteIndexGraph,
            onChineseRiddleClick = { navController.navigateToChineseRiddleIndexGraph() },
            onChineseTongueTwisterClick = { navController.navigateToChineseTongueTwisterIndexGraph() },
            onChineseWisecrackClick = { navController.navigateToChineseWisecrackIndexGraph() },
            onClassicalLiteratureClassicPoemClick = { navController.navigateToClassicalLiteratureClassicPoemIndexGraph() },
            onClassicalLiteraturePeopleClick = { navController.navigateToClassicalLiteraturePeopleGraph() },
            onClassicalLiteratureSentenceClick = { navController.navigateToClassicalLiteratureSentenceIndexGraph() },
            onClassicalLiteratureWritingClick = { navController.navigateToClassicalLiteratureWritingIndexGraph() },
            onTraditionalCultureCalendarClick = navController::navigateToTraditionalCultureCalendarGraph,
            onTraditionalCultureColorClick = { navController.navigateToTraditionalCultureColorIndexGraph() },
            onTraditionalCultureFestivalClick = { navController.navigateToTraditionalCultureFestivalIndexGraph() },
            onTraditionalCultureSolarTermsClick = { navController.navigateToTraditionalCultureSolarTermIndexGraph() },
            onLinksClick = { navController.navigateToLinkIndexScreen() },
            onSettingsClick = { navController.navigateToSettingsGraph() },
            nestGraph = {
                chinaWorldCultureHeritageGraph(
                    onBackClick = navController::navigateUp,
                    onItemClick = { navController.navigateToChinaWorldCultureHeritageShowScreen(it) }
                ) {
                    chinaWorldCultureHeritageShowScreen(
                        onBackClick = navController::navigateUp
                    )
                }
                chineseAntitheticalCoupletIndexGraph(
                    onBackClick = navController::navigateUp,
                    onReadMoreClick = { navController.navigateToChineseAntitheticalCoupletReadScreen() },
                    onBookmarksClick = { navController.navigateToChineseAntitheticalCoupletBookmarksScreen() },
                    onSearchClick = { navController.navigateToChineseAntitheticalCoupletSearchScreen() },
                    nestGraph = {
                        chineseAntitheticalCoupletBookmarksScreen(
                            onBackClick = navController::navigateUp,
                            onItemClick = {
                                navController.navigateToChineseAntitheticalCoupletShowScreen(
                                    it.toString()
                                )
                            }
                        )
                        chineseAntitheticalCoupletCaptureScreen(
                            onBackClick = navController::navigateUp
                        )
                        chineseAntitheticalCoupletReadScreen(
                            onBackClick = navController::navigateUp,
                            onCaptureClick = {
                                navController.navigateToChineseAntitheticalCoupletCaptureScreen(
                                    it.toString()
                                )
                            }
                        )
                        chineseAntitheticalCoupletShowScreen(
                            onBackClick = navController::navigateUp,
                            onCaptureClick = {
                                navController.navigateToChineseAntitheticalCoupletCaptureScreen(
                                    it.toString()
                                )
                            }
                        )
                        chineseAntitheticalCoupletSearchScreen(
                            onBackClick = navController::navigateUp,
                            onItemClick = {
                                navController.navigateToChineseAntitheticalCoupletShowScreen(
                                    it.toString()
                                )
                            }
                        )
                    }
                )
                chineseCharacterIndexGraph(
                    onBackClick = navController::navigateUp,
                    onBookmarksClick = { navController.navigateToChineseCharacterBookmarksScreen() },
                    onPinyinSearchClick = { navController.navigateToChineseCharacterPinyinIndexScreen() },
                    onRadicalClickSearch = { navController.navigateToChineseCharacterRadicalIndexScreen() },
                    onStrokeSearchClick = { navController.navigateToChineseCharacterStrokeIndexScreen() },
                    onStrokeClick = { navController.navigateToChineseCharacterStrokeScreen() },
                    onSearchClick = { char, type ->
                        navController.navigateToChineseCharacterSearchListScreen(
                            char,
                            type
                        )
                    },
                    nestGraph = {
                        chineseCharacterBookmarksScreen(
                            onBackClick = navController::navigateUp,
                            onItemClick = { navController.navigateToChineseCharacterShowScreen(it.toString()) },
                        )
                        chineseCharacterPinyinIndexScreen(
                            onBackClick = navController::navigateUp,
                            onItemClick = { pinyin, type ->
                                navController.navigateToChineseCharacterSearchListScreen(
                                    pinyin,
                                    type
                                )
                            },
                        )
                        chineseCharacterRadicalIndexScreen(
                            onBackClick = navController::navigateUp,
                            onItemClick = { radical, type ->
                                navController.navigateToChineseCharacterSearchListScreen(
                                    radical,
                                    type
                                )
                            },
                        )
                        chineseCharacterStrokeIndexScreen(
                            onBackClick = navController::navigateUp,
                            onItemClick = { stroke, type ->
                                navController.navigateToChineseCharacterSearchListScreen(
                                    stroke,
                                    type
                                )
                            },
                        )
                        chineseCharacterSearchListScreen(
                            onBackClick = navController::navigateUp,
                            onItemClick = { navController.navigateToChineseCharacterShowScreen(it) }
                        )
                        chineseCharacterShowScreen(
                            onBackClick = navController::navigateUp,
                        )
                        chineseCharacterStrokeScreen(
                            onBackClick = navController::navigateUp
                        )
                    }
                )

                chineseExpressionGraph(
                    onBackClick = navController::navigateUp,
                    onBookmarksClick = { navController.navigateToChineseExpressionBookmarksScreen() },
                    onSearchClick = { navController.navigateToChineseExpressionSearchScreen() },
                    nestGraph = {
                        chineseExpressionBookmarksScreen(
                            onBackClick = navController::navigateUp,
                            onItemClick = { navController.navigateToChineseExpressionShow(it) }
                        )
                        chineseExpressionSearchScreen(
                            onBackClick = navController::navigateUp,
                            onItemClick = { navController.navigateToChineseExpressionShow(it) }
                        )
                        chineseExpressionShowScreen(
                            onBackClick = navController::navigateUp
                        )
                    }
                )
                chineseIdiomIndexGraph(
                    onBackClick = navController::navigateUp,
                    onReadMoreClick = { navController.navigateToChineseIdiomReadScreen() },
                    onBookmarksClick = { navController.navigateToChineseIdiomBookmarksScreen() },
                    onSearchClick = { navController.navigateToChineseIdiomSearchScreen() },
                    nestGraph = {
                        chineseIdiomSearchScreen(
                            onBackClick = navController::navigateUp,
                            onItemClick = { navController.navigateToChineseIdiomShowScreen(it.toString()) },
                        )
                        chineseIdiomShowScreen(
                            onBackClick = navController::navigateUp,
                            onCaptureClick = { navController.navigateToChineseIdiomCaptureScreen(it.toString()) },
                        )
                        chineseIdiomReadScreen(
                            onBackClick = navController::navigateUp,
                            onCaptureClick = { navController.navigateToChineseIdiomCaptureScreen(it.toString()) }
                        )
                        chineseIdiomCaptureScreen(
                            onBackClick = navController::navigateUp
                        )
                        chineseIdiomBookmarksScreen(
                            onBackClick = navController::navigateUp,
                            onItemClick = { navController.navigateToChineseIdiomShowScreen(it.toString()) }
                        )
                    }
                )
                chineseKnowledgeIndexGraph(
                    onBackClick = navController::navigateUp,
                    onBookmarksClick = { navController.navigateToChineseKnowledgeBookmarksScreen() },
                    onReadMoreClick = { navController.navigateToChineseKnowledgeReadScreen() },
                    onSearchClick = { navController.navigateToChineseKnowSearchScreen() },
                    nestGraph = {
                        chineseKnowledgeBookmarksScreen(
                            onBackClick = navController::navigateUp,
                            onItemClick = { navController.navigateToChineseKnowledgeShowScreen(it.toString()) }
                        )
                        chineseKnowledgeReadScreen(
                            onBackClick = navController::navigateUp,
                        )
                        chineseKnowledgeSearchScreen(
                            onBackClick = navController::navigateUp,
                            onItemClick = { navController.navigateToChineseKnowledgeShowScreen(it.toString()) }
                        )
                        chineseKnowledgeShowScreen(
                            onBackClick = navController::navigateUp
                        )
                    }
                )
                chineseLyricIndexGraph(
                    onBackClick = navController::navigateUp,
                    onBookmarksClick = { navController.navigateToChineseLyricBookmarksScreen() },
                    onReadMoreClick = { navController.navigateToChineseLyricReadScreen() },
                    onSearchClick = { navController.navigateToChineseLyricSearchScreen() },
                    nestGraph = {
                        chineseLyricBookmarksScreen(
                            onBackClick = navController::navigateUp,
                            onItemClick = { navController.navigateToChineseLyricShowScreen(it.toString()) }
                        )
                        chineseLyricReadScreen(
                            onBackClick = navController::navigateUp,
                        )
                        chineseLyricSearchScreen(
                            onBackClick = navController::navigateUp,
                            onItemClick = { navController.navigateToChineseLyricShowScreen(it.toString()) }
                        )
                        chineseLyricShowScreen(
                            onBackClick = navController::navigateUp
                        )
                    }
                )
                chineseModernPoetryIndexGraph(
                    onBackClick = navController::navigateUp,
                    onBookmarksClick = navController::navigateToChineseModernPoetryBookmarksScreen,
                    onReadMoreClick = navController::navigateToChineseModernPoetryReadScreen,
                    onSearchClick = navController::navigateToChineseModernPoetrySearchScreen,
                    nestGraph = {
                        chineseModernPoetryBookmarksScreen(
                            onBackClick = navController::navigateUp,
                            onItemClick = navController::navigateToChineseModernPoetryShowScreen
                        )
                        chineseModernPoetryReadScreen(
                            onBackClick = navController::navigateUp
                        )
                        chineseModernPoetrySearchScreen(
                            onBackClick = navController::navigateUp,
                            onItemClick = navController::navigateToChineseModernPoetryShowScreen
                        )
                        chineseModernPoetryShowScreen(
                            onBackClick = navController::navigateUp
                        )
                    }
                )
                chineseProverbIndexGraph(
                    onBackClick = navController::navigateUp,
                    onBookmarksClick = { navController.navigateToChineseProverbBookmarksScreen() },
                    onReadMoreClick = { navController.navigateToChineseProverbReadScreen() },
                    onSearchClick = { navController.navigateToChineseProverbSearchScreen() },
                    nestGraph = {
                        chineseProverbBookmarksScreen(
                            onBackClick = navController::navigateUp,
                            onItemClick = { navController.navigateToChineseProverbShowScreen(it.toString()) }
                        )
                        chineseProverbReadScreen(
                            onBackClick = navController::navigateUp
                        )
                        chineseProverbSearchScreen(
                            onBackClick = navController::navigateUp,
                            onItemClick = { navController.navigateToChineseProverbShowScreen(it.toString()) }
                        )
                        chineseProverbShowScreen(
                            onBackClick = navController::navigateUp
                        )
                    }
                )
                chineseQuoteIndexGraph(
                    onBackClick = navController::navigateUp,
                    onBookmarksClick = navController::navigateToChineseQuoteBookmarksScreen,
                    onReadMoreClick = navController::navigateToChineseQuoteReadScreen,
                    onSearchClick = navController::navigateToChineseQuoteSearchScreen,
                    nestGraph = {
                        chineseQuoteBookmarksScreen(
                            onBackClick = navController::navigateUp,
                            onItemClick = navController::navigateToChineseQuoteShowScreen
                        )
                        chineseQuoteReadScreen(
                            onBackClick = navController::navigateUp
                        )
                        chineseQuoteSearchScreen(
                            onBackClick = navController::navigateUp,
                            onItemClick = navController::navigateToChineseQuoteShowScreen
                        )
                        chineseQuoteShowScreen(
                            onBackClick = navController::navigateUp
                        )
                    }
                )
                chineseRiddleIndexGraph(
                    onBackClick = navController::navigateUp,
                    onInfoClick = { navController.navigateToChineseRiddleInfoScreen() },
                    onReadMoreClick = { navController.navigateToChineseRiddleReadScreen() },
                    onSearchClick = { navController.navigateToChineseRiddleSearchScreen() },
                    nestGraph = {
                        chineseRiddleInfoScreen(
                            onBackClick = navController::navigateUp
                        )
                        chineseRiddleReadScreen(
                            onBackClick = navController::navigateUp,
                            onInfoClick = { navController.navigateToChineseRiddleInfoScreen() },
                        )
                        chineseRiddleSearchScreen(
                            onBackClick = navController::navigateUp
                        )
                    }
                )
                chineseTongueTwisterIndexGraph(
                    onBackClick = navController::navigateUp,
                    onItemsClick = { navController.navigateToChineseTongueTwisterShowScreen(it.toString()) },
                    nestGraph = {
                        chineseTongueTwisterShowScreen(
                            onBackClick = navController::navigateUp
                        )
                    }
                )
                chineseWisecrackIndexGraph(
                    onBackClick = navController::navigateUp,
                    onBookmarksClick = { navController.navigateToChineseWisecrackBookmarksScreen() },
                    onCaptureClick = { navController.navigateToChineseWisecrackCaptureScreen(it.toString()) },
                    onReadMoreClick = { navController.navigateToChineseWisecrackReadScreen() },
                    onSearchClick = { navController.navigateToChineseWisecrackSearchScreen() },
                    nestGraph = {
                        chineseWisecrackCaptureScreen(
                            onBackClick = navController::navigateUp
                        )
                        chineseWisecrackReadScreen(
                            onBackClick = navController::navigateUp,
                            onCaptureClick = {
                                navController.navigateToChineseWisecrackCaptureScreen(
                                    it.toString()
                                )
                            },
                        )
                        chineseWisecrackSearchScreen(
                            onBackClick = navController::navigateUp,
                            onItemClick = {
                                navController.navigateToChineseWisecrackShowScreen(it.toString())
                            }
                        )
                        chineseWisecrackShowScreen(
                            onBackClick = navController::navigateUp,
                            onCaptureClick = {
                                navController.navigateToChineseWisecrackCaptureScreen(
                                    it.toString()
                                )
                            },
                        )
                        chineseWisecrackBookmarksScreen(
                            onBackClick = navController::navigateUp
                        )
                    }
                )
                classicalLiteratureClassicPoemIndexGraph(
                    onBackClick = navController::navigateUp,
                    onBookmarksClick = { navController.navigateToClassicalLiteratureClassicPoemBookmarksGraph() },
                    onReadMoreClick = { navController.navigateToClassicalLiteratureClassicPoemReadScreen() },
                    onSearchClick = { navController.navigateToClassicalLiteratureClassicPoemSearchScreen() },
                    nestGraph = {
                        classicalLiteratureClassicPoemBookmarksGraph(
                            onBackClick = navController::navigateUp,
                            onReadClick = {
                                navController.navigateToClassicalLiteratureClassicPoemShowScreen(it)
                            },
                            nestGraph = {
                                classicalLiteratureClassicPoemShowScreen(
                                    onBackClick = navController::navigateUp
                                )
                            }
                        )
                        classicalLiteratureClassicPoemReadScreen(
                            onBackClick = navController::navigateUp
                        )
                        classicalLiteratureClassicPoemSearchScreen(
                            onBackClick = navController::navigateUp,
                            onItemClick = {
                                navController.navigateToClassicalLiteratureClassicPoemShowScreen(it)
                            },
                        )
                    }
                )
                classicalLiteratureSentenceIndexGraph(
                    onBackClick = navController::navigateUp,
                    onBookmarksClick = { navController.navigateToClassicalLiteratureSentenceBookmarksScreen() },
                    onCaptureClick = {
                        navController.navigateToClassicalLiteratureSentenceCaptureScreen(
                            it.toString()
                        )
                    },
                    onReadMoreClick = { navController.navigateToClassicalLiteratureSentenceReadScreen() },
                    onSearchClick = { navController.navigateToClassicalLiteratureSentenceSearchScreen() },
                    nestGraph = {
                        classicalLiteratureSentenceBookmarksScreen(
                            onBackClick = navController::navigateUp
                        )
                        classicalLiteratureSentenceCaptureScreen(
                            onBackClick = navController::navigateUp
                        )
                        classicalLiteratureSentenceReadScreen(
                            onBackClick = navController::navigateUp,
                            onCaptureClick = {
                                navController.navigateToClassicalLiteratureSentenceCaptureScreen(
                                    it.toString()
                                )
                            }
                        )
                        classicalLiteratureSentenceSearchScreen(
                            onBackClick = navController::navigateUp,
                            onCaptureClick = {
                                navController.navigateToClassicalLiteratureSentenceCaptureScreen(
                                    it.toString()
                                )
                            },
                        )
                    }
                )
                classicalLiteraturePeopleGraph(
                    onBackClick = navController::navigateUp,
                    onSearchClick = { navController.navigateToClassicalLiteraturePeopleSearchGraph() },
                    nestGraph = {
                        classicalLiteraturePeopleSearchGraph(
                            onBackClick = navController::navigateUp,
                            onItemClick = { type: String, query: String ->
                                navController.navigateToClassicalLiteraturePeopleShowScreen(
                                    type,
                                    query
                                )
                            },
                            nestGraph = {
                                classicalLiteraturePeopleShowScreen(
                                    onBackClick = navController::navigateUp,
                                )
                            }
                        )
                    }
                )
                classicalLiteratureWritingIndexGraph(
                    onBackClick = navController::navigateUp,
                    onSearchClick = {
                        navController.navigateToClassicalLiteratureWritingSearchScreen()
                    },
                    onBookmarksClick = { navController.navigateToClassicalLiteratureWritingBookmarksScreen() },
                    onReadMoreClick = {
                        navController.navigateToClassicalLiteratureWritingReadScreen()
                    },
                    nestGraph = {
                        classicalLiteratureWritingBookmarksScreen(
                            onBackClick = navController::navigateUp,
                            onItemClick = {
                                navController.navigateToClassicalLiteratureWritingShowScreen(it.toString())
                            }
                        )
                        classicalLiteratureWritingSearchScreen(
                            onBackClick = navController::navigateUp,
                            onItemClick = {
                                navController.navigateToClassicalLiteratureWritingShowScreen(it)
                            },
                        )
                        classicalLiteratureWritingShowScreen(
                            onBackClick = navController::navigateUp,
                            onCaptureClick = {
                                navController.navigateToClassicalLiteratureWritingCaptureScreen(
                                    it.toString()
                                )
                            }
                        )
                        classicalLiteratureWritingReadScreen(
                            onBackClick = navController::navigateUp,
                            onCaptureClick = {
                                navController.navigateToClassicalLiteratureWritingCaptureScreen(
                                    it.toString()
                                )
                            },
                        )
                        classicalLiteratureWritingCaptureScreen(
                            onBackClick = navController::navigateUp
                        )
                    }
                )
                traditionalCultureCalendarGraph(
                    onBackClick = navController::navigateUp,
                    nestGraph = {}
                )
                traditionalCultureColorIndexGraph(
                    onBackClick = navController::navigateUp,
                    onItemClick = { navController.navigateToTraditionalCultureColorShowScreen(it) },
                    nestGraph = {
                        traditionalCultureColorShowScreen(
                            onBackClick = navController::navigateUp
                        )
                    }
                )
                traditionalCultureFestivalIndexGraph(
                    onBackClick = navController::navigateUp,
                    onItemClick = { navController.navigateToTraditionalCultureFestivalShowScreen(it.toString()) },
                    nestGraph = {
                        traditionalCultureFestivalShowScreen(
                            onBackClick = navController::navigateUp
                        )
                    }
                )
                traditionalCultureSolarTermIndexGraph(
                    onBackClick = navController::navigateUp,
                    onItemClick = { navController.navigateToTraditionalCultureSolarTermShowScreen(it.toString()) },
                    nestGraph = {
                        traditionalCultureSolarTermShowScreen(
                            onBackClick = navController::navigateUp
                        )
                    }
                )
                linkIndexScreen(
                    onBackClick = navController::navigateUp
                )
                settingsGraph(
                    onAboutClick = { navController.navigateToAboutScreen() },
                    onBackClick = navController::navigateUp,
                    onDataClick = { navController.navigateToSettingsDataScreen() },
                    onHomeItemManagerClick = { navController.navigateToHomeItemManagerScreen() },
                    onImportClick = { navController.navigateToImportScreen() },
                    onPrivacyClick = { navController.navigateToPrivacyScreen() },
                    nestGraph = {
                        aboutScreen(
                            onBackClick = navController::navigateUp
                        )
                        homeItemManagerScreen(
                            onBackClick = navController::navigateUp
                        )
                        importScreen(
                            onBackClick = navController::navigateUp
                        )
                        privacyScreen(
                            onBackClick = navController::navigateUp
                        )
                        settingsDataScreen(
                            onBackClick = navController::navigateUp
                        )
                    }
                )
            }
        )
    }
}