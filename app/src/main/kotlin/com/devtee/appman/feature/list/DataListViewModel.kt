package com.devtee.appman.feature.list

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devtee.appman.R
import com.devtee.appman.helper.jsonFromRawToClass
import com.devtee.appman.model.DataItem
import com.devtee.appman.model.DocDTO

class DataListViewModel(context: Context) : ViewModel() {

    val data = MutableLiveData<List<DataListItem>>()

    init {
        val docDTO = context.jsonFromRawToClass<DocDTO>(R.raw.json)
        data.value = docDTO.data?.convertDataItem()
    }
}

fun List<DataItem>.convertDataItem(): List<DataListItem> {
    return this.asSequence().map { item ->
        DataListItem(
                id = indexOf(item),
                name = item.docType ?: "",
                display = "${indexOf(item) + 1}: ${item.docType}"
        )
    }.toList()
}