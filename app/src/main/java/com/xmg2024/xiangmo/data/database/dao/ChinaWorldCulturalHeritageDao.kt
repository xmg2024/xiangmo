/*
 *  This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 *  For the full copyright and license information, please view the LICENSE
 *  file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.xmg2024.xiangmo.data.database.entity.china.WorldCulturalHeritageEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ChinaWorldCulturalHeritageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: WorldCulturalHeritageEntity)

    @Query("select * from china_world_cultural_heritage where id = :id")
    fun get(id: Int): Flow<WorldCulturalHeritageEntity>

    @Query("select * from china_world_cultural_heritage order by id")
    fun list(): Flow<List<WorldCulturalHeritageEntity>>

    @Query("select count(*) from china_world_cultural_heritage")
    fun total(): Flow<Int>

    @Query("delete from china_world_cultural_heritage")
    suspend fun clear()
}