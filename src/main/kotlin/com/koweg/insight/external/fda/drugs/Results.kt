package com.koweg.insight.external.fda.drugs


import com.fasterxml.jackson.annotation.JsonProperty

data class Results(
    @JsonProperty("limit")
    val limit: Int,
    @JsonProperty("skip")
    val skip: Int,
    @JsonProperty("total")
    val total: Int
)