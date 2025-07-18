/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.di

import android.content.Context
import androidx.room.Room.databaseBuilder
import com.xmg2024.xiangmo.common.Constant
import com.xmg2024.xiangmo.data.database.AppDatabase
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
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun providesAppDatabase(
        @ApplicationContext context: Context,
    ): AppDatabase = databaseBuilder(
        context,
        AppDatabase::class.java,
        Constant.DB_NAME,
    ).build()

    @Provides
    @Singleton
    fun providesChinaWorldCultureHeritageDao(
        database: AppDatabase
    ): ChinaWorldCulturalHeritageDao = database.worldCulturalHeritageDao()

    @Provides
    @Singleton
    fun providesChineseAntitheticalCoupletDao(
        database: AppDatabase
    ): ChineseAntitheticalCoupletDao = database.antitheticalCoupletDao()

    @Provides
    @Singleton
    fun providesChineseExpressionDao(
        database: AppDatabase
    ): ChineseExpressionDao = database.expressionDao()

    @Provides
    @Singleton
    fun providesChineseKnowledgeDao(
        database: AppDatabase
    ): ChineseKnowledgeDao = database.knowledgeDao()

    @Provides
    @Singleton
    fun providesChineseModernPoetryDao(
        database: AppDatabase
    ): ChineseModernPoetryDao = database.chineseModernPoetryDao()

    @Provides
    @Singleton
    fun providesChineseWisecrackDao(
        database: AppDatabase
    ): ChineseWisecrackDao = database.wisecrackDao()

    @Provides
    @Singleton
    fun providesChineseDictionaryDao(
        database: AppDatabase
    ): ChineseDictionaryDao = database.dictionaryDao()

    @Provides
    @Singleton
    fun providesChineseIdiomDao(
        database: AppDatabase
    ): ChineseIdiomDao = database.idiomDao()

    @Provides
    @Singleton
    fun providesChineseLyricDao(
        database: AppDatabase
    ): ChineseLyricDao = database.lyricDao()

    @Provides
    @Singleton
    fun providesChineseProverbDao(
        database: AppDatabase
    ): ChineseProverbDao = database.proverbDao()

    @Provides
    @Singleton
    fun providesChineseQuoteDao(
        database: AppDatabase
    ): ChineseQuoteDao = database.chineseQuoteDao()

    @Provides
    @Singleton
    fun providesClassicalLiteratureClassicPoemDao(
        database: AppDatabase
    ): ClassicalLiteratureClassicPoemDao = database.classicPoemDao()

    @Provides
    @Singleton
    fun providesClassicalLiteraturePeopleDao(
        database: AppDatabase
    ): ClassicalLiteraturePeopleDao = database.peopleDao()

    @Provides
    @Singleton
    fun providesClassicalLiteratureSentenceDao(
        database: AppDatabase
    ): ClassicalLiteratureSentenceDao = database.sentenceDao()

    @Provides
    @Singleton
    fun providesChineseRiddleDao(
        database: AppDatabase
    ): ChineseRiddleDao = database.riddleDao()

    @Provides
    @Singleton
    fun providesChineseTongueTwisterDao(
        database: AppDatabase
    ): ChineseTongueTwisterDao = database.tongueTwisterDao()

    @Provides
    @Singleton
    fun providesClassicalLiteratureWritingDao(
        database: AppDatabase
    ): ClassicalLiteratureWritingDao = database.writingDao()
}