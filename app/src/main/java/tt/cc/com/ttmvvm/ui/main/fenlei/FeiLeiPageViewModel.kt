package tt.cc.com.ttmvvm.ui.main.fenlei

import android.arch.lifecycle.LifecycleOwner
import tt.cc.com.ttmvvm.mvvm.ui.BaseViewModel
import java.lang.ref.WeakReference

/**
 *created by Albert
 */
class FeiLeiPageViewModel(lifecycleOwner: WeakReference<LifecycleOwner>) : BaseViewModel(lifecycleOwner) {
    var tag: String = ""
}