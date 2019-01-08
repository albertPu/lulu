package tt.cc.com.ttmvvm.ui.main.home

import android.arch.lifecycle.ViewModelProviders
import android.graphics.Color
import kotlinx.android.synthetic.main.dif_fragment.*
import net.lucode.hackware.magicindicator.ViewPagerHelper
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator
import tt.cc.com.ttmvvm.R
import tt.cc.com.ttmvvm.databinding.HomeFragmentBinding
import tt.cc.com.ttmvvm.mvvm.ui.BaseMvvmFragment
import tt.cc.com.ttmvvm.mvvm.ui.ViewModelFactory
import tt.cc.com.ttmvvm.ui.adapter.HomeMagicAdapter

class HomeFragment : BaseMvvmFragment<HomeFragmentBinding>() {


    override fun getContentView() = R.layout.home_fragment

    override fun initViewModel(binding: HomeFragmentBinding?) {
        binding?.viewModel = ViewModelProviders.of(activity!!, ViewModelFactory(this)).get(HomeViewModel::class.java).also {
            lifecycle.addObserver(it)
        }
        iniTableLayout()
    }

    private fun iniTableLayout() {
        magic_indicator.setBackgroundColor(Color.WHITE)
        val commonNavigator = CommonNavigator(activity)
        commonNavigator.adapter = HomeMagicAdapter(bind?.viewModel?.title, home_view_pager)
        magic_indicator.navigator = commonNavigator
        ViewPagerHelper.bind(magic_indicator, home_view_pager)
    }
}