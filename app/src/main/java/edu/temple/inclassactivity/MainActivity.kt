package edu.temple.inclassactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Spinner
import android.widget.SpinnerAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Bind views
        val spinner = findViewById<Spinner>(R.id.spinner)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // Fetch images into Array<Int> called imageArray
        val typedArray = resources.obtainTypedArray(R.array.image_ids)
        val imageArray = Array(typedArray.length()) {typedArray.getResourceId(it, 0)}
        typedArray.recycle()



        // Display images specified in imageArray in Spinner and RecyclerView
        val customRecyclerAdapter = CustomRecyclerAdapter(imageArray)
        val customSpinnerAdapter: CustomSpinnerAdapter = CustomSpinnerAdapter(getApplicationContext(), imageArray)
        if(recyclerView == null) {
            spinner.adapter = customSpinnerAdapter
        }
        if(spinner == null) {
            recyclerView.adapter = customRecyclerAdapter
        }

    }
}