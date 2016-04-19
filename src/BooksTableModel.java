import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Arrays;

public class BooksTableModel extends AbstractTableModel
{
    public BooksTableModel()
    {
        booksData = new ArrayList<String[]>();
        for(int i = 0; i < booksData.size(); i++)
        {
            booksData.add(new String[getColumnCount()]);
        }
    }

    public int getColumnCount() {return columnCount;}

    public int getRowCount() {return booksData.size();}

    public String getColumnName(int column)
    {
        switch(column)
        {
            case 0: return "Название книги";
            case 1: return "ФИО автора";
            case 2: return "Издательство";
            case 3: return "Число томов";
            case 4: return "Тираж";
            case 5: return "Итого томов";
        }

        return "";
    }

    public Object getValueAt(int row, int column)
    {
        String[] curRow = booksData.get(row);

        return curRow[column];
    }

    public void addData(String[] row)
    {
        String[] newRow = new String[getColumnCount()];
        newRow = row;
        booksData.add(newRow);
    }

    public boolean findData(String[] toFind)
    {
        for (int i = 0; i < booksData.size(); i++)
        {
            boolean t = Arrays.equals(booksData.get(i), toFind);
            if(t) return true;
        }

        return false;
    }

    private int columnCount = 6;
    private ArrayList<String[]> booksData;
}
