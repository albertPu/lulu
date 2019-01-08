package tt.cc.com.ttmvvm.ui.main.mine.tuiguang

import android.arch.lifecycle.ViewModelProviders
import tt.cc.com.ttmvvm.R
import tt.cc.com.ttmvvm.databinding.FrgmentTuiGuangBinding
import tt.cc.com.ttmvvm.databinding.FrgmentVipBinding
import tt.cc.com.ttmvvm.mvvm.ui.BaseMvvmFragment
import tt.cc.com.ttmvvm.mvvm.ui.ViewModelFactory

/**
 * created by Albert
 */
class TuiGuangFragment : BaseMvvmFragment<FrgmentTuiGuangBinding>() {
    override fun getContentView() = R.layout.frgment_tui_guang

    override fun initViewModel(binding: FrgmentTuiGuangBinding?) {
        bind?.viewModel = ViewModelProviders.of(this, ViewModelFactory(this)).get(TuiGuangViewModel::class.java)
        showBarLine()
        initTitle("邀请好友免费领VIP", true)
    }

}
