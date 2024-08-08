package com.samsung;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Object2Json {
    public static void main(String[] args) throws IOException {
        Person person = new Person();
        person.firstName = "Alexander";
        person.lastName = "Dai De";
        person.phone = "091111111";

        Address address = new Address();
        address.streetName = "Duy Tan";
        address.city = "Ha noi";

        person.address = Arrays.asList(address);

        Gson gson = new Gson();
        String strJson = gson.toJson(person);

        String path = "src/main/resources";
        File file = new File(path);
        String jsonPath = file.getAbsolutePath();

        FileWriter fw = new FileWriter(jsonPath + "\\data.json", true);
        fw.write(strJson);
        fw.close();
    }
}
