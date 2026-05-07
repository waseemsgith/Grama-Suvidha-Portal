package com.gramssuvidha.portal.data.local;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.gramssuvidha.portal.data.local.dao.FeedbackDao;
import com.gramssuvidha.portal.data.local.dao.FeedbackDao_Impl;
import com.gramssuvidha.portal.data.local.dao.ProjectDao;
import com.gramssuvidha.portal.data.local.dao.ProjectDao_Impl;
import com.gramssuvidha.portal.data.local.dao.ProjectUpdateDao;
import com.gramssuvidha.portal.data.local.dao.ProjectUpdateDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class GramaSuvidhaDatabase_Impl extends GramaSuvidhaDatabase {
  private volatile ProjectDao _projectDao;

  private volatile FeedbackDao _feedbackDao;

  private volatile ProjectUpdateDao _projectUpdateDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `projects` (`id` TEXT NOT NULL, `title` TEXT NOT NULL, `description` TEXT NOT NULL, `category` TEXT NOT NULL, `status` TEXT NOT NULL, `budget` REAL NOT NULL, `budgetSpent` REAL NOT NULL, `progressPercent` INTEGER NOT NULL, `contractor` TEXT NOT NULL, `contractorContact` TEXT NOT NULL, `startDate` TEXT NOT NULL, `expectedCompletionDate` TEXT NOT NULL, `actualCompletionDate` TEXT, `location` TEXT NOT NULL, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL, `ward` TEXT NOT NULL, `panchayatName` TEXT NOT NULL, `imageUrls` TEXT NOT NULL, `beforeImages` TEXT NOT NULL, `afterImages` TEXT NOT NULL, `aiSummary` TEXT NOT NULL, `lastUpdated` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `feedback` (`id` TEXT NOT NULL, `projectId` TEXT NOT NULL, `projectTitle` TEXT NOT NULL, `rating` INTEGER NOT NULL, `comment` TEXT NOT NULL, `issueType` TEXT NOT NULL, `citizenName` TEXT NOT NULL, `citizenContact` TEXT NOT NULL, `imageUrl` TEXT, `isSubmitted` INTEGER NOT NULL, `submittedAt` INTEGER NOT NULL, `aiCategory` TEXT NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `project_updates` (`id` TEXT NOT NULL, `projectId` TEXT NOT NULL, `title` TEXT NOT NULL, `description` TEXT NOT NULL, `progressPercent` INTEGER NOT NULL, `imageUrl` TEXT, `updatedBy` TEXT NOT NULL, `updatedAt` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '64cfb55d2324f0745e9662cc57833392')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `projects`");
        db.execSQL("DROP TABLE IF EXISTS `feedback`");
        db.execSQL("DROP TABLE IF EXISTS `project_updates`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsProjects = new HashMap<String, TableInfo.Column>(23);
        _columnsProjects.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProjects.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProjects.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProjects.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProjects.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProjects.put("budget", new TableInfo.Column("budget", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProjects.put("budgetSpent", new TableInfo.Column("budgetSpent", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProjects.put("progressPercent", new TableInfo.Column("progressPercent", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProjects.put("contractor", new TableInfo.Column("contractor", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProjects.put("contractorContact", new TableInfo.Column("contractorContact", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProjects.put("startDate", new TableInfo.Column("startDate", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProjects.put("expectedCompletionDate", new TableInfo.Column("expectedCompletionDate", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProjects.put("actualCompletionDate", new TableInfo.Column("actualCompletionDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProjects.put("location", new TableInfo.Column("location", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProjects.put("latitude", new TableInfo.Column("latitude", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProjects.put("longitude", new TableInfo.Column("longitude", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProjects.put("ward", new TableInfo.Column("ward", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProjects.put("panchayatName", new TableInfo.Column("panchayatName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProjects.put("imageUrls", new TableInfo.Column("imageUrls", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProjects.put("beforeImages", new TableInfo.Column("beforeImages", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProjects.put("afterImages", new TableInfo.Column("afterImages", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProjects.put("aiSummary", new TableInfo.Column("aiSummary", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProjects.put("lastUpdated", new TableInfo.Column("lastUpdated", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysProjects = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesProjects = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoProjects = new TableInfo("projects", _columnsProjects, _foreignKeysProjects, _indicesProjects);
        final TableInfo _existingProjects = TableInfo.read(db, "projects");
        if (!_infoProjects.equals(_existingProjects)) {
          return new RoomOpenHelper.ValidationResult(false, "projects(com.gramssuvidha.portal.data.local.entity.ProjectEntity).\n"
                  + " Expected:\n" + _infoProjects + "\n"
                  + " Found:\n" + _existingProjects);
        }
        final HashMap<String, TableInfo.Column> _columnsFeedback = new HashMap<String, TableInfo.Column>(12);
        _columnsFeedback.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFeedback.put("projectId", new TableInfo.Column("projectId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFeedback.put("projectTitle", new TableInfo.Column("projectTitle", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFeedback.put("rating", new TableInfo.Column("rating", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFeedback.put("comment", new TableInfo.Column("comment", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFeedback.put("issueType", new TableInfo.Column("issueType", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFeedback.put("citizenName", new TableInfo.Column("citizenName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFeedback.put("citizenContact", new TableInfo.Column("citizenContact", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFeedback.put("imageUrl", new TableInfo.Column("imageUrl", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFeedback.put("isSubmitted", new TableInfo.Column("isSubmitted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFeedback.put("submittedAt", new TableInfo.Column("submittedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFeedback.put("aiCategory", new TableInfo.Column("aiCategory", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFeedback = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFeedback = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFeedback = new TableInfo("feedback", _columnsFeedback, _foreignKeysFeedback, _indicesFeedback);
        final TableInfo _existingFeedback = TableInfo.read(db, "feedback");
        if (!_infoFeedback.equals(_existingFeedback)) {
          return new RoomOpenHelper.ValidationResult(false, "feedback(com.gramssuvidha.portal.data.local.entity.FeedbackEntity).\n"
                  + " Expected:\n" + _infoFeedback + "\n"
                  + " Found:\n" + _existingFeedback);
        }
        final HashMap<String, TableInfo.Column> _columnsProjectUpdates = new HashMap<String, TableInfo.Column>(8);
        _columnsProjectUpdates.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProjectUpdates.put("projectId", new TableInfo.Column("projectId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProjectUpdates.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProjectUpdates.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProjectUpdates.put("progressPercent", new TableInfo.Column("progressPercent", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProjectUpdates.put("imageUrl", new TableInfo.Column("imageUrl", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProjectUpdates.put("updatedBy", new TableInfo.Column("updatedBy", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProjectUpdates.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysProjectUpdates = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesProjectUpdates = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoProjectUpdates = new TableInfo("project_updates", _columnsProjectUpdates, _foreignKeysProjectUpdates, _indicesProjectUpdates);
        final TableInfo _existingProjectUpdates = TableInfo.read(db, "project_updates");
        if (!_infoProjectUpdates.equals(_existingProjectUpdates)) {
          return new RoomOpenHelper.ValidationResult(false, "project_updates(com.gramssuvidha.portal.data.local.entity.ProjectUpdateEntity).\n"
                  + " Expected:\n" + _infoProjectUpdates + "\n"
                  + " Found:\n" + _existingProjectUpdates);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "64cfb55d2324f0745e9662cc57833392", "a7e226907bab9490504ade9ab2d6e9ec");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "projects","feedback","project_updates");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `projects`");
      _db.execSQL("DELETE FROM `feedback`");
      _db.execSQL("DELETE FROM `project_updates`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(ProjectDao.class, ProjectDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(FeedbackDao.class, FeedbackDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ProjectUpdateDao.class, ProjectUpdateDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public ProjectDao projectDao() {
    if (_projectDao != null) {
      return _projectDao;
    } else {
      synchronized(this) {
        if(_projectDao == null) {
          _projectDao = new ProjectDao_Impl(this);
        }
        return _projectDao;
      }
    }
  }

  @Override
  public FeedbackDao feedbackDao() {
    if (_feedbackDao != null) {
      return _feedbackDao;
    } else {
      synchronized(this) {
        if(_feedbackDao == null) {
          _feedbackDao = new FeedbackDao_Impl(this);
        }
        return _feedbackDao;
      }
    }
  }

  @Override
  public ProjectUpdateDao projectUpdateDao() {
    if (_projectUpdateDao != null) {
      return _projectUpdateDao;
    } else {
      synchronized(this) {
        if(_projectUpdateDao == null) {
          _projectUpdateDao = new ProjectUpdateDao_Impl(this);
        }
        return _projectUpdateDao;
      }
    }
  }
}
