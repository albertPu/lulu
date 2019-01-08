package tt.cc.com.ttmvvm.ui.main.huancun

import android.arch.lifecycle.ViewModelProviders
import tt.cc.com.ttmvvm.R
import tt.cc.com.ttmvvm.databinding.HuanCunFragmentBinding
import tt.cc.com.ttmvvm.mvvm.ui.BaseMvvmFragment

/**
 *created by Albert
 */
class HuanCunFragment:BaseMvvmFragment<HuanCunFragmentBinding>() {
    override fun getContentView() = R.layout.huan_cun_fragment

    override fun initViewModel(binding: HuanCunFragmentBinding?) {
        binding?.viewModel = ViewModelProviders.of(this).get(HuanCunViewModel::class.java)
        initTitle("缓存中心", 12)
        showBarLine()
    }
}