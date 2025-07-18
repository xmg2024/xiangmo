/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.data.repository.chinese

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.xmg2024.xiangmo.data.database.dao.ChineseLyricDao
import com.xmg2024.xiangmo.data.database.entity.chinese.LyricCollectionEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.LyricEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LyricRepositoryImpl @Inject constructor(
    private val chineseLyricDao: ChineseLyricDao
) : LyricRepository {
    override fun get(id: Int): Flow<LyricEntity> = chineseLyricDao.get(id)

    override fun random(): Flow<LyricEntity> = chineseLyricDao.random()

    override fun search(query: String): Flow<List<LyricEntity>> = chineseLyricDao.search(query)

    override fun collections(): Flow<PagingData<LyricEntity>> = Pager(
        config = PagingConfig(pageSize = 30),
        pagingSourceFactory = { chineseLyricDao.collections() }
    ).flow

    override fun total(): Flow<Int> = chineseLyricDao.total()

    override fun isCollect(id: Int): Flow<LyricCollectionEntity?> = chineseLyricDao.isCollect(id)

    override fun prevId(id: Int): Flow<Int?> = chineseLyricDao.getPrevId(id)

    override fun nextId(id: Int): Flow<Int?> = chineseLyricDao.getNextId(id)

    override suspend fun collect(entity: LyricCollectionEntity) = chineseLyricDao.collect(entity)

    override suspend fun uncollect(id: Int) = chineseLyricDao.uncollect(id)
}