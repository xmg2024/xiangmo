/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.data.network.fake

import com.xmg2024.xiangmo.common.network.AppDispatchers
import com.xmg2024.xiangmo.common.network.Dispatcher
import com.xmg2024.xiangmo.data.network.JvmUnitTestFakeAssetManager
import com.xmg2024.xiangmo.data.network.NetworkDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.serialization.json.Json
import javax.inject.Inject

/**
 * [NetworkDataSource] implementation that provides static news resources to aid development
 */
class FakeNetworkDataSource @Inject constructor(
    @Dispatcher(AppDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
    private val networkJson: Json,
    private val assets: FakeAssetManager = JvmUnitTestFakeAssetManager,
) : NetworkDataSource