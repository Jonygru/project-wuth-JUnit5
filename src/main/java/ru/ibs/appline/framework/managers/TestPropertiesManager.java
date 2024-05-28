package ru.ibs.appline.framework.managers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestPropertiesManager {

    private Properties properties = new Properties();

    private static TestPropertiesManager INSTANCE = null;
//Загрузка переменных пропертей
    private TestPropertiesManager() {
            loadApplicationProperties();
            loadCustomProperties();
    }

    private void loadApplicationProperties(){
        try {
            properties.load(new FileInputStream("src/main/resources/" +
                    System.getProperty("propFile","application") +  ".properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadCustomProperties(){
        properties.forEach((key, value)-> System.getProperties()
                .forEach((customUserKey, customUserValue) -> {
                    if (key.toString().equals(customUserKey.toString()) &&
                    !value.toString().equals(customUserValue.toString())) {
                        properties.setProperty(key.toString(), customUserValue.toString());
                    }
                }) );
    }

    //Паттерн singleton
    public static TestPropertiesManager getTestPropertiesManager() {
        if (INSTANCE == null) {
            INSTANCE = new TestPropertiesManager();
        }
        return INSTANCE;
    }

    public String getProperty(String key, String defaultValue){
        return properties.getProperty(key, defaultValue);
    }
    public String getProperty(String key){
        return properties.getProperty(key);
    }
}
