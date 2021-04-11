package com.example.recyclerview

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class MockDataProvider {
    public fun getCityDataList(): List<CityDataObject> {
        val jsonString =
            "[{\"city_name\":\"Andaman & Nicobar\",\"city_code\":\"AN\"},{\"city_name\":\"Andhra Pradesh\",\"city_code\":\"AP\"},{\"city_name\":\"Arunachal Pradesh\",\"city_code\":\"AR\"},{\"city_name\":\"Assam\",\"city_code\":\"AS\"},{\"city_name\":\"Chhattisgarh\",\"city_code\":\"CG\"},{\"city_name\":\"Chandigarh\",\"city_code\":\"CH\"},{\"city_name\":\"Daman and Diu\",\"city_code\":\"DD\"},{\"city_name\":\"Delhi\",\"city_code\":\"DL\"},{\"city_name\":\"Dadra and Nagar Haveli\",\"city_code\":\"DN\"},{\"city_name\":\"Goa\",\"city_code\":\"GA\"},{\"city_name\":\"Gujarat\",\"city_code\":\"GJ\"},{\"city_name\":\"Himachal Pradesh\",\"city_code\":\"HP\"},{\"city_name\":\"Haryana\",\"city_code\":\"HR\"},{\"city_name\":\"Jharkhand\",\"city_code\":\"JH\"},{\"city_name\":\"Jammu & Kashmir\",\"city_code\":\"JK\"},{\"city_name\":\"Karnataka\",\"city_code\":\"KA\"},{\"city_name\":\"Kerala\",\"city_code\":\"KL\"},{\"city_name\":\"Lakshadweep\",\"city_code\":\"LD\"},{\"city_name\":\"Maharashtra\",\"city_code\":\"MH\"},{\"city_name\":\"Meghalaya\",\"city_code\":\"ML\"},{\"city_name\":\"Manipur\",\"city_code\":\"MN\"},{\"city_name\":\"Madhya Pradesh\",\"city_code\":\"MP\"},{\"city_name\":\"Mizoram\",\"city_code\":\"MZ\"},{\"city_name\":\"Nagaland\",\"city_code\":\"NL\"},{\"city_name\":\"Odisha\",\"city_code\":\"OD/OR\"},{\"city_name\":\"Punjab\",\"city_code\":\"PB\"},{\"city_name\":\"Puducherry\",\"city_code\":\"PY\"},{\"city_name\":\"Rajasthan\",\"city_code\":\"RJ\"},{\"city_name\":\"Sikkim\",\"city_code\":\"SK\"},{\"city_name\":\"Tamil Nadu\",\"city_code\":\"TN\"},{\"city_name\":\"Telangana\",\"city_code\":\"TS\"},{\"city_name\":\"Tripura\",\"city_code\":\"TR\"},{\"city_name\":\"Uttar Pradesh\",\"city_code\":\"UP\"},{\"city_name\":\"Uttarakhand\",\"city_code\":\"UK\"},{\"city_name\":\"West Bengal\",\"city_code\":\"WB\"}]"
        val cityListType: Type = object :
            TypeToken<ArrayList<CityDataObject?>?>() {}.type
        return Gson().fromJson<ArrayList<CityDataObject>?>(jsonString, cityListType)
    }
}