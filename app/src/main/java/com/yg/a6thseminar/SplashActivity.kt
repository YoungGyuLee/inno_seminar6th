package com.yg.a6thseminar

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        val handler = Handler()
        handler.postDelayed({
            if(SharedPreferenceController.getId(this) == ""){
                startActivity(Intent(applicationContext, LoginActivity::class.java))
                finish()
            }else{
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("id", SharedPreferenceController.getId(this))
                startActivity(intent)
                finish()
            }
        }, 3000)
    }
}
