import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class DeleteActionListener implements ActionListener
{
    public DeleteActionListener(Controller newController, JLabel allRecordsLabel, TableWithPages table)
    {
        tableWithPages = table;
        deleteController = newController;
        recordsLabel = allRecordsLabel;
    }

    public void actionPerformed(ActionEvent event)
    {
        if(Messages.noDataMessage(deleteController)) return;

        deleteDialog = new JDialog();
        deleteDialog.setTitle("Удалить книгу");
        JPanel deleteConditionsPanel = new JPanel(new BorderLayout());

        deleteDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        deleteTabs = new SearchAndDeleteConditions();

        JButton deleteButton = new JButton("Удалить");
        deleteButton.addActionListener(new DeleteButtonActionListener());

        deleteConditionsPanel.add(deleteTabs, BorderLayout.NORTH);
        deleteConditionsPanel.add(deleteButton, BorderLayout.SOUTH);

        deleteDialog.add(deleteConditionsPanel);
        deleteDialog.pack();
        deleteDialog.setModal(true);
        deleteDialog.setVisible(true);
    }

    private class DeleteButtonActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            Searching searching = new Searching(deleteController, deleteTabs);
            List<Book> foundedBooks = searching.executeSearching();

            if (foundedBooks.isEmpty())
            {
                Messages.nothingFounded();
            }
            else
            {
                int before = deleteController.getCount();

                deleteController.deleteBooks(foundedBooks);

                JOptionPane.showMessageDialog(deleteDialog,
                        "Удалено: " + (before - deleteController.getCount()), "", JOptionPane.INFORMATION_MESSAGE);

                deleteDialog.dispose();

                recordsLabel.setText("Всего записей: " + deleteController.getCount());
                tableWithPages.updateTable();
            }
        }
    }

    private JDialog deleteDialog;
    private Controller deleteController;
    private SearchAndDeleteConditions deleteTabs;
    private JLabel recordsLabel = new JLabel();
    private TableWithPages tableWithPages;
}
