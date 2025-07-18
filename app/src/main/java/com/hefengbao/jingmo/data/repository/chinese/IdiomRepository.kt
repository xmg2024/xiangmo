/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) 贺丰宝（hefengbao） <hefengbao@foxmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.data.repository.chinese

import androidx.paging.PagingData
import com.hefengbao.jingmo.data.database.entity.chinese.IdiomCollectionEntity
import com.hefengbao.jingmo.data.database.entity.chinese.IdiomEntity
import kotlinx.coroutines.flow.Flow

interface IdiomRepository {
    fun get(id: Int): Flow<IdiomEntity>
    fun random(): Flow<IdiomEntity>
    fun getNextId(id: Int): Flow<Int?>
    fun getPrevId(id: Int): Flow<Int?>
    fun list(): Flow<PagingData<IdiomEntity>>
    fun search(query: String): Flow<PagingData<IdiomEntity>>
    fun collections(): Flow<PagingData<IdiomEntity>>
    suspend fun collect(entity: IdiomCollectionEntity)
    suspend fun uncollect(id: Int)
    fun isCollect(id: Int): Flow<IdiomCollectionEntity?>
}