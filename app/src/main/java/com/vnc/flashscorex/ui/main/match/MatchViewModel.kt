package com.vnc.flashscorex.ui.main.match

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.vnc.flashscorex.api.ApiClient
import com.vnc.flashscorex.constant.Config
import com.vnc.flashscorex.constant.Constants
import com.vnc.flashscorex.model.fixture.FixtureModel
import com.vnc.flashscorex.model.fixture.ResponseDetail
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MatchViewModel(application: Application) : AndroidViewModel(application) {

    private val listMatch = MutableLiveData<List<ResponseDetail>>()
    private val errorMessage = MutableLiveData<String>()

    fun getListMatch(): LiveData<List<ResponseDetail>> {
        return listMatch
    }
    fun getListMatchError(): LiveData<String> {
        return errorMessage
    }

    fun showMatch(id: Int, season: Int) = viewModelScope.launch{
        ApiClient.apiService.getFixture(Config.key, id, season,Config.time_zone)
            .enqueue(object : Callback<FixtureModel> {
                override fun onResponse(
                    call: Call<FixtureModel>,
                    response: Response<FixtureModel>
                ) {
                    if (response.code() == Constants.API.API_CODE_OK) {
                        listMatch.postValue(
                            response.body()!!.response
                        )
                    } else {
                        errorMessage.postValue(response.message())
                    }
                }

                override fun onFailure(call: Call<FixtureModel>, t: Throwable) {
                    errorMessage.value = t.message

                }
            })
    }
}