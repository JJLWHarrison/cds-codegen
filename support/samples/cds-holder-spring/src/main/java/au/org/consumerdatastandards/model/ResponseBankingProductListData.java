package au.org.consumerdatastandards.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ResponseBankingProductListData
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-04-16T16:57:32.382+10:00[Australia/Sydney]")

public class ResponseBankingProductListData   {
  @JsonProperty("products")
  @Valid
  private List<BankingProduct> products = new ArrayList<>();

  public ResponseBankingProductListData products(List<BankingProduct> products) {
    this.products = products;
    return this;
  }

  public ResponseBankingProductListData addProductsItem(BankingProduct productsItem) {
    this.products.add(productsItem);
    return this;
  }

  /**
   * The list of products returned.  If the filter results in an empty set then this array may have no records
   * @return products
  */
  @ApiModelProperty(required = true, value = "The list of products returned.  If the filter results in an empty set then this array may have no records")
  @NotNull

  @Valid

  public List<BankingProduct> getProducts() {
    return products;
  }

  public void setProducts(List<BankingProduct> products) {
    this.products = products;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseBankingProductListData responseBankingProductListData = (ResponseBankingProductListData) o;
    return Objects.equals(this.products, responseBankingProductListData.products);
  }

  @Override
  public int hashCode() {
    return Objects.hash(products);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseBankingProductListData {\n");
    
    sb.append("    products: ").append(toIndentedString(products)).append("\n");
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

