package Prac_Vs_ITVDN.XML.DOM;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLMakersDOM {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.newDocument();

            Element rootElement = doc.createElement("catalog");
            doc.appendChild(rootElement);


            for (int i = 0; i < 10; i++) {
                Element book1 = doc.createElement("book" + i);
                rootElement.appendChild(book1);

                Element author1 = doc.createElement("author" +i);
                author1.setTextContent("Author " +i);
                book1.appendChild(author1);
            }


            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult sr = new StreamResult(new File("D:\\PR\\Java\\JavaCore_0.1\\" +
                    "src\\main\\java\\Prac_Vs_ITVDN\\XML\\fromXMLMakersDOM.xml"));

            t.transform(source, sr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}