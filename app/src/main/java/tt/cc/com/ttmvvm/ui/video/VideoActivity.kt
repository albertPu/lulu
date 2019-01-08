package tt.cc.com.ttmvvm.ui.video

import android.os.Bundle
import tt.cc.com.ttmvvm.R
import tt.cc.com.ttmvvm.mvvm.ui.BaseMvvmFragment
import tt.cc.com.ttmvvm.ui.base.BaseActivity

/**
 *created by Albert
 */
class VideoActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activiy_video)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, VideoFragment())
                .commitNow()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        this.supportFragmentManager.fragments.forEach {
            (it as? BaseMvvmFragment<*>)?.onBackPressed()
        }
    }

}