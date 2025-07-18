package com.xmg2024.xiangmo.data.repository.chinese

import androidx.paging.PagingData
import com.xmg2024.xiangmo.data.database.entity.chinese.ModernPoetryCollectionEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.ModernPoetryEntity
import kotlinx.coroutines.flow.Flow

interface ModernPoetryRepository {
    suspend fun insert(entity: ModernPoetryEntity)
    fun get(id: Int): Flow<ModernPoetryEntity>
    fun random(): Flow<ModernPoetryEntity>
    fun search(query: String): Flow<List<ModernPoetryEntity>>
    fun collections(): Flow<PagingData<ModernPoetryEntity>>
    fun total(): Flow<Int>
    fun prevId(id: Int): Flow<Int?>
    fun nextId(id: Int): Flow<Int?>
    fun isCollect(id: Int): Flow<ModernPoetryCollectionEntity?>
    suspend fun collect(entity: ModernPoetryCollectionEntity)
    suspend fun uncollect(id: Int)
}