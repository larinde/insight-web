package com.koweg.insight.external.fda.drugs


import com.fasterxml.jackson.annotation.JsonProperty

data class Meta(
    @JsonProperty("disclaimer")
    val disclaimer: String,
    @JsonProperty("last_updated")
    val lastUpdated: String,
    @JsonProperty("license")
    val license: String,
    @JsonProperty("results")
    val results: Results,
    @JsonProperty("terms")
    val terms: String
)