/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.data.repository.settings

import com.xmg2024.xiangmo.data.database.entity.china.WorldCulturalHeritageEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.AntitheticalCoupletEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.DictionaryEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.DictionaryPinyinEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.ExpressionEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.IdiomEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.KnowledgeEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.LyricEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.ModernPoetryEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.ProverbEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.QuoteEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.RiddleEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.TongueTwisterEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.WisecrackEntity
import com.xmg2024.xiangmo.data.database.entity.classicalliterature.ClassicPoemEntity
import com.xmg2024.xiangmo.data.database.entity.classicalliterature.PeopleEntity
import com.xmg2024.xiangmo.data.database.entity.classicalliterature.SentenceEntity
import com.xmg2024.xiangmo.data.database.entity.classicalliterature.WritingEntity
import kotlinx.coroutines.flow.Flow

interface ImportRepository {
    suspend fun insertChinaWorldCultureHeritage(entity: WorldCulturalHeritageEntity)
    suspend fun clearChinaWorldCultureHeritage()
    suspend fun insertChineseAntitheticalCouplet(entity: AntitheticalCoupletEntity)
    suspend fun clearChineseAntitheticalCouplet()
    suspend fun insertChineseExpression(entity: ExpressionEntity)
    suspend fun clearChineseExpressions()
    suspend fun insertChineseWisecrack(entity: WisecrackEntity)
    suspend fun clearChineseWisecracks()
    suspend fun insertChineseKnowledge(entity: KnowledgeEntity)
    suspend fun clearChineseKnowledge()
    suspend fun insertChineseProverb(entity: ProverbEntity)
    suspend fun clearChineseProverbs()
    suspend fun insertChineseQuote(entity: QuoteEntity)
    suspend fun clearChineseQuotes()
    suspend fun insertChineseDictionary(entity: DictionaryEntity)
    suspend fun insertChineseDictionaryPinyin(entity: DictionaryPinyinEntity)
    suspend fun clearChineseDictionaries()
    suspend fun insertChineseIdiom(entity: IdiomEntity)
    suspend fun clearChineseIdioms()
    suspend fun insertChineseLyric(entity: LyricEntity)
    suspend fun clearChineseLyrics()
    suspend fun insertChineseModernPoetry(entity: ModernPoetryEntity)
    suspend fun clearChineseModernPoetry()
    suspend fun insertChineseTongueTwister(entity: TongueTwisterEntity)
    suspend fun clearChineseTongueTwisters()
    suspend fun insertChineseRiddle(entity: RiddleEntity)
    suspend fun clearChineseRiddles()
    suspend fun insertClassicalLiteratureClassicPoems(entity: ClassicPoemEntity)
    suspend fun clearClassicalLiteratureClassicPoems()
    suspend fun insertClassicalLiteraturePeople(entity: PeopleEntity)
    suspend fun clearClassicalLiteraturePeople()
    suspend fun insertClassicalLiteratureSentence(entity: SentenceEntity)
    suspend fun clearClassicalLiteratureSentence()
    suspend fun insertClassicalLiteratureWriting(entity: WritingEntity)
    suspend fun clearClassicalLiteratureWritings()
    fun chinaChinaWorldCultureHeritageTotal(): Flow<Int>
    fun chineseAntitheticalCoupletTotal(): Flow<Int>
    fun chineseExpressionTotal(): Flow<Int>
    fun chineseWisecrackTotal(): Flow<Int>
    fun chineseKnowledgeTotal(): Flow<Int>
    fun chineseProverbTotal(): Flow<Int>
    fun chineseQuoteTotal(): Flow<Int>
    fun chineseDictionaryTotal(): Flow<Int>
    fun chineseIdiomTotal(): Flow<Int>
    fun chineseLyricTotal(): Flow<Int>
    fun chineseModernPoetryTotal(): Flow<Int>
    fun chineseTongueTwistersTotal(): Flow<Int>
    fun chineseRiddleTotal(): Flow<Int>
    fun classicalLiteratureClassicPoemTotal(): Flow<Int>
    fun classicalLiteraturePeopleTotal(): Flow<Int>
    fun classicalLiteratureSentenceTotal(): Flow<Int>
    fun classicalLiteratureWritingTotal(): Flow<Int>
}