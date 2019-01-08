package tt.cc.com.ttmvvm.mvvm.ui

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.DrawableRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import tt.cc.com.ttmvvm.R
import tt.cc.com.ttmvvm.ui.widgt.CustomToolbar
import tt.cc.com.ttmvvm.utlis.ResUtils

abstract class BaseMvvmFragment<T : ViewDataBinding> : Fragment() {

    var bind: T? = null
    var customToolbar: CustomToolbar? = null
    var rootView: View? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        bind = DataBindingUtil.inflate(inflater, getContentView(), container, false)
        customToolbar = bind?.root?.findViewById(R.id.custom_toolbar_root)
        rootView = bind?.root
        return bind?.root ?: View(context)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        bind?.setLifecycleOwner(this)
        initViewModel(bind)
        EventBus.getDefault().register(this)

    }

    fun initTitle(title: String) {
        customToolbar?.setMainTitle(title)
    }

    fun initTitle(title: String, isBack: Boolean) {
        customToolbar?.setMainTitle(title)
        if (isBack) {
            customToolbar?.iv_title_left?.let {
                it.visibility = View.VISIBLE
                it.setOnClickListener {
                    Navigation.findNavController(activity!!, R.id.container).popBackStack()
                }
            }
        }
    }

    fun initTitle(title: String, textSize: Int) {
        customToolbar?.setMainTitle(title)
    }

    fun showBarLine() {
        customToolbar?.showBarLine()
    }

    fun setRightDrawable(@DrawableRes drawableRes: Int) {
        customToolbar?.setRightIconDrawable(ResUtils.getDrawable(drawableRes))
    }

    open fun initViewModel(binding: T?) {

    }


    abstract fun getContentView(): Int

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    open fun onEvent(any: Any) {

    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

    open fun onBackPressed() {

    }
}