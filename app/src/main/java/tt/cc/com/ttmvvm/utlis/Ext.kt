package tt.cc.com.ttmvvm.utlis

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.BindingAdapter
import android.databinding.ObservableField
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.text.TextUtils
import android.widget.TextView
import android.widget.Toast
import tt.cc.com.ttmvvm.TtApplication
import tt.cc.com.ttmvvm.ui.adapter.reclcerview.IMultiItemEntity
import java.lang.Exception
import java.math.RoundingMode
import java.text.DecimalFormat


fun ViewModel.getDrawable(res: Int): Drawable? {
    return TtApplication.context?.resources?.getDrawable(res)
}


fun ViewModel.getColor(res: Int): Int? {
    return TtApplication.context?.resources?.getColor(res)
}


fun IMultiItemEntity.getColor(res: Int): Int? {
    return TtApplication.context?.resources?.getColor(res)
}


fun ViewModel.showToast(msg: String) {
    Toast.makeText(TtApplication.context, msg, Toast.LENGTH_SHORT).show()
}



/**
 *created by Albert
 */

fun MutableLiveData<String>?.toDouble(): Double {
    return try {
        java.lang.Double.parseDouble(this?.value!!.toString())
    } catch (e: Exception) {
        0.00
    }
}

fun String?.toDoubleSF(): Double {
    return try {
        val s = this?.replace(",", "")
        java.lang.Double.parseDouble(s)
    } catch (e: Exception) {
        0.00
    }
}


fun String?.toFloatSF(): Float {
    return try {
        val s = this?.replace(",", "")
        java.lang.Float.parseFloat(s)
    } catch (e: Exception) {
        0.00f
    }
}


fun Double.keepTwo(): String {
    return try {
        val df = DecimalFormat("0.00")
        df.roundingMode = RoundingMode.FLOOR
        df.format(this)
    } catch (e: Exception) {
        String.format("%.2f", this)
    }
}

infix fun String?.eq(param: String?): Boolean {
    return TextUtils.equals(this, param)
}

infix fun Boolean.go(block: () -> Unit) {
    if (this)
        block()
}

infix fun Boolean.and(block: () -> Boolean): Boolean {
    return (this && block())
}

infix fun Boolean.or(block: () -> Boolean): Boolean {
    return (this && block())
}

infix fun String?.uneq(param: String?): Boolean {
    return !TextUtils.equals(this, param)
}

fun String?.subStart(position: Int): String {
    return try {
        return this?.substring(0, position) ?: ""
    } catch (e: Exception) {
        e.printStackTrace()
        this ?: ""
    }
}

fun String?.subEnd(position: Int): String {
    return try {
        return this?.substring(this.length - position, this.length) ?: ""
    } catch (e: Exception) {
        e.printStackTrace()
        this ?: ""
    }
}


infix fun String?.contained(param: List<String>): Boolean {
    return param.contains(this)
}

fun String?.toDouble(): Double {
    return try {
        val s = this?.replace(",", "")
        java.lang.Double.parseDouble(s)
    } catch (e: Exception) {
        e.printStackTrace()
        0.0
    }
}

fun String?.toIntSF(): Int {
    return try {
        val s = this?.replace(",", "")
        java.lang.Double.parseDouble(s).toInt()
    } catch (e: Exception) {
        e.printStackTrace()
        0
    }
}

fun <T> List<T>.getSF(index: Int): T? {
    if (this.size <= index) {
        return null
    }
    return this[index]
}

fun <T> ArrayList<T>.removeAtSF(index: Int) {
    try {
        if (this.size > index) {
            this.removeAt(index)
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}