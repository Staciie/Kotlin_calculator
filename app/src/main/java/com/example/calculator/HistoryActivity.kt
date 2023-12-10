package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val historyList = intent.getStringArrayExtra("history_list") ?: arrayOf();
        val itemsAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, historyList);
        val listView = findViewById<ListView>(R.id.history_list_view);
        listView.adapter = itemsAdapter
    }
}
