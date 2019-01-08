package tt.cc.com.ttmvvm.ui.main.mine.vip

import android.arch.lifecycle.ViewModelProviders
import tt.cc.com.ttmvvm.R
import tt.cc.com.ttmvvm.databinding.FrgmentVipBinding
import tt.cc.com.ttmvvm.mvvm.ui.BaseMvvmFragment
import tt.cc.com.ttmvvm.mvvm.ui.ViewModelFactory

/**
 * created by Albert
 */
class VipFragment : BaseMvvmFragment<FrgmentVipBinding>() {
    override fun getContentView() = R.layout.frgment_vip

    override fun initViewModel(binding: FrgmentVipBinding?) {
        bind?.viewModel = ViewModelProviders.of(this, ViewModelFactory(this)).get(VipViewModel::class.java)
        showBarLine()
        initTitle("会员中心", true)
    }

}
