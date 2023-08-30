package com.example.graduationproject.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.graduationproject.data.Repository
import com.example.graduationproject.data.model.CompareModelGet
import com.example.graduationproject.data.model.CompareModelPost
import com.example.graduationproject.data.model.Currency
import com.example.graduationproject.data.presestance.SharedObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CompareViewModel : ViewModel() {
    val repository = Repository()
    var amount by mutableStateOf("")
    var firstTargetValue by mutableStateOf("")

    var secondTargetValue by mutableStateOf("")

    var firstTargetSelected by if (SharedObject.countriesList.isNotEmpty()) mutableStateOf(
        SharedObject.countriesList[1]
    )
    else mutableStateOf(Currency("EUR", "https://flagcdn.com/h60/eu.png", 2))

    var secondTargetSelected by if (SharedObject.countriesList.isNotEmpty()) mutableStateOf(
        SharedObject.countriesList[2]
    )
    else mutableStateOf(
        Currency(
            id = 3,
            currencyCode = "GBP",
            flagUrl = "https://flagcdn.com/h60/gb.png"
        )
    )

    var base by if (SharedObject.countriesList.isNotEmpty()) mutableStateOf(SharedObject.countriesList[0])
    else mutableStateOf(Currency("USD", "https://flagcdn.com/h60/us.png", 1))
    var showLoading by mutableStateOf(false)
    var compareResult by mutableStateOf(CompareModelGet(emptyList()))

    fun compare(compareModelPost: CompareModelPost) {
        viewModelScope.launch(Dispatchers.IO) {
            showLoading = true
            compareResult = repository.compare(
                CompareModelPost(
                    compareModelPost.amount,
                    compareModelPost.baseCurrencyId,
                    compareModelPost.targetCurrencyIds
                )
            )
            firstTargetValue = compareResult.compare_result[0].toString()
            secondTargetValue = compareResult.compare_result[1].toString()
            showLoading = false
        }
    }
}