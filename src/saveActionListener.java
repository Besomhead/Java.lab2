import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SaveActionListener implements ActionListener
{
    public SaveActionListener(Controller controller)
    {
        saveController = controller;
    }

    public void actionPerformed(ActionEvent event)
    {
        if(Messages.noDataMessage(saveController)) return;

        int fl = 0;
        int ret = 0;

        while((fl == 0) && (ret != JFileChooser.CANCEL_OPTION))
        {
            JFileChooser saveFileChooser = new JFileChooser("E:\\JavaProjects\\Java.lab2\\");
            FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("Файл XML", "xml");
            saveFileChooser.setFileFilter(extensionFilter);

            ret = saveFileChooser.showSaveDialog(null);
            if (ret == JFileChooser.APPROVE_OPTION) {
                File saveFile = saveFileChooser.getSelectedFile();
                if (saveFile.exists()) {
                    int exist = JOptionPane.showConfirmDialog(saveFileChooser,
                            "Файл с таким именем уже существует. Заменить?", "", JOptionPane.YES_NO_OPTION);
                    if (exist == JOptionPane.YES_OPTION) {
                        SaveFile saveBooks = new SaveFile(saveFile, saveController);
                        saveBooks.saveFile();
                        fl = 1;
                    } else if (exist == JOptionPane.NO_OPTION) fl = 0;
                }
                else
                {
                    SaveFile saveBooks = new SaveFile(saveFile, saveController);
                    saveBooks.saveFile();
                    fl = 1;
                }
            }
        }
    }

    private Controller saveController;
}
