package Prac_Vs_ITVDN.JSON.gson;


import Prac_Vs_ITVDN.JSON.gson.parser.GsonParser;

import java.io.IOException;

/**
 * Created by Yevhenii Tykhonov.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        GsonParser.parseJson("https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5");
    }
}