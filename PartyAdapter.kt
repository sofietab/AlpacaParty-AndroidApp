package com.example.sofietb_oblig2


import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.util.ServiceLoader.load

class PartyAdapter(private val dataSet: List<AlpacaParty>): RecyclerView.Adapter<PartyAdapter.ViewHolder>() {

    class ViewHolder(binding: View): RecyclerView.ViewHolder(binding){
        val navn: TextView =binding.findViewById(R.id.navn)
        val leder: TextView =binding.findViewById(R.id.leder)
        val stemmer: TextView =binding.findViewById(R.id.stemmer)
        val bilde: ImageView =binding.findViewById(R.id.bilde)
        val farge : View =binding.findViewById(R.id.farge)
        ;


    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        val binding = LayoutInflater.from(parent.context).inflate(R.layout.element,parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.navn.text = dataSet[position].name
        viewHolder.leder.text= dataSet[position].leader
        Glide.with(viewHolder.bilde.context).load(dataSet[position].img).into(viewHolder.bilde)
        viewHolder.farge.setBackgroundColor(Color.parseColor(dataSet[position].color))
        viewHolder.stemmer.text = dataSet[position].hentStemmer().toString()

    }


    override fun getItemCount() = dataSet.size

}