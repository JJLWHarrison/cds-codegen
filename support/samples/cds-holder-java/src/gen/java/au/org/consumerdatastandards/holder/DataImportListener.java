package au.org.consumerdatastandards.holder;

import au.org.consumerdatastandards.models.BankingProduct;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@WebListener
public class DataImportListener implements ServletContextListener {
    private static Logger LOG = LoggerFactory.getLogger(DataImportListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOG.info("Data Import Listener initialised");
        
        File folder = new File("payloads/products");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                byte[] jsonData;
                try {
                    jsonData = Files.readAllBytes(Paths.get(file.getCanonicalPath()));
                    ObjectMapper objectMapper = new ObjectMapper();
                    BankingProduct oneProduct = objectMapper.readValue(jsonData, BankingProduct.class);
                    
                    Session session = DB.getSessionFactory().openSession();
                    session.beginTransaction();
                    session.save(oneProduct);
                    session.getTransaction().commit();
                    
                    LOG.info("Injected Banking Product named: %s", oneProduct.getName());

                } catch (IOException e) {
                    LOG.error("Attempted to read %s and failed", file.getName());
                }
            }
        }
    }
}
