package tt.cc.com.ttmvvm.mvvm.ui

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import tt.cc.com.ttmvvm.R

/**
 *created by Albert
 */
abstract class BaseMvvmDialogFragment<T : ViewDataBinding> : DialogFragment() {

    lateinit var bind: T
    private var isInitView: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.BobDialog)
    }

    override fun onCreateView(paramLayoutInflater: LayoutInflater, paramViewGroup: ViewGroup?, paramBundle: Bundle?): View? {
        bind = DataBindingUtil.inflate(paramLayoutInflater, contentViewLayoutID(), paramViewGroup, false)
        bind.setLifecycleOwner(this)
        return bind.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel(bind)
        isInitView = true
        EventBus.getDefault().register(this)
    }

    protected abstract fun contentViewLayoutID(): Int

    protected abstract fun initViewModel(bind: T)

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    fun getEvent(event: Any) {

    }


    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }


}