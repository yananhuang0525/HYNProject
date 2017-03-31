package com.hyn.baselibrary.utils;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * author： hyn
 * e-mail: hyn_0525@sina.com
 * Date : 2017/3/31
 * Time: 15:55
 */

public class JsonMapUtil {
    /**
     * map转成json字符串
     *
     * @param map
     * @return
     */
    public static String simpleMapToJsonStr(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return "null";
        }
        String jsonStr = "{";
        Set<?> keySet = map.keySet();
        for (Object key : keySet) {
            jsonStr += "\"" + key + "\":\"" + map.get(key) + "\",";
        }
        jsonStr = jsonStr.substring(0, jsonStr.length() - 1);
        jsonStr += "}";
        return jsonStr;
    }

    /**
     * Json 转成 Map<>
     *
     * @param jsonStr
     * @return
     */
    public static Map<String, String> getMapForJson(String jsonStr) {
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(jsonStr);

            Iterator<String> keyIter = jsonObject.keys();
            String key;
            String value;
            Map<String, String> valueMap = new HashMap<String, String>();
            while (keyIter.hasNext()) {
                key = keyIter.next();
                value = jsonObject.get(key).toString();
                valueMap.put(key, value);
            }
            return valueMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
