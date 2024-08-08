package com.samsung;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

public class XML2Object {
    public static void main(String[] args) throws JsonProcessingException {
        //Read xml file in resource
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("person.xml");

        //Read content by use BufferedReader
        String xmlInString = new BufferedReader(new InputStreamReader(inputStream))
                .lines().collect(Collectors.joining("\n"));

        //Map XML to Object
        XmlMapper xmlMapper = new XmlMapper();
        List<Person> person = xmlMapper.readValue(xmlInString,
                new TypeReference<List<Person>>() {});

        System.out.println(person.get(1).firstName);
    }
}
