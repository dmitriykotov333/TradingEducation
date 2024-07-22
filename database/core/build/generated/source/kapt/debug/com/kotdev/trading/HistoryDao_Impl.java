package com.kotdev.trading;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Long;
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
public final class HistoryDao_Impl implements HistoryDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<HistoryDBO> __insertionAdapterOfHistoryDBO;

  private final SharedSQLiteStatement __preparedStmtOfClean;

  public HistoryDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfHistoryDBO = new EntityInsertionAdapter<HistoryDBO>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `history` (`createdAt`,`icon`,`pair`,`open_time`,`close_time`,`open_price`,`close_price`,`profit`,`id`) VALUES (?,?,?,?,?,?,?,?,nullif(?, 0))";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final HistoryDBO entity) {
        statement.bindLong(1, entity.getCreatedAt());
        statement.bindLong(2, entity.getIcon());
        if (entity.getPair() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getPair());
        }
        statement.bindLong(4, entity.getOpenTime());
        statement.bindLong(5, entity.getCloseTime());
        statement.bindDouble(6, entity.getOpenPrice());
        statement.bindDouble(7, entity.getClosePrice());
        statement.bindDouble(8, entity.getProfit());
        statement.bindLong(9, entity.getId());
      }
    };
    this.__preparedStmtOfClean = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM history";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final HistoryDBO history, final Continuation<? super Long> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfHistoryDBO.insertAndReturnId(history);
          __db.setTransactionSuccessful();
          return _result;
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
  public Flow<List<HistoryDBO>> observeAll() {
    final String _sql = "SELECT * FROM history ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"history"}, new Callable<List<HistoryDBO>>() {
      @Override
      @NonNull
      public List<HistoryDBO> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfIcon = CursorUtil.getColumnIndexOrThrow(_cursor, "icon");
          final int _cursorIndexOfPair = CursorUtil.getColumnIndexOrThrow(_cursor, "pair");
          final int _cursorIndexOfOpenTime = CursorUtil.getColumnIndexOrThrow(_cursor, "open_time");
          final int _cursorIndexOfCloseTime = CursorUtil.getColumnIndexOrThrow(_cursor, "close_time");
          final int _cursorIndexOfOpenPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "open_price");
          final int _cursorIndexOfClosePrice = CursorUtil.getColumnIndexOrThrow(_cursor, "close_price");
          final int _cursorIndexOfProfit = CursorUtil.getColumnIndexOrThrow(_cursor, "profit");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<HistoryDBO> _result = new ArrayList<HistoryDBO>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final HistoryDBO _item;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final int _tmpIcon;
            _tmpIcon = _cursor.getInt(_cursorIndexOfIcon);
            final String _tmpPair;
            if (_cursor.isNull(_cursorIndexOfPair)) {
              _tmpPair = null;
            } else {
              _tmpPair = _cursor.getString(_cursorIndexOfPair);
            }
            final long _tmpOpenTime;
            _tmpOpenTime = _cursor.getLong(_cursorIndexOfOpenTime);
            final long _tmpCloseTime;
            _tmpCloseTime = _cursor.getLong(_cursorIndexOfCloseTime);
            final double _tmpOpenPrice;
            _tmpOpenPrice = _cursor.getDouble(_cursorIndexOfOpenPrice);
            final double _tmpClosePrice;
            _tmpClosePrice = _cursor.getDouble(_cursorIndexOfClosePrice);
            final double _tmpProfit;
            _tmpProfit = _cursor.getDouble(_cursorIndexOfProfit);
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            _item = new HistoryDBO(_tmpCreatedAt,_tmpIcon,_tmpPair,_tmpOpenTime,_tmpCloseTime,_tmpOpenPrice,_tmpClosePrice,_tmpProfit,_tmpId);
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
  public Object getProfit(final Continuation<? super Double> arg0) {
    final String _sql = "SELECT SUM(profit) FROM history";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Double>() {
      @Override
      @Nullable
      public Double call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Double _result;
          if (_cursor.moveToFirst()) {
            final Double _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getDouble(0);
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
    }, arg0);
  }

  @Override
  public Object getById(final long id, final Continuation<? super HistoryDBO> arg1) {
    final String _sql = "SELECT * FROM history WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<HistoryDBO>() {
      @Override
      @Nullable
      public HistoryDBO call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfIcon = CursorUtil.getColumnIndexOrThrow(_cursor, "icon");
          final int _cursorIndexOfPair = CursorUtil.getColumnIndexOrThrow(_cursor, "pair");
          final int _cursorIndexOfOpenTime = CursorUtil.getColumnIndexOrThrow(_cursor, "open_time");
          final int _cursorIndexOfCloseTime = CursorUtil.getColumnIndexOrThrow(_cursor, "close_time");
          final int _cursorIndexOfOpenPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "open_price");
          final int _cursorIndexOfClosePrice = CursorUtil.getColumnIndexOrThrow(_cursor, "close_price");
          final int _cursorIndexOfProfit = CursorUtil.getColumnIndexOrThrow(_cursor, "profit");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final HistoryDBO _result;
          if (_cursor.moveToFirst()) {
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final int _tmpIcon;
            _tmpIcon = _cursor.getInt(_cursorIndexOfIcon);
            final String _tmpPair;
            if (_cursor.isNull(_cursorIndexOfPair)) {
              _tmpPair = null;
            } else {
              _tmpPair = _cursor.getString(_cursorIndexOfPair);
            }
            final long _tmpOpenTime;
            _tmpOpenTime = _cursor.getLong(_cursorIndexOfOpenTime);
            final long _tmpCloseTime;
            _tmpCloseTime = _cursor.getLong(_cursorIndexOfCloseTime);
            final double _tmpOpenPrice;
            _tmpOpenPrice = _cursor.getDouble(_cursorIndexOfOpenPrice);
            final double _tmpClosePrice;
            _tmpClosePrice = _cursor.getDouble(_cursorIndexOfClosePrice);
            final double _tmpProfit;
            _tmpProfit = _cursor.getDouble(_cursorIndexOfProfit);
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            _result = new HistoryDBO(_tmpCreatedAt,_tmpIcon,_tmpPair,_tmpOpenTime,_tmpCloseTime,_tmpOpenPrice,_tmpClosePrice,_tmpProfit,_tmpId);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, arg1);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
