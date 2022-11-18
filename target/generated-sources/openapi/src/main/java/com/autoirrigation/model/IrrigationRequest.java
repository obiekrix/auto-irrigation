package com.autoirrigation.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * IrrigationRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-11-18T21:23:12.338624+01:00[Africa/Luanda]")
public class IrrigationRequest   {
  @JsonProperty("amountOfWater")
  private Integer amountOfWater;

  @JsonProperty("plotId")
  private Long plotId;

  @JsonProperty("slotId")
  private Long slotId;

  public IrrigationRequest amountOfWater(Integer amountOfWater) {
    this.amountOfWater = amountOfWater;
    return this;
  }

  /**
   * The amount of water required to irrigate the plot for during this period
   * @return amountOfWater
  */
  @ApiModelProperty(required = true, value = "The amount of water required to irrigate the plot for during this period")
  @NotNull


  public Integer getAmountOfWater() {
    return amountOfWater;
  }

  public void setAmountOfWater(Integer amountOfWater) {
    this.amountOfWater = amountOfWater;
  }

  public IrrigationRequest plotId(Long plotId) {
    this.plotId = plotId;
    return this;
  }

  /**
   * The id of the plot to be irrigated
   * @return plotId
  */
  @ApiModelProperty(required = true, value = "The id of the plot to be irrigated")
  @NotNull


  public Long getPlotId() {
    return plotId;
  }

  public void setPlotId(Long plotId) {
    this.plotId = plotId;
  }

  public IrrigationRequest slotId(Long slotId) {
    this.slotId = slotId;
    return this;
  }

  /**
   * The id of the time slot whom this irrigation request is meant for
   * @return slotId
  */
  @ApiModelProperty(required = true, value = "The id of the time slot whom this irrigation request is meant for")
  @NotNull


  public Long getSlotId() {
    return slotId;
  }

  public void setSlotId(Long slotId) {
    this.slotId = slotId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IrrigationRequest irrigationRequest = (IrrigationRequest) o;
    return Objects.equals(this.amountOfWater, irrigationRequest.amountOfWater) &&
        Objects.equals(this.plotId, irrigationRequest.plotId) &&
        Objects.equals(this.slotId, irrigationRequest.slotId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amountOfWater, plotId, slotId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IrrigationRequest {\n");
    
    sb.append("    amountOfWater: ").append(toIndentedString(amountOfWater)).append("\n");
    sb.append("    plotId: ").append(toIndentedString(plotId)).append("\n");
    sb.append("    slotId: ").append(toIndentedString(slotId)).append("\n");
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

