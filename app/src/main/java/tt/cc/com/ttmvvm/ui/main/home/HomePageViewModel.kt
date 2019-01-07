package tt.cc.com.ttmvvm.ui.main.home

import android.annotation.SuppressLint
import android.arch.lifecycle.MutableLiveData
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import tt.cc.com.ttmvvm.R
import tt.cc.com.ttmvvm.model.page.MovieVo
import tt.cc.com.ttmvvm.net.Api
import tt.cc.com.ttmvvm.net.ApiStore
import tt.cc.com.ttmvvm.net.ResponseTransformer
import tt.cc.com.ttmvvm.ui.adapter.reclcerview.ItemLayout
import tt.cc.com.ttmvvm.ui.base.BaseViewModel
import tt.cc.com.ttmvvm.utlis.ResUtils

/**
 *created by Albert
 */
class HomePageViewModel : BaseViewModel() {

    val tag = MutableLiveData<String>()
    val bindMainColor = MutableLiveData<Int>().apply { value = ResUtils.getColor(R.color.colorPrimary) }
    val bindRefresh = MutableLiveData<Boolean>().apply { value = false }
    val bindItem = ArrayList<ItemLayout>().apply { add(ItemLayout(R.layout.item_rec_home, 0)) }
    val bindRecData = MutableLiveData<ArrayList<MovieVo>>()

    val bindLoadingMoreListener = OnLoadMoreListener {
        loadRemoteData()
    }

    val bindRefreshListener = OnRefreshListener {
        loadRemoteData()
    }

    fun onPageSelected(p0: Int) {
        if (bindRecData.value?.size ?: 0 > 0) return
        bindRefresh.value = true
    }

    @SuppressLint("CheckResult")
    fun loadRemoteData() {
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