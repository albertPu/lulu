package tt.cc.com.ttmvvm.mvvm.adapter.reclcerview

interface ConvertListener {

    fun <T> onConvert(mvViewHolder: MVViewHolder, item: T)
}