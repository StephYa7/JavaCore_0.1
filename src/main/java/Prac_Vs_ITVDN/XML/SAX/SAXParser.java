package Prac_Vs_ITVDN.XML.SAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParserFactory;

public class SAXParser {
    public static void main(String args[]) {
        // Имя файла
        final String fileName = "src/main/java/Prac_Vs_ITVDN/XML/SAX/phonebook.xml";
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            javax.xml.parsers.SAXParser saxParser = factory.newSAXParser();
            // Здесь мы определили анонимный класс, расширяющий класс DefaultHandler
            DefaultHandler handler = new DefaultHandler() {
                // Поле для указания, что тэг name начался
                boolean name = false;
                boolean email = false;

                // Метод вызывается, когда SAXParser "натыкается" на начало тэга
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    // Если тэг имеет имя name, то мы этот момент отмечаем - начался тэг name
                    if (qName.equalsIgnoreCase("name")) {
                        name = true;
                    } else if (qName.equalsIgnoreCase("email")) {
                        email = true;
                    }
                }

                // Метод вызывается, когда SAXParser считывает текст между тэгами
                @Override
                public void characters(char ch[], int start, int length) throws SAXException {
                    // Если перед этим мы отметили, что имя тэга name - значит нам надо текст использовать.
                    if (name) {
                        System.out.println("Name: " + new String(ch, start, length));
                        name = false;
                    } else if (email) {
                        System.out.println("Email: " + new String(ch, start, length));
                        email = false;
                    }
                }
            };
            saxParser.parse(fileName, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}