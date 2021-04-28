package com.example.datastructure

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.datastructure.sort.InsertionSort
import com.example.datastructure.sort.SelectionSort
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn.setOnClickListener {
            text.text = Arrays.toString(InsertionSort.insertionSort(intArrayOf(4, 542, 2, 6, 73, 1)))
        }
    }
}