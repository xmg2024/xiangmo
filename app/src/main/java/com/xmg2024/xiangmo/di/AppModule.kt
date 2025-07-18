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
import com.xmg2024.xiangmo.App
import com.xmg2024.xiangmo.common.storage.AndroidImageDownloader
import com.xmg2024.xiangmo.data.datastore.AppPreference
import com.xmg2024.xiangmo.data.datastore.DatasetPreference
import com.xmg2024.xiangmo.data.datastore.HomePreference
import com.xmg2024.xiangmo.data.datastore.ReadStatusPreference
import com.xmg2024.xiangmo.data.network.fake.FakeAssetManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApp(): App = App()

    @Provides
    @Singleton
    fun providesNetworkJson(): Json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

    @Provides
    @Singleton
    fun providesFakeAssetManager(
        @ApplicationContext context: Context,
    ): FakeAssetManager = FakeAssetManager(context.assets::open)

    @Provides
    @Singleton
    fun providesAppPreference(
        @ApplicationContext context: Context
    ): AppPreference = AppPreference(context)

    @Provides
    @Singleton
    fun providesDatasetPreference(
        @ApplicationContext context: Context
    ): DatasetPreference = DatasetPreference(context)

    @Provides
    @Singleton
    fun providesHomePreference(
        @ApplicationContext context: Context
    ): HomePreference = HomePreference(context)

    @Provides
    @Singleton
    fun providesReadStatusPreference(
        @ApplicationContext context: Context
    ): ReadStatusPreference = ReadStatusPreference(context)

    @Provides
    @Singleton
    fun providesAndroidImageDownloader(
        @ApplicationContext context: Context,
        @IODispatcher ioDispatcher: CoroutineDispatcher,
        okHttpClient: OkHttpClient,
    ): AndroidImageDownloader = AndroidImageDownloader(context, ioDispatcher, okHttpClient)
}