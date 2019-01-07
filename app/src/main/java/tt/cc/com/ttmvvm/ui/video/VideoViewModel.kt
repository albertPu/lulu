package tt.cc.com.ttmvvm.ui.video

import android.annotation.SuppressLint
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.MutableLiveData
import android.support.v7.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import tt.cc.com.ttmvvm.R
import tt.cc.com.ttmvvm.TtApplication
import tt.cc.com.ttmvvm.model.page.DetailVo
import tt.cc.com.ttmvvm.net.Api
import tt.cc.com.ttmvvm.net.ApiStore
import tt.cc.com.ttmvvm.net.ResponseTransformer
import tt.cc.com.ttmvvm.ui.adapter.reclcerview.IMultiItemEntity
import tt.cc.com.ttmvvm.ui.adapter.reclcerview.ItemLayout
import tt.cc.com.ttmvvm.ui.base.BaseViewModel

/**
 *created by Albert
 */
class VideoViewModel : BaseViewModel(), LifecycleObserver {

    var imgUrl = MutableLiveData<String>()

    var movieData = ArrayList<IMultiItemEntity>()

    var movieVos = MutableLiveData<ArrayList<IMultiItemEntity>>().apply { value = movieData }

    var items = ArrayList<ItemLayout>().apply {
        add(ItemLayout(R.layout.item_video_detail_info, 0))
        add(ItemLayout(R.layout.item_two_rec, 1))
        add(ItemLayout(R.layout.item_video_small_card, 2))
        add(ItemLayout(R.layout.item_three_rc, 3))
        add(ItemLayout(R.layout.item_discuss, 4))
    }

    var layoutManager = LinearLayoutManager(TtApplication.context)
    var itemClickListener =
        BaseQuickAdapter.OnItemClickListener { _, _, data ->

        }

    @SuppressLint("CheckResult")
    fun load(id: String) {
        ApiStore.create(Api::class.java).getMoviesMore(1, id)
            .compose(ResponseTransformer.handleResult()).subscribe({
                val data = ArrayList<IMultiItemEntity>().apply {
                    addAll(it.videoList)
                }
                val discuss = ArrayList<IMultiItemEntity>().apply { addAll(it.discussList) }
                movieData.clear()
                movieData.addAll(data)
                movieData.addAll(discuss)
                movieVos.value = movieData

            }, {})
    }


}