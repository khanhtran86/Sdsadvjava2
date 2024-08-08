package com.samsung;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Json2ListObject {
    public static void main(String[] args) {
        //1. Tạo Input stream từ class loader tới file json
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = loader.getResourceAsStream("datalist.json");

        //2. Tạo Gson sử dụng
        Gson gson = new Gson();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        //**//
        Type listPersonType = new TypeToken<List<Person>>() {
        }.getType();

        List<Person> person = gson.fromJson(reader, listPersonType);

        //3. su dung
        System.out.println(person.get(1).firstName + " " + person.get(1).lastName);
        System.out.println(person.get(1).phone);

        person.get(1).address.forEach((u) -> {
            System.out.println(u.streetName + "," + u.city);
        });
    }
}
