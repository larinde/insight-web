package com.koweg.insight.external.api.fda.drugs


import com.fasterxml.jackson.annotation.JsonProperty

data class ApplicationDoc(
    @JsonProperty("date")
    val date: String,
    @JsonProperty("id")
    val id: String,
    @JsonProperty("type")
    val type: String,
    @JsonProperty("url")
    val url: String
)