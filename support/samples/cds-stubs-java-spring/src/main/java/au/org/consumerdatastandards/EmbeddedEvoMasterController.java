package au.org.consumerdatastandards;

import org.evomaster.clientJava.controller.EmbeddedSutController;
import org.evomaster.clientJava.controller.InstrumentedSutStarter;
import org.evomaster.clientJava.controller.internal.SutController;
import org.evomaster.clientJava.controllerApi.dto.AuthenticationDto;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class EmbeddedEvoMasterController extends EmbeddedSutController {

    public static void main(String[] args){

        SutController controller = new EmbeddedEvoMasterController();
        InstrumentedSutStarter starter = new InstrumentedSutStarter(controller);

        starter.start();
    }

    private ConfigurableApplicationContext ctx;

    @Override
    public boolean isSutRunning() {
        return ctx != null && ctx.isRunning();
    }

    @Override
    public String getPackagePrefixesToCover() {
        return "au.org.consumerdatastandards.api";
    }

    @Override
    public String getUrlOfSwaggerJSON() {
        return "http://localhost:" + getSutPort() + getSwaggerJsonPath();
    }

    @Override
    public List<AuthenticationDto> getInfoForAuthentication() {
        return null;
    }

    @Override
    public Connection getConnection() {
        return null;
    }

    @Override
    public String getDatabaseDriverName() {
        return null;
    }

    @Override
    public List<String> getEndpointsToSkip() {
        return null;
    }

    @Override
    public String startSut() {
        ctx = SpringApplication.run(BankingProductsApplication.class);
        return "http://localhost:" + getSutPort();
    }

    @Override
    public void stopSut() {
        ctx.stop();
    }

    @Override
    public void resetStateOfSUT() {

    }

    protected int getSutPort() {
        return (Integer) ((Map) ctx.getEnvironment()
            .getPropertySources().get("server.ports").getSource())
            .get("local.server.port");
    }

    protected String getSwaggerJsonPath() {
        return ((Map) ctx.getEnvironment()
            .getPropertySources().get("applicationConfig: [classpath:/application.properties]").getSource())
            .get("springfox.documentation.swagger.v2.path").toString();
    }
}
