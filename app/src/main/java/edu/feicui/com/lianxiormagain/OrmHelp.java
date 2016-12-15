package edu.feicui.com.lianxiormagain;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by lenovo on 2016/12/14.
 */

public class OrmHelp extends OrmLiteSqliteOpenHelper {
    Context context;
    private static OrmHelp ormHelp;


    private OrmHelp(Context context) {
        super(context, "system", null, 1);
        this.context = context;
    }

    public synchronized static OrmHelp getInstance(Context context) {
        if (ormHelp == null) {
            ormHelp = new OrmHelp(context.getApplicationContext());
        }

        return ormHelp;
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTableIfNotExists(connectionSource, Student.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Student.class, true);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
