/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.classicalliterature.sentence

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.xmg2024.xiangmo.data.repository.classicalliterature.SentenceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class SentenceSearchViewModel @Inject constructor(
    private val repository: SentenceRepository
) : ViewModel() {
    private val query = MutableStateFlow("")
    fun search(query: String) {
        this.query.value = query
    }

    @OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
    val sentences = query.debounce(200)
        .distinctUntilChanged()
        .filter { return@filter it.isNotEmpty() }
        .flatMapLatest { repository.search(it) }
        .cachedIn(viewModelScope)
}