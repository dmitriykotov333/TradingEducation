package com.kotdev.trading.splash.presentation

import androidx.lifecycle.viewModelScope
import com.kotdev.trading.core.navigation.AppGraph
import com.kotdev.trading.core.navigation.AppNavigator
import com.kotdev.trading.core.viewmodel.BaseViewModel
import com.kotdev.trading.service.api.ApiResult
import com.kotdev.trading.service.api.ServiceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val serviceRepository: ServiceRepository,
) : BaseViewModel<SplashViewState, Nothing, Nothing>(
    initialState = SplashViewState()
) {
    override fun obtainEvent(viewEvent: Nothing) = Unit

    private var job: Job? = null

    init {
        if (job == null) {
            job = viewModelScope.launch {
                serviceRepository.getConversionRates().collectLatest {
                    when (it) {
                        is ApiResult.Loading -> {

                        }

                        is ApiResult.Success -> {
                            AppNavigator.navigateWithClearPreviousScreen(
                                AppGraph.App,
                                AppGraph.Trading
                            )
                        }

                        is ApiResult.Error -> {
                            viewState = viewState.copy(error = it.error ?: "Something went wrong")
                            AppNavigator.navigateWithClearPreviousScreen(
                                AppGraph.App,
                                AppGraph.Trading
                            )
                        }

                        else -> {}
                    }
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
        job = null
    }
}