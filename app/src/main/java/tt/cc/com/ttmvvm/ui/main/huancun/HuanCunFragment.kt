package tt.cc.com.ttmvvm.ui.main.huancun

import android.arch.lifecycle.ViewModelProviders
import tt.cc.com.ttmvvm.R
import tt.cc.com.ttmvvm.databinding.LiveFragmentBinding
import tt.cc.com.ttmvvm.ui.base.BaseFragment

class HuanCunFragment : BaseFragment<LiveFragmentBinding>() {

    override fun getContentView() = R.layout.live_fragment

    override fun initViewModel(binding: LiveFragmentBinding?) {
        binding?.viewModel = ViewModelProviders.of(this).get(HuanCunViewModel::class.java)
        initTitle("缓存中心", 12)
        showBarLine()
    }
}