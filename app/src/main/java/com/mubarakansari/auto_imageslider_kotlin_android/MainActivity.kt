package com.mubarakansari.auto_imageslider_kotlin_android

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageList = ArrayList<SlideModel>() // Create image list

        imageList.add(
            SlideModel(
                "https://bit.ly/2YoJ77H",
                "The animal population decreased by 58 percent in 42 years."
            )
        )
        imageList.add(
            SlideModel(
                "https://bit.ly/2BteuF2",
                "Elephants and tigers may become extinct."
            )
        )

        // import com.denzcoskun.imageslider.constants.ScaleTypes
        //ScaleTypes.FIT/center etc
        imageList.add(SlideModel("https://bit.ly/3fLJf72", "And people do that.", ScaleTypes.FIT))

        val imageSlider = findViewById<ImageSlider>(R.id.image_slider)
        imageSlider.setImageList(imageList, ScaleTypes.FIT)

        //use click listener.
        imageSlider.setItemClickListener(object : ItemClickListener {
            override fun onItemSelected(position: Int) {
                // You can listen here
                Toast.makeText(this@MainActivity, "position : $position", Toast.LENGTH_SHORT).show()
            }
        })
    }
}

/*
Note: put this dependency to setting.gradle file
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()

        //add from denzcoskun:ImageSlideshow for img slide
        maven { url 'https://jitpack.io' }
    }
}
//////and put in build.gradle

 //add
    implementation 'com.github.denzcoskun:ImageSlideshow:0.1.0'

 */