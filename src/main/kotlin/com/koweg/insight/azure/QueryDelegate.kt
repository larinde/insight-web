package com.koweg.insight.azure

import org.springframework.stereotype.Component
import java.util.function.Function

@Component
class QueryDelegate : Function<RequestWrapper, ResponseWrapper> {
    override fun apply(requestWrapper: RequestWrapper): ResponseWrapper {
        return ResponseWrapper("RECEIVED: \"${requestWrapper.data}\"")
    }
}