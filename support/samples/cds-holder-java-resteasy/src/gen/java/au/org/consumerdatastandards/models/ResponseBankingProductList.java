package au.org.consumerdatastandards.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import au.org.consumerdatastandards.models.LinksPaginated;
import au.org.consumerdatastandards.models.MetaPaginated;
import au.org.consumerdatastandards.models.ResponseBankingProductListData;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;

public class ResponseBankingProductList {

    private ResponseBankingProductListData data = null;
    private LinksPaginated links = null;
    private MetaPaginated meta = null;

    /**
     **/

    @ApiModelProperty(required = true, value = "")
    @JsonProperty("data")
    @NotNull
    public ResponseBankingProductListData getData() {
        return data;
    }

    public void setData(ResponseBankingProductListData data) {
        this.data = data;
    }

    /**
     **/

    @ApiModelProperty(required = true, value = "")
    @JsonProperty("links")
    @NotNull
    public LinksPaginated getLinks() {
        return links;
    }

    public void setLinks(LinksPaginated links) {
        this.links = links;
    }

    /**
     **/

    @ApiModelProperty(required = true, value = "")
    @JsonProperty("meta")
    @NotNull
    public MetaPaginated getMeta() {
        return meta;
    }

    public void setMeta(MetaPaginated meta) {
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
        ResponseBankingProductList responseBankingProductList = (ResponseBankingProductList) o;
        return Objects.equals(data, responseBankingProductList.data)
                && Objects.equals(links, responseBankingProductList.links)
                && Objects.equals(meta, responseBankingProductList.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ResponseBankingProductList {\n");

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
