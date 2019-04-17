package au.org.consumerdatastandards.models;

import java.util.Objects;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.*;

public class BankingProductBundle {

    private String additionalInfo = null;
    private String additionalInfoUri = null;
    private String description = null;
    private String name = null;
    private List<String> productIds = new ArrayList<String>();

    /**
     * Display text providing more information on the bundle
     **/

    @ApiModelProperty(value = "Display text providing more information on the bundle")
    @JsonProperty("additionalInfo")
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    /**
     * Link to a web page with more information on the bundle criteria and benefits
     **/

    @ApiModelProperty(value = "Link to a web page with more information on the bundle criteria and benefits")
    @JsonProperty("additionalInfoUri")
    public String getAdditionalInfoUri() {
        return additionalInfoUri;
    }

    public void setAdditionalInfoUri(String additionalInfoUri) {
        this.additionalInfoUri = additionalInfoUri;
    }

    /**
     * Description of the bundle
     **/

    @ApiModelProperty(required = true, value = "Description of the bundle")
    @JsonProperty("description")
    @NotNull
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Name of the bundle
     **/

    @ApiModelProperty(required = true, value = "Name of the bundle")
    @JsonProperty("name")
    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Array of product IDs for products included in the bundle
     **/

    @ApiModelProperty(required = true, value = "Array of product IDs for products included in the bundle")
    @JsonProperty("productIds")
    @NotNull
    public List<String> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<String> productIds) {
        this.productIds = productIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingProductBundle bankingProductBundle = (BankingProductBundle) o;
        return Objects.equals(additionalInfo, bankingProductBundle.additionalInfo)
                && Objects.equals(additionalInfoUri, bankingProductBundle.additionalInfoUri)
                && Objects.equals(description, bankingProductBundle.description)
                && Objects.equals(name, bankingProductBundle.name)
                && Objects.equals(productIds, bankingProductBundle.productIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(additionalInfo, additionalInfoUri, description, name, productIds);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BankingProductBundle {\n");

        sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
        sb.append("    additionalInfoUri: ").append(toIndentedString(additionalInfoUri)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    productIds: ").append(toIndentedString(productIds)).append("\n");
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
