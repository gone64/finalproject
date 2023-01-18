package com.example.myapplication

class UserClass {
    var userMail : String? = null
    var userName : String? = null
    var userPass : String? = null
    constructor(userMail : String?,userName : String? , userPass : String?){
        this.userMail = userMail
        this.userName = userName
        this.userPass = userPass
    }
    constructor(){

    }
}