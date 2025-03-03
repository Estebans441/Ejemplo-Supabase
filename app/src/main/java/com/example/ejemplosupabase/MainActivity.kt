package com.example.ejemplosupabase

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.ejemplosupabase.databinding.ActivityMainBinding
import com.example.ejemplosupabase.model.Instrument
import com.example.ejemplosupabase.services.SupabaseService
import io.github.jan.supabase.postgrest.*
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val supabase = SupabaseService.client

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            updateInstruments()
        }

        binding.buttonAddInstrument.setOnClickListener {
            val instrument = Instrument(name = binding.editTextInstrumentName.text.toString())
            lifecycleScope.launch {
                addInstrument(instrument)
            }
        }
    }

    suspend fun updateInstruments() {
        val instruments = supabase.from("instruments").select().decodeList<Instrument>()
        val instrumentNames = instruments.map { it.name }
        val adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, instrumentNames)
        binding.listViewInstruments.adapter = adapter
    }

    suspend fun addInstrument(instrument: Instrument) {
        supabase.from("instruments").insert(instrument)
        updateInstruments()
    }
}