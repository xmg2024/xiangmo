/*
 *  This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 *  For the full copyright and license information, please view the LICENSE
 *  file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.data.repository.chinese

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.xmg2024.xiangmo.data.database.dao.ChineseAntitheticalCoupletDao
import com.xmg2024.xiangmo.data.database.entity.chinese.AntitheticalCoupletCollectionEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.AntitheticalCoupletEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AntitheticalCoupletRepositoryImpl @Inject constructor(
    private val dao: ChineseAntitheticalCoupletDao
) : AntitheticalCoupletRepository {
    override fun get(id: Int): Flow<AntitheticalCoupletEntity> = dao.get(id)

    override fun random(): Flow<AntitheticalCoupletEntity> = dao.random()

    override fun getNextId(id: Int): Flow<Int?> = dao.getNextId(id)

    override fun getPrevId(id: Int): Flow<Int?> = dao.getPrevId(id)

    override fun list(): Flow<PagingData<AntitheticalCoupletEntity>> = Pager(
        config = PagingConfig(pageSize = 30),
        pagingSourceFactory = { dao.list() }
    ).flow

    override fun search(query: String): Flow<PagingData<AntitheticalCoupletEntity>> = Pager(
        config = PagingConfig(pageSize = 30),
        pagingSourceFactory = { dao.search("%$query%") }
    ).flow

    override fun collections(): Flow<PagingData<AntitheticalCoupletEntity>> = Pager(
        config = PagingConfig(pageSize = 30),
        pagingSourceFactory = { dao.collections() }
    ).flow

    override suspend fun collect(entity: AntitheticalCoupletCollectionEntity) = dao.collect(entity)

    override suspend fun uncollect(id: Int) = dao.uncollect(id)

    override fun isCollect(id: Int): Flow<AntitheticalCoupletCollectionEntity?> = dao.isCollect(id)
}