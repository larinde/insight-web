package uk.co.koweg.insight.external.api.fda.devices


import com.fasterxml.jackson.annotation.JsonProperty

data class Result(
        @JsonProperty("advisory_committee")
    val advisoryCommittee: String,
        @JsonProperty("advisory_committee_description")
    val advisoryCommitteeDescription: String,
        @JsonProperty("ao_statement")
    val aoStatement: String,
        @JsonProperty("applicant")
    val applicant: String,
        @JsonProperty("city")
    val city: String,
        @JsonProperty("date_received")
    val dateReceived: String,
        @JsonProperty("decision_code")
    val decisionCode: String,
        @JsonProperty("decision_date")
    val decisionDate: String,
        @JsonProperty("docket_number")
    val docketNumber: String,
        @JsonProperty("expedited_review_flag")
    val expeditedReviewFlag: String,
        @JsonProperty("fed_reg_notice_date")
    val fedRegNoticeDate: String,
        @JsonProperty("generic_name")
    val genericName: String,
        @JsonProperty("openfda")
    val openfda: Openfda,
        @JsonProperty("pma_number")
    val pmaNumber: String,
        @JsonProperty("product_code")
    val productCode: String,
        @JsonProperty("state")
    val state: String,
        @JsonProperty("street_1")
    val street1: String,
        @JsonProperty("street_2")
    val street2: String,
        @JsonProperty("supplement_number")
    val supplementNumber: String,
        @JsonProperty("supplement_reason")
    val supplementReason: String,
        @JsonProperty("supplement_type")
    val supplementType: String,
        @JsonProperty("trade_name")
    val tradeName: String,
        @JsonProperty("zip")
    val zip: String,
        @JsonProperty("zip_ext")
    val zipExt: String
)