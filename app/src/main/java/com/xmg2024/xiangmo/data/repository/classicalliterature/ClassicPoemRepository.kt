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
import com.xmg2024.xiangmo.data.database.entity.classicalliterature.ClassicPoemCollectionEntity
import com.xmg2024.xiangmo.data.database.entity.classicalliterature.ClassicPoemEntity
import com.xmg2024.xiangmo.data.model.IdTitle
import kotlinx.coroutines.flow.Flow

interface ClassicPoemRepository {
    suspend fun insert(entity: ClassicPoemEntity)
    fun random(): Flow<ClassicPoemEntity>
    fun get(id: Int): Flow<ClassicPoemEntity>
    fun total(): Flow<Int>
    fun getNextId(id: Int): Flow<Int?>
    fun getPrevId(id: Int): Flow<Int?>
    suspend fun collect(entity: ClassicPoemCollectionEntity)
    suspend fun uncollect(id: Int)
    fun isCollect(id: Int): Flow<ClassicPoemCollectionEntity?>
    fun collections(): Flow<PagingData<ClassicPoemEntity>>
    fun search(query: String): Flow<List<ClassicPoemEntity>>
    fun getIdTitle(query: String): Flow<PagingData<IdTitle>>
}