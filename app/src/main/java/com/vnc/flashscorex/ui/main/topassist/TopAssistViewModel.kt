package com.vnc.flashscorex.ui.main.topassist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.vnc.flashscorex.api.ApiClient
import com.vnc.flashscorex.constant.Config
import com.vnc.flashscorex.constant.Constants
import com.vnc.flashscorex.model.topScore.ResponseDetail
import com.vnc.flashscorex.model.topScore.TopScoreModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class TopAssistViewModel(application: Application) : AndroidViewModel(application) {
    private val listTopAssist = MutableLiveData<List<ResponseDetail>>()
    private val errorMessage = MutableLiveData<String>()

    fun getTopAssistList() : LiveData<List<ResponseDetail>>{
        return listTopAssist
    }

    fun  getTopAssistError():LiveData<String>{
        return errorMessage
    }

    fun showListTopAssist(id: Int, season: Int) = viewModelScope.launch {
        ApiClient.apiService.getTopAssist(Config.key,id,season).enqueue(object : retrofit2.Callback<TopScoreModel> {
            override fun onResponse(call: Call<TopScoreModel>, response: Response<TopScoreModel>) {
                if (response.code() == Constants.API.API_CODE_OK) {
                    listTopAssist.postValue(
                        response.body()!!.response
                    )
                } else {
                    errorMessage.postValue(response.message())
                }
            }

            override fun onFailure(call: Call<TopScoreModel>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })
    }
}