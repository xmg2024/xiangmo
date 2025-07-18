/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.data.network.retrofit

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
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("dataset.json")
    suspend fun dataset(): List<Dataset>

    @GET("china_world_cultural_heritage_v{version}.json")
    suspend fun chinaWorldCultureHeritage(
        @Path("version") version: Int,
    ): List<WorldCulturalHeritage>

    @GET("chinese_antithetical_couplet_v{version}.json")
    suspend fun chineseAntitheticalCouplet(
        @Path("version") version: Int,
    ): List<AntitheticalCouplet>

    @GET("chinese_dict_v{version}_{page}.json")
    suspend fun chineseDictionary(
        @Path("version") version: Int,
        @Path("page") page: Int
    ): DictionaryWrapper

    @GET("chinese_expressions_v{version}_{page}.json")
    suspend fun chineseExpressions(
        @Path("version") version: Int,
        @Path("page") page: Int
    ): ExpressionWrapper

    @GET("chinese_idioms_v{version}_{page}.json")
    suspend fun chineseIdioms(
        @Path("version") version: Int,
        @Path("page") page: Int
    ): IdiomWrapper

    @GET("chinese_knowledge_v{version}.json")
    suspend fun chineseKnowledge(
        @Path("version") version: Int,
    ): List<ChineseKnowledge>

    @GET("chinese_lyrics_v{version}.json")
    suspend fun chineseLyrics(
        @Path("version") version: Int,
    ): List<Lyric>

    @GET("chinese_modern_poetry_v{version}.json")
    suspend fun chineseModernPoetry(
        @Path("version") version: Int,
    ): List<ModernPoetry>

    @GET("classical_literature_classic_poems_v{version}.json")
    suspend fun classicalLiteratureClassicPoems(
        @Path("version") version: Int,
    ): List<ClassicPoem>

    @GET("chinese_proverbs_v{version}.json")
    suspend fun chineseProverbs(
        @Path("version") version: Int,
    ): List<Proverb>

    @GET("chinese_quotes_v{version}.json")
    suspend fun chineseQuotes(
        @Path("version") version: Int,
    ): List<Quote>

    @GET("chinese_riddles_v{version}.json")
    suspend fun chineseRiddles(
        @Path("version") version: Int,
    ): List<Riddle>

    @GET("chinese_tongue_twisters_v{version}.json")
    suspend fun chineseTongueTwisters(
        @Path("version") version: Int,
    ): List<TongueTwister>

    @GET("chinese_wisecracks_v{version}.json")
    suspend fun chineseWisecracks(
        @Path("version") version: Int,
    ): List<ChineseWisecrack>

    @GET("classical_literature_people_v{version}_{page}.json")
    suspend fun classicalLiteraturePeople(
        @Path("version") version: Int,
        @Path("page") page: Int
    ): PeopleWrapper

    @GET("classical_literature_sentences_v{version}.json")
    suspend fun classicalLiteratureSentences(
        @Path("version") version: Int,
    ): List<PoemSentence>

    @GET("classical_literature_writings_v{version}_{page}.json")
    suspend fun classicalLiteratureWritings(
        @Path("version") version: Int,
        @Path("page") page: Int
    ): WritingWrapper
}