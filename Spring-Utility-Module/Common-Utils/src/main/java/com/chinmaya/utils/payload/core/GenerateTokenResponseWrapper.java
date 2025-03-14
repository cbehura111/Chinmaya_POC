package com.chinmaya.utils.payload.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenerateTokenResponseWrapper {

	@JsonProperty("responseCode")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Schema(example = "1", requiredMode = RequiredMode.REQUIRED)
	private String responseCode;

	@JsonProperty("responseMessage")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Schema(example = "SUCCESS", requiredMode = RequiredMode.REQUIRED)
	private String responseMessage;

	@JsonProperty("branchTokenNumber")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Schema(example = "0678689", requiredMode = RequiredMode.REQUIRED)
	private String branchTokenNumber;

	@JsonProperty("errorMessage")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Schema(example = "Invalid phone number", requiredMode = RequiredMode.REQUIRED)
	private String errorMessage;

	@JsonProperty("rrn")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Schema(example = "06786897789", requiredMode = RequiredMode.REQUIRED)
	private String rrn;

}
