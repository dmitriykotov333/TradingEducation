package com.kotdev.trading.service.api;

@kotlinx.serialization.Serializable()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u0013*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0004\u0013\u0014\u0015\u0016B\u0019\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007B\u0007\b\u0004\u00a2\u0006\u0002\u0010\bJ;\u0010\t\u001a\u00020\n\"\u0004\b\u0001\u0010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0012H\u00c7\u0001\u0082\u0001\u0003\u0017\u0018\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/kotdev/trading/service/api/ApiResult;", "T", "", "seen1", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "()V", "write$Self", "", "T0", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "typeSerial0", "Lkotlinx/serialization/KSerializer;", "Companion", "Error", "Loading", "Success", "Lcom/kotdev/trading/service/api/ApiResult$Error;", "Lcom/kotdev/trading/service/api/ApiResult$Loading;", "Lcom/kotdev/trading/service/api/ApiResult$Success;", "service_debug"})
public abstract class ApiResult<T extends java.lang.Object> {
    @org.jetbrains.annotations.NotNull()
    public static final com.kotdev.trading.service.api.ApiResult.Companion Companion = null;
    
    private ApiResult() {
        super();
    }
    
    @kotlin.jvm.JvmStatic()
    public static final <T0 extends java.lang.Object>void write$Self(@org.jetbrains.annotations.NotNull()
    com.kotdev.trading.service.api.ApiResult<T0> self, @org.jetbrains.annotations.NotNull()
    kotlinx.serialization.encoding.CompositeEncoder output, @org.jetbrains.annotations.NotNull()
    kotlinx.serialization.descriptors.SerialDescriptor serialDesc, @org.jetbrains.annotations.NotNull()
    kotlinx.serialization.KSerializer<T0> typeSerial0) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00050\u0004\"\u0004\b\u0001\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0004H\u00c6\u0001\u00a8\u0006\b"}, d2 = {"Lcom/kotdev/trading/service/api/ApiResult$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/kotdev/trading/service/api/ApiResult;", "T0", "typeSerial0", "service_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final <T0 extends java.lang.Object>kotlinx.serialization.KSerializer<com.kotdev.trading.service.api.ApiResult<T0>> serializer(@org.jetbrains.annotations.NotNull()
        kotlinx.serialization.KSerializer<T0> typeSerial0) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010\u0005R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/kotdev/trading/service/api/ApiResult$Error;", "T", "Lcom/kotdev/trading/service/api/ApiResult;", "error", "", "(Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "service_debug"})
    public static final class Error<T extends java.lang.Object> extends com.kotdev.trading.service.api.ApiResult<T> {
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String error = null;
        
        public Error(@org.jetbrains.annotations.Nullable()
        java.lang.String error) {
            super(0, null);
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getError() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/kotdev/trading/service/api/ApiResult$Loading;", "T", "Lcom/kotdev/trading/service/api/ApiResult;", "()V", "service_debug"})
    public static final class Loading<T extends java.lang.Object> extends com.kotdev.trading.service.api.ApiResult<T> {
        
        public Loading() {
            super(0, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0001\u00a2\u0006\u0002\u0010\u0004R\u0015\u0010\u0003\u001a\u0004\u0018\u00018\u0001\u00a2\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/kotdev/trading/service/api/ApiResult$Success;", "T", "Lcom/kotdev/trading/service/api/ApiResult;", "data", "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "service_debug"})
    public static final class Success<T extends java.lang.Object> extends com.kotdev.trading.service.api.ApiResult<T> {
        @org.jetbrains.annotations.Nullable()
        private final T data = null;
        
        public Success(@org.jetbrains.annotations.Nullable()
        T data) {
            super(0, null);
        }
        
        @org.jetbrains.annotations.Nullable()
        public final T getData() {
            return null;
        }
    }
}