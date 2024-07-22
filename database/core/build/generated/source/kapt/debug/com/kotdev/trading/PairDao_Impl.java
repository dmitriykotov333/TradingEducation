package com.kotdev.trading;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
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
public final class PairDao_Impl implements PairDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PairDBO> __insertionAdapterOfPairDBO;

  private final SharedSQLiteStatement __preparedStmtOfClean;

  public PairDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPairDBO = new EntityInsertionAdapter<PairDBO>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `pair` (`pair`,`value`,`time_next_update`,`id`) VALUES (?,?,?,nullif(?, 0))";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final PairDBO entity) {
        if (entity.getPair() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getPair());
        }
        statement.bindDouble(2, entity.getValue());
        if (entity.getTimeNextUpdate() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getTimeNextUpdate());
        }
        statement.bindLong(4, entity.getId());
      }
    };
    this.__preparedStmtOfClean = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM pair";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final List<PairDBO> pair, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPairDBO.insert(pair);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object clean(final Continuation<? super Unit> arg0) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfClean.acquire();
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
          __preparedStmtOfClean.release(_stmt);
        }
      }
    }, arg0);
  }

  @Override
  public Object observeAll(final Continuation<? super List<PairDBO>> arg0) {
    final String _sql = "SELECT * FROM pair";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<PairDBO>>() {
      @Override
      @NonNull
      public List<PairDBO> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfPair = CursorUtil.getColumnIndexOrThrow(_cursor, "pair");
          final int _cursorIndexOfValue = CursorUtil.getColumnIndexOrThrow(_cursor, "value");
          final int _cursorIndexOfTimeNextUpdate = CursorUtil.getColumnIndexOrThrow(_cursor, "time_next_update");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<PairDBO> _result = new ArrayList<PairDBO>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PairDBO _item;
            final String _tmpPair;
            if (_cursor.isNull(_cursorIndexOfPair)) {
              _tmpPair = null;
            } else {
              _tmpPair = _cursor.getString(_cursorIndexOfPair);
            }
            final double _tmpValue;
            _tmpValue = _cursor.getDouble(_cursorIndexOfValue);
            final String _tmpTimeNextUpdate;
            if (_cursor.isNull(_cursorIndexOfTimeNextUpdate)) {
              _tmpTimeNextUpdate = null;
            } else {
              _tmpTimeNextUpdate = _cursor.getString(_cursorIndexOfTimeNextUpdate);
            }
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            _item = new PairDBO(_tmpPair,_tmpValue,_tmpTimeNextUpdate,_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, arg0);
  }

  @Override
  public Flow<List<PairDBO>> flowAll() {
    final String _sql = "SELECT * FROM pair";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"pair"}, new Callable<List<PairDBO>>() {
      @Override
      @NonNull
      public List<PairDBO> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfPair = CursorUtil.getColumnIndexOrThrow(_cursor, "pair");
          final int _cursorIndexOfValue = CursorUtil.getColumnIndexOrThrow(_cursor, "value");
          final int _cursorIndexOfTimeNextUpdate = CursorUtil.getColumnIndexOrThrow(_cursor, "time_next_update");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<PairDBO> _result = new ArrayList<PairDBO>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PairDBO _item;
            final String _tmpPair;
            if (_cursor.isNull(_cursorIndexOfPair)) {
              _tmpPair = null;
            } else {
              _tmpPair = _cursor.getString(_cursorIndexOfPair);
            }
            final double _tmpValue;
            _tmpValue = _cursor.getDouble(_cursorIndexOfValue);
            final String _tmpTimeNextUpdate;
            if (_cursor.isNull(_cursorIndexOfTimeNextUpdate)) {
              _tmpTimeNextUpdate = null;
            } else {
              _tmpTimeNextUpdate = _cursor.getString(_cursorIndexOfTimeNextUpdate);
            }
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            _item = new PairDBO(_tmpPair,_tmpValue,_tmpTimeNextUpdate,_tmpId);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
