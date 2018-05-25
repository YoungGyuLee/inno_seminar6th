package com.yg.a6thseminar

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import io.realm.Realm
import io.realm.RealmResults
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var memberRealm : Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()

        login_check_btn.setOnClickListener {
            val id = login_id_edit.text.toString()
            val pwd = login_pw_edit.text.toString()
            if(!getMemberList(id).isEmpty()){
                if(login_auto_check.isChecked){
                    SharedPreferenceController.setId(this, id)
                    SharedPreferenceController.setPwd(this, pwd)
                }
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("id", id)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this, "존재하지 않는 아이디입니다.", Toast.LENGTH_SHORT).show()
            }
        }

        login_sign_btn.setOnClickListener {
            startActivity(Intent(this, SignActivity::class.java))
        }


    }

    fun init(){
        Realm.init(this)
        memberRealm = Realm.getDefaultInstance()
    }

    fun getMemberList(id : String) : RealmResults<MemberVO>{
        return memberRealm.where(MemberVO::class.java).equalTo("id", id).findAll()
    }

}
