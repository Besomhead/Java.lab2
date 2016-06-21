import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.runtime.JSType.isNumber;

public class Controller
{
    public Controller()
    {
        books = new ArrayList<>();
        booksTableModel = new BooksTableModel();
    }

    public Controller(List<Book> booksData)
    {
        books = booksData;
        booksTableModel = new BooksTableModel(booksData);
    }

    public BooksTableModel getTableModel()
    {
        return booksTableModel;
    }

    public boolean addBook(Book newBook)
    {
        if(findBook(newBook)) return false;
        books.add(newBook);
        booksTableModel.renewData(books);
        booksTableModel.fireTableDataChanged();
        return true;
    }

    public boolean findBook(Book toFind)
    {
        for (int bookIndex = 0; bookIndex < books.size(); bookIndex++)
            if (books.get(bookIndex).equals(toFind)) return true;

        return false;
    }

    public List<Book> findByFIO(Book toFind)
    {
        List<Book> result = new ArrayList<>();

        for(int bookIndex = 0; bookIndex < books.size(); bookIndex++)
            if(books.get(bookIndex).isAuthorEquals(toFind)) result.add(books.get(bookIndex));

        return result;
    }

    public List<Book> findByFIOAndPublisher(Book toFind)
    {
        List<Book> result = new ArrayList<>();

        for(int bookIndex = 0; bookIndex < books.size(); bookIndex++)
            if(books.get(bookIndex).isAuthorEquals(toFind)
                    && books.get(bookIndex).isPublisherEquals(toFind)) result.add(books.get(bookIndex));

        return result;
    }

    public List<Book> findByFIOAndTomes(Book toFind, int from, int to)
    {
        List<Book> result = new ArrayList<>();

        for(int bookIndex = 0; bookIndex < books.size(); bookIndex++)
            if(books.get(bookIndex).isAuthorEquals(toFind)
                    && (books.get(bookIndex).getTomesCount() >= from)
                    && (books.get(bookIndex).getTomesCount() <= to)) result.add(books.get(bookIndex));

        return result;
    }

    public List<Book> findByBookName(Book toFind)
    {
        List<Book> result = new ArrayList<>();

        for(int bookIndex = 0; bookIndex < books.size(); bookIndex++)
            if(books.get(bookIndex).isNameEquals(toFind)) result.add(books.get(bookIndex));

        return result;
    }

    public List<Book> findByCirculation(int less, int more)
    {
        List<Book> result = new ArrayList<>();

        for(int bookIndex = 0; bookIndex < books.size(); bookIndex++)
        if((less != -1) && (books.get(bookIndex).getCirculation() < less)) result.add(books.get(bookIndex));
        else
            if((more != -1) && (books.get(bookIndex).getCirculation() > more)) result.add(books.get(bookIndex));

        return result;
    }

    public List<Book> findByAllTomes(int less, int more)
    {
        List<Book> result = new ArrayList<>();

        for(int bookIndex = 0; bookIndex < books.size(); bookIndex++)
            if((less != -1) && (books.get(bookIndex).getAllTomes() < less)) result.add(books.get(bookIndex));
            else
                if((more != -1) && (books.get(bookIndex).getAllTomes() > more)) result.add(books.get(bookIndex));

        return result;
    }

    public Book getBook(int pos)
    {
        return books.get(pos);
    }

    public int getCount()
    {
        return books.size();
    }

    public void pageDown()
    {
        if(current < pageCount)
        {
            List<Book> newBooksData = new ArrayList<>(books.subList((current - 1) * visibleSize, current * visibleSize));

            booksTableModel.renewData(newBooksData);
            booksTableModel.fireTableDataChanged();

            current++;
        }
        else
            if(current == pageCount) lastPage();
    }

public void pageUp()
    {
        if(current > 2)
        {
            List<Book> newBooksData = new ArrayList<>(books.subList((current - 2) * visibleSize, (current - 1) * visibleSize));

            booksTableModel.renewData(newBooksData);
            booksTableModel.fireTableDataChanged();

            current--;
        }
        else firstPage();
    }

    public void firstPage()
    {
        List<Book> newBooksData = new ArrayList<>(books.subList(0, visibleSize));

        booksTableModel.renewData(newBooksData);
        booksTableModel.fireTableDataChanged();

        current = 2;
    }

    public void lastPage()
    {
        current = pageCount;

        List<Book> newBooksData;

        if(rest == 0)
            newBooksData = new ArrayList<>(books.subList(getCount() - visibleSize, getCount()));
        else
            newBooksData = new ArrayList<>(books.subList(getCount() - rest, getCount()));

        booksTableModel.renewData(newBooksData);
        booksTableModel.fireTableDataChanged();
    }

    public int getPagesCount()
    {
        return pageCount;
    }

    public int getVisibleSize()
    {
        return visibleSize;
    }

    public void setVisibleSize(int recordsOnPage)
    {
        current = 1;
        this.visibleSize = recordsOnPage;
        this.pageCount = getCount() / this.visibleSize;
        this.rest = getCount() % this.visibleSize;
        if (this.rest != 0) this.pageCount++;
    }

    public boolean isDataCorrect(String bName, String aLN, String aFN, String aP, String pName, String tomes, String circulation)
    {
        bName = bName.trim();
        aLN = aLN.trim();
        aFN = aFN.trim();
        aP = aP.trim();
        pName = pName.trim();
        tomes = tomes.trim();
        circulation = circulation.trim();

        return (!bName.isEmpty() && (bName.length() > 0)
                && !aLN.isEmpty() && (aLN.length() > 0)
                && !aFN.isEmpty() && (aFN.length() > 0)
                && !pName.isEmpty() && (pName.length() > 0)
                && isNumber(tomes) && isNumber(circulation));
    }

    public void deleteBooks(List<Book> toDelete)
    {
        for(int deleteIndex = 0; deleteIndex < toDelete.size(); deleteIndex++)
        for(int bookIndex = 0; bookIndex < books.size(); bookIndex++)
            if(toDelete.get(deleteIndex).equals(books.get(bookIndex))) books.remove(bookIndex);

        booksTableModel.renewData(books);
        booksTableModel.fireTableDataChanged();
    }

    private List<Book> books;
    private BooksTableModel booksTableModel;
    private int visibleSize = 1;
    private int pageCount = 1;
    private int rest;
    private int current = 1;
}
