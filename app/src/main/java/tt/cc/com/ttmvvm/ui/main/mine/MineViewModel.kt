package tt.cc.com.ttmvvm.ui.main.mine

import android.arch.lifecycle.LifecycleOwner
import android.view.View
import tt.cc.com.ttmvvm.R
import tt.cc.com.ttmvvm.mvvm.showFragment
import tt.cc.com.ttmvvm.mvvm.ui.BaseViewModel
import java.lang.ref.WeakReference

class MineViewModel(lifecycleOwner: WeakReference<LifecycleOwner>) : BaseViewModel(lifecycleOwner) {

    override fun onClick(v: View) {
        when (v.id) {
            R.id.rl_see_history -> showFragment(v, R.id.container, R.id.see_history, true)
            R.id.rl_collect -> showFragment(v, R.id.container, R.id.collect, true)
            R.id.rl_connect_service -> showFragment(v, R.id.container, R.id.connect, true)
            R.id.rl_about_us -> showFragment(v, R.id.container, R.id.about_us, true)
            R.id.rl_setting -> showFragment(v, R.id.container, R.id.setting, true)
        }
    }

}