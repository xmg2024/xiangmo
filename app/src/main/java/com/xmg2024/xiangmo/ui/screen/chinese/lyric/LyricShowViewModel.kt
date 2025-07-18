/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.lyric

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xmg2024.xiangmo.data.database.entity.chinese.LyricCollectionEntity
import com.xmg2024.xiangmo.data.repository.chinese.LyricRepository
import com.xmg2024.xiangmo.ui.screen.chinese.lyric.nav.LyricShowArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class LyricShowViewModel @Inject constructor(
    private val repository: LyricRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val args = LyricShowArgs(savedStateHandle)
    private var id = MutableStateFlow(args.id.toInt())

    val lyricEntity = id.flatMapLatest { repository.get(it) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = null
        )

    val lyricCollectionEntity = id.flatMapLatest { repository.isCollect(it) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
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