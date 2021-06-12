package com.koweg.insight.external.api.fda.drugs


import com.fasterxml.jackson.annotation.JsonProperty

data class Openfda(
    @JsonProperty("application_number")
    val applicationNumber: List<String>,
    @JsonProperty("brand_name")
    val brandName: List<String>,
    @JsonProperty("generic_name")
    val genericName: List<String>,
    @JsonProperty("manufacturer_name")
    val manufacturerName: List<String>,
    @JsonProperty("nui")
    val nui: List<String>,
    @JsonProperty("package_ndc")
    val packageNdc: List<String>,
    @JsonProperty("pharm_class_epc")
    val pharmClassEpc: List<String>,
    @JsonProperty("pharm_class_moa")
    val pharmClassMoa: List<String>,
    @JsonProperty("product_ndc")
    val productNdc: List<String>,
    @JsonProperty("product_type")
    val productType: List<String>,
    @JsonProperty("route")
    val route: List<String>,
    @JsonProperty("rxcui")
    val rxcui: List<String>,
    @JsonProperty("spl_id")
    val splId: List<String>,
    @JsonProperty("spl_set_id")
    val splSetId: List<String>,
    @JsonProperty("substance_name")
    val substanceName: List<String>,
    @JsonProperty("unii")
    val unii: List<String>
)