package au.org.consumerdatastandards;

import org.evomaster.client.java.controller.EmbeddedSutController;
import org.evomaster.client.java.controller.InstrumentedSutStarter;
import org.evomaster.client.java.controller.api.dto.AuthenticationDto;
import org.evomaster.client.java.controller.api.dto.SutInfoDto;
import org.evomaster.client.java.controller.problem.ProblemInfo;
import org.evomaster.client.java.controller.problem.RestProblem;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class EmbeddedEvoMasterController extends EmbeddedSutController {

    public static void main(String[] args) {

        EmbeddedEvoMasterController controller = new EmbeddedEvoMasterController();
        InstrumentedSutStarter starter = new InstrumentedSutStarter(controller);

        starter.start();
    }


    private ConfigurableApplicationContext ctx;


    @Override
    public String startSut() {

        ctx = SpringApplication.run(BankingProductsApplication.class);
        return "http://localhost:" + getSutPort();
    }

    private int getSutPort() {
        return (Integer) ((Map) ctx.getEnvironment()
            .getPropertySources().get("server.ports").getSource())
            .get("local.server.port");
    }


    @Override
    public boolean isSutRunning() {
        return ctx != null && ctx.isRunning();
    }

    @Override
    public void stopSut() {
        ctx.stop();
    }

    @Override
    public String getPackagePrefixesToCover() {
        return "au.org.consumerdatastandards.api";
    }

    @Override
    public void resetStateOfSUT() {
    }

    @Override
    public List<AuthenticationDto> getInfoForAuthentication() {
        return null;
    }

    public Connection getConnection() {
        return null;
    }

    @Override
    public String getDatabaseDriverName() {
        return null;
    }

    @Override
    public ProblemInfo getProblemInfo() {
        return new RestProblem(
            "http://localhost:" + getSutPort() + getSwaggerJsonPath(),
            null
        );
    }

    @Override
    public SutInfoDto.OutputFormat getPreferredOutputFormat() {
        return SutInfoDto.OutputFormat.JAVA_JUNIT_5;
    }

    private Map getSource(String s) {
        return (Map) ctx.getEnvironment().getPropertySources().get(s).getSource();
    }

    private String getSwaggerJsonPath() {
        return getSource("applicationConfig: [classpath:/application.properties]")
            .get("springfox.documentation.swagger.v2.path").toString();
    }
}
