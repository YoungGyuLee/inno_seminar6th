package com.yg.a6thseminar

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class PokemonVO  : RealmObject() {
    @PrimaryKey
    var name : String = ""
    var num : Int = 0
    var user : String = ""
    var type : String = ""
}


