package tt.cc.com.ttmvvm.ui.main.fenlei

import android.arch.lifecycle.*
import tt.cc.com.ttmvvm.R
import tt.cc.com.ttmvvm.mvvm.adapter.viewpage.PageBind
import tt.cc.com.ttmvvm.mvvm.ui.BaseViewModel
import java.lang.ref.WeakReference

class FenLeiViewModel(lifecycleOwner: WeakReference<LifecycleOwner>) : BaseViewModel(lifecycleOwner), LifecycleObserver {

    var title = ArrayList<String>().apply {
        add("爱情")
        add("喜剧")
        add("动作")
    }

    var bindPageItems = MutableLiveData<ArrayList<PageBind>>()

    init {
        bindPageItems.value = ArrayList<PageBind>().apply {
            add(PageBind(R.layout.view_page_fen_lei, initViewModel(lifecycleOwner.get(), FeiLeiPageViewModel::class.java).apply {
                tag = title[0]
            }))
            add(PageBind(R.layout.view_page_fen_lei, initViewModel(lifecycleOwner.get(), FeiLeiPageViewModel::class.java).apply {
                tag = title[1]
            }))
            add(PageBind(R.layout.view_page_fen_lei, initViewModel(lifecycleOwner.get(), FeiLeiPageViewModel::class.java).apply {
                tag = title[2]
            }))
        }
    }

}