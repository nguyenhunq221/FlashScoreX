package com.vnc.flashscorex.ui.dashboard.favorite

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.vnc.flashscorex.database.FavorPlayerDatabase
import com.vnc.flashscorex.model.topScore.Player
import kotlinx.coroutines.launch

class FavorViewModel(application: Application) :AndroidViewModel(application) {
    private val listFavorPlayer = MutableLiveData<List<Player>>()
    private val listSearchPlayer = MutableLiveData<List<Player>>()

    fun getListFavorPlayer():LiveData<List<Player>>{
        return listFavorPlayer
    }
    fun getListSearchPlayer():LiveData<List<Player>>{
        return listSearchPlayer
    }

    fun loadListFavorPlayer(context:Context) = viewModelScope.launch{
       listFavorPlayer.postValue(FavorPlayerDatabase.getDatabase(context).playerDao().getFavorPlayer())
    }

    fun searchPlayer(context: Context,searchQuery:String) = viewModelScope.launch {
        listSearchPlayer.postValue(FavorPlayerDatabase.getDatabase(context).playerDao().searchPlayer(searchQuery))
    }
}