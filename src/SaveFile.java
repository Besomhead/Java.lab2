import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class SaveFile
{
    public SaveFile(File file, Controller controller)
    {
        saveController = controller;
        saveBooksFile = file;
    }

    public void saveFile()
    {
        paramLangXML();
        writeParamXML();
    }

    private void paramLangXML()
    {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            builder = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    private void writeParamXML()
    {
        Document document = builder.newDocument();

        Element rootElement = document.createElement(XMLTagsConstants.BOOKS_TAG);

        for(int bookIndex = 0; bookIndex < saveController.getCount(); bookIndex++)

        {
            Element bookElement = document.createElement(XMLTagsConstants.BOOK_TAG);

            Element nameElementTitle = document.createElement(XMLTagsConstants.BOOK_NAME_TAG);
            nameElementTitle.appendChild(document.createTextNode(saveController.getBook(bookIndex).getName()));
            bookElement.appendChild(nameElementTitle);

            Element authorSurnameElementTitle = document.createElement(XMLTagsConstants.AUTHOR_SURNAME_TAG);
            authorSurnameElementTitle.appendChild(document.createTextNode(saveController.getBook(bookIndex).getAuthorSurname()));
            bookElement.appendChild(authorSurnameElementTitle);

            Element authorNameElementTitle = document.createElement(XMLTagsConstants.AUTHOR_NAME_TAG);
            authorNameElementTitle.appendChild(document.createTextNode(saveController.getBook(bookIndex).getAuthorName()));
            bookElement.appendChild(authorNameElementTitle);

            Element authorPatronymicElementTitle = document.createElement(XMLTagsConstants.AUTHOR_PATRONYMIC_TAG);
            authorPatronymicElementTitle.appendChild(document.createTextNode(saveController.getBook(bookIndex).getAuthorPatronymic()));
            bookElement.appendChild(authorPatronymicElementTitle);

            Element publisherElementTitle = document.createElement(XMLTagsConstants.PUBLISHER_TAG);
            publisherElementTitle.appendChild(document.createTextNode(saveController.getBook(bookIndex).getPublisher()));
            bookElement.appendChild(publisherElementTitle);

            Element tomesElementTitle = document.createElement(XMLTagsConstants.TOMES_TAG);
            tomesElementTitle.appendChild(document.createTextNode(String.valueOf(saveController.getBook(bookIndex).getTomesCount())));
            bookElement.appendChild(tomesElementTitle);

            Element circulationElementTitle = document.createElement(XMLTagsConstants.CIRCULATION_TAG);
            circulationElementTitle.appendChild(document.createTextNode(String.valueOf(saveController.getBook(bookIndex).getCirculation())));
            bookElement.appendChild(circulationElementTitle);

            rootElement.appendChild(bookElement);
        }

        document.appendChild(rootElement);

        Transformer t = null;

        try {
            t = TransformerFactory.newInstance().newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }

        try {
            if (t != null) {
                if(!saveBooksFile.getName().contains(FILE_EXTENSION))
                t.transform(new DOMSource(document), new StreamResult(new FileOutputStream(saveBooksFile.getName() + FILE_EXTENSION)));
                else t.transform(new DOMSource(document), new StreamResult(new FileOutputStream(saveBooksFile.getName())));
            }
        } catch (TransformerException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Controller saveController;
    private DocumentBuilder builder;
    private File saveBooksFile;
    private static final String FILE_EXTENSION = ".xml";
}
