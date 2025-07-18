/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.data.network

import com.xmg2024.xiangmo.data.model.Dataset
import com.xmg2024.xiangmo.data.model.china.WorldCulturalHeritage
import com.xmg2024.xiangmo.data.model.chinese.AntitheticalCouplet
import com.xmg2024.xiangmo.data.model.chinese.ChineseKnowledge
import com.xmg2024.xiangmo.data.model.chinese.ChineseWisecrack
import com.xmg2024.xiangmo.data.model.chinese.DictionaryWrapper
import com.xmg2024.xiangmo.data.model.chinese.ExpressionWrapper
import com.xmg2024.xiangmo.data.model.chinese.IdiomWrapper
import com.xmg2024.xiangmo.data.model.chinese.Lyric
import com.xmg2024.xiangmo.data.model.chinese.ModernPoetry
import com.xmg2024.xiangmo.data.model.chinese.Proverb
import com.xmg2024.xiangmo.data.model.chinese.Quote
import com.xmg2024.xiangmo.data.model.chinese.Riddle
import com.xmg2024.xiangmo.data.model.chinese.TongueTwister
import com.xmg2024.xiangmo.data.model.classicalliterature.ClassicPoem
import com.xmg2024.xiangmo.data.model.classicalliterature.PeopleWrapper
import com.xmg2024.xiangmo.data.model.classicalliterature.PoemSentence
import com.xmg2024.xiangmo.data.model.classicalliterature.WritingWrapper

interface Network {
    suspend fun dataset(): List<Dataset>
    suspend fun chinaWorldCultureHeritage(version: Int): List<WorldCulturalHeritage>
    suspend fun chineseAntitheticalCouplets(version: Int): List<AntitheticalCouplet>
    suspend fun chineseExpressions(version: Int, page: Int): ExpressionWrapper
    suspend fun chineseKnowledge(version: Int): List<ChineseKnowledge>
    suspend fun chineseModernPoetry(version: Int): List<ModernPoetry>
    suspend fun chineseQuotes(version: Int): List<Quote>
    suspend fun chineseWisecracks(version: Int): List<ChineseWisecrack>
    suspend fun chineseDictionary(version: Int, page: Int): DictionaryWrapper
    suspend fun chineseLyrics(version: Int): List<Lyric>
    suspend fun chineseIdioms(version: Int, page: Int): IdiomWrapper
    suspend fun chineseProverbs(version: Int): List<Proverb>
    suspend fun chineseRiddles(version: Int): List<Riddle>
    suspend fun chineseTongueTwisters(version: Int): List<TongueTwister>
    suspend fun classicalLiteratureClassicPoems(version: Int): List<ClassicPoem>
    suspend fun classicalLiteraturePeople(version: Int, page: Int): PeopleWrapper
    suspend fun classicalLiteratureSentences(version: Int): List<PoemSentence>
    suspend fun classicalLiteratureWritings(version: Int, page: Int): WritingWrapper
}