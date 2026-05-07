package com.gramssuvidha.portal.data.local;

/**
 * Main Room database for Grama Suvidha app.
 * Contains projects, feedback, and project updates tables.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\n"}, d2 = {"Lcom/gramssuvidha/portal/data/local/GramaSuvidhaDatabase;", "Landroidx/room/RoomDatabase;", "()V", "feedbackDao", "Lcom/gramssuvidha/portal/data/local/dao/FeedbackDao;", "projectDao", "Lcom/gramssuvidha/portal/data/local/dao/ProjectDao;", "projectUpdateDao", "Lcom/gramssuvidha/portal/data/local/dao/ProjectUpdateDao;", "Companion", "app_release"})
@androidx.room.Database(entities = {com.gramssuvidha.portal.data.local.entity.ProjectEntity.class, com.gramssuvidha.portal.data.local.entity.FeedbackEntity.class, com.gramssuvidha.portal.data.local.entity.ProjectUpdateEntity.class}, version = 1, exportSchema = true)
@androidx.room.TypeConverters(value = {com.gramssuvidha.portal.data.local.converter.StringListConverter.class})
public abstract class GramaSuvidhaDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATABASE_NAME = "grama_suvidha_db";
    @org.jetbrains.annotations.NotNull()
    public static final com.gramssuvidha.portal.data.local.GramaSuvidhaDatabase.Companion Companion = null;
    
    public GramaSuvidhaDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.gramssuvidha.portal.data.local.dao.ProjectDao projectDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.gramssuvidha.portal.data.local.dao.FeedbackDao feedbackDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.gramssuvidha.portal.data.local.dao.ProjectUpdateDao projectUpdateDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/gramssuvidha/portal/data/local/GramaSuvidhaDatabase$Companion;", "", "()V", "DATABASE_NAME", "", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}