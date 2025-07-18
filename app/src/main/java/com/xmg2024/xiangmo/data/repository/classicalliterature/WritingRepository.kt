/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.data.repository.classicalliterature

import androidx.paging.PagingData
import com.xmg2024.xiangmo.data.database.entity.classicalliterature.WritingCollectionEntity
import com.xmg2024.xiangmo.data.database.entity.classicalliterature.WritingEntity
import com.xmg2024.xiangmo.data.model.IdTitle
import kotlinx.coroutines.flow.Flow

interface WritingRepository {
    fun get(id: Int): Flow<WritingEntity>
    fun random(): Flow<WritingEntity>
    fun list(): Flow<PagingData<WritingEntity>>
    fun search(query: String): Flow<PagingData<WritingEntity>>
    fun searchByAuthor(author: String): Flow<PagingData<WritingEntity>>
    fun getNextId(id: Int): Flow<Int?>
    fun getPrevId(id: Int): Flow<Int?>
    fun collections(): Flow<PagingData<WritingEntity>>
    suspend fun collect(entity: WritingCollectionEntity)
    suspend fun uncollect(writingId: Int)
    fun isCollect(id: Int): Flow<WritingCollectionEntity?>
    fun getIdTitle(query: String): Flow<PagingData<IdTitle>>
    fun getMaxId(): Flow<Int>
}