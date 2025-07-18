/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.data.network

import com.hefengbao.jingmo.data.model.Dataset
import com.hefengbao.jingmo.data.model.china.WorldCulturalHeritage
import com.hefengbao.jingmo.data.model.chinese.AntitheticalCouplet
import com.hefengbao.jingmo.data.model.chinese.ChineseKnowledge
import com.hefengbao.jingmo.data.model.chinese.ChineseWisecrack
import com.hefengbao.jingmo.data.model.chinese.DictionaryWrapper
import com.hefengbao.jingmo.data.model.chinese.ExpressionWrapper
import com.hefengbao.jingmo.data.model.chinese.IdiomWrapper
import com.hefengbao.jingmo.data.model.chinese.Lyric
import com.hefengbao.jingmo.data.model.chinese.ModernPoetry
import com.hefengbao.jingmo.data.model.chinese.Proverb
import com.hefengbao.jingmo.data.model.chinese.Quote
import com.hefengbao.jingmo.data.model.chinese.Riddle
import com.hefengbao.jingmo.data.model.chinese.TongueTwister
import com.hefengbao.jingmo.data.model.classicalliterature.ClassicPoem
import com.hefengbao.jingmo.data.model.classicalliterature.PeopleWrapper
import com.hefengbao.jingmo.data.model.classicalliterature.PoemSentence
import com.hefengbao.jingmo.data.model.classicalliterature.WritingWrapper

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