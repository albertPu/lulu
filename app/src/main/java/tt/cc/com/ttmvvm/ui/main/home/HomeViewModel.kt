package tt.cc.com.ttmvvm.ui.main.home

import android.annotation.SuppressLint
import android.arch.lifecycle.*
import android.support.v4.view.ViewPager
import android.support.v7.widget.GridLayoutManager
import android.view.View
import tt.cc.com.ttmvvm.mvvm.getSF
import io.reactivex.rxkotlin.subscribeBy
import tt.cc.com.ttmvvm.R
import tt.cc.com.ttmvvm.TtApplication
import tt.cc.com.ttmvvm.mvvm.net.Api
import tt.cc.com.ttmvvm.mvvm.net.ApiStore
import tt.cc.com.ttmvvm.mvvm.net.ResponseTransformer
import tt.cc.com.ttmvvm.mvvm.adapter.viewpage.PageBind
import tt.cc.com.ttmvvm.mvvm.ui.BaseViewModel
import java.lang.ref.WeakReference

class HomeViewModel(lifecycleOwner: WeakReference<LifecycleOwner>) : BaseViewModel(lifecycleOwner), LifecycleObserver {

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


    init {
        bindPageItems.value = ArrayList<PageBind>().apply {
            add(PageBind(R.layout.view_page_home_one, initViewModel(lifecycleOwner.get(), HomePageViewModel::class.java).apply {
                tag.value = title.getSF(0)
            }))
            add(PageBind(R.layout.view_page_home_one, initViewModel(lifecycleOwner.get(), HomePageViewModel::class.java).apply {
                tag.value = title.getSF(1)
            }))
            add(PageBind(R.layout.view_page_home_one, initViewModel(lifecycleOwner.get(), HomePageViewModel::class.java).apply {
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
    override fun onClick(view: View) {

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