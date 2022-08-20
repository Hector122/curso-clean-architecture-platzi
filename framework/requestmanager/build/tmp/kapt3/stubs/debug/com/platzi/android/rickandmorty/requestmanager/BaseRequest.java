package com.platzi.android.rickandmorty.requestmanager;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010\r\u001a\u0002H\u0001\"\n\b\u0001\u0010\u0001\u0018\u0001*\u00020\u0002H\u0086\b\u00a2\u0006\u0002\u0010\u000eR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/platzi/android/rickandmorty/requestmanager/BaseRequest;", "T", "", "baseUrl", "", "(Ljava/lang/String;)V", "getBaseUrl", "()Ljava/lang/String;", "setBaseUrl", "okHttpClient", "Lokhttp3/OkHttpClient;", "buildRetrofit", "Lretrofit2/Retrofit;", "getService", "()Ljava/lang/Object;", "requestmanager_debug"})
public abstract class BaseRequest<T extends java.lang.Object> {
    private final okhttp3.OkHttpClient okHttpClient = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String baseUrl;
    
    @org.jetbrains.annotations.NotNull()
    public final retrofit2.Retrofit buildRetrofit() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBaseUrl() {
        return null;
    }
    
    public final void setBaseUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public BaseRequest(@org.jetbrains.annotations.NotNull()
    java.lang.String baseUrl) {
        super();
    }
}