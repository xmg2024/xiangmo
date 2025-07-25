/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.idiom

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xmg2024.xiangmo.data.model.AppStatus
import com.xmg2024.xiangmo.data.model.traditionalculture.Color
import com.xmg2024.xiangmo.data.repository.chinese.IdiomRepository
import com.xmg2024.xiangmo.data.repository.settings.PreferenceRepository
import com.xmg2024.xiangmo.data.repository.traditionalculture.ColorRepository
import com.xmg2024.xiangmo.ui.screen.chinese.idiom.nav.IdiomCaptureArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IdiomCaptureViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    idiomRepository: IdiomRepository,
    private val colorRepository: ColorRepository,
    private val preferenceRepository: PreferenceRepository
) : ViewModel() {
    private val args: IdiomCaptureArgs = IdiomCaptureArgs(savedStateHandle)

    val idiom = idiomRepository.get(args.idiomId.toInt()).stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = null
    )

    private val _appStatus: MutableStateFlow<AppStatus?> = MutableStateFlow(null)
    val appStatus: SharedFlow<AppStatus?> = _appStatus

    init {
        viewModelScope.launch {
            preferenceRepository.getAppStatus().collectLatest {
                _appStatus.value = it
            }
        }
    }

    private val _colors: MutableStateFlow<List<Color>> = MutableStateFlow(emptyList())
    val colors: SharedFlow<List<Color>> = _colors
    fun getColors() {
        viewModelScope.launch {
            _colors.value = colorRepository.list()
        }
    }

    fun setCaptureColor(color: String) {
        viewModelScope.launch {
            preferenceRepository.setCaptureTextColor(color)
        }
    }

    fun setCaptureBackgroundColor(color: String) {
        viewModelScope.launch {
            preferenceRepository.setCaptureBackgroundColor(color)
        }
    }
}