/*
 * This file is part of the 湘墨（jingmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.hefengbao.jingmo.ui.screen.traditionalculture.color

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hefengbao.jingmo.data.model.traditionalculture.Color
import com.hefengbao.jingmo.data.repository.traditionalculture.ColorRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ColorIndexViewModel @Inject constructor(
    private val repository: ColorRepository
) : ViewModel() {

    private val _colors: MutableStateFlow<List<Color>> =
        MutableStateFlow(emptyList())
    val colors: SharedFlow<List<Color>> = _colors
    fun getList() {
        viewModelScope.launch {
            _colors.value = repository.list()
        }
    }

    private val _searchColors: MutableStateFlow<List<Color>> =
        MutableStateFlow(emptyList())
    val searchColors: SharedFlow<List<Color>> = _searchColors
    fun search(query: String) {
        _searchColors.value = emptyList()
        viewModelScope.launch {
            _searchColors.value = repository.list().filter {
                it.name.contains(query)
            }
        }
    }
}