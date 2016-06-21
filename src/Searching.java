import java.util.ArrayList;
import java.util.List;

public class Searching
{
    public Searching(Controller controller, SearchAndDeleteConditions conditions)
    {
        searchingController = controller;
        searchingConditions = conditions;
    }

    public List<Book> executeSearching()
    {
        switch(searchingConditions.tabs.getSelectedIndex())
        {
            case 0: return byFIO();
            case 1: return byFIOAndPublisher();
            case 2: return byFIOAndTomes();
            case 3: return byBookName();
            case 4: return byCirculation();
            case 5: return byAllTomes();
        }

        return null;
    }

    private List<Book> byFIO()
    {
        Book findBook = new Book();

        findBook.setAuthor(searchingConditions.textSurname.getText(), searchingConditions.textName.getText(), searchingConditions.textPatronymic.getText());

        return searchingController.findByFIO(findBook);
    }

    private List<Book> byFIOAndPublisher()
    {
        Book findBook = new Book();

        findBook.setAuthor(searchingConditions.textSurname2.getText(), searchingConditions.textName2.getText(), searchingConditions.textPatronymic2.getText());
        findBook.setPublisher(searchingConditions.textPublisher.getText());

        return searchingController.findByFIOAndPublisher(findBook);
    }

    private List<Book> byFIOAndTomes()
    {
        Book findBook = new Book();

        findBook.setAuthor(searchingConditions.textSurname3.getText(), searchingConditions.textName3.getText(), searchingConditions.textPatronymic3.getText());

        return searchingController.findByFIOAndTomes(findBook,
                Integer.parseInt(searchingConditions.textTomesFrom.getText()), Integer.parseInt(searchingConditions.textTomesTo.getText()));
    }

    private List<Book> byBookName()
    {
        Book findBook = new Book();

        findBook.setName(searchingConditions.textBookName.getText());

        return searchingController.findByBookName(findBook);
    }

    private List<Book> byCirculation()
    {
        List<Book> founded = new ArrayList<>();

        if(searchingConditions.lessCirculation.isSelected())
            founded = searchingController.findByCirculation(Integer.parseInt(searchingConditions.textCirculation.getText()), -1);
        else
        if(searchingConditions.moreCirculation.isSelected())
            founded = searchingController.findByCirculation(-1, Integer.parseInt(searchingConditions.textCirculation.getText()));

        return founded;
    }

    private List<Book> byAllTomes()
    {
        List<Book> founded = new ArrayList<>();

        if(searchingConditions.lessAllTomes.isSelected())
            founded = searchingController.findByAllTomes(Integer.parseInt(searchingConditions.textAllTomes.getText()), -1);
        else
        if(searchingConditions.moreAllTomes.isSelected())
            founded = searchingController.findByAllTomes(-1, Integer.parseInt(searchingConditions.textAllTomes.getText()));

        return founded;
    }

    private Controller searchingController;
    private SearchAndDeleteConditions searchingConditions;
}
