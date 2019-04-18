package au.org.consumerdatastandards;

import au.org.consumerdatastandards.api.BankingProductsApi;
import au.org.consumerdatastandards.model.ResponseBankingProductById;
import au.org.consumerdatastandards.model.ResponseBankingProductList;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.threeten.bp.OffsetDateTime;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

@ShellComponent
public class CdsClient {

    private final BankingProductsApi api = new BankingProductsApi();

    private String serverUrl;

    @ShellMethod("Set CDS server URL, e.g. http://data.holder/cds-au/v1")
    public void server(@ShellOption String url) {
        if (isValid(url)) {
            this.serverUrl = url;
            ApiClient client = new ApiClient();
            client.setBasePath(serverUrl);
            client.addDefaultHeader("x-v", "1");
            client.addDefaultHeader("x-min-v", "1");
            client.addDefaultHeader("x-fapi-financial-id", "blah");
            client.addDefaultHeader("x-fapi-customer-last-logged-time", "");
            client.addDefaultHeader("x-fapi-customer-ip-address", "192.168.1.2");
            client.addDefaultHeader("x-fapi-interaction-id", UUID.randomUUID().toString());
            api.setApiClient(client);
            System.out.println("Server URL is set to " + this.serverUrl);
        } else {
            System.out.println("Invalid URL, please double check it");
        }
    }

    @ShellMethod("List products filtered by the parameters")
    public void listProducts(
        @ShellOption(defaultValue = ShellOption.NULL) String effective,
        @ShellOption(defaultValue = ShellOption.NULL, help = "'yyyy-MM-dd HH:mm:ss.SSS Z' or '-1y -2M -3d 5H 3m 45s 8S'") OffsetDateTime updatedSince,
        @ShellOption(defaultValue = ShellOption.NULL) String brand,
        @ShellOption(defaultValue = ShellOption.NULL) String productCategory,
        @ShellOption(defaultValue = ShellOption.NULL) Integer page,
        @ShellOption(defaultValue = ShellOption.NULL) Integer pageSize) throws ApiException {

        if (this.serverUrl == null) {
            System.out.println("Please use `server` command to set Server URL first");
            return;
        }
        try {
            ResponseBankingProductList response = api.listProducts(effective, updatedSince, brand, productCategory, page, pageSize);
            System.out.println(response);
        } catch (Exception e) {
            System.out.println("Oops, something went wrong!");
            throw e;
        }
    }

    @ShellMethod("Get product detail by id")
    public void getProductDetail(@ShellOption String id) throws Exception {
        if (this.serverUrl == null) {
            System.out.println("Please use `server` command to set Server URL first");
            return;
        }
        try {
            ResponseBankingProductById productDetail = api.getProductDetail(id);
            System.out.println(productDetail);
        } catch (Exception e) {
            System.out.println("Oops, something went wrong!");
            throw e;
        }
    }

    private boolean isValid(String url) {
        String lowerCaseUrl = url.toLowerCase();
        if (!lowerCaseUrl.startsWith("https://") && !lowerCaseUrl.startsWith("http://")) {
            return false;
        }
        try {
            new URL(url);
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }
}
