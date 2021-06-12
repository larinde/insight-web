package com.koweg.insight.external.api.fda.devices


import com.fasterxml.jackson.annotation.JsonProperty

data class DeviceApprovalSearch(
        @JsonProperty("meta")
    val meta: Meta,
        @JsonProperty("results")
    val results: List<Result>
)