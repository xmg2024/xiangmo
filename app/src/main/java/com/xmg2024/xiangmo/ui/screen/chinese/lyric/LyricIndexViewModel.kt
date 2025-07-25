/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.lyric

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xmg2024.xiangmo.data.database.entity.chinese.LyricCollectionEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.LyricEntity
import com.xmg2024.xiangmo.data.repository.chinese.LyricRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LyricIndexViewModel @Inject constructor(
    private val repository: LyricRepository
) : ViewModel() {
    init {
        random()
    }

    private val _lyricEntity: MutableStateFlow<LyricEntity?> = MutableStateFlow(null)
    val lyricEntity: SharedFlow<LyricEntity?> = _lyricEntity

    fun random() {
        viewModelScope.launch {
            repository.random().collectLatest {
                _lyricEntity.value = it
            }
        }
    }

    private val _lyricCollectionEntity: MutableStateFlow<LyricCollectionEntity?> =
        MutableStateFlow(null)
    val lyricCollectionEntity: SharedFlow<LyricCollectionEntity?> = _lyricCollectionEntity

    fun isCollect(id: Int) {
        viewModelScope.launch {
            repository.isCollect(id).collectLatest {
                _lyricCollectionEntity.value = it
            }
        }
    }

    fun collect(id: Int) {
        viewModelScope.launch {
            repository.collect(LyricCollectionEntity(id))
        }
    }

    fun uncollect(id: Int) {
        viewModelScope.launch {
            repository.uncollect(id)
        }
    }
}