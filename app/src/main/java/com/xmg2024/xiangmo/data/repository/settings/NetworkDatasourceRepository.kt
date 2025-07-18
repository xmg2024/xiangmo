/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.data.repository.settings

import com.xmg2024.xiangmo.common.network.Result
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

interface NetworkDatasourceRepository {
    suspend fun dataset(): Result<List<Dataset>>
    suspend fun insertChinaWorldCultureHeritage(entity: WorldCulturalHeritageEntity)
    suspend fun syncChinaWorldCultureHeritage(version: Int): Result<List<WorldCulturalHeritage>>
    suspend fun insertChineseAntitheticalCouplet(entity: AntitheticalCoupletEntity)
    suspend fun syncChineseAntitheticalCouplets(version: Int): Result<List<AntitheticalCouplet>>
    suspend fun clearChineseDictionaryPinyin()
    suspend fun insertChineseDictionary(entity: DictionaryEntity)
    suspend fun insertChineseDictionaryPinyin(entity: DictionaryPinyinEntity)
    suspend fun syncChineseDictionary(version: Int, page: Int): Result<DictionaryWrapper>
    suspend fun insertChineseExpression(entity: ExpressionEntity)
    suspend fun syncChineseExpressions(version: Int, page: Int): Result<ExpressionWrapper>
    suspend fun insertChineseIdiom(entity: IdiomEntity)
    suspend fun syncChineseIdioms(version: Int, page: Int): Result<IdiomWrapper>
    suspend fun insertChinesKnowledge(entity: KnowledgeEntity)
    suspend fun syncChineseKnowledge(version: Int): Result<List<ChineseKnowledge>>
    suspend fun insertChineseLyric(entity: LyricEntity)
    suspend fun syncChineseLyrics(version: Int): Result<List<Lyric>>
    suspend fun insertChineseModernPoetry(entity: ModernPoetryEntity)
    suspend fun syncChineseModernPoetry(version: Int): Result<List<ModernPoetry>>
    suspend fun insertChineseProverb(entity: ProverbEntity)
    suspend fun syncChineseProverbs(version: Int): Result<List<Proverb>>
    suspend fun insertChineseQuote(entity: QuoteEntity)
    suspend fun syncChineseQuotes(version: Int): Result<List<Quote>>
    suspend fun insertChineseRiddle(entity: RiddleEntity)
    suspend fun syncChineseRiddles(version: Int): Result<List<Riddle>>
    suspend fun insertChineseTongueTwister(entity: TongueTwisterEntity)
    suspend fun syncChineseTongueTwisters(version: Int): Result<List<TongueTwister>>
    suspend fun insertChineseWisecrack(entity: WisecrackEntity)
    suspend fun syncChineseWisecracks(version: Int): Result<List<ChineseWisecrack>>
    suspend fun insertClassicalLiteratureClassicPoem(entity: ClassicPoemEntity)
    suspend fun syncClassicalLiteratureClassicPoems(version: Int): Result<List<ClassicPoem>>
    suspend fun insertClassicalLiteraturePeople(entity: PeopleEntity)
    suspend fun syncClassicalLiteraturePeople(version: Int, page: Int): Result<PeopleWrapper>
    suspend fun insertClassicalLiteratureSentence(entity: SentenceEntity)
    suspend fun syncClassicalLiteratureSentence(version: Int): Result<List<PoemSentence>>
    suspend fun insertClassicalLiteratureWriting(entity: WritingEntity)
    suspend fun insertClassicalLiteratureWriting(entities: List<WritingEntity>)
    suspend fun syncClassicalLiteratureWritings(version: Int, page: Int): Result<WritingWrapper>
}