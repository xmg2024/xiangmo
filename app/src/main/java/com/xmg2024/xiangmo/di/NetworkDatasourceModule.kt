/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.di

import com.xmg2024.xiangmo.data.network.Network
import com.xmg2024.xiangmo.data.network.retrofit.NetworkImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface NetworkDatasourceModule {
    @Binds
    fun bindsNetwork(
        networkImpl: NetworkImpl
    ): Network
}