package tt.cc.com.ttmvvm.ui.main.mine.aboutus

import android.arch.lifecycle.ViewModelProviders
import tt.cc.com.ttmvvm.R
import tt.cc.com.ttmvvm.databinding.FrgmentAboutUsBinding
import tt.cc.com.ttmvvm.databinding.FrgmentConnectBinding
import tt.cc.com.ttmvvm.mvvm.ui.BaseMvvmFragment
import tt.cc.com.ttmvvm.mvvm.ui.ViewModelFactory

/**
 * created by Albert
 */
class AboutUsFragment : BaseMvvmFragment<FrgmentAboutUsBinding>() {
    override fun getContentView() = R.layout.frgment_about_us

    override fun initViewModel(binding: FrgmentAboutUsBinding?) {
        bind?.viewModel = ViewModelProviders.of(this, ViewModelFactory(this)).get(AboutUsViewModel::class.java)
        showBarLine()
        initTitle("关于我们", true)
    }

}
