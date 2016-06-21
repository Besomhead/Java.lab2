import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class FindActionListener implements ActionListener
{
    public FindActionListener(Controller newController)
    {
        findController = newController;
    }

    public void actionPerformed(ActionEvent event)
    {
        if(Messages.noDataMessage(findController)) return;

        commonSearchPanel.removeAll();

        findDialog = new JDialog();
        findDialog.setTitle("Найти книгу");
        JPanel searchConditionsPanel = new JPanel(new BorderLayout());
        commonSearchPanel.setLayout(new BoxLayout(commonSearchPanel, BoxLayout.X_AXIS));

        findDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        findTabs = new SearchAndDeleteConditions();

        JButton searchButton = new JButton("Найти");
        searchButton.addActionListener(new SearchButtonActionListener());

        JPanel searchButtonsPanel = new JPanel(new FlowLayout());

        JButton cancelButton = new JButton("Выйти");
        cancelButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                findDialog.getContentPane().removeAll();
                findDialog.dispose();
                findDialog = null;
                commonSearchPanel.removeAll();
            }
        }
        );

        searchButtonsPanel.add(searchButton);
        searchButtonsPanel.add(cancelButton);

        searchConditionsPanel.add(findTabs, BorderLayout.NORTH);
        searchConditionsPanel.add(searchButtonsPanel, BorderLayout.SOUTH);

        commonSearchPanel.add(searchConditionsPanel);

        findDialog.add(commonSearchPanel);
        findDialog.pack();
        findDialog.setModal(true);
        findDialog.setVisible(true);
    }
    
    private class SearchButtonActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if (answerTable != null) commonSearchPanel.remove(answerTable);

            Searching searching = new Searching(findController, findTabs);

            List<Book> foundedBooks = searching.executeSearching();

            if (foundedBooks.isEmpty())
            {
                Messages.nothingFounded();
            }
            else createAnswerTable(foundedBooks);
        }
    }

    private void createAnswerTable(List<Book> answer)
    {
        Controller answerController = new Controller(answer);
        answerTable = new TableWithPages(answerController);
        commonSearchPanel.add(answerTable);
        answerTable.updateTable();
        findDialog.setResizable(true);
        findDialog.setSize(new Dimension(1250, 600));
        findDialog.revalidate();
        findDialog.repaint();
    }

    private JPanel commonSearchPanel = new JPanel();
    private TableWithPages answerTable;
    private JDialog findDialog;
    private Controller findController;
    private SearchAndDeleteConditions findTabs;
}
