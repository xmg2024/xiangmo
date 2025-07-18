/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.data.repository.chinese

import androidx.paging.PagingData
import com.xmg2024.xiangmo.data.database.entity.chinese.LyricCollectionEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.LyricEntity
import kotlinx.coroutines.flow.Flow

interface LyricRepository {
    fun get(id: Int): Flow<LyricEntity>
    fun random(): Flow<LyricEntity>
    fun search(query: String): Flow<List<LyricEntity>>
    fun collections(): Flow<PagingData<LyricEntity>>
    fun total(): Flow<Int>
    fun isCollect(id: Int): Flow<LyricCollectionEntity?>
    fun prevId(id: Int): Flow<Int?>
    fun nextId(id: Int): Flow<Int?>
    suspend fun collect(entity: LyricCollectionEntity)
    suspend fun uncollect(id: Int)
}