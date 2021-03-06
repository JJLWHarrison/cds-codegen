package au.org.consumerdatastandards.holder.util;

import au.org.consumerdatastandards.holder.model.BankingProductDetail;
import au.org.consumerdatastandards.holder.repository.BankingProductDetailsRepository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class CdsDataLoader {

    private BankingProductDetailsRepository productDetailsRepository;
    
    private static final Logger LOG = LogManager.getLogger(CdsDataLoader.class);


    @Autowired
    public CdsDataLoader(BankingProductDetailsRepository productDetailsRepository) {
        this.productDetailsRepository = productDetailsRepository;
    }

    public void loadProducts(String fileOrFolder) throws IOException {

        File file = new File(fileOrFolder);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File oneFile : files) {
                loadProducts(oneFile.getAbsolutePath());
            }
        } else {
            LOG.info("Reading {}", file.getAbsolutePath());
            byte[] jsonData;
            try {
                jsonData = Files.readAllBytes(Paths.get(file.getCanonicalPath()));
                ObjectMapper objectMapper = new ObjectMapper()
                    .registerModule(new ParameterNamesModule())
                    .registerModule(new Jdk8Module())
                    .registerModule(new JavaTimeModule());
                BankingProductDetail productDetail = objectMapper.readValue(jsonData, BankingProductDetail.class);

                productDetailsRepository.save(productDetail);

                LOG.info("Saved the following to database: \n{}", new String(jsonData));
            } catch (IOException e) {
                LOG.error("Failed to read: {}", file.getName());
                throw e;
            }
        }
    }
}
