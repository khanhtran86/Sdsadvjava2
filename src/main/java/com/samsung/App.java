package com.samsung;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        //get file path in resource folder
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String settingPath = classLoader.getResource("smtp.properties").getPath();

        //Sử dụng InputStream để đọc file
        InputStream fileInput = new FileInputStream(settingPath);

        //Sử dụng Properties để load file
        Properties settingProp = new Properties();
        settingProp.load(fileInput);

        String server = settingProp.getProperty("server");
        String port = settingProp.getProperty("port");
        String ssl = settingProp.getProperty("ssl");
        String user = settingProp.getProperty("user");

        System.out.println(server);

    }


}
