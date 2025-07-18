/*
 * This file is part of the 湘墨（xiangmo）APP.
 *
 * (c) xmg2024 <ml112265@126.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xmg2024.xiangmo.ui.screen.chinese.expression

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xmg2024.xiangmo.data.database.entity.chinese.ExpressionCollectionEntity
import com.xmg2024.xiangmo.data.database.entity.chinese.ExpressionEntity
import com.xmg2024.xiangmo.data.repository.chinese.ExpressionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExpressionIndexViewModel @Inject constructor(
    private val repository: ExpressionRepository
) : ViewModel() {

    init {
        getRandom()
    }

    private val _expression: MutableStateFlow<ExpressionEntity?> = MutableStateFlow(null)
    val expression: SharedFlow<ExpressionEntity?> = _expression

    fun getRandom() {
        viewModelScope.launch {
            repository.random().collectLatest {
                _expression.value = it
            }
        }
    }

    private val _collected: MutableStateFlow<ExpressionCollectionEntity?> = MutableStateFlow(null)
    val collected: SharedFlow<ExpressionCollectionEntity?> = _collected
    fun getCollected(id: Int) {
        viewModelScope.launch {
            repository.isCollect(id).collectLatest {
                _collected.value = it
            }
        }
    }

    fun setUncollect(id: Int) {
        viewModelScope.launch {
            repository.uncollect(id)
        }
    }

    fun setCollect(id: Int) {
        viewModelScope.launch {
            repository.collect(ExpressionCollectionEntity(id))
        }
    }
}