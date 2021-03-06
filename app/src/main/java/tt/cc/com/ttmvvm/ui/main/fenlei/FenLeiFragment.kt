package tt.cc.com.ttmvvm.ui.main.fenlei

import android.arch.lifecycle.ViewModelProviders
import android.graphics.Color
import kotlinx.android.synthetic.main.dif_fragment.*
import net.lucode.hackware.magicindicator.ViewPagerHelper
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator
import tt.cc.com.ttmvvm.R
import tt.cc.com.ttmvvm.databinding.DifFragmentBinding
import tt.cc.com.ttmvvm.mvvm.ui.BaseMvvmFragment
import tt.cc.com.ttmvvm.mvvm.ui.ViewModelFactory
import tt.cc.com.ttmvvm.ui.adapter.HomeMagicAdapter

class FenLeiFragment : BaseMvvmFragment<DifFragmentBinding>() {


    override fun getContentView() = R.layout.dif_fragment

    override fun initViewModel(binding: DifFragmentBinding?) {
        binding?.viewModel = ViewModelProviders.of(activity!!, ViewModelFactory(this)).get(FenLeiViewModel::class.java)
        binding?.setLifecycleOwner(this)
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