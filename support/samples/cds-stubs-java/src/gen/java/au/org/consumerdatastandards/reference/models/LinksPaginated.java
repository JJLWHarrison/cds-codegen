package au.org.consumerdatastandards.reference.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;


public class LinksPaginated   {
  
  private String first = null;
  private String last = null;
  private String next = null;
  private String prev = null;
  private String self = null;

  /**
   * URI to the first page of this set. Mandatory if this response is not the first page
   **/
  
  @ApiModelProperty(value = "URI to the first page of this set. Mandatory if this response is not the first page")
  @JsonProperty("first")
  public String getFirst() {
    return first;
  }
  public void setFirst(String first) {
    this.first = first;
  }

  /**
   * URI to the last page of this set. Mandatory if this response is not the last page
   **/
  
  @ApiModelProperty(value = "URI to the last page of this set. Mandatory if this response is not the last page")
  @JsonProperty("last")
  public String getLast() {
    return last;
  }
  public void setLast(String last) {
    this.last = last;
  }

  /**
   * URI to the next page of this set. Mandatory if this response is not the last page
   **/
  
  @ApiModelProperty(value = "URI to the next page of this set. Mandatory if this response is not the last page")
  @JsonProperty("next")
  public String getNext() {
    return next;
  }
  public void setNext(String next) {
    this.next = next;
  }

  /**
   * URI to the previous page of this set. Mandatory if this response is not the first page
   **/
  
  @ApiModelProperty(value = "URI to the previous page of this set. Mandatory if this response is not the first page")
  @JsonProperty("prev")
  public String getPrev() {
    return prev;
  }
  public void setPrev(String prev) {
    this.prev = prev;
  }

  /**
   * Fully qualified link to this API call
   **/
  
  @ApiModelProperty(required = true, value = "Fully qualified link to this API call")
  @JsonProperty("self")
  @NotNull
  public String getSelf() {
    return self;
  }
  public void setSelf(String self) {
    this.self = self;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LinksPaginated linksPaginated = (LinksPaginated) o;
    return Objects.equals(first, linksPaginated.first) &&
        Objects.equals(last, linksPaginated.last) &&
        Objects.equals(next, linksPaginated.next) &&
        Objects.equals(prev, linksPaginated.prev) &&
        Objects.equals(self, linksPaginated.self);
  }

  @Override
  public int hashCode() {
    return Objects.hash(first, last, next, prev, self);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LinksPaginated {\n");
    
    sb.append("    first: ").append(toIndentedString(first)).append("\n");
    sb.append("    last: ").append(toIndentedString(last)).append("\n");
    sb.append("    next: ").append(toIndentedString(next)).append("\n");
    sb.append("    prev: ").append(toIndentedString(prev)).append("\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
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

