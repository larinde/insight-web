package com.koweg.insight.external.fda.drugs


import com.fasterxml.jackson.annotation.JsonProperty

data class DrugApprovalSearch(
    @JsonProperty("meta")
    val meta: Meta,
    @JsonProperty("results")
    val results: List<Result>
)