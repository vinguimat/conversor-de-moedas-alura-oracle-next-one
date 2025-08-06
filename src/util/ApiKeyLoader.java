package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ApiKeyLoader {

    public static String carregarChave() {
        try {
            Properties props = new Properties();
            FileInputStream file = new FileInputStream("config.properties");
            props.load(file);
            String chave = props.getProperty("api.key");

            if (chave == null || chave.isBlank()) {
                throw new RuntimeException("API key não encontrada no arquivo config.properties.");
            }
            return chave;

        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar o arquivo config.properties: " + e.getMessage(), e);
        }
    }
}
