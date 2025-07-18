/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) 贺丰宝（hefengbao） <hefengbao@foxmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.data.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hefengbao.jingmo.data.database.entity.chinese.ExpressionCollectionEntity
import com.hefengbao.jingmo.data.database.entity.chinese.ExpressionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ChineseExpressionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: ExpressionEntity)

    @Query("select * from chinese_expressions where id = (select e.id from chinese_expressions e order by random() limit 1) limit 1")
    fun random(): Flow<ExpressionEntity>

    @Query("select * from chinese_expressions where id = :id")
    fun get(id: Int): Flow<ExpressionEntity>

    @Query("select i.* from chinese_expression_collections c join chinese_expressions i on c.id = i.id order by collected_at desc")
    fun collections(): PagingSource<Int, ExpressionEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun collect(entity: ExpressionCollectionEntity)

    @Query("delete from chinese_expression_collections where id = :id")
    suspend fun uncollect(id: Int)

    @Query("select * from chinese_expression_collections where id = :id")
    fun isCollect(id: Int): Flow<ExpressionCollectionEntity?>

    @Query("select * from chinese_expressions where word like :query")
    fun search(query: String): PagingSource<Int, ExpressionEntity>

    @Query("select count(*) from chinese_expressions")
    fun total(): Flow<Int>

    @Query("delete from chinese_expressions")
    suspend fun clear()
}