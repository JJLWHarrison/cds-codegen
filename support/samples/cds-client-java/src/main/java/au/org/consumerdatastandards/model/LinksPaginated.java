/*
 * Consumer Data Standards
 * API sets created by the Australian Consumer Data Standards to meet the needs of the Consumer Data Right
 *
 */


package au.org.consumerdatastandards.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * LinksPaginated
 */
public class LinksPaginated {
  public static final String SERIALIZED_NAME_FIRST = "first";
  @SerializedName(SERIALIZED_NAME_FIRST)
  private String first;

  public static final String SERIALIZED_NAME_LAST = "last";
  @SerializedName(SERIALIZED_NAME_LAST)
  private String last;

  public static final String SERIALIZED_NAME_NEXT = "next";
  @SerializedName(SERIALIZED_NAME_NEXT)
  private String next;

  public static final String SERIALIZED_NAME_PREV = "prev";
  @SerializedName(SERIALIZED_NAME_PREV)
  private String prev;

  public static final String SERIALIZED_NAME_SELF = "self";
  @SerializedName(SERIALIZED_NAME_SELF)
  private String self;

  public LinksPaginated first(String first) {
    this.first = first;
    return this;
  }

   /**
   * URI to the first page of this set. Mandatory if this response is not the first page
   * @return first
  **/
  @ApiModelProperty(value = "URI to the first page of this set. Mandatory if this response is not the first page")
  public String getFirst() {
    return first;
  }

  public void setFirst(String first) {
    this.first = first;
  }

  public LinksPaginated last(String last) {
    this.last = last;
    return this;
  }

   /**
   * URI to the last page of this set. Mandatory if this response is not the last page
   * @return last
  **/
  @ApiModelProperty(value = "URI to the last page of this set. Mandatory if this response is not the last page")
  public String getLast() {
    return last;
  }

  public void setLast(String last) {
    this.last = last;
  }

  public LinksPaginated next(String next) {
    this.next = next;
    return this;
  }

   /**
   * URI to the next page of this set. Mandatory if this response is not the last page
   * @return next
  **/
  @ApiModelProperty(value = "URI to the next page of this set. Mandatory if this response is not the last page")
  public String getNext() {
    return next;
  }

  public void setNext(String next) {
    this.next = next;
  }

  public LinksPaginated prev(String prev) {
    this.prev = prev;
    return this;
  }

   /**
   * URI to the previous page of this set. Mandatory if this response is not the first page
   * @return prev
  **/
  @ApiModelProperty(value = "URI to the previous page of this set. Mandatory if this response is not the first page")
  public String getPrev() {
    return prev;
  }

  public void setPrev(String prev) {
    this.prev = prev;
  }

  public LinksPaginated self(String self) {
    this.self = self;
    return this;
  }

   /**
   * Fully qualified link to this API call
   * @return self
  **/
  @ApiModelProperty(required = true, value = "Fully qualified link to this API call")
  public String getSelf() {
    return self;
  }

  public void setSelf(String self) {
    this.self = self;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LinksPaginated linksPaginated = (LinksPaginated) o;
    return Objects.equals(this.first, linksPaginated.first) &&
        Objects.equals(this.last, linksPaginated.last) &&
        Objects.equals(this.next, linksPaginated.next) &&
        Objects.equals(this.prev, linksPaginated.prev) &&
        Objects.equals(this.self, linksPaginated.self);
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

