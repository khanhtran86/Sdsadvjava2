package com.samsung;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Json2Object {
    public static void main(String[] args) {
        //1. Tạo Input stream từ class loader tới file json
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = loader.getResourceAsStream("data.json");

        //2. Tạo Gson sử dụng
        Gson gson = new Gson();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        Person person = gson.fromJson(reader, Person.class);

        //3. su dung
        System.out.println(person.firstName + " "+ person.lastName);
        System.out.println(person.phone);

        person.address.forEach((u)->{
            System.out.println(u.streetName + ","+ u.city);
        });
    }
}
