package Prac_Vs_ITVDN.JSON.jackson;

import Prac_Vs_ITVDN.JSON.jackson.parser.JacksonParser;

import java.io.IOException;

/**
 * Created by Yevhenii Tykhonov.
 */
public class MainJackson {
    public static void main(String[] args) throws IOException {
        JacksonParser.parseJson("https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5");
    }
}