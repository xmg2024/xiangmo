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
import com.xmg2024.xiangmo.data.database.entity.chinese.ExpressionCollectionEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.ExpressionEntity
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