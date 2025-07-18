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
import com.xmg2024.xiangmo.data.network.Network
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

/*private const val baseUrl = "https://xmg2024.github.io/xiangmo-data/api/"
private const val baseUrl2 = "https://xmg2024.github.io/xiangmo-data2/api/"
private const val baseUrl3 = "https://xmg2024.github.io/xiangmo-data3/api/"*/
private const val baseUrl = "https://xiangmo-data.pages.dev/api/"
private const val baseUrl2 = "https://xiangmo-data2.pages.dev/api/"
private const val baseUrl3 = "https://xiangmo-data3.pages.dev/api/"

@Singleton
class NetworkImpl @Inject constructor(
    networkJson: Json,
    okhttpCallFactory: Call.Factory
) : Network {

    private val networkApi = Retrofit.Builder()
        .baseUrl(baseUrl)
        .callFactory(okhttpCallFactory)
        .addConverterFactory(
            networkJson.asConverterFactory("application/json".toMediaType())
        ).build()
        .create(Api::class.java)

    private val networkApi2 = Retrofit.Builder()
        .baseUrl(baseUrl2)
        .callFactory(okhttpCallFactory)
        .addConverterFactory(
            networkJson.asConverterFactory("application/json".toMediaType())
        ).build()
        .create(Api::class.java)

    private val networkApi3 = Retrofit.Builder()
        .baseUrl(baseUrl3)
        .callFactory(okhttpCallFactory)
        .addConverterFactory(
            networkJson.asConverterFactory("application/json".toMediaType())
        ).build()
        .create(Api::class.java)

    override suspend fun dataset(): List<Dataset> = networkApi.dataset()

    override suspend fun chinaWorldCultureHeritage(version: Int): List<WorldCulturalHeritage> =
        networkApi.chinaWorldCultureHeritage(version)

    override suspend fun chineseAntitheticalCouplets(version: Int): List<AntitheticalCouplet> =
        networkApi.chineseAntitheticalCouplet(version)

    override suspend fun chineseExpressions(version: Int, page: Int): ExpressionWrapper =
        networkApi.chineseExpressions(version, page)

    override suspend fun chineseKnowledge(version: Int): List<ChineseKnowledge> =
        networkApi.chineseKnowledge(version)

    override suspend fun chineseModernPoetry(version: Int): List<ModernPoetry> =
        networkApi.chineseModernPoetry(version)

    override suspend fun chineseQuotes(version: Int): List<Quote> =
        networkApi.chineseQuotes(version)

    override suspend fun chineseWisecracks(version: Int): List<ChineseWisecrack> =
        networkApi.chineseWisecracks(version)

    override suspend fun chineseDictionary(version: Int, page: Int): DictionaryWrapper =
        networkApi.chineseDictionary(version, page)

    override suspend fun chineseLyrics(version: Int): List<Lyric> =
        networkApi.chineseLyrics(version)

    override suspend fun chineseIdioms(version: Int, page: Int): IdiomWrapper =
        networkApi.chineseIdioms(version, page)

    override suspend fun chineseProverbs(version: Int): List<Proverb> =
        networkApi.chineseProverbs(version)

    override suspend fun chineseRiddles(version: Int): List<Riddle> =
        networkApi.chineseRiddles(version)

    override suspend fun chineseTongueTwisters(version: Int): List<TongueTwister> =
        networkApi.chineseTongueTwisters(version)

    override suspend fun classicalLiteratureClassicPoems(version: Int): List<ClassicPoem> =
        networkApi.classicalLiteratureClassicPoems(version)

    override suspend fun classicalLiteraturePeople(version: Int, page: Int): PeopleWrapper =
        networkApi.classicalLiteraturePeople(version, page)

    override suspend fun classicalLiteratureSentences(version: Int): List<PoemSentence> =
        networkApi.classicalLiteratureSentences(version)

    override suspend fun classicalLiteratureWritings(version: Int, page: Int): WritingWrapper =
        networkApi3.classicalLiteratureWritings(version, page)
}