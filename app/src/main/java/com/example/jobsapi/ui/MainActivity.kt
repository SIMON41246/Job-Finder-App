package com.example.jobsapi.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.jobsapi.ViewModels.MyviewModel
import com.example.jobsapi.data.Data
import com.example.jobsapi.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), Adapter.Readmore {
    private var myviewmodel: MyviewModel? = null
    private lateinit var binding: ActivityMainBinding
    lateinit var button: Button

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


    @SuppressLint("SetJavaScriptEnabled")
    override fun click(data: Data) {
        binding.wv.visibility = View.VISIBLE
        binding.wv.settings.javaScriptEnabled = true
        binding.wv.loadData(data.description, "text/html", "UTF-8")
        binding.btn.visibility = View.VISIBLE
        binding.btn.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(data.url))
            startActivity(browserIntent)
        }

        /*


        val intent = Intent(this, WebViewActivity::class.java)
        intent.putExtra("data", data.description)
        startActivity(intent)





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

        */
    }

    override fun onBackPressed() {
        if (binding.wv.visibility == View.VISIBLE) {
            binding.wv.visibility = View.GONE
            binding.btn.visibility = View.GONE
        }
    }


}