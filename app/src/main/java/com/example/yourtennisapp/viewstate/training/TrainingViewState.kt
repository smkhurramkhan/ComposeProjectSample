package com.example.yourtennisapp.viewstate.training

import androidx.compose.runtime.Stable
import com.example.whatsapptoolkit.extensions.empty
import com.example.yourtennisapp.viewstate.IViewState

/**
 * Created by merttoptas on 13.03.2022
 */
@Stable
data class TrainingViewState(
    val isLoading: Boolean = false,
    val pagedData: String = String.empty,
    val data: List<String>? = null,
) : IViewState