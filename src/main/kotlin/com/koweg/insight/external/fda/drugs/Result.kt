package com.koweg.insight.external.fda.drugs


import com.fasterxml.jackson.annotation.JsonProperty

data class Result(
    @JsonProperty("application_number")
    val applicationNumber: String,
    @JsonProperty("openfda")
    val openfda: Openfda,
    @JsonProperty("products")
    val products: List<Product>,
    @JsonProperty("sponsor_name")
    val sponsorName: String,
    @JsonProperty("submissions")
    val submissions: List<Submission>
)