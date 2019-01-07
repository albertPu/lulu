package tt.cc.com.ttmvvm.ui.main.guochan

import android.annotation.SuppressLint
import android.arch.lifecycle.*
import android.support.v7.widget.GridLayoutManager
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import tt.cc.com.ttmvvm.R
import tt.cc.com.ttmvvm.TtApplication
import tt.cc.com.ttmvvm.model.page.MovieVo
import tt.cc.com.ttmvvm.net.Api
import tt.cc.com.ttmvvm.net.ApiStore
import tt.cc.com.ttmvvm.net.ResponseTransformer
import tt.cc.com.ttmvvm.ui.adapter.reclcerview.ItemLayout
import tt.cc.com.ttmvvm.ui.base.BaseViewModel
import tt.cc.com.ttmvvm.utlis.ResUtils

class GuoChanViewModel : BaseViewModel(), LifecycleObserver {

    val bindItem = ArrayList<ItemLayout>().apply { add(ItemLayout(R.layout.item_rec_guo_chan, 0)) }
    val bindRecData = MutableLiveData<ArrayList<MovieVo>>()
    val bindMainColor = MutableLiveData<Int>().apply { value = ResUtils.getColor(R.color.colorPrimary) }
    val bindRefresh = MutableLiveData<Boolean>().apply { value = false }

    val bindLoadingMoreListener = OnLoadMoreListener {
        loadRemoteData()
    }

    val bindRefreshListener = OnRefreshListener {
        loadRemoteData()
    }


    var layoutManager = GridLayoutManager(TtApplication.context, 3).apply {
        spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(p0: Int): Int {
                return 1
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        bindRefresh.value = true
    }

    @SuppressLint("CheckResult")
    private fun loadRemoteData() {
        ApiStore.create(Api::class.java)
            .getMovies(1)
            .compose(ResponseTransformer.handleResult())
            .subscribe({
                bindRecData.value = it
                bindRefresh.value = false
            }, {
                bindRefresh.value = false
            })
    }
}