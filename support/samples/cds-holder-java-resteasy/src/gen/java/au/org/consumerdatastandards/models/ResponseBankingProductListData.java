package au.org.consumerdatastandards.models;

import java.util.Objects;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;

import au.org.consumerdatastandards.models.BankingProduct;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import javax.validation.constraints.*;

public class ResponseBankingProductListData {

    private List<BankingProduct> products = new ArrayList<BankingProduct>();

    /**
     * The list of products returned. If the filter results in an empty set then
     * this array may have no records
     **/

    @ApiModelProperty(required = true, value = "The list of products returned.  If the filter results in an empty set then this array may have no records")
    @JsonProperty("products")
    @NotNull
    public List<BankingProduct> getProducts() {
        return products;
    }

    public void setProducts(List<BankingProduct> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResponseBankingProductListData responseBankingProductListData = (ResponseBankingProductListData) o;
        return Objects.equals(products, responseBankingProductListData.products);
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
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
