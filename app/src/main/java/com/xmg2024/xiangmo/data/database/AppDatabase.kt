/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.data.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.DeleteTable
import androidx.room.RenameColumn
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.AutoMigrationSpec
import com.xmg2024.xiangmo.data.database.dao.ChinaWorldCulturalHeritageDao
import com.xmg2024.xiangmo.data.database.dao.ChineseAntitheticalCoupletDao
import com.xmg2024.xiangmo.data.database.dao.ChineseDictionaryDao
import com.xmg2024.xiangmo.data.database.dao.ChineseExpressionDao
import com.xmg2024.xiangmo.data.database.dao.ChineseIdiomDao
import com.xmg2024.xiangmo.data.database.dao.ChineseKnowledgeDao
import com.xmg2024.xiangmo.data.database.dao.ChineseLyricDao
import com.xmg2024.xiangmo.data.database.dao.ChineseModernPoetryDao
import com.xmg2024.xiangmo.data.database.dao.ChineseProverbDao
import com.xmg2024.xiangmo.data.database.dao.ChineseQuoteDao
import com.xmg2024.xiangmo.data.database.dao.ChineseRiddleDao
import com.xmg2024.xiangmo.data.database.dao.ChineseTongueTwisterDao
import com.xmg2024.xiangmo.data.database.dao.ChineseWisecrackDao
import com.xmg2024.xiangmo.data.database.dao.ClassicalLiteratureClassicPoemDao
import com.xmg2024.xiangmo.data.database.dao.ClassicalLiteraturePeopleDao
import com.xmg2024.xiangmo.data.database.dao.ClassicalLiteratureSentenceDao
import com.xmg2024.xiangmo.data.database.dao.ClassicalLiteratureWritingDao
import com.xmg2024.xiangmo.data.database.entity.china.WorldCulturalHeritageEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.AntitheticalCoupletCollectionEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.AntitheticalCoupletEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.DictionaryCollectionEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.DictionaryEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.DictionaryPinyinEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.ExpressionCollectionEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.ExpressionEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.IdiomCollectionEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.IdiomEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.KnowledgeCollectionEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.KnowledgeEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.KnowledgeFtsEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.LyricCollectionEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.LyricEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.LyricFtsEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.ModernPoetryCollectionEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.ModernPoetryEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.ModernPoetryFtsEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.ProverbCollectionEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.ProverbEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.ProverbFtsEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.QuoteCollectionEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.QuoteEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.QuoteFtsEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.RiddleEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.TongueTwisterEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.WisecrackCollectionEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.WisecrackEntity
import com.xmg2024.xiangmo.data.database.entity.classicalliterature.ClassicPoemCollectionEntity
import com.xmg2024.xiangmo.data.database.entity.classicalliterature.ClassicPoemEntity
import com.xmg2024.xiangmo.data.database.entity.classicalliterature.ClassicPoemFtsEntity
import com.xmg2024.xiangmo.data.database.entity.classicalliterature.PeopleEntity
import com.xmg2024.xiangmo.data.database.entity.classicalliterature.SentenceCollectionEntity
import com.xmg2024.xiangmo.data.database.entity.classicalliterature.SentenceEntity
import com.xmg2024.xiangmo.data.database.entity.classicalliterature.WritingCollectionEntity
import com.xmg2024.xiangmo.data.database.entity.classicalliterature.WritingEntity
import com.xmg2024.xiangmo.data.database.entity.classicalliterature.WritingFtsEntity
import com.xmg2024.xiangmo.data.database.util.IntListConverter
import com.xmg2024.xiangmo.data.database.util.PeopleAliasListConverter
import com.xmg2024.xiangmo.data.database.util.PeopleDetailListConverter
import com.xmg2024.xiangmo.data.database.util.PeopleHometownListConverter
import com.xmg2024.xiangmo.data.database.util.StringListConverter
import com.xmg2024.xiangmo.data.database.util.WritingAllusionListConverter
import com.xmg2024.xiangmo.data.database.util.WritingClauseListConverter
import com.xmg2024.xiangmo.data.database.util.WritingCommentListConverter
import com.xmg2024.xiangmo.data.database.util.WritingQuoteListConverter

/**
 *  entities 数组中添加 data class 或其中的 data class 发生任何变化， 先 version + 1, 然后再 Build。
 *  app/schemas 目录下，保存 exportSchema 数据
 */
@Database(
    entities = [
        AntitheticalCoupletEntity::class,
        AntitheticalCoupletCollectionEntity::class,
        ClassicPoemCollectionEntity::class,
        ClassicPoemEntity::class,
        ClassicPoemFtsEntity::class,
        PeopleEntity::class,
        WritingCollectionEntity::class,
        WritingEntity::class,
        WritingFtsEntity::class,
        SentenceCollectionEntity::class,
        SentenceEntity::class,
        ExpressionCollectionEntity::class,
        ExpressionEntity::class,
        WisecrackCollectionEntity::class,
        WisecrackEntity::class,
        DictionaryCollectionEntity::class,
        DictionaryEntity::class,
        DictionaryPinyinEntity::class,
        IdiomCollectionEntity::class,
        IdiomEntity::class,
        KnowledgeCollectionEntity::class,
        KnowledgeEntity::class,
        KnowledgeFtsEntity::class,
        LyricCollectionEntity::class,
        LyricEntity::class,
        LyricFtsEntity::class,
        ModernPoetryCollectionEntity::class,
        ModernPoetryEntity::class,
        ModernPoetryFtsEntity::class,
        ProverbEntity::class,
        ProverbCollectionEntity::class,
        ProverbFtsEntity::class,
        QuoteCollectionEntity::class,
        QuoteEntity::class,
        QuoteFtsEntity::class,
        RiddleEntity::class,
        TongueTwisterEntity::class,
        WorldCulturalHeritageEntity::class,
    ],
    version = 27,
    autoMigrations = [
        AutoMigration(from = 1, to = 2),
        AutoMigration(from = 2, to = 3),
        AutoMigration(from = 3, to = 4),
        AutoMigration(from = 4, to = 5),
        AutoMigration(from = 5, to = 6),
        AutoMigration(from = 6, to = 7),
        AutoMigration(from = 7, to = 8, spec = AppDatabase.AutoMigration7To8::class),
        AutoMigration(from = 8, to = 9, spec = AppDatabase.AutoMigration8To9::class),
        AutoMigration(from = 9, to = 10),
        AutoMigration(from = 10, to = 11),
        AutoMigration(from = 11, to = 12),
        AutoMigration(from = 12, to = 13),
        AutoMigration(from = 13, to = 14, spec = AppDatabase.AutoMigration13To14::class),
        AutoMigration(from = 14, to = 15),
        AutoMigration(from = 15, to = 16),
        AutoMigration(from = 16, to = 17),
        AutoMigration(from = 17, to = 18),
        AutoMigration(from = 18, to = 19, spec = AppDatabase.AutoMigration18To19::class),
        AutoMigration(from = 19, to = 20),
        AutoMigration(from = 20, to = 21),
        AutoMigration(from = 21, to = 22),
        AutoMigration(from = 22, to = 23),
        AutoMigration(from = 23, to = 24),
        AutoMigration(from = 24, to = 25),
        AutoMigration(from = 25, to = 26, spec = AppDatabase.AutoMigration25To26::class),
        AutoMigration(from = 26, to = 27),
    ],
    exportSchema = true
)
@TypeConverters(
    IntListConverter::class,
    PeopleAliasListConverter::class,
    PeopleDetailListConverter::class,
    PeopleHometownListConverter::class,
    StringListConverter::class,
    WritingAllusionListConverter::class,
    WritingClauseListConverter::class,
    WritingCommentListConverter::class,
    WritingQuoteListConverter::class,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun antitheticalCoupletDao(): ChineseAntitheticalCoupletDao
    abstract fun chineseModernPoetryDao(): ChineseModernPoetryDao
    abstract fun chineseQuoteDao(): ChineseQuoteDao
    abstract fun expressionDao(): ChineseExpressionDao
    abstract fun knowledgeDao(): ChineseKnowledgeDao
    abstract fun wisecrackDao(): ChineseWisecrackDao
    abstract fun dictionaryDao(): ChineseDictionaryDao
    abstract fun idiomDao(): ChineseIdiomDao
    abstract fun lyricDao(): ChineseLyricDao
    abstract fun proverbDao(): ChineseProverbDao
    abstract fun riddleDao(): ChineseRiddleDao
    abstract fun tongueTwisterDao(): ChineseTongueTwisterDao
    abstract fun classicPoemDao(): ClassicalLiteratureClassicPoemDao
    abstract fun peopleDao(): ClassicalLiteraturePeopleDao
    abstract fun sentenceDao(): ClassicalLiteratureSentenceDao
    abstract fun writingDao(): ClassicalLiteratureWritingDao
    abstract fun worldCulturalHeritageDao(): ChinaWorldCulturalHeritageDao

    @DeleteTable(
        tableName = "poems"
    )
    @DeleteTable(
        tableName = "poem_tag"
    )
    @DeleteTable(
        tableName = "tags"
    )
    @DeleteTable(
        tableName = "writers"
    )
    class AutoMigration7To8 : AutoMigrationSpec

    @RenameColumn(
        tableName = "chinese_knowledge",
        fromColumnName = "id",
        toColumnName = "rowid"
    )
    class AutoMigration8To9 : AutoMigrationSpec

    @DeleteTable(
        tableName = "idioms"
    )
    @DeleteTable(
        tableName = "idiom_collections"
    )
    class AutoMigration13To14 : AutoMigrationSpec

    @DeleteTable(
        tableName = "chinese_knowledge"
    )
    class AutoMigration18To19 : AutoMigrationSpec

    @DeleteTable(
        tableName = "writings"
    )
    class AutoMigration25To26 : AutoMigrationSpec
}