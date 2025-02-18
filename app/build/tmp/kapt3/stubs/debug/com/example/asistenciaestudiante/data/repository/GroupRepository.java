package com.example.asistenciaestudiante.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u001c\u0010\u000f\u001a\u00020\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0086@\u00a2\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/example/asistenciaestudiante/data/repository/GroupRepository;", "", "apiService", "Lcom/example/asistenciaestudiante/data/network/ApiService;", "groupDao", "Lcom/example/asistenciaestudiante/data/room/GroupDao;", "context", "Landroid/content/Context;", "(Lcom/example/asistenciaestudiante/data/network/ApiService;Lcom/example/asistenciaestudiante/data/room/GroupDao;Landroid/content/Context;)V", "clearGroups", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGroups", "", "Lcom/example/asistenciaestudiante/data/room/GroupEntity;", "saveGroups", "groups", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class GroupRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.asistenciaestudiante.data.network.ApiService apiService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.asistenciaestudiante.data.room.GroupDao groupDao = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    
    public GroupRepository(@org.jetbrains.annotations.NotNull()
    com.example.asistenciaestudiante.data.network.ApiService apiService, @org.jetbrains.annotations.NotNull()
    com.example.asistenciaestudiante.data.room.GroupDao groupDao, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getGroups(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.asistenciaestudiante.data.room.GroupEntity>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveGroups(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.asistenciaestudiante.data.room.GroupEntity> groups, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object clearGroups(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}