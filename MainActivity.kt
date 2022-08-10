package com.example.sofietb_oblig2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.lifecycle.viewModelScope

import com.example.sofietb_oblig2.databinding.ActivityMainBinding
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
     private lateinit var binding: ActivityMainBinding
    private val mViewModel = MainActivityViewModel()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setUpViews()
        setObserver()
        setUpSpinner()
    }
    private fun setUpViews(){
        binding.recycler.layoutManager= LinearLayoutManager(this)
        binding.recycler.adapter=(PartyAdapter(mutableListOf()))
}
    private fun setObserver(){
    mViewModel.fetchParties()
        mViewModel.getParties().observe(this){
            binding.recycler.adapter = PartyAdapter(it)
        }
    }
private fun setUpSpinner(){
    ArrayAdapter.createFromResource(this, R.array.SpinnerListe, android.R.layout.simple_spinner_dropdown_item
    ).also { adapter ->
        binding.spinner.adapter = adapter
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long ) {

                    mViewModel.oppdaterParties(p2)



            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}

        }

    }
}


}
