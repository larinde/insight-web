package com.koweg.insight.azure

import com.fasterxml.jackson.annotation.JsonTypeInfo
import kotlin.String

@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public data class ResponseWrapper(var data: String)