package tt.cc.com.ttmvvm.model.page

import tt.cc.com.ttmvvm.mvvm.adapter.reclcerview.IMultiItemEntity


class DiscussVo : IMultiItemEntity {
    override fun setPosition(position: Int) {

    }

    override fun getClickViewIds(): ArrayList<Int>? = null



    override fun getItemType(): Int = 1

    var discussContent = ""
    var disucsserName = ""
    var disucsserHeadUrl = ""
    var videoId = ""
    var id = ""
    var createTime = ""
}