package com.vnc.flashscorex.ui.main.topscore

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

class TopScoreViewModel(application: Application) : AndroidViewModel(application) {

    private val listTopScore = MutableLiveData<List<ResponseDetail>>()
    private val errorMessage = MutableLiveData<String>()

    fun getTopScoreList() : LiveData<List<ResponseDetail>> {
        return listTopScore
    }

    fun  getTopAssistError(): LiveData<String> {
        return errorMessage
    }

    fun showListTopScore(id: Int, season: Int) = viewModelScope.launch {
        ApiClient.apiService.getTopScore(Config.key,id,season).enqueue(object : retrofit2.Callback<TopScoreModel> {
            override fun onResponse(call: Call<TopScoreModel>, response: Response<TopScoreModel>) {
                if (response.code() == Constants.API.API_CODE_OK) {
                    listTopScore.postValue(
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