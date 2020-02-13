package com.epetrenko.flowexample

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

/**
 * Created by: Evgeniy Petrenko
 * Email: evgeniy.petrenko89@gmail.com
 * GitHub: https://github.com/epetrenko
 * Date: 12.02.2020
 */
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.state.observe(this, Observer(::renderViewState))
    }

    private fun renderViewState(state: MainViewState) {

    }
}