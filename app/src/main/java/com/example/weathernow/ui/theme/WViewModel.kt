package com.example.weathernow.ui.theme

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weathernow.API.Constant
import com.example.weathernow.API.NetworkResponse
import com.example.weathernow.API.RetrofitInstance
import com.example.weathernow.API.WeatherAPI
import com.example.weathernow.API.WeatherModel
import kotlinx.coroutines.launch

class WViewModel : ViewModel() {
    private val weatherAPI = RetrofitInstance.weatherAPI
    private val _weatherResult = MutableLiveData<NetworkResponse<WeatherModel>>()
    val weatherResult :  LiveData<NetworkResponse<WeatherModel>> = _weatherResult
    fun getData(city: String){
        _weatherResult.value = NetworkResponse.Loading
        viewModelScope.launch {
            try {
                val response = weatherAPI.getWeather(Constant.apikey, city)
                if (response.isSuccessful) {
                    response.body()?.let {
                        _weatherResult.value = NetworkResponse.Success(it)
                    }
                } else {
                    _weatherResult.value = NetworkResponse.Error("Failed to load data")
                }
            }
            catch (e : Exception){
                _weatherResult.value = NetworkResponse.Error("Failed to load data")
            }
        }
    }
}