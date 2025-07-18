/*
 *  This file is part of the 湘墨（jingmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 *  For the full copyright and license information, please view the LICENSE
 *  file that was distributed with this source code.
 */

package com.hefengbao.jingmo.data.repository.china

import com.hefengbao.jingmo.data.database.dao.ChinaWorldCulturalHeritageDao
import com.hefengbao.jingmo.data.database.entity.china.WorldCulturalHeritageEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WorldCultureHeritageRepositoryImpl @Inject constructor(
    private val dao: ChinaWorldCulturalHeritageDao
) : WorldCultureHeritageRepository {
    override fun get(id: Int): Flow<WorldCulturalHeritageEntity> = dao.get(id)

    override fun list(): Flow<List<WorldCulturalHeritageEntity>> = dao.list()
}