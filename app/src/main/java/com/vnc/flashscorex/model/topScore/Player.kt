package com.vnc.flashscorex.model.topScore

data class Player(
    val id:Int,
    val name:String,
    val firstname:String,
    val lastname:String,
    val age:Int,
    val photo:String,
    val injured:Boolean,
    val height:String,
    val birth: Birth,
    val weight:String,
    val nationality:String
)

//  private int id;
//    private String name;
//    private String firstname;
//    private String lastname;
//    private int age;
//    private String photo;
//    private Boolean injured;
//    private String height;
//    private Birth birth;
//    private String weight;
//    private String nationality;