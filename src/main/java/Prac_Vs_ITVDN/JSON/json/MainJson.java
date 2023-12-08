package Prac_Vs_ITVDN.JSON.json;

import Prac_Vs_ITVDN.JSON.json.parser.JacksonDataBind;

/**
 * Created by Yevhenii Tykhonov.
 */
public class MainJson {
    public static void main(String[] args) {
        JacksonDataBind.parseJson
                ("D:\\PR\\Java\\JavaCore_0.1\\src\\main\\resources\\person.json");
    }
}