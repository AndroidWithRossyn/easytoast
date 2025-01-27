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
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

object ToastUtils {
    private var activeToast: Toast? = null

    /**
     * Displays a custom toast message with the specified duration and gravity.
     *
     * @param message The message to be displayed in the toast.
     * @param duration The duration for which the toast should be displayed.
     *                 It can be either [Toast.LENGTH_SHORT] or [Toast.LENGTH_LONG].
     *                 Default value is [Toast.LENGTH_SHORT].
     * @param gravity The gravity for the toast's position.
     *                It can be any of the constants defined in [Gravity].
     *                Default value is [Gravity.BOTTOM].
     *
     */
    private fun Context.displayToast(
        message: String, duration: Int = Toast.LENGTH_SHORT, gravity: Int = Gravity.BOTTOM
    ) {
        cancelActiveToast()
        activeToast = Toast.makeText(this, message, duration).apply {
            setGravity(gravity, 0, 0)
            show()
        }
    }


    /**
     * Cancels the currently displayed toast, if any.
     *
     * This function checks if there is an active toast and, if so, cancels it by calling its [Toast.cancel] method.
     * After cancelling the active toast, it sets the [activeToast] variable to null to indicate that there is no active toast.
     *
     */
    fun cancelActiveToast() {
        activeToast?.cancel()
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

