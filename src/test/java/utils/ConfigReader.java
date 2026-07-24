package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

        private static Properties properties;


        public static void loadProperties() {

            properties = new Properties();

            try {

                FileInputStream fis =
                        new FileInputStream(
                                "C://Users//MythiliB//IdeaProjects//IVIS_SAAS//src//test//java//resources//config//config.properties");

                properties.load(fis);

            } catch (IOException e) {

                throw new RuntimeException(
                        "Unable to load config file"
                );
            }
        }


        public static String get(String key){

            return properties.getProperty(key);

        }
    }

