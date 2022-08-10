package com.example.sofietb_oblig2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

  private val data =DataSource()


    private val parties = MutableLiveData<MutableList<AlpacaParty>>()

    fun getParties(): MutableLiveData<MutableList<AlpacaParty>> {

        return parties
    }

    fun fetchParties(){
        viewModelScope.launch(Dispatchers.IO)
        {parties.postValue(data.callApi() as MutableList<AlpacaParty>?)

        }
    }

    fun oppdaterParties(enhet: Int) {
        viewModelScope.launch(Dispatchers.IO){

            run {
                parties.postValue(data.callApiStemmer(enhet) as MutableList<AlpacaParty>?)

                parties.hasActiveObservers()

            }


    }

}}



