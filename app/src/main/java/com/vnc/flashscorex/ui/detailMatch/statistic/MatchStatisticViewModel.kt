package com.vnc.flashscorex.ui.detailMatch.statistic

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.vnc.flashscorex.api.ApiClient
import com.vnc.flashscorex.constant.Config
import com.vnc.flashscorex.model.event.GoalModel
import com.vnc.flashscorex.model.statistic.ResponseDetail
import kotlinx.coroutines.launch

class MatchStatisticViewModel(application: Application) : AndroidViewModel(application) {
    private var listStatistic = MutableLiveData<List<ResponseDetail>>()
    private var listGoal = MutableLiveData<List<GoalModel>>()

    private var errorMessage = MutableLiveData<String>()

    fun getListStatistic() : LiveData<List<ResponseDetail>> {
        return listStatistic
    }

    fun getListGoal() : LiveData<List<GoalModel>> {
        return listGoal
    }

    fun getListStatisticError() : LiveData<String> {
        return errorMessage
    }

    fun getStatistic (id:Int){
        viewModelScope.launch {
            try {
                listStatistic.postValue(ApiClient.apiService.getStatistic(Config.key,id).body()?.response)
            }catch (e:Exception){
                errorMessage.postValue(e.message)
            }
        }
    }

}