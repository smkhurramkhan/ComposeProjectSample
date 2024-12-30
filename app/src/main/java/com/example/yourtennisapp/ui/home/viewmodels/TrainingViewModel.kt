package com.example.yourtennisapp.ui.home.viewmodels

import androidx.lifecycle.viewModelScope
import com.example.yourtennisapp.base.BaseViewModel
import com.example.yourtennisapp.viewstate.IViewEvent
import com.example.yourtennisapp.viewstate.training.TrainingViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrainingViewModel @Inject constructor(
) : BaseViewModel<TrainingViewState, TrainingViewEvent>() {

    override fun createInitialState() = TrainingViewState()

    override fun onTriggerEvent(event: TrainingViewEvent) {
        viewModelScope.launch {
            /*when (event) {
                is CharactersViewEvent.UpdateFavorite -> updateFavorite(event.dto)
            }*/
        }
    }

}


sealed class TrainingViewEvent : IViewEvent {
    /*class UpdateFavorite(val dto: CharacterDto) : CharactersViewEvent()*/
}