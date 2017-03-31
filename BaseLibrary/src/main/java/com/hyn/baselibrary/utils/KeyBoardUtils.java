package com.hyn.baselibrary.utils;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/**
 * author： hyn
 * e-mail: hyn_0525@sina.com
 * Date : 2017/3/31
 * Time: 15:51
 */

public class KeyBoardUtils {

    /**
     * 打开软键盘
     * @param mEditText    控件
     * @param mContext     界面上下文
     */
    public static void openKeyboard(EditText mEditText, Context mContext)
    {
        InputMethodManager imm = (InputMethodManager) mContext
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(mEditText, InputMethodManager.RESULT_SHOWN);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,
                InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    /**
     * 关闭软键盘
     * @param mEditText     调用软键盘的控件
     * @param mContext      上下文对象
     */
    public static void closeKeyboard(EditText mEditText, Context mContext)
    {
        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);

        imm.hideSoftInputFromWindow(mEditText.getWindowToken(), 0);
    }

}
