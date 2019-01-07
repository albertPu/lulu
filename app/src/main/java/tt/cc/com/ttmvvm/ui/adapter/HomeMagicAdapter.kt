package tt.cc.com.ttmvvm.ui.adapter

import android.content.Context
import android.graphics.Color
import android.support.v4.view.ViewPager
import android.view.View
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.BezierPagerIndicator
import tt.cc.com.ttmvvm.R
import tt.cc.com.ttmvvm.TtApplication
import tt.cc.com.ttmvvm.TtApplication.Companion.context
import tt.cc.com.ttmvvm.ui.widgt.ScaleTransitionPagerTitleView

/**
 *created by Albert
 */
class HomeMagicAdapter(private var mDataList: ArrayList<String>?, var viewPage: ViewPager?) : CommonNavigatorAdapter() {

    override fun getTitleView(p0: Context?, index: Int): IPagerTitleView {
        val simplePagerTitleView = ScaleTransitionPagerTitleView(TtApplication.context)
        simplePagerTitleView.text = mDataList?.get(index)
        simplePagerTitleView.textSize = 16f
        simplePagerTitleView.normalColor = Color.GRAY
        simplePagerTitleView.selectedColor = TtApplication.getColor(R.color.main_colore)
        simplePagerTitleView.setOnClickListener { viewPage?.currentItem = index }
        return simplePagerTitleView
    }

    override fun getCount(): Int = mDataList?.size ?: 0

    override fun getIndicator(p0: Context?): IPagerIndicator {
        val indicator = BezierPagerIndicator(context)
        indicator.setColors(TtApplication.getColor(R.color.main_colore))
        return indicator
    }

}