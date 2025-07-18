/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.data.repository.chinese

import com.xmg2024.xiangmo.data.database.entity.chinese.TongueTwisterEntity
import kotlinx.coroutines.flow.Flow

interface TongueTwisterRepository {
    fun get(id: Int): Flow<TongueTwisterEntity>
    fun getNextId(id: Int): Flow<Int?>
    fun getPrevId(id: Int): Flow<Int?>
    fun search(): Flow<List<TongueTwisterEntity>>
}