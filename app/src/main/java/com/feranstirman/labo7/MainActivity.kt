package com.feranstirman.labo7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.feranstirman.labo7.Database.GithubRepo
import com.feranstirman.labo7.ViewModel.GithubRepoViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(GithubRepoViewModel::class.java)
        btn_add.setOnClickListener {
            val name = et_texto.text.toString()
            if (name.isNotEmpty() && name.isNotBlank()){
                viewModel.insert(GithubRepo(name))
            }
        }

        viewModel.getAll().observe(this, Observer {

        })
    }
}
