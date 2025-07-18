/*
 *  This file is part of the 湘墨（jingmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 *  For the full copyright and license information, please view the LICENSE
 *  file that was distributed with this source code.
 */

package com.hefengbao.jingmo.data.repository.chinese

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.hefengbao.jingmo.data.database.dao.ChineseQuoteDao
import com.hefengbao.jingmo.data.database.entity.chinese.QuoteCollectionEntity
import com.hefengbao.jingmo.data.database.entity.chinese.QuoteEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class QuoteRepositoryImpl @Inject constructor(
    private val dao: ChineseQuoteDao,
) : QuoteRepository {
    override suspend fun insert(entity: QuoteEntity) = dao.insert(entity)

    override fun get(id: Int): Flow<QuoteEntity> = dao.get(id)

    override fun random(): Flow<QuoteEntity> = dao.random()

    override fun search(query: String): Flow<List<QuoteEntity>> = dao.search(query)

    override fun collections(): Flow<PagingData<QuoteEntity>> = Pager(
        config = PagingConfig(pageSize = 30),
        pagingSourceFactory = { dao.collections() }
    ).flow

    override fun total(): Flow<Int> = dao.total()

    override fun prevId(id: Int): Flow<Int?> = dao.getPrevId(id)

    override fun nextId(id: Int): Flow<Int?> = dao.getNextId(id)

    override fun isCollect(id: Int): Flow<QuoteCollectionEntity?> = dao.isCollect(id)

    override suspend fun collect(entity: QuoteCollectionEntity) = dao.collect(entity)

    override suspend fun uncollect(id: Int) = dao.uncollect(id)
}