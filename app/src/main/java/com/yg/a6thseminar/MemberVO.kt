package com.yg.a6thseminar

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class MemberVO : RealmObject() {
    //VO : Value Object
    @PrimaryKey
    var id : String =""
    var pwd : String = ""
}