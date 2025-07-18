/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) 贺丰宝（hefengbao） <hefengbao@foxmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.data.repository.settings

import com.hefengbao.jingmo.data.model.HomeItem
import kotlinx.coroutines.flow.Flow

interface HomeItemRepository {
    suspend fun setChinaWorldCultureHeritage(checked: Boolean)
    suspend fun setChineseAntitheticalCouplet(checked: Boolean)
    suspend fun setChineseCharacter(checked: Boolean)
    suspend fun setChineseExpression(checked: Boolean)
    suspend fun setChineseIdiom(checked: Boolean)
    suspend fun setChineseKnowledge(checked: Boolean)
    suspend fun setChineseLyric(checked: Boolean)
    suspend fun setChineseModernPoetry(checked: Boolean)
    suspend fun setChineseProverb(checked: Boolean)
    suspend fun setChineseQuote(checked: Boolean)
    suspend fun setChineseRiddle(checked: Boolean)
    suspend fun setChineseTongueTwister(checked: Boolean)
    suspend fun setChineseWisecrack(checked: Boolean)
    suspend fun setClassicalLiteratureClassicPoem(checked: Boolean)
    suspend fun setClassicalLiteraturePeople(checked: Boolean)
    suspend fun setClassicalLiteratureSentence(checked: Boolean)
    suspend fun setClassicalLiteratureWriting(checked: Boolean)
    suspend fun setTraditionalCultureCalendar(checked: Boolean)
    suspend fun setTraditionalCultureColor(checked: Boolean)
    suspend fun setTraditionalCultureFestival(checked: Boolean)
    suspend fun setTraditionalCultureSolarTerm(checked: Boolean)
    fun getHomeItem(): Flow<HomeItem>
}