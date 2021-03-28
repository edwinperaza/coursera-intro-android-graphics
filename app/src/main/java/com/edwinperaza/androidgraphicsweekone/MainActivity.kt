package com.edwinperaza.androidgraphicsweekone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var myView: MyView
    private lateinit var myAffineView: MyAffineView
    private lateinit var myPlottingView: MyPlottingView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main);
//        replace the view with my custom designed view
//        myView = MyView(this)
//        myAffineView = MyAffineView(this)
        myPlottingView = MyPlottingView(this)
        setContentView(myPlottingView)
    }
}