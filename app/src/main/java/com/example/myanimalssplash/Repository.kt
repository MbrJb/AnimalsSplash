package com.example.myanimalssplash

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class Repository(private val context: Activity, private val arrayList: ArrayList<User>) : ArrayAdapter<User>(context,
    R.layout.activity_main,arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.activity_main, null)

        val imageView : ImageView = view.findViewById(R.id.profile_pic)
        val username : TextView = view.findViewById(R.id.animalName)
        val description : TextView = view.findViewById(R.id.description)

        imageView.setImageResource(arrayList[position].imageId)
        username.text =arrayList[position].name
        description.text = arrayList[position].description

        return view

    }
}