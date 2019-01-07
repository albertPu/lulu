package tt.cc.com.ttmvvm.ui.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.View
import android.widget.CompoundButton
import tt.cc.com.ttmvvm.R
import tt.cc.com.ttmvvm.ui.base.BaseFragment
import tt.cc.com.ttmvvm.ui.main.fenlei.FenLeiFragment
import tt.cc.com.ttmvvm.ui.main.home.HomeFragment
import tt.cc.com.ttmvvm.ui.main.huancun.HuanCunFragment
import tt.cc.com.ttmvvm.ui.main.mine.MineFragment
import tt.cc.com.ttmvvm.ui.main.guochan.GuoChanFragment
import tt.cc.com.ttmvvm.utlis.getSF
import java.util.*

class MainViewModel : ViewModel() {

    var childFragmentManager: FragmentManager? = null
    var currentFragment: BaseFragment<*>? = null
    var bindGroupSelect = MutableLiveData<String>().apply { value = "首页" }

    private val fragments = ArrayList<Fragment>().apply {
        add(HomeFragment().apply { currentFragment = this })
        add(GuoChanFragment())
        add(FenLeiFragment())
        add(HuanCunFragment())
        add(MineFragment())
    }


    fun onClick(view: View) {
        when (view.id) {


        }
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
        }
    }

    private fun switchFragment(targetFragment: Fragment?) {
        targetFragment?.let {
            val transaction = childFragmentManager?.beginTransaction()
            if (!targetFragment.isAdded) {
                transaction
                    ?.hide(currentFragment as Fragment)
                    ?.add(R.id.home_container, targetFragment)
                    ?.show(targetFragment)?.commit()
            } else {
                transaction
                    ?.hide(currentFragment as Fragment)
                    ?.show(targetFragment)
                    ?.commit()
            }
            currentFragment = targetFragment as BaseFragment<*>
        }

    }

    fun touchHome() {
        switchFragment(fragments[0])
    }

}