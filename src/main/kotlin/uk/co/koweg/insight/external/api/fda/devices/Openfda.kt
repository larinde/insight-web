package uk.co.koweg.insight.external.api.fda.devices


import com.fasterxml.jackson.annotation.JsonProperty

data class Openfda(
    @JsonProperty("device_class")
    val deviceClass: String,
    @JsonProperty("device_name")
    val deviceName: String,
    @JsonProperty("fei_number")
    val feiNumber: List<String>,
    @JsonProperty("medical_specialty_description")
    val medicalSpecialtyDescription: String,
    @JsonProperty("registration_number")
    val registrationNumber: List<String>,
    @JsonProperty("regulation_number")
    val regulationNumber: String
)