package com.example.myapplication



class DataClass {
    var proName: String? = null
    var proPrice: String? = null
    var proLoc: String? = null
    var proDesc: String? = null
    var number: String? = null
    var proUrl: String? = null

    constructor(){}
    constructor(proName: String?,proPrice: String?,proLoc: String?,proDesc: String?,proCond: String?, proUrl: String?){

        this.proName = proName
        this.proPrice = proPrice
        this.proLoc = proLoc
        this.proDesc = proDesc
        this.number = proCond
        this.proUrl = proUrl
    }
}