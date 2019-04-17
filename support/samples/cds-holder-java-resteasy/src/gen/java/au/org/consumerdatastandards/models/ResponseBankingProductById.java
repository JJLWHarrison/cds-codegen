package au.org.consumerdatastandards.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import au.org.consumerdatastandards.models.BankingProductDetail;
import au.org.consumerdatastandards.models.Links;
import au.org.consumerdatastandards.models.Meta;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;

public class ResponseBankingProductById {

    private BankingProductDetail data = null;
    private Links links = null;
    private Meta meta = null;

    /**
     **/

    @ApiModelProperty(required = true, value = "")
    @JsonProperty("data")
    @NotNull
    public BankingProductDetail getData() {
        return data;
    }

    public void setData(BankingProductDetail data) {
        this.data = data;
    }

    /**
     **/

    @ApiModelProperty(required = true, value = "")
    @JsonProperty("links")
    @NotNull
    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    /**
     **/

    @ApiModelProperty(required = true, value = "")
    @JsonProperty("meta")
    @NotNull
    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResponseBankingProductById responseBankingProductById = (ResponseBankingProductById) o;
        return Objects.equals(data, responseBankingProductById.data)
                && Objects.equals(links, responseBankingProductById.links)
                && Objects.equals(meta, responseBankingProductById.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ResponseBankingProductById {\n");

        sb.append("    data: ").append(toIndentedString(data)).append("\n");
        sb.append("    links: ").append(toIndentedString(links)).append("\n");
        sb.append("    meta: ").append(toIndentedString(meta)).append("\n");
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
