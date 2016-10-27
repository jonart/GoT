package ru.skillbranch;

import com.facebook.stetho.Stetho;

import org.greenrobot.greendao.database.Database;

import android.app.Application;
import android.content.Context;

import ru.skillbranch.data.storage.models.DaoMaster;
import ru.skillbranch.data.storage.models.DaoSession;

public class GameOfThronesApplication extends Application {

    private static Context sContext;
    private static DaoSession sDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "iceandfire-db");
        Database db = helper.getWritableDb();
        sDaoSession = new DaoMaster(db).newSession();

        Stetho.initializeWithDefaults(this);
    }

    public static Context getContext() {
        return sContext;
    }

    public static DaoSession getDaoSession() {
        return sDaoSession;
    }
}
