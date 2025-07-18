package com.xmg2024.xiangmo.data.database.entity.chinese

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "proverbs")
data class ProverbEntity(
    @PrimaryKey
    val id: Int,
    val content: String
)
