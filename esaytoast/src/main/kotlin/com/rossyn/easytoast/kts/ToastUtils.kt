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

package com.rossyn.easytoast.kts

import android.app.Dialog
import android.content.Context
import android.os.Build
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import java.lang.ref.WeakReference

/**
 * Utility object for showing customizable Toast messages.
 * Note: `setGravity()` is deprecated on Android 11+ (API 30).
 */
object ToastUtils {

    private var activeToast: WeakReference<Toast>? = null

    /**
     * Displays a Toast message with customizable options.
     *
     * @param message The message to display in the Toast.
     * @param duration The duration for which the Toast should be displayed. Default is Toast.LENGTH_SHORT.
     * @param gravity The gravity for the Toast position. Default is Gravity.BOTTOM.
     * @param xOffset The X offset for the Toast position. Default is 0.
     * @param yOffset The Y offset for the Toast position. Default is 0.
     */
    private fun Context.displayToast(
        message: String,
        duration: Int = Toast.LENGTH_SHORT,
        gravity: Int = Gravity.BOTTOM,
        xOffset: Int = 0,
        yOffset: Int = 0
    ) {
        cancelActiveToast()
        val toast = Toast.makeText(this, message, duration).apply {
            /* Changes in Android 11 (API 30) and newer versions:
              The ability to customize the position of Toast has been restricted from Android 11.
              setGravity() method no longer works
              Toast will now appear only at the bottom
              */
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
                setGravity(gravity, xOffset, yOffset)
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                addCallback(object : Toast.Callback() {
                    override fun onToastHidden() {
                        super.onToastHidden()
                        activeToast = null
                    }
                })
            }
            show()
        }
        activeToast = WeakReference(toast)
    }

    /**
     * Cancels the currently active Toast, if any.
     */
    fun cancelActiveToast() {
        activeToast?.get()?.cancel()
        activeToast = null
    }


    fun Context.showToast(
        message: String, duration: Int = Toast.LENGTH_SHORT, gravity: Int = Gravity.BOTTOM
    ) = displayToast(message, duration, gravity)


    fun Context.showToast(
        @StringRes messageRes: Int,
        duration: Int = Toast.LENGTH_SHORT,
        gravity: Int = Gravity.BOTTOM
    ) = showToast(getString(messageRes), duration, gravity)


    fun Context.showToastLong(message: String) = showToast(message, Toast.LENGTH_LONG)


    fun Context.showToastLong(@StringRes messageRes: Int) =
        showToast(getString(messageRes), Toast.LENGTH_LONG)


    fun Context.showToastTop(message: String) = showToast(message, Toast.LENGTH_SHORT, Gravity.TOP)


    fun Context.showToastTop(@StringRes messageRes: Int) =
        showToast(getString(messageRes), Toast.LENGTH_SHORT, Gravity.TOP)


    fun Context.showToastTopLong(message: String) =
        showToast(message, Toast.LENGTH_LONG, Gravity.TOP)


    fun Context.showToastTopLong(@StringRes messageRes: Int) =
        showToast(getString(messageRes), Toast.LENGTH_LONG, Gravity.TOP)


    fun Context.showToastCenter(message: String) =
        showToast(message, Toast.LENGTH_SHORT, Gravity.CENTER)


    fun Context.showToastCenter(@StringRes messageRes: Int) =
        showToast(getString(messageRes), Toast.LENGTH_SHORT, Gravity.CENTER)


    fun Context.showToastCenterLong(message: String) =
        showToast(message, Toast.LENGTH_LONG, Gravity.CENTER)


    fun Context.showToastCenterLong(@StringRes messageRes: Int) =
        showToast(getString(messageRes), Toast.LENGTH_LONG, Gravity.CENTER)


    fun Fragment.showToast(
        message: String, duration: Int = Toast.LENGTH_SHORT, gravity: Int = Gravity.BOTTOM
    ) = requireContext().showToast(message, duration, gravity)


    fun Fragment.showToast(
        @StringRes messageRes: Int,
        duration: Int = Toast.LENGTH_SHORT,
        gravity: Int = Gravity.BOTTOM
    ) = requireContext().showToast(messageRes, duration, gravity)


    fun Fragment.showToastLong(message: String) = requireContext().showToastLong(message)


    fun Fragment.showToastLong(@StringRes messageRes: Int) =
        requireContext().showToastLong(messageRes)


    fun Fragment.showToastTop(message: String) = requireContext().showToastTop(message)


    fun Fragment.showToastTop(@StringRes messageRes: Int) =
        requireContext().showToastTop(messageRes)


    fun Fragment.showToastTopLong(message: String) = requireContext().showToastTopLong(message)


    fun Fragment.showToastTopLong(@StringRes messageRes: Int) =
        requireContext().showToastTopLong(messageRes)


    fun Fragment.showToastCenter(message: String) = requireContext().showToastCenter(message)


    fun Fragment.showToastCenter(@StringRes messageRes: Int) =
        requireContext().showToastCenter(messageRes)


    fun Fragment.showToastCenterLong(message: String) =
        requireContext().showToastCenterLong(message)


    fun Fragment.showToastCenterLong(@StringRes messageRes: Int) =
        requireContext().showToastCenterLong(messageRes)


    fun Dialog.showToast(
        message: String, duration: Int = Toast.LENGTH_SHORT, gravity: Int = Gravity.BOTTOM
    ) = context.showToast(message, duration, gravity)


    fun Dialog.showToast(
        @StringRes messageRes: Int,
        duration: Int = Toast.LENGTH_SHORT,
        gravity: Int = Gravity.BOTTOM
    ) = context.showToast(messageRes, duration, gravity)


    fun Dialog.showToastLong(message: String) = context.showToastLong(message)


    fun Dialog.showToastLong(@StringRes messageRes: Int) = context.showToastLong(messageRes)


    fun Dialog.showToastTop(message: String) = context.showToastTop(message)


    fun Dialog.showToastTop(@StringRes messageRes: Int) = context.showToastTop(messageRes)


    fun Dialog.showToastTopLong(message: String) = context.showToastTopLong(message)


    fun Dialog.showToastTopLong(@StringRes messageRes: Int) = context.showToastTopLong(messageRes)


    fun Dialog.showToastCenter(message: String) = context.showToastCenter(message)


    fun Dialog.showToastCenter(@StringRes messageRes: Int) = context.showToastCenter(messageRes)


    fun Dialog.showToastCenterLong(message: String) = context.showToastCenterLong(message)


    fun Dialog.showToastCenterLong(@StringRes messageRes: Int) =
        context.showToastCenterLong(messageRes)


    fun View.showToast(
        message: String, duration: Int = Toast.LENGTH_SHORT, gravity: Int = Gravity.BOTTOM
    ) = context.showToast(message, duration, gravity)


    fun View.showToast(
        @StringRes messageRes: Int,
        duration: Int = Toast.LENGTH_SHORT,
        gravity: Int = Gravity.BOTTOM
    ) = context.showToast(messageRes, duration, gravity)


    fun View.showToastLong(message: String) = context.showToastLong(message)


    fun View.showToastLong(@StringRes messageRes: Int) = context.showToastLong(messageRes)


    fun View.showToastTop(message: String) = context.showToastTop(message)


    fun View.showToastTop(@StringRes messageRes: Int) = context.showToastTop(messageRes)


    fun View.showToastTopLong(message: String) = context.showToastTopLong(message)


    fun View.showToastTopLong(@StringRes messageRes: Int) = context.showToastTopLong(messageRes)


    fun View.showToastCenter(message: String) = context.showToastCenter(message)


    fun View.showToastCenter(@StringRes messageRes: Int) = context.showToastCenter(messageRes)


    fun View.showToastCenterLong(message: String) = context.showToastCenterLong(message)


    fun View.showToastCenterLong(@StringRes messageRes: Int) =
        context.showToastCenterLong(messageRes)
}