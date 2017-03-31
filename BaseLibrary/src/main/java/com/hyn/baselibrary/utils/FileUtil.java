package com.hyn.baselibrary.utils;

import android.content.res.AssetManager;
import android.os.Environment;

import com.hyn.baselibrary.base.BaseApplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * author： hyn
 * e-mail: hyn_0525@sina.com
 * Date : 2017/3/31
 * Time: 15:43
 */
public class FileUtil {
    /**
     * 读取asset文件，以string 格式返回
     *
     * @param fileName
     * @return
     */
    public static String readAsSetFile(String fileName) {
        try {
            AssetManager assetManager = BaseApplication.context().getResources().getAssets();
            InputStreamReader inputReader = new InputStreamReader(assetManager.open(fileName));
            BufferedReader bufReader = new BufferedReader(inputReader);
            String line = "";
            String result = "";
            while ((line = bufReader.readLine()) != null)
                result += line;
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 是否存在SD卡
     *
     * @return
     */
    public static boolean hasSDCard() {
        String status = Environment.getExternalStorageState();
        if (!status.equals(Environment.MEDIA_MOUNTED)) {
            return false;
        }
        return true;
    }

    /**
     * 得到根目录
     *
     * @return
     */
    public static String getRootFilePath() {
        if (hasSDCard()) {
            return Environment.getExternalStorageDirectory().getAbsolutePath()
                    + "/";// filePath:/sdcard/
        } else {
            return Environment.getDataDirectory().getAbsolutePath() + "/data/"; // filePath:
            // /data/data/
        }
    }

    /**
     * 得到保存文件路径
     *
     * @return
     */
    public static String getSaveFilePath() {
        String path = getRootFilePath() + BaseApplication.context().getPackageName();
        createDirectory(path);
        path = path + "/database/";
        createDirectory(path);
        return getRootFilePath() + BaseApplication.context().getPackageName() + "/database/";
    }

    /**
     * 创建文件夹
     *
     * @param path
     */
    public static void createDirectory(String path) {
        if (path == null || path.length() < 1) {
            return;
        }

        File f = new File(path);
        if (!f.exists()) {
            f.mkdirs();
        }
    }
}
