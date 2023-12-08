package Prac_Vs_ITVDN.JSON.gson;


import Prac_Vs_ITVDN.JSON.gson.parser.GsonParser;

import java.io.IOException;

public class MainGson {
    public static void main(String[] args) throws IOException {
        GsonParser.parseJson("https://www.cbr-xml-daily.ru/daily_json.js");
    }
}