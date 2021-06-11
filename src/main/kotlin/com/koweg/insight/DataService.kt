package com.koweg.insight

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class DataService {

    /**
     * Supervisor job to prevent cascading exceptions
     */
    val scope = CoroutineScope()

    val supScope = SupervisorJob()


    fun retrieveFDAInfo(company: String): String {
        return ""
    }
}