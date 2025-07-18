/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) 贺丰宝（hefengbao） <hefengbao@foxmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.data.repository.chinese

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.hefengbao.jingmo.data.database.dao.ChineseIdiomDao
import com.hefengbao.jingmo.data.database.entity.chinese.IdiomCollectionEntity
import com.hefengbao.jingmo.data.database.entity.chinese.IdiomEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class IdiomRepositoryImpl @Inject constructor(
    private val chineseIdiomDao: ChineseIdiomDao
) : IdiomRepository {
    override fun get(id: Int): Flow<IdiomEntity> = chineseIdiomDao.get(id)

    override fun random(): Flow<IdiomEntity> = chineseIdiomDao.random()

    override fun getNextId(id: Int): Flow<Int?> = chineseIdiomDao.getNextId(id)

    override fun getPrevId(id: Int): Flow<Int?> = chineseIdiomDao.getPrevId(id)

    override fun list(): Flow<PagingData<IdiomEntity>> = Pager(
        config = PagingConfig(pageSize = 30),
        pagingSourceFactory = {
            chineseIdiomDao.list()
        }
    ).flow

    override fun search(query: String): Flow<PagingData<IdiomEntity>> =
        Pager(
            config = PagingConfig(pageSize = 30),
            pagingSourceFactory = {
                chineseIdiomDao.search("%$query%")
            }
        ).flow

    override fun collections(): Flow<PagingData<IdiomEntity>> = Pager(
        config = PagingConfig(pageSize = 30),
        pagingSourceFactory = { chineseIdiomDao.collections() }
    ).flow

    override suspend fun collect(entity: IdiomCollectionEntity) =
        chineseIdiomDao.collect(entity)

    override suspend fun uncollect(id: Int) = chineseIdiomDao.uncollect(id)

    override fun isCollect(id: Int): Flow<IdiomCollectionEntity?> = chineseIdiomDao.isCollect(id)
}