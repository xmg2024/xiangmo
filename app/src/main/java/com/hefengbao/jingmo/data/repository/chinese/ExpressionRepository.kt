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
import com.hefengbao.jingmo.data.database.entity.chinese.ExpressionCollectionEntity
import com.hefengbao.jingmo.data.database.entity.chinese.ExpressionEntity
import kotlinx.coroutines.flow.Flow

interface ExpressionRepository {
    fun get(id: Int): Flow<ExpressionEntity>
    fun random(): Flow<ExpressionEntity>
    fun search(query: String): Flow<PagingData<ExpressionEntity>>
    fun collections(): Flow<PagingData<ExpressionEntity>>
    suspend fun collect(entity: ExpressionCollectionEntity)
    suspend fun uncollect(id: Int)
    fun isCollect(id: Int): Flow<ExpressionCollectionEntity?>
}