package tt.cc.com.ttmvvm.ui.main.mine

import android.arch.lifecycle.ViewModelProviders
import tt.cc.com.ttmvvm.R
import tt.cc.com.ttmvvm.databinding.MineFragmentBinding
import tt.cc.com.ttmvvm.mvvm.ui.BaseMvvmFragment
import tt.cc.com.ttmvvm.mvvm.ui.ViewModelFactory
import java.lang.ref.WeakReference

class MineFragment : BaseMvvmFragment<MineFragmentBinding>() {

    override fun getContentView() = R.layout.mine_fragment

    override fun initViewModel(binding: MineFragmentBinding?) {
        binding?.viewModel = ViewModelProviders.of(activity!!, ViewModelFactory(this)).get(MineViewModel::class.java)
        binding?.viewModel?.lifecycleOwner = WeakReference(this)
        initTitle("个人中心")
        showBarLine()
        setRightDrawable(R.mipmap.message)
    }
}