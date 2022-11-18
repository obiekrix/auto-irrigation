package com.autoirrigation.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Plot
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-11-18T21:23:12.338624+01:00[Africa/Luanda]")
public class Plot   {
  @JsonProperty("soilMoistureLevel")
  private BigDecimal soilMoistureLevel;

  @JsonProperty("name")
  private String name;

  public Plot soilMoistureLevel(BigDecimal soilMoistureLevel) {
    this.soilMoistureLevel = soilMoistureLevel;
    return this;
  }

  /**
   * Percentage of water present in the soil
   * @return soilMoistureLevel
  */
  @ApiModelProperty(value = "Percentage of water present in the soil")

  @Valid

  public BigDecimal getSoilMoistureLevel() {
    return soilMoistureLevel;
  }

  public void setSoilMoistureLevel(BigDecimal soilMoistureLevel) {
    this.soilMoistureLevel = soilMoistureLevel;
  }

  public Plot name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of this plot (e.g. rice plot)
   * @return name
  */
  @ApiModelProperty(required = true, value = "The name of this plot (e.g. rice plot)")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Plot plot = (Plot) o;
    return Objects.equals(this.soilMoistureLevel, plot.soilMoistureLevel) &&
        Objects.equals(this.name, plot.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(soilMoistureLevel, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Plot {\n");
    
    sb.append("    soilMoistureLevel: ").append(toIndentedString(soilMoistureLevel)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

