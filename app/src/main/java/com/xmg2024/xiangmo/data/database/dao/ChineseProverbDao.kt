package com.xmg2024.xiangmo.data.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.xmg2024.xiangmo.data.database.entity.chinese.ProverbCollectionEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.ProverbEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ChineseProverbDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: ProverbEntity)

    @Query("select * from proverbs where id = :id limit 1")
    fun get(id: Int): Flow<ProverbEntity>

    @Query("select p.*from proverbs p where p.id = (select id from proverbs order by random() limit 1) limit 1")
    fun random(): Flow<ProverbEntity>

    @Query("select id from proverbs where id > :id order by id asc limit 1")
    fun getNextId(id: Int): Flow<Int?>

    @Query("select id from proverbs where id < :id order by id desc limit 1")
    fun getPrevId(id: Int): Flow<Int?>

    @Transaction
    @Query("select * from proverbs join proverbs_fts on proverbs_fts.rowid = proverbs.id where proverbs_fts match :query")
    fun search(query: String): Flow<List<ProverbEntity>>

    @Query("select p.* from proverb_collections c join proverbs p on c.id = p.id order by collected_at desc")
    fun collections(): PagingSource<Int, ProverbEntity>

    @Query("select count(*) from proverbs")
    fun total(): Flow<Int>

    @Query("select * from proverb_collections where id = :id")
    fun isCollect(id: Int): Flow<ProverbCollectionEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun collect(entity: ProverbCollectionEntity)

    @Query("delete from proverb_collections where id = :id")
    suspend fun uncollect(id: Int)

    @Query("delete from proverbs")
    suspend fun clear()
}