package com.koweg.insight.external.api.fda.drugs


import com.fasterxml.jackson.annotation.JsonProperty

data class Submission(
        @JsonProperty("application_docs")
    val applicationDocs: List<ApplicationDoc>,
        @JsonProperty("review_priority")
    val reviewPriority: String,
        @JsonProperty("submission_class_code")
    val submissionClassCode: String,
        @JsonProperty("submission_class_code_description")
    val submissionClassCodeDescription: String,
        @JsonProperty("submission_number")
    val submissionNumber: String,
        @JsonProperty("submission_property_type")
    val submissionPropertyType: List<SubmissionPropertyType>,
        @JsonProperty("submission_status")
    val submissionStatus: String,
        @JsonProperty("submission_status_date")
    val submissionStatusDate: String,
        @JsonProperty("submission_type")
    val submissionType: String
)