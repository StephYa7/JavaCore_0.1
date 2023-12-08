package Prac_Vs_ITVDN.JSON.json.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import Prac_Vs_ITVDN.JSON.json.entity.Person;

import java.io.File;
import java.io.IOException;

/**
 * Created by Yevhenii Tykhonov.
 */
public class JacksonDataBind {
    public static void parseJson(String path) {
        ObjectMapper objectMapper = new ObjectMapper();

        Person person = null;

        try {
            person = objectMapper.readValue(new File(path), Person.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(person);
    }
}