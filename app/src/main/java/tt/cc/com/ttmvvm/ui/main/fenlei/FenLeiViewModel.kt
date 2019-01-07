package tt.cc.com.ttmvvm.ui.main.fenlei

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.OnLifecycleEvent
import tt.cc.com.ttmvvm.R
import tt.cc.com.ttmvvm.ui.adapter.viewpage.PageBind
import tt.cc.com.ttmvvm.ui.base.BaseViewModel

class FenLeiViewModel : BaseViewModel(), LifecycleObserver {

    var title = ArrayList<String>().apply {
        add("爱情")
        add("喜剧")
        add("动作")
    }

    var bindPageItems = MutableLiveData<ArrayList<PageBind>>()


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        bindPageItems.value = ArrayList<PageBind>().apply {
            add(PageBind(R.layout.view_page_fen_lei, FeiLeiPageViewModel().apply {
                lifecycleOwner = this@FenLeiViewModel.lifecycleOwner
                tag = title[0]
            }))
            add(PageBind(R.layout.view_page_fen_lei, FeiLeiPageViewModel().apply {
                lifecycleOwner = this@FenLeiViewModel.lifecycleOwner
                tag = title[1]
            }))
            add(PageBind(R.layout.view_page_fen_lei, FeiLeiPageViewModel().apply {
                lifecycleOwner = this@FenLeiViewModel.lifecycleOwner
                tag = title[2]
            }))
        }

    }
}