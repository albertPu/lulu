package tt.cc.com.ttmvvm.mvvm

import android.app.Activity
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.support.annotation.IdRes
import android.text.TextUtils
import android.view.View
import androidx.navigation.*
import com.google.gson.Gson
import tt.cc.com.ttmvvm.R
import java.lang.Exception
import java.math.RoundingMode
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.text.DecimalFormat

/**
 *created by Albert
 */
val gson = Gson()

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
        e.printStackTrace()
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

fun <T, V> List<T>?.topMap(block: (T) -> V): LinkedHashMap<V, T>? {
    if (this?.size ?: 0 > 0) {
        val map = LinkedHashMap<V, T>()
        this?.forEach {
            map[block(it)] = it
        }
        return map
    }
    return null
}

fun <T, V> List<T>?.topMapValueList(block: (T) -> V): LinkedHashMap<V, ArrayList<T>>? {
    if (this?.size ?: 0 > 0) {
        val map = LinkedHashMap<V, ArrayList<T>>()
        this?.forEach {
            var array: ArrayList<T>? = null
            if (map[block(it)] == null) {
                map[block(it)] = ArrayList()
                array = map[block(it)]
            }
            array?.add(it)
        }
        return map
    }
    return null
}

fun <K, V> Map<K, V>?.containsKeyOb(any: K): V? {
    val or = md5(gson.toJson(any))
    this?.forEach { map ->
        if (md5(gson.toJson(map.key)) == or) {
            return map.value
        }
    }
    return null
}

fun md5(password: String): String {
    try {
        val instance: MessageDigest = MessageDigest.getInstance("MD5")
        val digest: ByteArray = instance.digest(password.toByteArray())
        val sb = StringBuffer()
        for (b in digest) {
            val i: Int = b.toInt() and 0xff
            var hexString = Integer.toHexString(i)
            if (hexString.length < 2) {
                hexString = "0$hexString"
            }
            sb.append(hexString)
        }
        return sb.toString()

    } catch (e: NoSuchAlgorithmException) {
        e.printStackTrace()
    }
    return ""
}


fun ViewModel.showFragment(v: View, @IdRes container: Int, @IdRes target: Int, showAni: Boolean) {
    var options: NavOptions? = null
    if (showAni) {
        options = navOptions {
            anim {
                enter = R.anim.slide_in_right
                exit = R.anim.slide_out_left
                popEnter = R.anim.slide_in_left
                popExit = R.anim.slide_out_right
            }
        }
    }
    Navigation.findNavController(v.context as Activity, container).navigate(target, null, options)
}

fun ViewModel.showFragment(v: View, @IdRes container: Int, @IdRes target: Int) {
    showFragment(v, container, target, false)
}