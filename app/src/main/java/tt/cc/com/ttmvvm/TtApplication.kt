package tt.cc.com.ttmvvm

import android.app.Application

class TtApplication : Application() {

    companion object {
        var context: Application? = null

        fun getColor(int: Int): Int {
            return context?.resources?.getColor(int) ?: 0
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }

}