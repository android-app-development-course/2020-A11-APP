package com.example.random_1

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity


class Welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_welcome)

        mHandler.removeCallbacks(mRunnable)
        mHandler.postDelayed(mRunnable, 1_000L)
    }

    private var mTime = 1

    private var mHandler: Handler = Handler()

    private val mRunnable: Runnable = object : Runnable {
        override fun run() {
            // TODO: 倒计时逻辑
            if (mTime == 0) {
                val intent = Intent(this@Welcome, MainActivity::class.java)
                startActivity(intent)
            }
            mTime--
            // 每隔一秒调用
            mHandler.postDelayed(this, 1_000L)

        }
    }
}