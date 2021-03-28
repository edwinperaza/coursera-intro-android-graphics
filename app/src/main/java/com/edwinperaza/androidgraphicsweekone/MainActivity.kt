package com.edwinperaza.androidgraphicsweekone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var myView: MyView
    lateinit var myAffineView: MyAffineView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main);
//        replace the view with my custom designed view
//        myView = MyView(this)
        myAffineView = MyAffineView(this)
        setContentView(myAffineView)
    }
}