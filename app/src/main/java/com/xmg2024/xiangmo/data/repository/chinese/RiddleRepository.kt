/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.data.repository.chinese

import com.xmg2024.xiangmo.data.database.entity.chinese.RiddleEntity
import kotlinx.coroutines.flow.Flow

interface RiddleRepository {
    fun get(id: Int): Flow<RiddleEntity>
    fun getNextId(id: Int): Flow<Int?>
    fun getPrevId(id: Int): Flow<Int?>
    fun random(): Flow<RiddleEntity>
    fun search(query: String): Flow<List<RiddleEntity>>
    suspend fun clear()
}