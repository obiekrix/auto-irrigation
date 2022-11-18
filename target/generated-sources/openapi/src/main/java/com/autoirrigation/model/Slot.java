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
 * Slot
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-11-18T21:23:12.338624+01:00[Africa/Luanda]")
public class Slot   {
  @JsonProperty("period")
  private Integer period;

  @JsonProperty("amountOfWater")
  private Integer amountOfWater;

  @JsonProperty("plotId")
  private Long plotId;

  public Slot period(Integer period) {
    this.period = period;
    return this;
  }

  /**
   * The time (in hour) to trigger irrigation of the plot
   * @return period
  */
  @ApiModelProperty(required = true, value = "The time (in hour) to trigger irrigation of the plot")
  @NotNull


  public Integer getPeriod() {
    return period;
  }

  public void setPeriod(Integer period) {
    this.period = period;
  }

  public Slot amountOfWater(Integer amountOfWater) {
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

  public Slot plotId(Long plotId) {
    this.plotId = plotId;
    return this;
  }

  /**
   * The id of the plot that owns this time slot
   * @return plotId
  */
  @ApiModelProperty(required = true, value = "The id of the plot that owns this time slot")
  @NotNull


  public Long getPlotId() {
    return plotId;
  }

  public void setPlotId(Long plotId) {
    this.plotId = plotId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Slot slot = (Slot) o;
    return Objects.equals(this.period, slot.period) &&
        Objects.equals(this.amountOfWater, slot.amountOfWater) &&
        Objects.equals(this.plotId, slot.plotId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(period, amountOfWater, plotId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Slot {\n");
    
    sb.append("    period: ").append(toIndentedString(period)).append("\n");
    sb.append("    amountOfWater: ").append(toIndentedString(amountOfWater)).append("\n");
    sb.append("    plotId: ").append(toIndentedString(plotId)).append("\n");
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

