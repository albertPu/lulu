package tt.cc.com.ttmvvm.mvvm.ui

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.SupportActivity
import android.view.View
import java.lang.ref.WeakReference

/**
 *created by Albert
 */
open class BaseViewModel(var lifecycleOwner: WeakReference<LifecycleOwner>) : ViewModel() {

    var fragment: WeakReference<BaseMvvmFragment<*>>? = if (lifecycleOwner.get() is BaseMvvmFragment<*>) WeakReference(lifecycleOwner.get() as BaseMvvmFragment<*>) else null
    var activity: WeakReference<FragmentActivity>? = if (lifecycleOwner.get() is SupportActivity) WeakReference(lifecycleOwner.get() as FragmentActivity) else null
    val action = MutableLiveData<Action>()

    open fun onClick(v: View) {

    }

    override fun onCleared() {
        super.onCleared()
        fragment = null
        activity = null
    }

    fun <T : BaseViewModel> initViewModel(lifecycleOwner: LifecycleOwner?, clazz: Class<T>): T {
        return when (lifecycleOwner) {
            is FragmentActivity -> ViewModelProviders.of(lifecycleOwner, ViewModelFactory(lifecycleOwner)).get(clazz)
            is Fragment -> ViewModelProviders.of(lifecycleOwner, ViewModelFactory(lifecycleOwner)).get(clazz)
            else -> clazz.newInstance()
        }
    }
}