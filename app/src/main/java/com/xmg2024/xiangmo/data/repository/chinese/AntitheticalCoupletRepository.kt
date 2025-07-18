/*
 *  This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 *  For the full copyright and license information, please view the LICENSE
 *  file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.data.repository.chinese

import androidx.paging.PagingData
import com.xmg2024.xiangmo.data.database.entity.chinese.AntitheticalCoupletCollectionEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.AntitheticalCoupletEntity
import kotlinx.coroutines.flow.Flow

interface AntitheticalCoupletRepository {
    fun get(id: Int): Flow<AntitheticalCoupletEntity>
    fun random(): Flow<AntitheticalCoupletEntity>
    fun getNextId(id: Int): Flow<Int?>
    fun getPrevId(id: Int): Flow<Int?>
    fun list(): Flow<PagingData<AntitheticalCoupletEntity>>
    fun search(query: String): Flow<PagingData<AntitheticalCoupletEntity>>
    fun collections(): Flow<PagingData<AntitheticalCoupletEntity>>
    suspend fun collect(entity: AntitheticalCoupletCollectionEntity)
    suspend fun uncollect(id: Int)
    fun isCollect(id: Int): Flow<AntitheticalCoupletCollectionEntity?>
}