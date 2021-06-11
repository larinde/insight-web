package com.koweg.insight.external.fda.drugs


import com.fasterxml.jackson.annotation.JsonProperty

data class ActiveIngredient(
    @JsonProperty("name")
    val name: String,
    @JsonProperty("strength")
    val strength: String
)