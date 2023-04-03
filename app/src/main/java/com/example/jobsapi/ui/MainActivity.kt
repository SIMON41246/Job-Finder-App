package com.example.jobsapi.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.jobsapi.R
import com.example.jobsapi.ViewModels.MyviewModel
import com.example.jobsapi.data.Data
import com.example.jobsapi.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetDialog


class MainActivity : AppCompatActivity(), Adapter.Readmore {
    private var myviewmodel: MyviewModel? = null
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        myviewmodel = ViewModelProvider(this)[MyviewModel::class.java]
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myviewmodel!!.getdatajob()

        myviewmodel!!.listlivedata.observe(this) {
            if (it != null) {
                val adapter = Adapter(this, it.data, this)
                binding.myRecycle.adapter = adapter
                adapter.notifyDataSetChanged()
            }
        }


    }


    override fun click(data: Data) {
        val dialog = BottomSheetDialog(this)
        val view = layoutInflater.inflate(R.layout.itembottomsheet, null)
        val companyName = view.findViewById<TextView>(R.id.companyName)
        val description = view.findViewById<TextView>(R.id.description)
        val tags = view.findViewById<TextView>(R.id.tags)
        val slug = view.findViewById<TextView>(R.id.slug)
        val btnurl = view.findViewById<Button>(R.id.btnurl)
        btnurl.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(data.url))
            startActivity(browserIntent)
        }
        description.text = data.description
        companyName.text = data.companyName
        tags.text = data.tags.toString()
        slug.text = data.slug
        dialog.setContentView(view)
        dialog.show()
    }
}