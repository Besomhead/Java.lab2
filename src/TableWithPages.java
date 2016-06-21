import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TableWithPages extends JPanel
{
    public TableWithPages(Controller controller)
    {
        super();
        tableController = controller;
        createTable();
    }

    private void createTable()
    {
        booksTable = new JTable(tableController.getTableModel());
        booksScroll = new JScrollPane(booksTable);

        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new GridBagLayout());

        booksTable.setRowSelectionAllowed(true);
        booksTable.setColumnSelectionAllowed(true);

        JButton firstPageButton = new JButton("1");
        JButton lastPageButton = new JButton("n");
        JButton previousPageButton = new JButton("<<");
        JButton nextPageButton = new JButton(">>");

        firstPageButton.setPreferredSize(new Dimension(50, 20));
        previousPageButton.setPreferredSize(new Dimension(50, 20));
        nextPageButton.setPreferredSize(new Dimension(50, 20));
        lastPageButton.setPreferredSize(new Dimension(50, 20));

        recordsOnPageText.setText("0");

        recordsOnPageText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent event)
            {
                if (event.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    if ((Integer.parseInt(recordsOnPageText.getText()) > tableController.getCount())
                            || (Integer.parseInt(recordsOnPageText.getText()) <= 0))  Messages.incorrectData();
                    else
                    {
                        tableController.setVisibleSize(Integer.parseInt(recordsOnPageText.getText()));
                        tableController.firstPage();
                        lastPageButton.setText(String.valueOf(tableController.getPagesCount()));
                    }
                }
            }
        });

        nextPageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event)
            {
                tableController.pageDown();
            }
        });

        previousPageButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                tableController.pageUp();
            }
        });

        firstPageButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                tableController.firstPage();
            }
        });

        lastPageButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                tableController.lastPage();
            }
        });

        lastPageButton.setText(String.valueOf(tableController.getPagesCount()));
        recordsOnPageText.setText(String.valueOf(
                tableController.getTableModel().getRowCount()));
        recordsCountLabel.setText("Всего записей: " + tableController.getTableModel().getRowCount());

        JPanel pageButtonsPanel = new JPanel(new FlowLayout());

        pageButtonsPanel.add(firstPageButton);
        pageButtonsPanel.add(previousPageButton);
        pageButtonsPanel.add(nextPageButton);
        pageButtonsPanel.add(lastPageButton);

        JPanel recordsOnPagePanel = new JPanel(new FlowLayout());
        recordsOnPagePanel.add(recordsOnPageLabel);
        recordsOnPagePanel.add(recordsOnPageText);

        JPanel pagesPanel = new JPanel(new FlowLayout());
        pagesPanel.add(recordsCountLabel);
        pagesPanel.add(recordsOnPagePanel);
        pagesPanel.add(pageButtonsPanel);

        pagesPanel.setSize(booksScroll.getSize());

        tablePanel.add(booksScroll,
                new GridBagConstraints(0, GridBagConstraints.RELATIVE, GridBagConstraints.REMAINDER, GridBagConstraints.RELATIVE, 10, 10,
                        GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                        new Insets(2, 2, 2, 2), 0, 0));
        tablePanel.add(pagesPanel,
                new GridBagConstraints(0, 500, 1, 1, 0, 0,
                        GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                        new Insets(2, 2, 2, 2), 0, 0));
        add(tablePanel);
    }
    
    public JLabel getRecordsCountLabel()
    {
        return recordsCountLabel;
    }

    public void updateTable()
    {
        booksTable.revalidate();
        booksTable.repaint();
        booksScroll.revalidate();
        booksScroll.repaint();
        removeAll();
        createTable();
        revalidate();
        repaint();
    }

    private JLabel recordsOnPageLabel = new JLabel("Записей на странице:");
    private JLabel recordsCountLabel = new JLabel("Всего записей: 0");
    private JTextField recordsOnPageText = new JTextField(3);
    private Controller tableController = new Controller();
    private JTable booksTable;
    private JScrollPane booksScroll;
}
