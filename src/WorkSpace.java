import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WorkSpace
{
    public void createWorkSpace()
    {
        booksFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        booksFrame.setLayout(new GridBagLayout());

        TableWithPages booksTable = new TableWithPages(controller);

        addButton.setPreferredSize(new Dimension(30, 30));
        deleteButton.setPreferredSize(new Dimension(30, 30));
        findButton.setPreferredSize(new Dimension(30, 30));
        openButton.setPreferredSize(new Dimension(30, 30));
        saveButton.setPreferredSize(new Dimension(30, 30));

        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);

        editMenu.add(addMenuItem);
        editMenu.add(deleteMenuItem);
        editMenu.add(findMenuItem);

        menu.add(fileMenu);
        menu.add(editMenu);

        addButton.addActionListener(new AddActionListener(controller, booksTable.getRecordsCountLabel(), booksTable));
        addMenuItem.addActionListener(new AddActionListener(controller, booksTable.getRecordsCountLabel(), booksTable));

        findButton.addActionListener(new FindActionListener(controller));
        findMenuItem.addActionListener(new FindActionListener(controller));

        deleteButton.addActionListener(new DeleteActionListener(controller, booksTable.getRecordsCountLabel(), booksTable));
        deleteMenuItem.addActionListener(new DeleteActionListener(controller, booksTable.getRecordsCountLabel(), booksTable));

        openButton.addActionListener(new OpenActionListener(controller, booksTable.getRecordsCountLabel(), booksTable));
        openMenuItem.addActionListener(new OpenActionListener(controller, booksTable.getRecordsCountLabel(), booksTable));

        saveButton.addActionListener(new SaveActionListener(controller));
        saveMenuItem.addActionListener(new SaveActionListener(controller));

        JPanel controlButtons = new JPanel(new FlowLayout());
        controlButtons.add(addButton);
        controlButtons.add(deleteButton);
        controlButtons.add(findButton);
        controlButtons.add(openButton);
        controlButtons.add(saveButton);

        booksFrame.add(menu,
                new GridBagConstraints(0, 0, 1, 1, 0, 0,
                GridBagConstraints.WEST, GridBagConstraints.NONE,
                new Insets(2, 2, 2, 2), 0, 0));
        booksFrame.add(controlButtons,
                new GridBagConstraints(0, 15, 1, 1, 1, 1,
                GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 0, 0), 0, 0));
        booksFrame.add(booksTable,
                new GridBagConstraints(0, GridBagConstraints.RELATIVE, GridBagConstraints.REMAINDER, GridBagConstraints.RELATIVE, 10, 10,
                        GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                        new Insets(2, 2, 2, 2), 0, 0));

        booksFrame.setSize(new Dimension(680, 768));
        booksFrame.setVisible(true);
        booksFrame.revalidate();
        booksTable.repaint();
    }

    private JFrame booksFrame = new JFrame("Книги");
    private Controller controller = new Controller();
    private JButton addButton = new JButton(new ImageIcon("E:\\JavaProjects\\Java.lab2\\src\\images\\add.png"));
    private JButton deleteButton = new JButton(new ImageIcon("E:\\JavaProjects\\Java.lab2\\src\\images\\delete.png"));
    private JButton findButton = new JButton(new ImageIcon("E:\\JavaProjects\\Java.lab2\\src\\images\\find.png"));
    private JButton openButton = new JButton(new ImageIcon("E:\\JavaProjects\\Java.lab2\\src\\images\\open.png"));
    private JButton saveButton = new JButton(new ImageIcon("E:\\JavaProjects\\Java.lab2\\src\\images\\save.png"));
    private JMenuBar menu = new JMenuBar();
    private JMenu fileMenu = new JMenu("Файл");
    private JMenu editMenu = new JMenu("Редактировать");
    private JMenuItem openMenuItem = new JMenuItem("Открыть");
    private JMenuItem saveMenuItem = new JMenuItem("Сохранить");
    private JMenuItem addMenuItem = new JMenuItem("Добавить");
    private JMenuItem deleteMenuItem = new JMenuItem("Удалить");
    private JMenuItem findMenuItem = new JMenuItem("Найти");
}
