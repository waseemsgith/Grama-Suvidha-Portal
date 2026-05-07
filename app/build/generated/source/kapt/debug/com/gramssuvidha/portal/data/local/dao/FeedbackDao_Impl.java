package com.gramssuvidha.portal.data.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.gramssuvidha.portal.data.local.entity.FeedbackEntity;
import java.lang.Class;
import java.lang.Exception;
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
public final class FeedbackDao_Impl implements FeedbackDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<FeedbackEntity> __insertionAdapterOfFeedbackEntity;

  private final EntityDeletionOrUpdateAdapter<FeedbackEntity> __deletionAdapterOfFeedbackEntity;

  private final EntityDeletionOrUpdateAdapter<FeedbackEntity> __updateAdapterOfFeedbackEntity;

  private final SharedSQLiteStatement __preparedStmtOfMarkAsSubmitted;

  public FeedbackDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFeedbackEntity = new EntityInsertionAdapter<FeedbackEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `feedback` (`id`,`projectId`,`projectTitle`,`rating`,`comment`,`issueType`,`citizenName`,`citizenContact`,`imageUrl`,`isSubmitted`,`submittedAt`,`aiCategory`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final FeedbackEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getProjectId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getProjectId());
        }
        if (entity.getProjectTitle() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getProjectTitle());
        }
        statement.bindLong(4, entity.getRating());
        if (entity.getComment() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getComment());
        }
        if (entity.getIssueType() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getIssueType());
        }
        if (entity.getCitizenName() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getCitizenName());
        }
        if (entity.getCitizenContact() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getCitizenContact());
        }
        if (entity.getImageUrl() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getImageUrl());
        }
        final int _tmp = entity.isSubmitted() ? 1 : 0;
        statement.bindLong(10, _tmp);
        statement.bindLong(11, entity.getSubmittedAt());
        if (entity.getAiCategory() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getAiCategory());
        }
      }
    };
    this.__deletionAdapterOfFeedbackEntity = new EntityDeletionOrUpdateAdapter<FeedbackEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `feedback` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final FeedbackEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
      }
    };
    this.__updateAdapterOfFeedbackEntity = new EntityDeletionOrUpdateAdapter<FeedbackEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `feedback` SET `id` = ?,`projectId` = ?,`projectTitle` = ?,`rating` = ?,`comment` = ?,`issueType` = ?,`citizenName` = ?,`citizenContact` = ?,`imageUrl` = ?,`isSubmitted` = ?,`submittedAt` = ?,`aiCategory` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final FeedbackEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getProjectId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getProjectId());
        }
        if (entity.getProjectTitle() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getProjectTitle());
        }
        statement.bindLong(4, entity.getRating());
        if (entity.getComment() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getComment());
        }
        if (entity.getIssueType() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getIssueType());
        }
        if (entity.getCitizenName() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getCitizenName());
        }
        if (entity.getCitizenContact() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getCitizenContact());
        }
        if (entity.getImageUrl() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getImageUrl());
        }
        final int _tmp = entity.isSubmitted() ? 1 : 0;
        statement.bindLong(10, _tmp);
        statement.bindLong(11, entity.getSubmittedAt());
        if (entity.getAiCategory() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getAiCategory());
        }
        if (entity.getId() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getId());
        }
      }
    };
    this.__preparedStmtOfMarkAsSubmitted = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE feedback SET isSubmitted = 1 WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertFeedback(final FeedbackEntity feedback,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfFeedbackEntity.insert(feedback);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteFeedback(final FeedbackEntity feedback,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfFeedbackEntity.handle(feedback);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateFeedback(final FeedbackEntity feedback,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfFeedbackEntity.handle(feedback);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object markAsSubmitted(final String id, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfMarkAsSubmitted.acquire();
        int _argIndex = 1;
        if (id == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, id);
        }
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
          __preparedStmtOfMarkAsSubmitted.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<FeedbackEntity>> getFeedbackForProject(final String projectId) {
    final String _sql = "SELECT * FROM feedback WHERE projectId = ? ORDER BY submittedAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (projectId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, projectId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"feedback"}, new Callable<List<FeedbackEntity>>() {
      @Override
      @NonNull
      public List<FeedbackEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfProjectId = CursorUtil.getColumnIndexOrThrow(_cursor, "projectId");
          final int _cursorIndexOfProjectTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "projectTitle");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
          final int _cursorIndexOfIssueType = CursorUtil.getColumnIndexOrThrow(_cursor, "issueType");
          final int _cursorIndexOfCitizenName = CursorUtil.getColumnIndexOrThrow(_cursor, "citizenName");
          final int _cursorIndexOfCitizenContact = CursorUtil.getColumnIndexOrThrow(_cursor, "citizenContact");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfIsSubmitted = CursorUtil.getColumnIndexOrThrow(_cursor, "isSubmitted");
          final int _cursorIndexOfSubmittedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "submittedAt");
          final int _cursorIndexOfAiCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "aiCategory");
          final List<FeedbackEntity> _result = new ArrayList<FeedbackEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final FeedbackEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpProjectId;
            if (_cursor.isNull(_cursorIndexOfProjectId)) {
              _tmpProjectId = null;
            } else {
              _tmpProjectId = _cursor.getString(_cursorIndexOfProjectId);
            }
            final String _tmpProjectTitle;
            if (_cursor.isNull(_cursorIndexOfProjectTitle)) {
              _tmpProjectTitle = null;
            } else {
              _tmpProjectTitle = _cursor.getString(_cursorIndexOfProjectTitle);
            }
            final int _tmpRating;
            _tmpRating = _cursor.getInt(_cursorIndexOfRating);
            final String _tmpComment;
            if (_cursor.isNull(_cursorIndexOfComment)) {
              _tmpComment = null;
            } else {
              _tmpComment = _cursor.getString(_cursorIndexOfComment);
            }
            final String _tmpIssueType;
            if (_cursor.isNull(_cursorIndexOfIssueType)) {
              _tmpIssueType = null;
            } else {
              _tmpIssueType = _cursor.getString(_cursorIndexOfIssueType);
            }
            final String _tmpCitizenName;
            if (_cursor.isNull(_cursorIndexOfCitizenName)) {
              _tmpCitizenName = null;
            } else {
              _tmpCitizenName = _cursor.getString(_cursorIndexOfCitizenName);
            }
            final String _tmpCitizenContact;
            if (_cursor.isNull(_cursorIndexOfCitizenContact)) {
              _tmpCitizenContact = null;
            } else {
              _tmpCitizenContact = _cursor.getString(_cursorIndexOfCitizenContact);
            }
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            final boolean _tmpIsSubmitted;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsSubmitted);
            _tmpIsSubmitted = _tmp != 0;
            final long _tmpSubmittedAt;
            _tmpSubmittedAt = _cursor.getLong(_cursorIndexOfSubmittedAt);
            final String _tmpAiCategory;
            if (_cursor.isNull(_cursorIndexOfAiCategory)) {
              _tmpAiCategory = null;
            } else {
              _tmpAiCategory = _cursor.getString(_cursorIndexOfAiCategory);
            }
            _item = new FeedbackEntity(_tmpId,_tmpProjectId,_tmpProjectTitle,_tmpRating,_tmpComment,_tmpIssueType,_tmpCitizenName,_tmpCitizenContact,_tmpImageUrl,_tmpIsSubmitted,_tmpSubmittedAt,_tmpAiCategory);
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
  public Object getPendingFeedback(final Continuation<? super List<FeedbackEntity>> $completion) {
    final String _sql = "SELECT * FROM feedback WHERE isSubmitted = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<FeedbackEntity>>() {
      @Override
      @NonNull
      public List<FeedbackEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfProjectId = CursorUtil.getColumnIndexOrThrow(_cursor, "projectId");
          final int _cursorIndexOfProjectTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "projectTitle");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
          final int _cursorIndexOfIssueType = CursorUtil.getColumnIndexOrThrow(_cursor, "issueType");
          final int _cursorIndexOfCitizenName = CursorUtil.getColumnIndexOrThrow(_cursor, "citizenName");
          final int _cursorIndexOfCitizenContact = CursorUtil.getColumnIndexOrThrow(_cursor, "citizenContact");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfIsSubmitted = CursorUtil.getColumnIndexOrThrow(_cursor, "isSubmitted");
          final int _cursorIndexOfSubmittedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "submittedAt");
          final int _cursorIndexOfAiCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "aiCategory");
          final List<FeedbackEntity> _result = new ArrayList<FeedbackEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final FeedbackEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpProjectId;
            if (_cursor.isNull(_cursorIndexOfProjectId)) {
              _tmpProjectId = null;
            } else {
              _tmpProjectId = _cursor.getString(_cursorIndexOfProjectId);
            }
            final String _tmpProjectTitle;
            if (_cursor.isNull(_cursorIndexOfProjectTitle)) {
              _tmpProjectTitle = null;
            } else {
              _tmpProjectTitle = _cursor.getString(_cursorIndexOfProjectTitle);
            }
            final int _tmpRating;
            _tmpRating = _cursor.getInt(_cursorIndexOfRating);
            final String _tmpComment;
            if (_cursor.isNull(_cursorIndexOfComment)) {
              _tmpComment = null;
            } else {
              _tmpComment = _cursor.getString(_cursorIndexOfComment);
            }
            final String _tmpIssueType;
            if (_cursor.isNull(_cursorIndexOfIssueType)) {
              _tmpIssueType = null;
            } else {
              _tmpIssueType = _cursor.getString(_cursorIndexOfIssueType);
            }
            final String _tmpCitizenName;
            if (_cursor.isNull(_cursorIndexOfCitizenName)) {
              _tmpCitizenName = null;
            } else {
              _tmpCitizenName = _cursor.getString(_cursorIndexOfCitizenName);
            }
            final String _tmpCitizenContact;
            if (_cursor.isNull(_cursorIndexOfCitizenContact)) {
              _tmpCitizenContact = null;
            } else {
              _tmpCitizenContact = _cursor.getString(_cursorIndexOfCitizenContact);
            }
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            final boolean _tmpIsSubmitted;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsSubmitted);
            _tmpIsSubmitted = _tmp != 0;
            final long _tmpSubmittedAt;
            _tmpSubmittedAt = _cursor.getLong(_cursorIndexOfSubmittedAt);
            final String _tmpAiCategory;
            if (_cursor.isNull(_cursorIndexOfAiCategory)) {
              _tmpAiCategory = null;
            } else {
              _tmpAiCategory = _cursor.getString(_cursorIndexOfAiCategory);
            }
            _item = new FeedbackEntity(_tmpId,_tmpProjectId,_tmpProjectTitle,_tmpRating,_tmpComment,_tmpIssueType,_tmpCitizenName,_tmpCitizenContact,_tmpImageUrl,_tmpIsSubmitted,_tmpSubmittedAt,_tmpAiCategory);
            _result.add(_item);
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
