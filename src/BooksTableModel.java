import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class BooksTableModel extends AbstractTableModel
{
    public BooksTableModel()
    {
        booksData = new ArrayList<>();
    }

    public BooksTableModel(List<Book> data)
    {
        booksData = data;
    }

    public int getColumnCount() {return BOOK_COLUMN_COUNT;}

    public int getRowCount() {return booksData.size();}

    public String getColumnName(int column)
    {
        switch(column)
        {
            case BOOK_NAME_COL: return "Название книги";
            case BOOK_AUTHOR_COL: return "ФИО автора";
            case BOOK_PUBLISHER_COL: return "Издательство";
            case BOOK_TOMES_COL: return "Число томов";
            case BOOK_CIRCULATION_COL: return "Тираж";
            case BOOK_ALL_TOMES_COL: return "Итого томов";
        }

        return "";
    }

    public Object getValueAt(int row, int column)
    {
        Book curBook = booksData.get(row);

        switch(column)
        {
            case BOOK_NAME_COL: return curBook.getName();
            case BOOK_AUTHOR_COL: return curBook.getAuthorSurname() + " " + curBook.getAuthorName() + " " + curBook.getAuthorPatronymic();
            case BOOK_PUBLISHER_COL: return curBook.getPublisher();
            case BOOK_TOMES_COL: return curBook.getTomesCount();
            case BOOK_CIRCULATION_COL: return curBook.getCirculation();
            case BOOK_ALL_TOMES_COL: return curBook.getAllTomes();
        }

        return "";
    }

    public void setValueAt(Object value, int row, int column)
    {
        Book curBook = booksData.get(row);

        switch(column)
        {
            case BOOK_NAME_COL: curBook.setName((String) value);
            case BOOK_AUTHOR_COL:
            {
                String[] author = ((String)value).split(" ");
                curBook.setAuthor(author[0], author[1], author[2]);
            }
            case BOOK_PUBLISHER_COL: curBook.setPublisher((String) value);
            case BOOK_TOMES_COL: curBook.setTomesCount((int) value);
            case BOOK_CIRCULATION_COL: curBook.setCirculation((int) value);
            case BOOK_ALL_TOMES_COL: curBook.setAllTomes((int) value);
        }
        fireTableCellUpdated(row, column);
    }

    public Class getColumnClass(int column)
    {
        return getValueAt(0, column).getClass();
    }

    public void renewData(List<Book> newData)
    {
        booksData = newData;
        fireTableDataChanged();
    }

    private static final int BOOK_NAME_COL = 0;
    private static final int BOOK_AUTHOR_COL = 1;
    private static final int BOOK_PUBLISHER_COL = 2;
    private static final int BOOK_TOMES_COL = 3;
    private static final int BOOK_CIRCULATION_COL = 4;
    private static final int BOOK_ALL_TOMES_COL = 5;
    private static final int BOOK_COLUMN_COUNT = 6;
    private List<Book> booksData;
}