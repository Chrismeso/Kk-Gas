package com.example.kkgas.models


class Book {
    var name:String = ""
    var email:String = ""
    var gas:String = ""
    var imageUrl:String = ""
    var id:String = ""

    constructor(name: String, email: String, gas: String,imageUrl: String, id: String) {
        this.name = name
        this.email = email
        this.gas= gas
        this.imageUrl = imageUrl
        this.id = id
    }

    constructor()
}