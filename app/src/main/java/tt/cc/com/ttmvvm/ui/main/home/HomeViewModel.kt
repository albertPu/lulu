package tt.cc.com.ttmvvm.ui.main.home

import android.annotation.SuppressLint
import android.app.Activity
import android.arch.lifecycle.*
import android.content.Intent
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.support.v4.view.ViewPager
import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
import io.reactivex.rxkotlin.subscribeBy
import tt.cc.com.ttmvvm.R
import tt.cc.com.ttmvvm.TtApplication
import tt.cc.com.ttmvvm.net.Api
import tt.cc.com.ttmvvm.net.ApiStore
import tt.cc.com.ttmvvm.net.ResponseTransformer
import tt.cc.com.ttmvvm.ui.adapter.viewpage.PageBind
import tt.cc.com.ttmvvm.ui.base.BaseViewModel
import tt.cc.com.ttmvvm.ui.video.VideoActivity
import tt.cc.com.ttmvvm.ui.video.VideoFragment
import tt.cc.com.ttmvvm.utlis.getSF
import tt.cc.com.ttmvvm.utlis.showToast

class HomeViewModel : BaseViewModel(), LifecycleObserver {

    var title = ArrayList<String>().apply {
        add("推荐")
        add("最新")
        add("排行")
    }

    var bindPageItems = MutableLiveData<ArrayList<PageBind>>()


    var isLoading = MutableLiveData<Boolean>().also { it.value = false }
    var page = 0


    var pageListener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(p0: Int) {
        }

        override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
        }

        override fun onPageSelected(p0: Int) {
            (bindPageItems.value?.getSF(p0)?.bindData as? HomePageViewModel)?.onPageSelected(p0)
        }
    }


    @SuppressLint("CheckResult")
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        bindPageItems.value = ArrayList<PageBind>().apply {
            add(PageBind(R.layout.view_page_home_one, HomePageViewModel().apply {
                lifecycleOwner = this@HomeViewModel.lifecycleOwner
                tag.value = title.getSF(0)
            }))
            add(PageBind(R.layout.view_page_home_one, HomePageViewModel().apply {
                lifecycleOwner = this@HomeViewModel.lifecycleOwner
                tag.value = title.getSF(1)
            }))
            add(PageBind(R.layout.view_page_home_one, HomePageViewModel().apply {
                lifecycleOwner = this@HomeViewModel.lifecycleOwner
                tag.value = title.getSF(2)
            }))
        }
        pageListener.onPageSelected(0)
    }


    var layoutManager = GridLayoutManager(TtApplication.context, 2).apply {
        spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(p0: Int): Int {
                return 1
            }
        }
    }


    @SuppressLint("CheckResult")
    fun onClick(view: View) {
        showToast("点击了")
    }

    @SuppressLint("CheckResult")
    private fun load() {
        page++
        ApiStore.create(Api::class.java).getMovies(page).compose(ResponseTransformer.handleResult()).subscribeBy(
            onNext = {
                isLoading.value = false
                if (it.isEmpty()) page--
            },
            onError = {}
        )
    }


}