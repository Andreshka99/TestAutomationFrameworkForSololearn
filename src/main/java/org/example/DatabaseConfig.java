package org.example;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class DatabaseConfig {
    private final String FILE_NAME = "dataBase.json";
    private ObjectMapper objectMapper;
    private Map<String, String> emailAndPasswords;

    public DatabaseConfig() {
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        TypeFactory typeFactory = objectMapper.getTypeFactory();
        MapType mapType = typeFactory.constructMapType(LinkedHashMap.class, String.class, String.class);

        try {
            File file = new File("src/main/resources/" + FILE_NAME);
            if (!file.exists()) {
                file.createNewFile();
                emailAndPasswords = new LinkedHashMap<>();
                objectMapper.writeValue(file, emailAndPasswords);
            } else {
                emailAndPasswords = objectMapper.readValue(file, mapType);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setEmailAndPassword(String email, String password) {
        emailAndPasswords.put(email, password);

        try {
            File file = new File("src/main/resources/" + FILE_NAME);
            objectMapper.writeValue(file, emailAndPasswords);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, String> getEmailAndPasswords() {
        return emailAndPasswords;
    }

    public String getLastEmail() {
        return emailAndPasswords.keySet().stream().reduce((first, second) -> second).orElse(null);
    }

    public String getLastPassword() {
        return emailAndPasswords.values().stream().reduce((first, second) -> second).orElse(null);
    }
}
