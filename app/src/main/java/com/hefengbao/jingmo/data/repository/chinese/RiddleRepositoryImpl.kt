/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.data.repository.chinese

import com.hefengbao.jingmo.data.database.dao.ChineseRiddleDao
import com.hefengbao.jingmo.data.database.entity.chinese.RiddleEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RiddleRepositoryImpl @Inject constructor(
    private val dao: ChineseRiddleDao
) : RiddleRepository {
    override fun get(id: Int): Flow<RiddleEntity> = dao.get(id)

    override fun getNextId(id: Int): Flow<Int?> = dao.getNextId(id)

    override fun getPrevId(id: Int): Flow<Int?> = dao.getPrevId(id)

    override fun random(): Flow<RiddleEntity> = dao.random()

    override fun search(query: String): Flow<List<RiddleEntity>> =
        dao.search("%$query%")

    override suspend fun clear() = dao.clear()
}