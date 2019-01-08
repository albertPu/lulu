package tt.cc.com.ttmvvm.ui.main.mine.seehistory

import android.arch.lifecycle.ViewModelProviders
import tt.cc.com.ttmvvm.R
import tt.cc.com.ttmvvm.databinding.FrgmentSeeHistoryBinding
import tt.cc.com.ttmvvm.mvvm.ui.BaseMvvmFragment
import tt.cc.com.ttmvvm.mvvm.ui.ViewModelFactory
import tt.cc.com.ttmvvm.ui.main.mine.setting.SettingViewModel

/**
 * created by Albert
 */
class SeeHistoryFragment : BaseMvvmFragment<FrgmentSeeHistoryBinding>() {
    override fun getContentView() = R.layout.frgment_see_history

    override fun initViewModel(binding: FrgmentSeeHistoryBinding?) {
        bind?.viewModel = ViewModelProviders.of(this, ViewModelFactory(this)).get(SeeHistoryViewModel::class.java)
        showBarLine()
        initTitle("观看历史", true)
    }

}
