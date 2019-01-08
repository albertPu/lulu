package tt.cc.com.ttmvvm.ui.main.guochan

import android.arch.lifecycle.ViewModelProviders
import tt.cc.com.ttmvvm.R
import tt.cc.com.ttmvvm.databinding.VipFragmentBinding
import tt.cc.com.ttmvvm.mvvm.ui.BaseMvvmFragment
import tt.cc.com.ttmvvm.mvvm.ui.ViewModelFactory

class GuoChanFragment : BaseMvvmFragment<VipFragmentBinding>() {

    override fun getContentView() = R.layout.vip_fragment

    override fun initViewModel(binding: VipFragmentBinding?) {
        binding?.viewModel = ViewModelProviders.of(activity!!, ViewModelFactory(this)).get(GuoChanViewModel::class.java).also {
            lifecycle.addObserver(it)
        }
        initTitle("国产", 12)
        showBarLine()
    }
}