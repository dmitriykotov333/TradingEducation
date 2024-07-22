package com.kotdev.trading;

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
public final class TradingRoomDatabase_Impl extends TradingRoomDatabase {
  private volatile HistoryDao _historyDao;

  private volatile PairDao _pairDao;

  private volatile BalanceDao _balanceDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `history` (`createdAt` INTEGER NOT NULL, `icon` INTEGER NOT NULL, `pair` TEXT NOT NULL, `open_time` INTEGER NOT NULL, `close_time` INTEGER NOT NULL, `open_price` REAL NOT NULL, `close_price` REAL NOT NULL, `profit` REAL NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `pair` (`pair` TEXT NOT NULL, `value` REAL NOT NULL, `time_next_update` TEXT NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `balance` (`balance` REAL NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '200b3fc70371e10e4eba0f0da52a014e')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `history`");
        db.execSQL("DROP TABLE IF EXISTS `pair`");
        db.execSQL("DROP TABLE IF EXISTS `balance`");
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
        final HashMap<String, TableInfo.Column> _columnsHistory = new HashMap<String, TableInfo.Column>(9);
        _columnsHistory.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHistory.put("icon", new TableInfo.Column("icon", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHistory.put("pair", new TableInfo.Column("pair", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHistory.put("open_time", new TableInfo.Column("open_time", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHistory.put("close_time", new TableInfo.Column("close_time", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHistory.put("open_price", new TableInfo.Column("open_price", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHistory.put("close_price", new TableInfo.Column("close_price", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHistory.put("profit", new TableInfo.Column("profit", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHistory.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysHistory = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesHistory = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoHistory = new TableInfo("history", _columnsHistory, _foreignKeysHistory, _indicesHistory);
        final TableInfo _existingHistory = TableInfo.read(db, "history");
        if (!_infoHistory.equals(_existingHistory)) {
          return new RoomOpenHelper.ValidationResult(false, "history(com.kotdev.trading.HistoryDBO).\n"
                  + " Expected:\n" + _infoHistory + "\n"
                  + " Found:\n" + _existingHistory);
        }
        final HashMap<String, TableInfo.Column> _columnsPair = new HashMap<String, TableInfo.Column>(4);
        _columnsPair.put("pair", new TableInfo.Column("pair", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPair.put("value", new TableInfo.Column("value", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPair.put("time_next_update", new TableInfo.Column("time_next_update", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPair.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPair = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPair = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPair = new TableInfo("pair", _columnsPair, _foreignKeysPair, _indicesPair);
        final TableInfo _existingPair = TableInfo.read(db, "pair");
        if (!_infoPair.equals(_existingPair)) {
          return new RoomOpenHelper.ValidationResult(false, "pair(com.kotdev.trading.PairDBO).\n"
                  + " Expected:\n" + _infoPair + "\n"
                  + " Found:\n" + _existingPair);
        }
        final HashMap<String, TableInfo.Column> _columnsBalance = new HashMap<String, TableInfo.Column>(2);
        _columnsBalance.put("balance", new TableInfo.Column("balance", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBalance.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBalance = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBalance = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBalance = new TableInfo("balance", _columnsBalance, _foreignKeysBalance, _indicesBalance);
        final TableInfo _existingBalance = TableInfo.read(db, "balance");
        if (!_infoBalance.equals(_existingBalance)) {
          return new RoomOpenHelper.ValidationResult(false, "balance(com.kotdev.trading.BalanceDBO).\n"
                  + " Expected:\n" + _infoBalance + "\n"
                  + " Found:\n" + _existingBalance);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "200b3fc70371e10e4eba0f0da52a014e", "ee8171760f64b3e0c84c7c24d026bc9c");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "history","pair","balance");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `history`");
      _db.execSQL("DELETE FROM `pair`");
      _db.execSQL("DELETE FROM `balance`");
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
    _typeConvertersMap.put(HistoryDao.class, HistoryDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(PairDao.class, PairDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(BalanceDao.class, BalanceDao_Impl.getRequiredConverters());
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
  public HistoryDao historyDao() {
    if (_historyDao != null) {
      return _historyDao;
    } else {
      synchronized(this) {
        if(_historyDao == null) {
          _historyDao = new HistoryDao_Impl(this);
        }
        return _historyDao;
      }
    }
  }

  @Override
  public PairDao pairDao() {
    if (_pairDao != null) {
      return _pairDao;
    } else {
      synchronized(this) {
        if(_pairDao == null) {
          _pairDao = new PairDao_Impl(this);
        }
        return _pairDao;
      }
    }
  }

  @Override
  public BalanceDao balanceDao() {
    if (_balanceDao != null) {
      return _balanceDao;
    } else {
      synchronized(this) {
        if(_balanceDao == null) {
          _balanceDao = new BalanceDao_Impl(this);
        }
        return _balanceDao;
      }
    }
  }
}
