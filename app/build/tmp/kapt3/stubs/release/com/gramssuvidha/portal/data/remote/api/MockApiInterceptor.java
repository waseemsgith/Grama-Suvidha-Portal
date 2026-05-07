package com.gramssuvidha.portal.data.remote.api;

/**
 * OkHttp Interceptor that returns mock JSON responses,
 * simulating a real Panchayat backend API.
 * Replace with a real base URL when deploying to production.
 */
@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/gramssuvidha/portal/data/remote/api/MockApiInterceptor;", "Lokhttp3/Interceptor;", "()V", "getUpdatesJson", "", "projectId", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "app_release"})
public final class MockApiInterceptor implements okhttp3.Interceptor {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String FEEDBACK_RESPONSE_JSON = "{\"success\":true,\"message\":\"Feedback submitted successfully.\"}";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String PROJECTS_JSON = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.gramssuvidha.portal.data.remote.api.MockApiInterceptor.Companion Companion = null;
    
    @javax.inject.Inject()
    public MockApiInterceptor() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public okhttp3.Response intercept(@org.jetbrains.annotations.NotNull()
    okhttp3.Interceptor.Chain chain) {
        return null;
    }
    
    private final java.lang.String getUpdatesJson(java.lang.String projectId) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/gramssuvidha/portal/data/remote/api/MockApiInterceptor$Companion;", "", "()V", "FEEDBACK_RESPONSE_JSON", "", "getFEEDBACK_RESPONSE_JSON", "()Ljava/lang/String;", "PROJECTS_JSON", "getPROJECTS_JSON", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getFEEDBACK_RESPONSE_JSON() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getPROJECTS_JSON() {
            return null;
        }
    }
}