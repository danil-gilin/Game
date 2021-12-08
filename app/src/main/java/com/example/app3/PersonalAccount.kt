package com.example.app3

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app3.databinding.PersonalAccountBinding
import com.example.app3.databinding.SignInUpBinding
import kotlin.random.Random as Random

class PersonalAccount: AppCompatActivity() {
    private lateinit var bindingclass: PersonalAccountBinding
    private val adapter = FigursAdapter()
    private val imgFigursList= listOf(
        R.drawable.figurs11,
        R.drawable.figurs22,
        R.drawable.figurs33,
        R.drawable.figurs44
    )
    private var index=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingclass = PersonalAccountBinding.inflate(layoutInflater)
        setContentView(bindingclass.root)
        rcInit()

        val avatar=intent.getIntExtra("Img",0)!!
        val name=intent.getStringExtra("Name")!!

        bindingclass.btAvatar.setImageResource(avatar)
        bindingclass.Name.text=name

    }

    private fun rcInit(){
        bindingclass.rcfugurs.layoutManager = GridLayoutManager(this,2)
        bindingclass.rcfugurs.adapter = adapter
        bindingclass.btAvatar.setOnClickListener {
            if(index>3){
                index=0
            }
            val figurs=Figurs_Item(
                imgFigursList[index],
                "Figurs ${index + 1}",
                Random(10).nextInt(100)
            )
            adapter.addFigurs(figurs)
            index++
        }
    }

    fun onClick(view: View){
        finish()
    }

}

