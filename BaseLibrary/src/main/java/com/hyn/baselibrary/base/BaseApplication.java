package com.hyn.baselibrary.base;

import android.app.Application;
import android.content.Context;

import org.xutils.x;

/**
 * @author： hyn
 * @e-mail： hyn_0525@sina.com
 * Created at 2017/3/31  15:30
 */
public class BaseApplication extends Application {
    protected static Context _context;  //上下文

    @Override
    public void onCreate() {
        super.onCreate();
//        初始化xutils
        x.Ext.init(this);
        x.Ext.setDebug(true);
        if (_context == null) {  //判断是否已经被初始化过
            _context = getApplicationContext();
        }
    }

    public static synchronized BaseApplication context() {
        return (BaseApplication) _context;
    }
}
