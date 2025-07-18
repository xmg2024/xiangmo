/*
 *  This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 *  For the full copyright and license information, please view the LICENSE
 *  file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.lyric

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xmg2024.xiangmo.data.database.entity.chinese.LyricCollectionEntity
import com.xmg2024.xiangmo.data.datastore.ReadStatusPreference
import com.xmg2024.xiangmo.data.repository.chinese.LyricRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class LyricReadViewModel @Inject constructor(
    private val repository: LyricRepository,
    private val preference: ReadStatusPreference
) : ViewModel() {
    private val id = MutableStateFlow(1)

    init {
        viewModelScope.launch {
            preference.readStatus.collectLatest {
                id.value = it.chineseLyricLastReadId
            }
        }
    }

    fun setCurrentId(id: Int) {
        this.id.value = id

        viewModelScope.launch {
            preference.setChineseLyricLastReadId(id)
        }
    }

    val lyric = id.flatMapLatest { repository.get(it) }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed((5_000)),
        initialValue = null
    )

    val lyricCollection = id.flatMapLatest { repository.isCollect(it) }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed((5_000)),
        initialValue = null
    )

    val prevId = id.flatMapLatest { repository.prevId(it) }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed((5_000)),
        initialValue = null
    )

    val nextId = id.flatMapLatest { repository.nextId(it) }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed((5_000)),
        initialValue = null
    )

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