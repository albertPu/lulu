package tt.cc.com.ttmvvm

import android.os.Bundle
import android.support.v4.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import tt.cc.com.ttmvvm.ui.base.BaseActivity
import tt.cc.com.ttmvvm.ui.main.MainFragment

class MainActivity : BaseActivity() {
    lateinit var fragment: Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        setStatusColor(true)
        fragment = supportFragmentManager.findFragmentById(R.id.container)!!
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavHostFragment.findNavController(fragment).navigateUp()
    }

    override fun onBackPressed() {
        val b = NavHostFragment.findNavController(fragment).navigateUp()
        if (!b) {
            finish()
        }
    }
}
