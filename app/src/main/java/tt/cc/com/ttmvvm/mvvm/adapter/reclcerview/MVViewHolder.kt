package tt.cc.com.ttmvvm.mvvm.adapter.reclcerview

import android.databinding.ViewDataBinding
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

class MVViewHolder(binding: ViewDataBinding) : BaseViewHolder(binding.root) {

    var dataViewBinding: ViewDataBinding? = null
        internal set

    init {
          this.dataViewBinding = binding
    }

    fun setQAdapter(adapter: BaseQuickAdapter<*, *>): BaseViewHolder {
        super.setAdapter(adapter)
        return this
    }

}
