package tt.cc.com.ttmvvm.ui.main

import android.arch.lifecycle.ViewModelProviders
import tt.cc.com.ttmvvm.R
import tt.cc.com.ttmvvm.databinding.MainFragmentBinding
import tt.cc.com.ttmvvm.mvvm.ui.ViewModelFactory
import tt.cc.com.ttmvvm.ui.base.BaseFragment

class MainFragment : BaseFragment<MainFragmentBinding>() {


    override fun getContentView() = R.layout.main_fragment

    override fun initViewModel(binding: MainFragmentBinding?) {
        bind?.viewModel = ViewModelProviders.of(activity!!, ViewModelFactory(activity)).get(MainViewModel::class.java).also {
            it.childFragmentManager = childFragmentManager
        }
        bind?.viewModel?.touchHome()
    }

}
