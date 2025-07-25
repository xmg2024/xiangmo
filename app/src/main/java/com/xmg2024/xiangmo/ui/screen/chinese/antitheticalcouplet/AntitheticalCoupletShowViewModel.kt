/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.antitheticalcouplet

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xmg2024.xiangmo.data.database.entity.chinese.AntitheticalCoupletCollectionEntity
import com.xmg2024.xiangmo.data.repository.chinese.AntitheticalCoupletRepository
import com.xmg2024.xiangmo.ui.screen.chinese.antitheticalcouplet.nav.AntitheticalCoupletShowArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AntitheticalCoupletShowViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: AntitheticalCoupletRepository
) : ViewModel() {

    private val antitheticalCoupletShowArgs = AntitheticalCoupletShowArgs(savedStateHandle)

    val antitheticalCouplet =
        repository.get(antitheticalCoupletShowArgs.antitheticalCoupletId.toInt()).stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = null
        )

    val antitheticalCoupletCollection =
        repository.isCollect(antitheticalCoupletShowArgs.antitheticalCoupletId.toInt()).stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = null
        )

    fun setUncollect(id: Int) {
        viewModelScope.launch {
            repository.uncollect(id)
        }
    }

    fun setCollect(id: Int) {
        viewModelScope.launch {
            repository.collect(AntitheticalCoupletCollectionEntity(id))
        }
    }
}