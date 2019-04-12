package au.org.consumerdatastandards.reference.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;


public class MetaPaginated   {
  
  private Integer totalPages = null;
  private Integer totalRecords = null;

  /**
   * The total number of pages in the full set
   **/
  
  @ApiModelProperty(required = true, value = "The total number of pages in the full set")
  @JsonProperty("totalPages")
  @NotNull
  public Integer getTotalPages() {
    return totalPages;
  }
  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }

  /**
   * The total number of records in the full set
   **/
  
  @ApiModelProperty(required = true, value = "The total number of records in the full set")
  @JsonProperty("totalRecords")
  @NotNull
  public Integer getTotalRecords() {
    return totalRecords;
  }
  public void setTotalRecords(Integer totalRecords) {
    this.totalRecords = totalRecords;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MetaPaginated metaPaginated = (MetaPaginated) o;
    return Objects.equals(totalPages, metaPaginated.totalPages) &&
        Objects.equals(totalRecords, metaPaginated.totalRecords);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalPages, totalRecords);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MetaPaginated {\n");
    
    sb.append("    totalPages: ").append(toIndentedString(totalPages)).append("\n");
    sb.append("    totalRecords: ").append(toIndentedString(totalRecords)).append("\n");
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

