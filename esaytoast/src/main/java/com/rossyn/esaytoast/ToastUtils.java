/**
 * Copyright (c) 2024. Rossyn
 * <p>
 * All rights reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * <a href="http://www.apache.org/licenses/LICENSE-2.0">http://www.apache.org/licenses/LICENSE-2.0</a>
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.rossyn.esaytoast;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

import androidx.annotation.StringRes;


public class ToastUtils {

    private static Toast activeToast = null;

    /**
     * Cancels the currently active toast, if any.
     * <p>
     * This method checks if there is an active toast displayed. If so, it cancels the toast and sets the
     * {@link #activeToast} reference to null. This ensures that only one toast is displayed at a time.
     */
    private static void cancelActiveToast() {
        if (activeToast != null) {
            activeToast.cancel();
            activeToast = null;
        }
    }

    /**
     * Displays a custom toast with the given message, duration, and gravity.
     *
     * @param context  The context in which the toast will be displayed.
     * @param message  The message to be displayed in the toast.
     * @param duration The duration for which the toast will be displayed.
     *                 It can be either {@link Toast#LENGTH_SHORT} or {@link Toast#LENGTH_LONG}.
     * @param gravity  The gravity of the toast.
     *                 It can be one of the following: {@link Gravity#TOP}, {@link Gravity#BOTTOM},
     *                 {@link Gravity#CENTER}, {@link Gravity#LEFT}, {@link Gravity#RIGHT},
     *                 or any combination of these using the bitwise OR operator.
     */
    private static void displayToast(Context context, String message, int duration, int gravity) {
        cancelActiveToast();
        activeToast = Toast.makeText(context, message, duration);
        activeToast.setGravity(gravity, 0, 0);
        activeToast.show();
    }

    public static void showToast(Context context, String message, int duration, int gravity) {
        displayToast(context, message, duration, gravity);
    }

    public static void showToast(Context context, @StringRes int messageRes, int duration, int gravity) {
        String message = context.getString(messageRes);
        showToast(context, message, duration, gravity);
    }

    public static void showToast(Context context, String message) {
        showToast(context, message, Toast.LENGTH_SHORT, Gravity.BOTTOM);
    }

    public static void showToast(Context context, @StringRes int messageRes) {
        showToast(context, messageRes, Toast.LENGTH_SHORT, Gravity.BOTTOM);
    }

    public static void showToastLong(Context context, String message) {
        showToast(context, message, Toast.LENGTH_LONG, Gravity.BOTTOM);
    }

    public static void showToastLong(Context context, @StringRes int messageRes) {
        showToast(context, messageRes, Toast.LENGTH_LONG, Gravity.BOTTOM);
    }

    public static void showToastTop(Context context, String message) {
        showToast(context, message, Toast.LENGTH_SHORT, Gravity.TOP);
    }

    public static void showToastTop(Context context, @StringRes int messageRes) {
        showToast(context, messageRes, Toast.LENGTH_SHORT, Gravity.TOP);
    }

    public static void showToastTopLong(Context context, String message) {
        showToast(context, message, Toast.LENGTH_LONG, Gravity.TOP);
    }

    public static void showToastTopLong(Context context, @StringRes int messageRes) {
        showToast(context, messageRes, Toast.LENGTH_LONG, Gravity.TOP);
    }

    public static void showToastCenter(Context context, String message) {
        showToast(context, message, Toast.LENGTH_SHORT, Gravity.CENTER);
    }

    public static void showToastCenter(Context context, @StringRes int messageRes) {
        showToast(context, messageRes, Toast.LENGTH_SHORT, Gravity.CENTER);
    }

    public static void showToastCenterLong(Context context, String message) {
        showToast(context, message, Toast.LENGTH_LONG, Gravity.CENTER);
    }

    public static void showToastCenterLong(Context context, @StringRes int messageRes) {
        showToast(context, messageRes, Toast.LENGTH_LONG, Gravity.CENTER);
    }

}
