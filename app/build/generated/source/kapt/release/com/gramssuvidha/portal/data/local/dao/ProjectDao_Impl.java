package com.gramssuvidha.portal.data.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.gramssuvidha.portal.data.local.converter.StringListConverter;
import com.gramssuvidha.portal.data.local.entity.ProjectEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ProjectDao_Impl implements ProjectDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ProjectEntity> __insertionAdapterOfProjectEntity;

  private final StringListConverter __stringListConverter = new StringListConverter();

  private final EntityDeletionOrUpdateAdapter<ProjectEntity> __deletionAdapterOfProjectEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllProjects;

  public ProjectDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfProjectEntity = new EntityInsertionAdapter<ProjectEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `projects` (`id`,`title`,`description`,`category`,`status`,`budget`,`budgetSpent`,`progressPercent`,`contractor`,`contractorContact`,`startDate`,`expectedCompletionDate`,`actualCompletionDate`,`location`,`latitude`,`longitude`,`ward`,`panchayatName`,`imageUrls`,`beforeImages`,`afterImages`,`aiSummary`,`lastUpdated`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ProjectEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDescription());
        }
        if (entity.getCategory() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getCategory());
        }
        if (entity.getStatus() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getStatus());
        }
        statement.bindDouble(6, entity.getBudget());
        statement.bindDouble(7, entity.getBudgetSpent());
        statement.bindLong(8, entity.getProgressPercent());
        if (entity.getContractor() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getContractor());
        }
        if (entity.getContractorContact() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getContractorContact());
        }
        if (entity.getStartDate() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getStartDate());
        }
        if (entity.getExpectedCompletionDate() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getExpectedCompletionDate());
        }
        if (entity.getActualCompletionDate() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getActualCompletionDate());
        }
        if (entity.getLocation() == null) {
          statement.bindNull(14);
        } else {
          statement.bindString(14, entity.getLocation());
        }
        statement.bindDouble(15, entity.getLatitude());
        statement.bindDouble(16, entity.getLongitude());
        if (entity.getWard() == null) {
          statement.bindNull(17);
        } else {
          statement.bindString(17, entity.getWard());
        }
        if (entity.getPanchayatName() == null) {
          statement.bindNull(18);
        } else {
          statement.bindString(18, entity.getPanchayatName());
        }
        final String _tmp = __stringListConverter.fromStringList(entity.getImageUrls());
        if (_tmp == null) {
          statement.bindNull(19);
        } else {
          statement.bindString(19, _tmp);
        }
        final String _tmp_1 = __stringListConverter.fromStringList(entity.getBeforeImages());
        if (_tmp_1 == null) {
          statement.bindNull(20);
        } else {
          statement.bindString(20, _tmp_1);
        }
        final String _tmp_2 = __stringListConverter.fromStringList(entity.getAfterImages());
        if (_tmp_2 == null) {
          statement.bindNull(21);
        } else {
          statement.bindString(21, _tmp_2);
        }
        if (entity.getAiSummary() == null) {
          statement.bindNull(22);
        } else {
          statement.bindString(22, entity.getAiSummary());
        }
        statement.bindLong(23, entity.getLastUpdated());
      }
    };
    this.__deletionAdapterOfProjectEntity = new EntityDeletionOrUpdateAdapter<ProjectEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `projects` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ProjectEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
      }
    };
    this.__preparedStmtOfDeleteAllProjects = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM projects";
        return _query;
      }
    };
  }

  @Override
  public Object insertProjects(final List<ProjectEntity> projects,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfProjectEntity.insert(projects);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertProject(final ProjectEntity project,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfProjectEntity.insert(project);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteProject(final ProjectEntity project,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfProjectEntity.handle(project);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAllProjects(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllProjects.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteAllProjects.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<ProjectEntity>> getAllProjects() {
    final String _sql = "SELECT * FROM projects ORDER BY lastUpdated DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"projects"}, new Callable<List<ProjectEntity>>() {
      @Override
      @NonNull
      public List<ProjectEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfBudget = CursorUtil.getColumnIndexOrThrow(_cursor, "budget");
          final int _cursorIndexOfBudgetSpent = CursorUtil.getColumnIndexOrThrow(_cursor, "budgetSpent");
          final int _cursorIndexOfProgressPercent = CursorUtil.getColumnIndexOrThrow(_cursor, "progressPercent");
          final int _cursorIndexOfContractor = CursorUtil.getColumnIndexOrThrow(_cursor, "contractor");
          final int _cursorIndexOfContractorContact = CursorUtil.getColumnIndexOrThrow(_cursor, "contractorContact");
          final int _cursorIndexOfStartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "startDate");
          final int _cursorIndexOfExpectedCompletionDate = CursorUtil.getColumnIndexOrThrow(_cursor, "expectedCompletionDate");
          final int _cursorIndexOfActualCompletionDate = CursorUtil.getColumnIndexOrThrow(_cursor, "actualCompletionDate");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfWard = CursorUtil.getColumnIndexOrThrow(_cursor, "ward");
          final int _cursorIndexOfPanchayatName = CursorUtil.getColumnIndexOrThrow(_cursor, "panchayatName");
          final int _cursorIndexOfImageUrls = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrls");
          final int _cursorIndexOfBeforeImages = CursorUtil.getColumnIndexOrThrow(_cursor, "beforeImages");
          final int _cursorIndexOfAfterImages = CursorUtil.getColumnIndexOrThrow(_cursor, "afterImages");
          final int _cursorIndexOfAiSummary = CursorUtil.getColumnIndexOrThrow(_cursor, "aiSummary");
          final int _cursorIndexOfLastUpdated = CursorUtil.getColumnIndexOrThrow(_cursor, "lastUpdated");
          final List<ProjectEntity> _result = new ArrayList<ProjectEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ProjectEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            final double _tmpBudget;
            _tmpBudget = _cursor.getDouble(_cursorIndexOfBudget);
            final double _tmpBudgetSpent;
            _tmpBudgetSpent = _cursor.getDouble(_cursorIndexOfBudgetSpent);
            final int _tmpProgressPercent;
            _tmpProgressPercent = _cursor.getInt(_cursorIndexOfProgressPercent);
            final String _tmpContractor;
            if (_cursor.isNull(_cursorIndexOfContractor)) {
              _tmpContractor = null;
            } else {
              _tmpContractor = _cursor.getString(_cursorIndexOfContractor);
            }
            final String _tmpContractorContact;
            if (_cursor.isNull(_cursorIndexOfContractorContact)) {
              _tmpContractorContact = null;
            } else {
              _tmpContractorContact = _cursor.getString(_cursorIndexOfContractorContact);
            }
            final String _tmpStartDate;
            if (_cursor.isNull(_cursorIndexOfStartDate)) {
              _tmpStartDate = null;
            } else {
              _tmpStartDate = _cursor.getString(_cursorIndexOfStartDate);
            }
            final String _tmpExpectedCompletionDate;
            if (_cursor.isNull(_cursorIndexOfExpectedCompletionDate)) {
              _tmpExpectedCompletionDate = null;
            } else {
              _tmpExpectedCompletionDate = _cursor.getString(_cursorIndexOfExpectedCompletionDate);
            }
            final String _tmpActualCompletionDate;
            if (_cursor.isNull(_cursorIndexOfActualCompletionDate)) {
              _tmpActualCompletionDate = null;
            } else {
              _tmpActualCompletionDate = _cursor.getString(_cursorIndexOfActualCompletionDate);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            final String _tmpWard;
            if (_cursor.isNull(_cursorIndexOfWard)) {
              _tmpWard = null;
            } else {
              _tmpWard = _cursor.getString(_cursorIndexOfWard);
            }
            final String _tmpPanchayatName;
            if (_cursor.isNull(_cursorIndexOfPanchayatName)) {
              _tmpPanchayatName = null;
            } else {
              _tmpPanchayatName = _cursor.getString(_cursorIndexOfPanchayatName);
            }
            final List<String> _tmpImageUrls;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfImageUrls)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfImageUrls);
            }
            _tmpImageUrls = __stringListConverter.toStringList(_tmp);
            final List<String> _tmpBeforeImages;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfBeforeImages)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfBeforeImages);
            }
            _tmpBeforeImages = __stringListConverter.toStringList(_tmp_1);
            final List<String> _tmpAfterImages;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfAfterImages)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfAfterImages);
            }
            _tmpAfterImages = __stringListConverter.toStringList(_tmp_2);
            final String _tmpAiSummary;
            if (_cursor.isNull(_cursorIndexOfAiSummary)) {
              _tmpAiSummary = null;
            } else {
              _tmpAiSummary = _cursor.getString(_cursorIndexOfAiSummary);
            }
            final long _tmpLastUpdated;
            _tmpLastUpdated = _cursor.getLong(_cursorIndexOfLastUpdated);
            _item = new ProjectEntity(_tmpId,_tmpTitle,_tmpDescription,_tmpCategory,_tmpStatus,_tmpBudget,_tmpBudgetSpent,_tmpProgressPercent,_tmpContractor,_tmpContractorContact,_tmpStartDate,_tmpExpectedCompletionDate,_tmpActualCompletionDate,_tmpLocation,_tmpLatitude,_tmpLongitude,_tmpWard,_tmpPanchayatName,_tmpImageUrls,_tmpBeforeImages,_tmpAfterImages,_tmpAiSummary,_tmpLastUpdated);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<ProjectEntity> getProjectById(final String id) {
    final String _sql = "SELECT * FROM projects WHERE id = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"projects"}, new Callable<ProjectEntity>() {
      @Override
      @Nullable
      public ProjectEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfBudget = CursorUtil.getColumnIndexOrThrow(_cursor, "budget");
          final int _cursorIndexOfBudgetSpent = CursorUtil.getColumnIndexOrThrow(_cursor, "budgetSpent");
          final int _cursorIndexOfProgressPercent = CursorUtil.getColumnIndexOrThrow(_cursor, "progressPercent");
          final int _cursorIndexOfContractor = CursorUtil.getColumnIndexOrThrow(_cursor, "contractor");
          final int _cursorIndexOfContractorContact = CursorUtil.getColumnIndexOrThrow(_cursor, "contractorContact");
          final int _cursorIndexOfStartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "startDate");
          final int _cursorIndexOfExpectedCompletionDate = CursorUtil.getColumnIndexOrThrow(_cursor, "expectedCompletionDate");
          final int _cursorIndexOfActualCompletionDate = CursorUtil.getColumnIndexOrThrow(_cursor, "actualCompletionDate");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfWard = CursorUtil.getColumnIndexOrThrow(_cursor, "ward");
          final int _cursorIndexOfPanchayatName = CursorUtil.getColumnIndexOrThrow(_cursor, "panchayatName");
          final int _cursorIndexOfImageUrls = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrls");
          final int _cursorIndexOfBeforeImages = CursorUtil.getColumnIndexOrThrow(_cursor, "beforeImages");
          final int _cursorIndexOfAfterImages = CursorUtil.getColumnIndexOrThrow(_cursor, "afterImages");
          final int _cursorIndexOfAiSummary = CursorUtil.getColumnIndexOrThrow(_cursor, "aiSummary");
          final int _cursorIndexOfLastUpdated = CursorUtil.getColumnIndexOrThrow(_cursor, "lastUpdated");
          final ProjectEntity _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            final double _tmpBudget;
            _tmpBudget = _cursor.getDouble(_cursorIndexOfBudget);
            final double _tmpBudgetSpent;
            _tmpBudgetSpent = _cursor.getDouble(_cursorIndexOfBudgetSpent);
            final int _tmpProgressPercent;
            _tmpProgressPercent = _cursor.getInt(_cursorIndexOfProgressPercent);
            final String _tmpContractor;
            if (_cursor.isNull(_cursorIndexOfContractor)) {
              _tmpContractor = null;
            } else {
              _tmpContractor = _cursor.getString(_cursorIndexOfContractor);
            }
            final String _tmpContractorContact;
            if (_cursor.isNull(_cursorIndexOfContractorContact)) {
              _tmpContractorContact = null;
            } else {
              _tmpContractorContact = _cursor.getString(_cursorIndexOfContractorContact);
            }
            final String _tmpStartDate;
            if (_cursor.isNull(_cursorIndexOfStartDate)) {
              _tmpStartDate = null;
            } else {
              _tmpStartDate = _cursor.getString(_cursorIndexOfStartDate);
            }
            final String _tmpExpectedCompletionDate;
            if (_cursor.isNull(_cursorIndexOfExpectedCompletionDate)) {
              _tmpExpectedCompletionDate = null;
            } else {
              _tmpExpectedCompletionDate = _cursor.getString(_cursorIndexOfExpectedCompletionDate);
            }
            final String _tmpActualCompletionDate;
            if (_cursor.isNull(_cursorIndexOfActualCompletionDate)) {
              _tmpActualCompletionDate = null;
            } else {
              _tmpActualCompletionDate = _cursor.getString(_cursorIndexOfActualCompletionDate);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            final String _tmpWard;
            if (_cursor.isNull(_cursorIndexOfWard)) {
              _tmpWard = null;
            } else {
              _tmpWard = _cursor.getString(_cursorIndexOfWard);
            }
            final String _tmpPanchayatName;
            if (_cursor.isNull(_cursorIndexOfPanchayatName)) {
              _tmpPanchayatName = null;
            } else {
              _tmpPanchayatName = _cursor.getString(_cursorIndexOfPanchayatName);
            }
            final List<String> _tmpImageUrls;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfImageUrls)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfImageUrls);
            }
            _tmpImageUrls = __stringListConverter.toStringList(_tmp);
            final List<String> _tmpBeforeImages;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfBeforeImages)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfBeforeImages);
            }
            _tmpBeforeImages = __stringListConverter.toStringList(_tmp_1);
            final List<String> _tmpAfterImages;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfAfterImages)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfAfterImages);
            }
            _tmpAfterImages = __stringListConverter.toStringList(_tmp_2);
            final String _tmpAiSummary;
            if (_cursor.isNull(_cursorIndexOfAiSummary)) {
              _tmpAiSummary = null;
            } else {
              _tmpAiSummary = _cursor.getString(_cursorIndexOfAiSummary);
            }
            final long _tmpLastUpdated;
            _tmpLastUpdated = _cursor.getLong(_cursorIndexOfLastUpdated);
            _result = new ProjectEntity(_tmpId,_tmpTitle,_tmpDescription,_tmpCategory,_tmpStatus,_tmpBudget,_tmpBudgetSpent,_tmpProgressPercent,_tmpContractor,_tmpContractorContact,_tmpStartDate,_tmpExpectedCompletionDate,_tmpActualCompletionDate,_tmpLocation,_tmpLatitude,_tmpLongitude,_tmpWard,_tmpPanchayatName,_tmpImageUrls,_tmpBeforeImages,_tmpAfterImages,_tmpAiSummary,_tmpLastUpdated);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getProjectCount(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM projects";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
