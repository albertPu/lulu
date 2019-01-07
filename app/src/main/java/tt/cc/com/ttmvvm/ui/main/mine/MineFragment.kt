package tt.cc.com.ttmvvm.ui.main.mine

import android.arch.lifecycle.ViewModelProviders
import tt.cc.com.ttmvvm.R
import tt.cc.com.ttmvvm.databinding.MineFragmentBinding
import tt.cc.com.ttmvvm.ui.base.BaseFragment
import java.lang.ref.WeakReference

class MineFragment : BaseFragment<MineFragmentBinding>() {

    override fun getContentView() = R.layout.mine_fragment

    override fun initViewModel(binding: MineFragmentBinding?) {
        binding?.viewModel = ViewModelProviders.of(this).get(MineViewModel::class.java)
        binding?.viewModel?.lifecycleOwner = WeakReference(this)
        initTitle("个人中心")
        showBarLine()
        setRightDrawable(R.mipmap.message)
    }
}