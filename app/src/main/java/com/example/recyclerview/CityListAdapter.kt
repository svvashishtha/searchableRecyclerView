package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class CityListAdapter(private var cityDataList: ArrayList<CityDataObject>) :
    RecyclerView.Adapter<CityViewHolder>() {

    // Create a copy of localityList that is not a clone
    // (so that any changes in localityList aren't reflected in this list)
    val initialCityDataList = ArrayList<CityDataObject>().apply {
        cityDataList?.let { addAll(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        return CityViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.city_name_row_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(cityDataList[position])
    }

    override fun getItemCount(): Int {
        return cityDataList.size
    }

    fun getFilter(): Filter {
        return cityFilter
    }

    private val cityFilter = object : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {
            val filteredList: ArrayList<CityDataObject> = ArrayList()
            if (constraint == null || constraint.isEmpty()) {
                initialCityDataList.let { filteredList.addAll(it) }
            } else {
                val query = constraint.toString().trim().toLowerCase()
                initialCityDataList.forEach {
                    if (it.cityName.toLowerCase(Locale.ROOT).contains(query)) {
                        filteredList.add(it)
                    }
                }
            }
            val results = FilterResults()
            results.values = filteredList
            return results
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
            if (results?.values is ArrayList<*>) {
                cityDataList.clear()
                cityDataList.addAll(results.values as ArrayList<CityDataObject>)
                notifyDataSetChanged()
            }
        }
    }
}

class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val cityName: TextView = itemView.findViewById(R.id.city_name)
    private val cityCode: TextView = itemView.findViewById(R.id.city_code)
    fun bind(cityDataObject: CityDataObject) {
        cityName.text = cityDataObject.cityName
        cityCode.text = cityDataObject.cityCode
    }
}