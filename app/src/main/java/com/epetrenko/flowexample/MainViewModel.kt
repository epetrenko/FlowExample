package com.epetrenko.flowexample

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlin.random.Random

/**
 * Created by: Evgeniy Petrenko
 * Email: evgeniy.petrenko89@gmail.com
 * GitHub: https://github.com/epetrenko
 * Date: 12.02.2020
 */
class MainViewModel : ViewModel() {

    private val _state = MutableLiveData(MainViewState())
    val state: LiveData<MainViewState>
        get() = _state

    init {
        viewModelScope.launch {
            flow {
                val list = arrayListOf<Int>()
                for (i in 0..100) {
                    list.add(Random(100).nextInt())
                }
                emit(list)
            }.flowOn(Dispatchers.Default)
                .distinctUntilChanged()
                .collect { list ->
                    Log.e("Collect list", list.toString())
                }
        }
    }
}