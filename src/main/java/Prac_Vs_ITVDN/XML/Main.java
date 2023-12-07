package Prac_Vs_ITVDN.XML;


public class Main {

    public static void main(String[] args) {

        XMLParser xml = new XMLParser("src/main/java/Prac_Vs_ITVDN/XML/1.xml");
        String value = xml.get("catalog/book/author");
        System.out.println(value);

    }
}