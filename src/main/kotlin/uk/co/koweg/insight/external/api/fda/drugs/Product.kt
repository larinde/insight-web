package uk.co.koweg.insight.external.api.fda.drugs


import com.fasterxml.jackson.annotation.JsonProperty

data class Product(
        @JsonProperty("active_ingredients")
    val activeIngredients: List<ActiveIngredient>,
        @JsonProperty("brand_name")
    val brandName: String,
        @JsonProperty("dosage_form")
    val dosageForm: String,
        @JsonProperty("marketing_status")
    val marketingStatus: String,
        @JsonProperty("product_number")
    val productNumber: String,
        @JsonProperty("reference_drug")
    val referenceDrug: String,
        @JsonProperty("reference_standard")
    val referenceStandard: String,
        @JsonProperty("route")
    val route: String
)