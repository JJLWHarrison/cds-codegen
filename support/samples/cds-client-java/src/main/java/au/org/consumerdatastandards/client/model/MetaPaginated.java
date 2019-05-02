/*
 * Consumer Data Standards
 * API sets created by the Australian Consumer Data Standards to meet the needs of the Consumer Data Right
 *
 */


package au.org.consumerdatastandards.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;

/**
 * MetaPaginated
 */
public class MetaPaginated {
  public static final String SERIALIZED_NAME_TOTAL_PAGES = "totalPages";
  @SerializedName(SERIALIZED_NAME_TOTAL_PAGES)
  private Integer totalPages;

  public static final String SERIALIZED_NAME_TOTAL_RECORDS = "totalRecords";
  @SerializedName(SERIALIZED_NAME_TOTAL_RECORDS)
  private Integer totalRecords;

  public MetaPaginated totalPages(Integer totalPages) {
    this.totalPages = totalPages;
    return this;
  }

   /**
   * The total number of pages in the full set
   * @return totalPages
  **/
  @ApiModelProperty(required = true, value = "The total number of pages in the full set")
  public Integer getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }

  public MetaPaginated totalRecords(Integer totalRecords) {
    this.totalRecords = totalRecords;
    return this;
  }

   /**
   * The total number of records in the full set
   * @return totalRecords
  **/
  @ApiModelProperty(required = true, value = "The total number of records in the full set")
  public Integer getTotalRecords() {
    return totalRecords;
  }

  public void setTotalRecords(Integer totalRecords) {
    this.totalRecords = totalRecords;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MetaPaginated metaPaginated = (MetaPaginated) o;
    return Objects.equals(this.totalPages, metaPaginated.totalPages) &&
        Objects.equals(this.totalRecords, metaPaginated.totalRecords);
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

