package tma.inf.upol.cz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class ActivitySecond : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.d("TMA/TODO", "onCreate()")
    }

    override fun onStart() {
        super.onStart()
        Log.d("TMA/TODO", "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d("TMA/TODO", "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d("TMA/TODO", "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d("TMA/TODO", "onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TMA/TODO", "onDestroy()")
    }
}
