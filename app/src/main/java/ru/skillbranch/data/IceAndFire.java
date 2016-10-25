package ru.skillbranch.data;

import com.facebook.stetho.Stetho;

import org.greenrobot.greendao.database.Database;
import android.app.Application;
import android.content.Context;

import ru.skillbranch.data.network.database.DaoMaster;
import ru.skillbranch.data.network.database.DaoSession;

/**
 * Created by root on 20.10.2016.
 */

public class IceAndFire extends Application{

    private static Context sContext;
    private static DaoSession sDaoSession;

    public static Context getContext() {
        return sContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"iceandfire-db");
        Database db = helper.getWritableDb();
        sDaoSession = new DaoMaster(db).newSession();

        Stetho.initializeWithDefaults(this);
    }

    public static DaoSession getDaoSession() {
        return sDaoSession;
    }
}
