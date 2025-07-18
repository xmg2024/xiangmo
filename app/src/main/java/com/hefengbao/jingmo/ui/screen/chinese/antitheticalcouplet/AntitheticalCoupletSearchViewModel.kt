/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.ui.screen.chinese.antitheticalcouplet

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.hefengbao.jingmo.data.repository.chinese.AntitheticalCoupletRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class AntitheticalCoupletSearchViewModel @Inject constructor(
    private val repository: AntitheticalCoupletRepository,
) : ViewModel() {
    private val queryStateFlow = MutableStateFlow("")
    fun search(query: String) {
        queryStateFlow.value = query
    }

    @OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
    var antitheticalCouplets = queryStateFlow
        .debounce(200)
        .distinctUntilChanged()
        .flatMapLatest {
            repository.search(it)
        }
        .cachedIn(viewModelScope)
}