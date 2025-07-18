/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.di

import com.xmg2024.xiangmo.data.repository.LinksRepository
import com.xmg2024.xiangmo.data.repository.LinksRepositoryImpl
import com.xmg2024.xiangmo.data.repository.china.WorldCultureHeritageRepository
import com.xmg2024.xiangmo.data.repository.china.WorldCultureHeritageRepositoryImpl
import com.xmg2024.xiangmo.data.repository.chinese.AntitheticalCoupletRepository
import com.xmg2024.xiangmo.data.repository.chinese.AntitheticalCoupletRepositoryImpl
import com.xmg2024.xiangmo.data.repository.chinese.CharacterRepository
import com.xmg2024.xiangmo.data.repository.chinese.CharacterRepositoryImpl
import com.xmg2024.xiangmo.data.repository.chinese.ExpressionRepository
import com.xmg2024.xiangmo.data.repository.chinese.ExpressionRepositoryImpl
import com.xmg2024.xiangmo.data.repository.chinese.IdiomRepository
import com.xmg2024.xiangmo.data.repository.chinese.IdiomRepositoryImpl
import com.xmg2024.xiangmo.data.repository.chinese.KnowledgeRepository
import com.xmg2024.xiangmo.data.repository.chinese.KnowledgeRepositoryImpl
import com.xmg2024.xiangmo.data.repository.chinese.LyricRepository
import com.xmg2024.xiangmo.data.repository.chinese.LyricRepositoryImpl
import com.xmg2024.xiangmo.data.repository.chinese.ModernPoetryRepository
import com.xmg2024.xiangmo.data.repository.chinese.ModernPoetryRepositoryImpl
import com.xmg2024.xiangmo.data.repository.chinese.ProverbRepository
import com.xmg2024.xiangmo.data.repository.chinese.ProverbRepositoryImpl
import com.xmg2024.xiangmo.data.repository.chinese.QuoteRepository
import com.xmg2024.xiangmo.data.repository.chinese.QuoteRepositoryImpl
import com.xmg2024.xiangmo.data.repository.chinese.RiddleRepository
import com.xmg2024.xiangmo.data.repository.chinese.RiddleRepositoryImpl
import com.xmg2024.xiangmo.data.repository.chinese.TongueTwisterRepository
import com.xmg2024.xiangmo.data.repository.chinese.TongueTwisterRepositoryImpl
import com.xmg2024.xiangmo.data.repository.chinese.WisecrackRepository
import com.xmg2024.xiangmo.data.repository.chinese.WisecrackRepositoryImpl
import com.xmg2024.xiangmo.data.repository.classicalliterature.ClassicPoemRepository
import com.xmg2024.xiangmo.data.repository.classicalliterature.ClassicPoemRepositoryImpl
import com.xmg2024.xiangmo.data.repository.classicalliterature.PeopleRepository
import com.xmg2024.xiangmo.data.repository.classicalliterature.PeopleRepositoryImpl
import com.xmg2024.xiangmo.data.repository.classicalliterature.SentenceRepository
import com.xmg2024.xiangmo.data.repository.classicalliterature.SentenceRepositoryImpl
import com.xmg2024.xiangmo.data.repository.classicalliterature.WritingRepository
import com.xmg2024.xiangmo.data.repository.classicalliterature.WritingRepositoryImpl
import com.xmg2024.xiangmo.data.repository.settings.HomeItemRepository
import com.xmg2024.xiangmo.data.repository.settings.HomeItemRepositoryImpl
import com.xmg2024.xiangmo.data.repository.settings.ImportRepository
import com.xmg2024.xiangmo.data.repository.settings.ImportRepositoryImpl
import com.xmg2024.xiangmo.data.repository.settings.NetworkDatasourceRepository
import com.xmg2024.xiangmo.data.repository.settings.NetworkDatasourceRepositoryImpl
import com.xmg2024.xiangmo.data.repository.settings.PreferenceRepository
import com.xmg2024.xiangmo.data.repository.settings.PreferenceRepositoryImpl
import com.xmg2024.xiangmo.data.repository.settings.ThemeRepository
import com.xmg2024.xiangmo.data.repository.settings.ThemeRepositoryImpl
import com.xmg2024.xiangmo.data.repository.traditionalculture.ColorRepository
import com.xmg2024.xiangmo.data.repository.traditionalculture.ColorRepositoryImpl
import com.xmg2024.xiangmo.data.repository.traditionalculture.FestivalRepository
import com.xmg2024.xiangmo.data.repository.traditionalculture.FestivalRepositoryImpl
import com.xmg2024.xiangmo.data.repository.traditionalculture.SolarTermsRepository
import com.xmg2024.xiangmo.data.repository.traditionalculture.SolarTermsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsChinaWorldCultureHeritageRepository(
        repository: WorldCultureHeritageRepositoryImpl
    ): WorldCultureHeritageRepository

    @Binds
    fun bindsChineseAntitheticalCoupletRepository(
        repository: AntitheticalCoupletRepositoryImpl
    ): AntitheticalCoupletRepository

    @Binds
    fun bindsChineseCharacterRepository(
        repository: CharacterRepositoryImpl
    ): CharacterRepository

    @Binds
    fun bindsChineseColorRepository(
        chineseColorRepository: ColorRepositoryImpl
    ): ColorRepository

    @Binds
    fun bindsChineseExpressionRepository(
        chineseExpressionRepositoryImpl: ExpressionRepositoryImpl
    ): ExpressionRepository

    @Binds
    fun bindsChineseModernPoetryRepository(
        repositoryImpl: ModernPoetryRepositoryImpl
    ): ModernPoetryRepository

    @Binds
    fun bindsChineseQuoteRepository(
        repository: QuoteRepositoryImpl
    ): QuoteRepository

    @Binds
    fun bindsChineseKnowledgeRepository(
        chineseKnowledgeRepositoryImpl: KnowledgeRepositoryImpl
    ): KnowledgeRepository

    @Binds
    fun bindsChineseWisecrackRepository(
        chineseCrackRepository: WisecrackRepositoryImpl
    ): WisecrackRepository

    @Binds
    fun bindsClassicPoemRepository(
        poemRepository: ClassicPoemRepositoryImpl
    ): ClassicPoemRepository

    @Binds
    fun bindsFestivalRepository(
        festivalRepositoryImpl: FestivalRepositoryImpl
    ): FestivalRepository

    @Binds
    fun bindsHomeItemRepository(
        homeItemRepositoryImpl: HomeItemRepositoryImpl
    ): HomeItemRepository

    @Binds
    fun bindsIdiomRepository(
        idiomRepository: IdiomRepositoryImpl
    ): IdiomRepository

    @Binds
    fun bindsImportRepository(
        importRepositoryImpl: ImportRepositoryImpl
    ): ImportRepository

    @Binds
    fun bindsLinksRepository(
        linksRepositoryImpl: LinksRepositoryImpl
    ): LinksRepository

    @Binds
    fun bindsLyricRepository(
        lyricRepositoryImpl: LyricRepositoryImpl
    ): LyricRepository

    @Binds
    fun bindsNetworkDatasourceRepository(
        networkDatasourceRepositoryImpl: NetworkDatasourceRepositoryImpl
    ): NetworkDatasourceRepository

    @Binds
    fun bindsPeopleRepository(
        peopleRepositoryImpl: PeopleRepositoryImpl
    ): PeopleRepository

    @Binds
    fun bindsPoemSentenceRepository(
        poemSentenceRepository: SentenceRepositoryImpl
    ): SentenceRepository

    @Binds
    fun bindsPreferenceRepository(
        preferenceRepository: PreferenceRepositoryImpl
    ): PreferenceRepository

    @Binds
    fun bindsRiddleRepository(
        riddleRepositoryImpl: RiddleRepositoryImpl
    ): RiddleRepository

    @Binds
    fun bindsSolarTermsRepository(
        solarTermsRepositoryImpl: SolarTermsRepositoryImpl
    ): SolarTermsRepository

    @Binds
    fun bindsTongueTwisterRepository(
        tongueTwisterRepositoryImpl: TongueTwisterRepositoryImpl
    ): TongueTwisterRepository

    @Binds
    fun bindsClassicalLiteratureWritingRepository(
        writingRepositoryImpl: WritingRepositoryImpl
    ): WritingRepository

    @Binds
    fun bindsChineseProverbRepository(
        proverbRepository: ProverbRepositoryImpl
    ): ProverbRepository

    @Binds
    fun bindsThemeRepository(
        themeRepositoryImpl: ThemeRepositoryImpl
    ): ThemeRepository
}