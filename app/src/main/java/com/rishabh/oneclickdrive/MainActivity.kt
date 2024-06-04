package com.rishabh.oneclickdrive

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rishabh.oneclickdrive.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener {
            val list1 = binding.textBox1.text.toString().split(",").map { it.trim().toInt() }
            val list2 = binding.textBox2.text.toString().split(",").map { it.trim().toInt() }
            val list3 = binding.textBox3.text.toString().split(",").map { it.trim().toInt() }

            val intersection = list1.intersect(list2.toSet()).intersect(list3.toSet())
            val union = list1.union(list2).union(list3)
            val highestNumber = union.maxOrNull()

            binding.resultTextView.text = buildString {
                append("Intersection: ${intersection.joinToString(", ")}\n")
                append("Union: ${union.sorted().joinToString(", ")}\n")
                append("Highest Number: $highestNumber")
            }
        }
    }
}