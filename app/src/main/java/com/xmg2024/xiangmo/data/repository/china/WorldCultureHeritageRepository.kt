/*
 *  This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 *  For the full copyright and license information, please view the LICENSE
 *  file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.data.repository.china

import com.xmg2024.xiangmo.data.database.entity.china.WorldCulturalHeritageEntity
import kotlinx.coroutines.flow.Flow

interface WorldCultureHeritageRepository {
    fun get(id: Int): Flow<WorldCulturalHeritageEntity>
    fun list(): Flow<List<WorldCulturalHeritageEntity>>
}