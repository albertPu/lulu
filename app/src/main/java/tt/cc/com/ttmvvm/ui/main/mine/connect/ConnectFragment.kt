package tt.cc.com.ttmvvm.ui.main.mine.connect

import android.arch.lifecycle.ViewModelProviders
import tt.cc.com.ttmvvm.R
import tt.cc.com.ttmvvm.databinding.FrgmentConnectBinding
import tt.cc.com.ttmvvm.mvvm.ui.BaseMvvmFragment
import tt.cc.com.ttmvvm.mvvm.ui.ViewModelFactory
import tt.cc.com.ttmvvm.ui.main.mine.aboutus.AboutUsViewModel

/**
 * created by Albert
 */
class ConnectFragment : BaseMvvmFragment<FrgmentConnectBinding>() {
    override fun getContentView() = R.layout.frgment_connect

    override fun initViewModel(binding: FrgmentConnectBinding?) {
        bind?.viewModel = ViewModelProviders.of(this, ViewModelFactory(this)).get(ConnectViewModel::class.java)
        showBarLine()
        initTitle("联系客服", true)
    }

}
