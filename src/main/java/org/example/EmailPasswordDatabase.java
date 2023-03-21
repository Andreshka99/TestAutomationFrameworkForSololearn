package org.example;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class EmailPasswordDatabase {
    private static final String DATA_FILE_PATH = "C:\\Users\\Андрей\\Desktop\\QA Automation\\cloud\\dataBase.txt";
    private LinkedHashMap<String, String> emailPasswordMap;

    public EmailPasswordDatabase() {
        emailPasswordMap = new LinkedHashMap<>();
        readDataFromFile();
    }

    public boolean addEmailAndPassword(String email, String password) {
        if (emailPasswordMap.containsKey(email)) {
            return false;
        } else {
            emailPasswordMap.put(email, password);
            saveDataToFile();
            return true;
        }
    }

    public boolean removeEmailAndPassword(String email) {
        if (emailPasswordMap.containsKey(email)) {
            emailPasswordMap.remove(email);
            saveDataToFile();
            return true;
        } else {
            return false;
        }
    }

    public String getPasswordByEmail(String email) {
        return emailPasswordMap.get(email);
    }

    public boolean containsEmail(String email) {
        return emailPasswordMap.containsKey(email);
    }

    public String getLastEmail() {
        if (emailPasswordMap.isEmpty()) {
            return null;
        } else {
            return emailPasswordMap.keySet().toArray(new String[0])[emailPasswordMap.size() - 1];
        }
    }

    public String getLastPassword() {
        if (emailPasswordMap.isEmpty()) {
            return null;
        } else {
            String lastEmail = getLastEmail();
            return emailPasswordMap.get(lastEmail);
        }
    }

    private void readDataFromFile() {
        File dataFile = new File(DATA_FILE_PATH);
        if (dataFile.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(dataFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(":");
                    emailPasswordMap.put(parts[0], parts[1]);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveDataToFile() {
        File dataFile = new File(DATA_FILE_PATH);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dataFile))) {
            for (String email : emailPasswordMap.keySet()) {
                String line = email + ":" + emailPasswordMap.get(email);
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
