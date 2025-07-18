/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.classicalliterature.classicpoem

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xmg2024.xiangmo.data.database.entity.classicalliterature.ClassicPoemEntity
import com.xmg2024.xiangmo.data.repository.classicalliterature.ClassicPoemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClassicPoemSearchScreenViewModel @Inject constructor(
    private val repository: ClassicPoemRepository
) : ViewModel() {
    private val _poems: MutableStateFlow<List<ClassicPoemEntity>> = MutableStateFlow(emptyList())
    val poems: SharedFlow<List<ClassicPoemEntity>> = _poems
    fun search(query: String) {
        viewModelScope.launch {
            repository.search(query).collectLatest {
                _poems.value = it
            }
        }
    }
}