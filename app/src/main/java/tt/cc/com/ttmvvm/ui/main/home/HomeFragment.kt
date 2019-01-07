package tt.cc.com.ttmvvm.ui.main.home

import android.arch.lifecycle.ViewModelProviders
import android.graphics.Color
import com.scwang.smartrefresh.header.MaterialHeader
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.android.synthetic.main.view_page_home_one.*
import net.lucode.hackware.magicindicator.ViewPagerHelper
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator
import tt.cc.com.ttmvvm.R
import tt.cc.com.ttmvvm.databinding.HomeFragmentBinding
import tt.cc.com.ttmvvm.ui.adapter.HomeMagicAdapter
import tt.cc.com.ttmvvm.ui.base.BaseFragment
import tt.cc.com.ttmvvm.utlis.ResUtils
import java.lang.ref.WeakReference

class HomeFragment : BaseFragment<HomeFragmentBinding>() {


    override fun getContentView() = R.layout.home_fragment

    override fun initViewModel(binding: HomeFragmentBinding?) {
        binding?.viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java).also {
            it.lifecycleOwner = WeakReference(this)
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