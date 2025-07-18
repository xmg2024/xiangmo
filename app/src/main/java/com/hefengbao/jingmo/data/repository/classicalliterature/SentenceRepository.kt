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
import com.hefengbao.jingmo.data.database.entity.classicalliterature.SentenceCollectionEntity
import com.hefengbao.jingmo.data.database.entity.classicalliterature.SentenceEntity
import kotlinx.coroutines.flow.Flow

interface SentenceRepository {
    fun get(id: Int): Flow<SentenceEntity>
    fun random(): Flow<SentenceEntity>
    fun getNextId(id: Int): Flow<Int?>
    fun getPrevId(id: Int): Flow<Int?>
    fun search(query: String): Flow<PagingData<SentenceEntity>>
    fun collections(): Flow<PagingData<SentenceEntity>>
    suspend fun collect(entity: SentenceCollectionEntity)
    suspend fun uncollect(id: Int)
    fun isCollect(id: Int): Flow<SentenceCollectionEntity?>
}