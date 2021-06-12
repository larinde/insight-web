package com.koweg.insight.external.api.fda.drugs


import com.fasterxml.jackson.annotation.JsonProperty

data class SubmissionPropertyType(
    @JsonProperty("code")
    val code: String
)