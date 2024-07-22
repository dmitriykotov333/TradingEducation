package com.kotdev.trading.service.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00040\u0003H&\u00a8\u0006\u0007"}, d2 = {"Lcom/kotdev/trading/service/api/ServiceRepository;", "", "getConversionRates", "Lkotlinx/coroutines/flow/Flow;", "Lcom/kotdev/trading/service/api/ApiResult;", "", "Lcom/kotdev/trading/core/BasePair;", "service_debug"})
public abstract interface ServiceRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.kotdev.trading.service.api.ApiResult<java.util.List<com.kotdev.trading.core.BasePair>>> getConversionRates();
}