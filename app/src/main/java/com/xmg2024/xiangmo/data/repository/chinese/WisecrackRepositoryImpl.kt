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
import com.xmg2024.xiangmo.data.database.dao.ChineseWisecrackDao
import com.xmg2024.xiangmo.data.database.entity.chinese.WisecrackCollectionEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.WisecrackEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WisecrackRepositoryImpl @Inject constructor(
    private val chineseWisecrackDao: ChineseWisecrackDao
) : WisecrackRepository {
    override fun get(id: Int): Flow<WisecrackEntity> = chineseWisecrackDao.get(id)

    override fun random(): Flow<WisecrackEntity> = chineseWisecrackDao.random()

    override fun getNextId(id: Int): Flow<Int?> = chineseWisecrackDao.getNextId(id)

    override fun getPrevId(id: Int): Flow<Int?> = chineseWisecrackDao.getPrevId(id)

    override fun search(query: String): Flow<List<WisecrackEntity>> =
        chineseWisecrackDao.search("%$query%")

    override fun collections(): Flow<PagingData<WisecrackEntity>> = Pager(
        config = PagingConfig(pageSize = 30),
        pagingSourceFactory = { chineseWisecrackDao.collections() }
    ).flow

    override suspend fun collect(entity: WisecrackCollectionEntity) =
        chineseWisecrackDao.collect(entity)

    override suspend fun uncollect(id: Int) =
        chineseWisecrackDao.uncollect(id)

    override fun isCollect(id: Int): Flow<WisecrackCollectionEntity?> =
        chineseWisecrackDao.isCollect(id)
}