/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) 贺丰宝（hefengbao） <hefengbao@foxmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.data.repository.classicalliterature

import androidx.paging.PagingData
import com.hefengbao.jingmo.data.database.entity.classicalliterature.WritingCollectionEntity
import com.hefengbao.jingmo.data.database.entity.classicalliterature.WritingEntity
import com.hefengbao.jingmo.data.model.IdTitle
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