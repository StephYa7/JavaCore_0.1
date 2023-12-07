package Prac_Vs_ITVDN.XML._HandwrittenXMLParser;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

public class XMLParser {
    private String xml;

    public String getXml() {
        return xml;
    }

    public XMLParser(String path) {
        byte[] buf = null;
        try (RandomAccessFile file = new RandomAccessFile(path, "r")) {
            buf = new byte[(int) file.length()];
            file.read(buf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            xml = new String(buf, "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }


    // Метод определения "catalog/book/author"
    public String get(String inputTeg) {
        // Разбиваем /
        String[] parts = inputTeg.split("/");
        String s_xml = xml;

        for (String s : parts) {
            String toFind = "<" + s + ">";
            // start начинается с 1 символа найденного тега
            int start = s_xml.indexOf(toFind);
            if (start < 0) {
                return null;
            } else {
                start += toFind.length();
            }

            // Находим закрывающийся тег
            int end = s_xml.lastIndexOf("</" + s + ">");
            if (end < 0) {
                return null;
            }
            // Вырезаем найденную строку
            s_xml = s_xml.substring(start, end);
        }

        return s_xml;
    }
    
}