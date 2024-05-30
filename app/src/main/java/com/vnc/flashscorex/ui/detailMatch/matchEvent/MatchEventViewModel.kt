package com.vnc.flashscorex.ui.detailMatch.matchEvent

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.vnc.flashscorex.api.ApiClient
import com.vnc.flashscorex.constant.Config
import com.vnc.flashscorex.model.event.GoalModel
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.launch

class MatchEventViewModel(application: Application) : AndroidViewModel(application) {
    private var listEvent = MutableLiveData<List<GoalModel>>()
    private var errorMessage = MutableLiveData<String>()
    fun getListEvent(): LiveData<List<GoalModel>> {
        return listEvent
    }
    fun getErrorMessage () : LiveData<String> {
        return errorMessage
    }

    fun getEvent (id : Int) {
        viewModelScope.launch {
            try {
                listEvent.postValue(ApiClient.apiService.getEvent(Config.key,id,null).body()?.listGoal)
            }catch (e : Exception) {
                errorMessage.postValue(e.message)
            }catch (e : TimeoutCancellationException){
                errorMessage.postValue(e.message)
            }
        }
    }
}