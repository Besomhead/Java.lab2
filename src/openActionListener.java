import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class OpenActionListener implements ActionListener
{
    public OpenActionListener(Controller controller, JLabel label, TableWithPages table)
    {
        tableWithPages = table;
        openController = controller;
        recordsCountLabel = label;
    }

    public void actionPerformed(ActionEvent event)
    {
        JFileChooser openFileChooser = new JFileChooser("E:\\JavaProjects\\Java.lab2\\");
        FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("Файл XML", "xml");
        openFileChooser.setFileFilter(extensionFilter);

        int ret = openFileChooser.showDialog(null, "Открыть файл");
        if(ret == JFileChooser.APPROVE_OPTION)
        {
            File bookFile = openFileChooser.getSelectedFile();
            ReadFile readBooks = new ReadFile(bookFile, openController);
            openController = readBooks.readFile();
        }

        recordsCountLabel.setText("Всего записей: " + openController.getCount());
        tableWithPages.updateTable();
    }

    private Controller openController;
    private JLabel recordsCountLabel;
    private TableWithPages tableWithPages;
}
