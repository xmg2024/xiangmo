/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.proverb

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xmg2024.xiangmo.data.database.entity.chinese.ProverbCollectionEntity
import com.xmg2024.xiangmo.data.repository.chinese.ProverbRepository
import com.xmg2024.xiangmo.ui.screen.chinese.proverb.nav.ProverbShowArgs
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
class ProverbShowViewModel @Inject constructor(
    private val repository: ProverbRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val args = ProverbShowArgs(savedStateHandle)
    private var id = MutableStateFlow(args.id.toInt())

    val proverbEntity = id.flatMapLatest { repository.get(it) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = null
        )

    val proverbCollectionEntity = id.flatMapLatest { repository.isCollect(it) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = null
        )

    fun collect(id: Int) {
        viewModelScope.launch {
            repository.collect(ProverbCollectionEntity(id))
        }
    }

    fun uncollect(id: Int) {
        viewModelScope.launch {
            repository.uncollect(id)
        }
    }
}