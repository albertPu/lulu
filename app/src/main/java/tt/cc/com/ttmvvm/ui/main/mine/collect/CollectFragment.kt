package tt.cc.com.ttmvvm.ui.main.mine.collect

import android.arch.lifecycle.ViewModelProviders
import tt.cc.com.ttmvvm.R
import tt.cc.com.ttmvvm.databinding.FrgmentCollectBinding
import tt.cc.com.ttmvvm.mvvm.ui.BaseMvvmFragment
import tt.cc.com.ttmvvm.mvvm.ui.ViewModelFactory

/**
 * created by Albert
 */
class CollectFragment : BaseMvvmFragment<FrgmentCollectBinding>() {
    override fun getContentView() = R.layout.frgment_collect

    override fun initViewModel(binding: FrgmentCollectBinding?) {
        bind?.viewModel = ViewModelProviders.of(this, ViewModelFactory(this)).get(CollectViewModel::class.java)
        showBarLine()
        initTitle("我的收藏", true)
    }

}
