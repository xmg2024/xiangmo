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
import com.xmg2024.xiangmo.data.database.entity.chinese.WisecrackCollectionEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.WisecrackEntity
import kotlinx.coroutines.flow.Flow

interface WisecrackRepository {
    fun get(id: Int): Flow<WisecrackEntity>
    fun random(): Flow<WisecrackEntity>
    fun getNextId(id: Int): Flow<Int?>
    fun getPrevId(id: Int): Flow<Int?>
    fun search(query: String): Flow<List<WisecrackEntity>>
    fun collections(): Flow<PagingData<WisecrackEntity>>
    suspend fun collect(entity: WisecrackCollectionEntity)
    suspend fun uncollect(id: Int)
    fun isCollect(id: Int): Flow<WisecrackCollectionEntity?>
}