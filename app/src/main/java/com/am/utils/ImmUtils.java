package com.am.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

public class ImmUtils {

	/**
	 * 关闭输入法
	 * 
	 * @param context
	 */
	public static void closeImm(Activity activity) {
		if (activity == null) {
			return;
		}
		closeImm(activity, activity.getCurrentFocus());
	}

	/**
	 * 关闭输入法
	 * 
	 * @param context
	 * @param focus
	 */
	public static void closeImm(Context context, View focus) {
		if (null == context) {
			return;
		}
		if (focus != null) {
			InputMethodManager imm = ((InputMethodManager) (context
					.getSystemService(Context.INPUT_METHOD_SERVICE)));
			imm.hideSoftInputFromWindow(focus.getWindowToken(),
					InputMethodManager.HIDE_NOT_ALWAYS);
		}
	}

	/**
	 * 打开输入法
	 * 
	 * @param context
	 * @param view
	 */
	public static void showImm(Context context, View view) {
		if (null == context) {
			return;
		}
		if (view != null) {
			InputMethodManager imm = ((InputMethodManager) (context
					.getSystemService(Context.INPUT_METHOD_SERVICE)));
			imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
		}
	}

	/**
	 * 是否已开启输入法
	 * 
	 * @param context
	 * @return
	 */
	public static boolean isShowImm(Activity context) {
		if (null == context) {
			return false;
		}
		return context.getWindow().getAttributes().softInputMode == WindowManager.LayoutParams.SOFT_INPUT_STATE_UNSPECIFIED;
	}
}
