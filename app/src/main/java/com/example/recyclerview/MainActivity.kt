package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private var adapter: CityListAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setUpRecyclerView()
        setUpSearchView()
    }

    private fun setUpSearchView() {
        binding?.searchBar?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                adapter?.getFilter()?.filter(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter?.getFilter()?.filter(newText);
                return true
            }

        })
    }

    private fun setUpRecyclerView() {
        //attach layout manager
        binding?.cityNameList?.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        //add item decoration for divider
        val itemDecorator = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        ContextCompat.getDrawable(this, R.drawable.line_divider)?.let { itemDecorator.setDrawable(it) }
        binding?.cityNameList?.addItemDecoration(itemDecorator)

        //create a copy of city list
        val cityList = MockDataProvider().getCityDataList()
        val cityListCopy = ArrayList<CityDataObject>().apply {
            addAll(cityList)
        }

        //attach adapter to list
        adapter = CityListAdapter(cityListCopy)
        binding?.cityNameList?.adapter = adapter
    }
}