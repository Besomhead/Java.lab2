import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class ReadFile
{

    public ReadFile(File file, Controller controller)
    {
        booksFile = file;
        bookController = controller;
    }

    public Controller readFile()
    {
        try
        {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = null;
            Document document = null;
            try
            {
                dBuilder = dbFactory.newDocumentBuilder();
            } catch (ParserConfigurationException e)
            {
                e.printStackTrace();
            }
            try
            {
                if (dBuilder != null) {
                    document = dBuilder.parse(booksFile);
                }
            } catch (SAXException | IOException e)
            {
                e.printStackTrace();
            }

            if (document != null) {
                document.getDocumentElement().normalize();
            }
            NodeList nList = null;
            if (document != null) {
                nList = document.getElementsByTagName(XMLTagsConstants.BOOK_TAG);
            }

            assert nList != null;
            for(int docIndex = 0; docIndex < nList.getLength(); docIndex++)
            {
                Node nNode = nList.item(docIndex);

                if(nNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) nNode;

                    Book newBook = new Book( eElement.getElementsByTagName(XMLTagsConstants.BOOK_NAME_TAG).item(0).getTextContent(),
                            eElement.getElementsByTagName(XMLTagsConstants.AUTHOR_SURNAME_TAG).item(0).getTextContent(),
                            eElement.getElementsByTagName(XMLTagsConstants.AUTHOR_NAME_TAG).item(0).getTextContent(),
                            eElement.getElementsByTagName(XMLTagsConstants.AUTHOR_PATRONYMIC_TAG).item(0).getTextContent(),
                            eElement.getElementsByTagName(XMLTagsConstants.PUBLISHER_TAG).item(0).getTextContent(),
                            Integer.parseInt(eElement.getElementsByTagName(XMLTagsConstants.TOMES_TAG).item(0).getTextContent()),
                            Integer.parseInt(eElement.getElementsByTagName(XMLTagsConstants.CIRCULATION_TAG).item(0).getTextContent()));

                    bookController.addBook(newBook);
                }
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return bookController;
    }

    private Controller bookController;
    private File booksFile;
}
