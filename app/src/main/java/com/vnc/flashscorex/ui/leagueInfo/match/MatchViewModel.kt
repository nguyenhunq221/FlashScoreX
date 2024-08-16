package com.vnc.flashscorex.ui.leagueInfo.match

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.vnc.flashscorex.api.ApiClient
import com.vnc.flashscorex.constant.Config
import com.vnc.flashscorex.model.fixture.ResponseDetail
import kotlinx.coroutines.launch

class MatchViewModel(application: Application) : AndroidViewModel(application) {

    private val listMatch = MutableLiveData<List<ResponseDetail>>()
    private val errorMessage = MutableLiveData<String>()
    private val errorRound = MutableLiveData<String>()
    private val listRound = MutableLiveData<List<String>>()

    fun getListMatch(): LiveData<List<ResponseDetail>> {
        return listMatch
    }
    fun getListRound(): LiveData<List<String>> {
        return listRound
    }
    fun getListMatchError(): LiveData<String> {
        return errorMessage
    }
    fun getListRoundError(): LiveData<String> {
        return errorRound
    }

    fun showMatch(id: Int, season: Int,round:String? = null,status:String? = null) {

        viewModelScope.launch {

            //use retrofit with call type with coroutines

//            ApiClient.apiService.getFixture(Config.key, id, season, Config.time_zone)
//                .enqueue(object : Callback<FixtureModel> {
//                    override fun onResponse(
//                        call: Call<FixtureModel>,
//                        response: Response<FixtureModel>
//                    ) {
//                        if (response.code() == Constants.API.API_CODE_OK) {
//
//                            Log.e("hung", "thread==: " + Thread.currentThread().name)
//                            listMatch.postValue(
//                                response.body()!!.response
//                            )
//                        } else {
//                            errorMessage.postValue(response.message())
//                        }
//                    }
//
//                    override fun onFailure(call: Call<FixtureModel>, t: Throwable) {
//                        errorMessage.value = t.message
//
//                    }
//                })
            //use retrofit with response type with coroutines
            Log.e("hung", "thread==: " + Thread.currentThread().name)
            try {
                listMatch.postValue(ApiClient.apiService.getFixture(Config.key, id, season, Config.TIME_ZONE,round,status).body()?.response)
            }catch (e:Exception){
                errorMessage.postValue(e.message.toString())
            }
        }
    }

    fun getRound(id:Int,season:Int){
        viewModelScope.launch {
            try {
                listRound.postValue(ApiClient.apiService.getRound(Config.key,id,season).body()?.listRound)
//                errorRound.postValue(ApiClient.apiService.getRound(Config.key,id,season).body()?.errors?.get(0)?.access.toString())
//                errorRound.postValue(ApiClient.apiService.getRound(Config.key,id,season).body()?.errors?.get(0)?.requests.toString())
            }catch (e:Exception){
                errorMessage.postValue(e.message.toString())
            }

        }
    }
}