import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkSpace
{
    public void CreateWorkSpace()
    {
        booksFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        booksFrame.setLayout(new GridBagLayout());

        addButton.setPreferredSize(new Dimension(30, 30));
        deleteButton.setPreferredSize(new Dimension(30, 30));
        findButton.setPreferredSize(new Dimension(30, 30));
        openButton.setPreferredSize(new Dimension(30, 30));
        saveButton.setPreferredSize(new Dimension(30, 30));

        firstPageButton.setPreferredSize(new Dimension(50, 20));
        previousPageButton.setPreferredSize(new Dimension(50, 20));
        nextPageButton.setPreferredSize(new Dimension(50, 20));
        lastPageButton.setPreferredSize(new Dimension(50, 20));

        recordsOnPageText.setText("0");

        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);

        editMenu.add(addMenuItem);
        editMenu.add(deleteMenuItem);
        editMenu.add(findMenuItem);

        menu.add(fileMenu);
        menu.add(editMenu);

        addButton.addActionListener(new addActionListener());
        addMenuItem.addActionListener(new addActionListener());

        booksFrame.add(addButton,
                new GridBagConstraints(GridBagConstraints.LINE_START, 10, 1, 1, 0, 0,
                        GridBagConstraints.NORTH, GridBagConstraints.NONE,
                        new Insets(2, 2, 2, 2), 0, 0));
        booksFrame.add(deleteButton,
                new GridBagConstraints(GridBagConstraints.RELATIVE, 10, 1, 1, 0, 0,
                        GridBagConstraints.NORTH, GridBagConstraints.NONE,
                        new Insets(2, 2, 2, 2), 0, 0));
        booksFrame.add(findButton,
                new GridBagConstraints(GridBagConstraints.RELATIVE, 10, 1, 1, 0, 0,
                        GridBagConstraints.NORTH, GridBagConstraints.NONE,
                        new Insets(2, 2, 2, 2), 0, 0));
        booksFrame.add(openButton,
                new GridBagConstraints(GridBagConstraints.RELATIVE, 10, 1, 1, 0, 0,
                        GridBagConstraints.NORTH, GridBagConstraints.NONE,
                        new Insets(2, 2, 2, 2), 0, 0));
        booksFrame.add(saveButton,
                new GridBagConstraints(GridBagConstraints.RELATIVE, 10, 1, 1, 0, 0,
                        GridBagConstraints.NORTH, GridBagConstraints.NONE,
                        new Insets(2, 2, 2, 2), 0, 0));
        booksFrame.add(booksScroll,
                new GridBagConstraints(0, GridBagConstraints.RELATIVE, GridBagConstraints.REMAINDER, GridBagConstraints.RELATIVE, 10, 10,
                        GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                        new Insets(2, 2, 2, 2), 0, 0));
        booksFrame.add(firstPageButton,
                new GridBagConstraints(160, 500, 1, 1, 0, 0,
                        GridBagConstraints.NORTH, GridBagConstraints.NONE,
                        new Insets(2, 2, 2, 2), 0, 0));
        booksFrame.add(previousPageButton,
                new GridBagConstraints(GridBagConstraints.RELATIVE, 500, 1, 1, 0, 0,
                        GridBagConstraints.NORTH, GridBagConstraints.NONE,
                        new Insets(2, 2, 2, 2), 0, 0));
        booksFrame.add(nextPageButton,
                new GridBagConstraints(GridBagConstraints.RELATIVE, 500, 1, 1, 0, 0,
                        GridBagConstraints.NORTH, GridBagConstraints.NONE,
                        new Insets(2, 2, 2, 2), 0, 0));
        booksFrame.add(lastPageButton,
                new GridBagConstraints(GridBagConstraints.RELATIVE, 500, 1, 1, 0, 0,
                        GridBagConstraints.NORTH, GridBagConstraints.NONE,
                        new Insets(2, 2, 2, 2), 0, 0));
        booksFrame.add(recordsCountLabel,
                new GridBagConstraints(0, 500, 1, 1, 0, 0,
                        GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                        new Insets(2, 2, 2, 2), 0, 0));
        booksFrame.add(recordsOnPageLabel,
                new GridBagConstraints(100, 500, 1, 1, 0, 0,
                        GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                        new Insets(2, 2, 2, 2), 0, 0));
        booksFrame.add(recordsOnPageText,
                new GridBagConstraints(115, 500, 1, 1, 0, 0,
                        GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                        new Insets(2, 2, 2, 2), 0, 0));
        booksFrame.add(menu,
                new GridBagConstraints(0, 0, 1, 1, 0, 0,
                        GridBagConstraints.NORTH, GridBagConstraints.NONE,
                        new Insets(2, 2, 2, 2), 0, 0));

        booksFrame.pack();
        booksFrame.setVisible(true);
    }

    private JFrame booksFrame = new JFrame("Книги");
    private BooksTableModel booksModel = new BooksTableModel();
    private JTable booksTable = new JTable(booksModel);
    private JScrollPane booksScroll = new JScrollPane(booksTable);
    private JButton addButton = new JButton(new ImageIcon("E:\\JavaProjects\\Java.lab2\\src\\images\\add.png"));
    private JButton deleteButton = new JButton(new ImageIcon("E:\\JavaProjects\\Java.lab2\\src\\images\\delete.png"));
    private JButton findButton = new JButton(new ImageIcon("E:\\JavaProjects\\Java.lab2\\src\\images\\find.png"));
    private JButton openButton = new JButton(new ImageIcon("E:\\JavaProjects\\Java.lab2\\src\\images\\open.png"));
    private JButton saveButton = new JButton(new ImageIcon("E:\\JavaProjects\\Java.lab2\\src\\images\\save.png"));
    private JButton firstPageButton = new JButton("1");
    private JButton lastPageButton = new JButton("n");
    private JButton previousPageButton = new JButton("<<");
    private JButton nextPageButton = new JButton(">>");
    private JLabel recordsOnPageLabel = new JLabel("Записей на странице:");
    private JLabel recordsCountLabel = new JLabel("Всего записей: 0");
    private JTextField recordsOnPageText = new JTextField(5);
    private JMenuBar menu = new JMenuBar();
    private JMenu fileMenu = new JMenu("Файл");
    private JMenu editMenu = new JMenu("Редактировать");
    private JMenuItem openMenuItem = new JMenuItem("Открыть");
    private JMenuItem saveMenuItem = new JMenuItem("Сохранить");
    private JMenuItem addMenuItem = new JMenuItem("Добавить");
    private JMenuItem deleteMenuItem = new JMenuItem("Удалить");
    private JMenuItem findMenuItem = new JMenuItem("Найти");

    private class addActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            addDialog = new JDialog();

            addNameText.setText("");
            addAuthorText.setText("");
            addPublisherText.setText("");
            addTomesCountText.setText("");
            addCirculationText.setText("");

            addDialog.setLayout(new GridBagLayout());
            addDialog.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

            JLabel addNameLabel = new JLabel("Название книги:");
            JLabel addAuthorLabel = new JLabel("ФИО автора:");
            JLabel addPublisherLabel = new JLabel("Издательство:");
            JLabel addTomesCountLabel = new JLabel("Число томов:");
            JLabel addCirculationLabel = new JLabel("Тираж:");

            JButton okButton = new JButton("OK");
            okButton.addActionListener(new okButtonActionListener());

            addDialog.add(addNameLabel,
                    new GridBagConstraints(0, 5, 1, 1, 0, 0,
                            GridBagConstraints.NORTH, GridBagConstraints.NONE,
                            new Insets(2, 2, 2, 2), 0, 0));
            addDialog.add(addNameText,
                    new GridBagConstraints(GridBagConstraints.RELATIVE, 5, 1, 1, 0, 0,
                            GridBagConstraints.NORTH, GridBagConstraints.NONE,
                            new Insets(2, 2, 2, 2), 0, 0));
            addDialog.add(addAuthorLabel,
                    new GridBagConstraints(0, 20, 1, 1, 0, 0,
                            GridBagConstraints.NORTH, GridBagConstraints.NONE,
                            new Insets(2, 2, 2, 2), 0, 0));
            addDialog.add(addAuthorText,
                    new GridBagConstraints(GridBagConstraints.RELATIVE, 20, 1, 1, 0, 0,
                            GridBagConstraints.NORTH, GridBagConstraints.NONE,
                            new Insets(2, 2, 2, 2), 0, 0));
            addDialog.add(addPublisherLabel,
                    new GridBagConstraints(0, 35, 1, 1, 0, 0,
                            GridBagConstraints.NORTH, GridBagConstraints.NONE,
                            new Insets(2, 2, 2, 2), 0, 0));
            addDialog.add(addPublisherText,
                    new GridBagConstraints(GridBagConstraints.RELATIVE, 35, 1, 1, 0, 0,
                            GridBagConstraints.NORTH, GridBagConstraints.NONE,
                            new Insets(2, 2, 2, 2), 0, 0));
            addDialog.add(addTomesCountLabel,
                    new GridBagConstraints(0, 50, 1, 1, 0, 0,
                            GridBagConstraints.NORTH, GridBagConstraints.NONE,
                            new Insets(2, 2, 2, 2), 0, 0));
            addDialog.add(addTomesCountText,
                    new GridBagConstraints(GridBagConstraints.RELATIVE, 50, 1, 1, 0, 0,
                            GridBagConstraints.NORTH, GridBagConstraints.NONE,
                            new Insets(2, 2, 2, 2), 0, 0));
            addDialog.add(addCirculationLabel,
                    new GridBagConstraints(0, 75, 1, 1, 0, 0,
                            GridBagConstraints.NORTH, GridBagConstraints.NONE,
                            new Insets(2, 2, 2, 2), 0, 0));
            addDialog.add(addCirculationText,
                    new GridBagConstraints(GridBagConstraints.RELATIVE, 75, 1, 1, 0, 0,
                            GridBagConstraints.NORTH, GridBagConstraints.NONE,
                            new Insets(2, 2, 2, 2), 0, 0));
            addDialog.add(okButton,
                    new GridBagConstraints(200, 550, 1, 1, 0, 0,
                            GridBagConstraints.NORTH, GridBagConstraints.NONE,
                            new Insets(2, 2, 2, 2), 0, 0));

            addDialog.pack();
            addDialog.setModal(true);
            addDialog.setVisible(true);
        }

        class okButtonActionListener implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                String[] newData = new String[6];
                newData[0] = addNameText.getText();
                newData[1] = addAuthorText.getText();
                newData[2] = addPublisherText.getText();
                newData[3] = addTomesCountText.getText();
                newData[4] = addCirculationText.getText();

                int allTomes = Integer.parseInt(newData[3])*Integer.parseInt(newData[4]);
                newData[5] = String.valueOf(allTomes);

                if(booksModel.findData(newData))
                {
                    JOptionPane notExist = new JOptionPane();
                    notExist.showMessageDialog(addDialog, "Такая книга уже есть!");
                }
                else
                {
                    booksModel.addData(newData);
                    booksModel.fireTableDataChanged();
                }

                addDialog.dispose();
            }
        }

        private JDialog addDialog;
        private JTextField addNameText = new JTextField(50);
        private JTextField addAuthorText = new JTextField(50);
        private JTextField addPublisherText = new JTextField(50);
        private JTextField addTomesCountText = new JTextField(50);
        private JTextField addCirculationText = new JTextField(50);
    }
}
