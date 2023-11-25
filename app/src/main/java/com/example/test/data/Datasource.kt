package com.example.test.data

import com.example.test.R
import com.example.test.data.model.GoShopping

class Datasource {

    fun loadGoShopping(): List<GoShopping> {

        val result = mutableListOf<GoShopping>()


        return mutableListOf(
            GoShopping(R.string.index1, R.string.name1, R.string.menge1),
            GoShopping(R.string.index2, R.string.name2, R.string.menge2),
            GoShopping(R.string.index3, R.string.name3, R.string.menge3),
            GoShopping(R.string.index4, R.string.name4, R.string.menge4),
            GoShopping(R.string.index5, R.string.name5, R.string.menge5),
            GoShopping(R.string.index6, R.string.name6, R.string.menge6)
        )


    }


}
