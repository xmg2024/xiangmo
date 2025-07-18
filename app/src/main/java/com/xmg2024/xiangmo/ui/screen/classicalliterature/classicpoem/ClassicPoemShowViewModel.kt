/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.classicalliterature.classicpoem

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xmg2024.xiangmo.data.database.entity.classicalliterature.ClassicPoemCollectionEntity
import com.xmg2024.xiangmo.data.repository.classicalliterature.ClassicPoemRepository
import com.xmg2024.xiangmo.ui.screen.classicalliterature.classicpoem.nav.ClassicPoemShowArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
@OptIn(ExperimentalCoroutinesApi::class)
class ClassicPoemShowViewModel @Inject constructor(
    private val classicPoemRepository: ClassicPoemRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val args = ClassicPoemShowArgs(savedStateHandle)
    private var id = MutableStateFlow(args.poemId.toInt())
    private var collectedAt = MutableStateFlow(0L)

    fun setCurrentId(id: Int) {
        this.id.value = id
    }

    fun setCurrentCollectedAt(collectedAt: Long) {
        this.collectedAt.value = collectedAt
    }

    val classicPoemEntity = id.flatMapLatest {
        classicPoemRepository.get(it)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = null
    )

    val classicPoemCollectionEntity = id.flatMapLatest {
        classicPoemRepository.isCollect(it)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = null
    )

    fun collect(id: Int) {
        viewModelScope.launch {
            classicPoemRepository.collect(ClassicPoemCollectionEntity(id))
        }
    }

    fun uncollect(id: Int) {
        viewModelScope.launch {
            classicPoemRepository.uncollect(id)
        }
    }
}