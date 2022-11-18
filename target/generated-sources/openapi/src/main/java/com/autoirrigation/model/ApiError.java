package com.autoirrigation.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ApiError
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-11-18T21:23:12.338624+01:00[Africa/Luanda]")
public class ApiError   {
  @JsonProperty("error")
  private String error;

  @JsonProperty("exception")
  private String exception;

  @JsonProperty("message")
  private String message;

  @JsonProperty("path")
  private String path;

  @JsonProperty("status")
  private Integer status;

  @JsonProperty("timestamp")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime timestamp;

  public ApiError error(String error) {
    this.error = error;
    return this;
  }

  /**
   * HTTP status message
   * @return error
  */
  @ApiModelProperty(required = true, value = "HTTP status message")
  @NotNull


  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public ApiError exception(String exception) {
    this.exception = exception;
    return this;
  }

  /**
   * Fully qualified exception type
   * @return exception
  */
  @ApiModelProperty(value = "Fully qualified exception type")


  public String getException() {
    return exception;
  }

  public void setException(String exception) {
    this.exception = exception;
  }

  public ApiError message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Exception / error message
   * @return message
  */
  @ApiModelProperty(required = true, value = "Exception / error message")
  @NotNull


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ApiError path(String path) {
    this.path = path;
    return this;
  }

  /**
   * Get path
   * @return path
  */
  @ApiModelProperty(value = "")


  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public ApiError status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * HTTP status code for the error
   * @return status
  */
  @ApiModelProperty(required = true, value = "HTTP status code for the error")
  @NotNull


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public ApiError timestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * Date and time the error occurred
   * @return timestamp
  */
  @ApiModelProperty(required = true, value = "Date and time the error occurred")
  @NotNull

  @Valid

  public OffsetDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiError apiError = (ApiError) o;
    return Objects.equals(this.error, apiError.error) &&
        Objects.equals(this.exception, apiError.exception) &&
        Objects.equals(this.message, apiError.message) &&
        Objects.equals(this.path, apiError.path) &&
        Objects.equals(this.status, apiError.status) &&
        Objects.equals(this.timestamp, apiError.timestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(error, exception, message, path, status, timestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiError {\n");
    
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    exception: ").append(toIndentedString(exception)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

