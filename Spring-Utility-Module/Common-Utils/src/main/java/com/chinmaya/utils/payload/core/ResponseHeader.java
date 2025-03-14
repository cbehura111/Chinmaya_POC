package com.chinmaya.utils.payload.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseHeader {
	
	@Schema(example = "0(SUCCESS)/1(FAILURE)", allowableValues = "0, 1")
	@JsonProperty("ResponseCode")
	private String responseCode;
	
	@Schema(hidden=true)
	@JsonProperty("ErrorCode")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String errorCode;
	
	@Schema(example = "This field contains the error message if the API execution fails")
	@JsonProperty("ResponseMessage")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String responseMessage;
	
	@JsonIgnore
	private HttpStatus httpStatus;

	@JsonProperty("ErrorMessage")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String errorMessage;

}