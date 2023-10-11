package com.vnc.flashscorex.ui.main.standing

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.vnc.flashscorex.api.ApiClient
import com.vnc.flashscorex.constant.Config
import com.vnc.flashscorex.constant.Constants
import com.vnc.flashscorex.model.standing.StandingDetail
import com.vnc.flashscorex.model.standing.StandingModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StandingViewModel(application: Application) : AndroidViewModel(application) {

    private val standingDetailList = MutableLiveData<List<StandingDetail>>()
    private val errorMessage = MutableLiveData<String>()

    fun getStanding():LiveData<List<StandingDetail>>{
        return standingDetailList
    }
    fun getStandingError():LiveData<String>{
        return errorMessage
    }

    fun showStandings(id: Int, season: Int) = viewModelScope.launch{
        ApiClient.apiService.getStandings(Config.key, id, season)
            .enqueue(object : Callback<StandingModel> {
                override fun onResponse(
                    call: Call<StandingModel>,
                    response: Response<StandingModel>
                ) {
                    if (response.code() == Constants.API.API_CODE_OK) {
                        standingDetailList.postValue(
                            response.body()!!.response[0].league.standings[0]
                        )
                    } else {
                        errorMessage.postValue(response.message())
                    }
                }

                override fun onFailure(call: Call<StandingModel>, t: Throwable) {
                    errorMessage.value = t.message

                }
            })
    }

}