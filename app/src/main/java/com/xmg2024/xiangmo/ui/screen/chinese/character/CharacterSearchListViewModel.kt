/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.character

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xmg2024.xiangmo.data.database.entity.chinese.DictionaryEntity
import com.xmg2024.xiangmo.data.repository.chinese.CharacterRepository
import com.xmg2024.xiangmo.ui.screen.chinese.character.nav.CharacterSearchListArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterSearchListViewModel @Inject constructor(
    private val repository: CharacterRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val args = CharacterSearchListArgs(savedStateHandle)

    val query = args.query
    val type = args.type

    private val _characters: MutableStateFlow<List<DictionaryEntity>> =
        MutableStateFlow(emptyList())
    val characters: SharedFlow<List<DictionaryEntity>> = _characters

    init {
        viewModelScope.launch {
            when (type) {
                "pinyin" -> {
                    repository.searchByPinyin(query).collectLatest {
                        _characters.value = it
                    }
                }

                "radical" -> {
                    repository.searchByRadical(query).collectLatest {
                        _characters.value = it
                    }
                }

                "stroke" -> {
                    repository.searchByStroke(query.toInt()).collectLatest {
                        _characters.value = it
                    }
                }

                "char" -> {
                    repository.search(query).collectLatest {
                        _characters.value = it
                    }
                }
            }
        }
    }
}