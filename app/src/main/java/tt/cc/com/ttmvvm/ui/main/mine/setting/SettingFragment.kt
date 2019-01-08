package tt.cc.com.ttmvvm.ui.main.mine.setting

import android.arch.lifecycle.ViewModelProviders
import tt.cc.com.ttmvvm.R
import tt.cc.com.ttmvvm.databinding.FrgmentSettingBinding
import tt.cc.com.ttmvvm.mvvm.ui.BaseMvvmFragment
import tt.cc.com.ttmvvm.mvvm.ui.ViewModelFactory
import tt.cc.com.ttmvvm.ui.main.mine.tuiguang.TuiGuangViewModel

/**
 * created by Albert
 */
class SettingFragment : BaseMvvmFragment<FrgmentSettingBinding>() {
    override fun getContentView() = R.layout.frgment_setting

    override fun initViewModel(binding: FrgmentSettingBinding?) {
        bind?.viewModel = ViewModelProviders.of(this, ViewModelFactory(this)).get(SettingViewModel::class.java)
        showBarLine()
        initTitle("设置", true)
    }

}
