package com.qxm.mobiledata.model

data class DataUsageResult(
    val result: DataUsageList,
    val success: Boolean,
    val help: String
)

data class DataUsageList (
    val records: List<DataUsage>,
    val resource_id: String,
    val fields: List<Field>
)

data class DataUsage (
    val _id: Int,
    val volume_of_mobile_data: String,
    val quarter: String
)

data class Field (
    val type: String,
    val id: String
)