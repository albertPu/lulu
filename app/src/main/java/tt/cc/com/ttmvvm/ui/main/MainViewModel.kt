package tt.cc.com.ttmvvm.ui.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.View
import android.widget.CompoundButton
import tt.cc.com.ttmvvm.R
import tt.cc.com.ttmvvm.mvvm.getSF
import tt.cc.com.ttmvvm.ui.base.BaseFragment
import tt.cc.com.ttmvvm.ui.main.fenlei.FenLeiFragment
import tt.cc.com.ttmvvm.ui.main.home.HomeFragment
import tt.cc.com.ttmvvm.ui.main.huancun.HuanCunFragment
import tt.cc.com.ttmvvm.ui.main.mine.MineFragment
import tt.cc.com.ttmvvm.ui.main.guochan.GuoChanFragment
import java.util.*

class MainViewModel : ViewModel() {

    var bindGroupSelect = MutableLiveData<String>()

    var childFragmentManager: FragmentManager? = null
    private var currentFragment: Fragment? = null

    init {
        bindGroupSelect.value = "首页"
    }

    private val fragments = ArrayList<Fragment>().apply {
        add(HomeFragment())
        add(GuoChanFragment())
        add(FenLeiFragment())
        add(HuanCunFragment())
        add(MineFragment())
    }


    fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
        if (isChecked) {
            when (buttonView.id) {
                R.id.rtn_home -> switchFragment(fragments.getSF(0))
                R.id.rtn_guo_chan -> switchFragment(fragments.getSF(1))
                R.id.rtn_fen_lei -> switchFragment(fragments.getSF(2))
                R.id.rtn_huan_cun -> switchFragment(fragments.getSF(3))
                R.id.rtn_me -> switchFragment(fragments.getSF(4))
            }
            bindGroupSelect.value = buttonView.text.toString()
        }
    }

    private fun switchFragment(targetFragment: Fragment?) {
        var mTargetFragment: Fragment? = targetFragment
        if (mTargetFragment == null) {
            mTargetFragment = fragments.getSF(0)
        }
        if (currentFragment == mTargetFragment) return
        mTargetFragment?.let {
            val transaction = childFragmentManager?.beginTransaction()
            if (!mTargetFragment.isAdded) {
                if (currentFragment != null) {
                    transaction?.hide(currentFragment as Fragment)
                        ?.add(R.id.home_container, mTargetFragment)
                        ?.show(mTargetFragment)?.commit()
                } else {
                    transaction?.add(R.id.home_container, mTargetFragment)
                        ?.show(mTargetFragment)?.commit()
                }
            } else {
                transaction
                    ?.hide(currentFragment as Fragment)
                    ?.show(mTargetFragment)
                    ?.commit()
            }
            currentFragment = mTargetFragment as BaseFragment<*>
        }

    }

    fun touchHome() {
        switchFragment(currentFragment)
    }

}