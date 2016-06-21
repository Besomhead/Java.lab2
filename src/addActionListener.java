import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddActionListener implements ActionListener
{
    public AddActionListener(Controller newController, JLabel changingLabel, TableWithPages table)
    {
        controller = newController;
        recordsCountLabel = changingLabel;
        tableWithPages = table;
    }

    public void actionPerformed(ActionEvent event)
    {
        addDialog = new JDialog();
        addDialog.setTitle("Добавить книгу");

        addNameText.setText("");
        addAuthorLastNameText.setText("");
        addAuthorFirstNameText.setText("");
        addAuthorPatronymicText.setText("");
        addPublisherText.setText("");
        addTomesCountText.setText("");
        addCirculationText.setText("");

        addDialog.setLayout(new GridBagLayout());
        addDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JLabel addNameLabel = new JLabel("Название книги:");
        JLabel addAuthorLastNameLabel = new JLabel("Фамилия автора:");
        JLabel addAuthorFirstNameLabel = new JLabel("Имя автора:");
        JLabel addAuthorPatronymicLabel = new JLabel("Отчество автора:");
        JLabel addPublisherLabel = new JLabel("Издательство:");
        JLabel addTomesCountLabel = new JLabel("Число томов:");
        JLabel addCirculationLabel = new JLabel("Тираж:");

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new OkButtonActionListener());

        addDialog.add(addNameLabel,
                new GridBagConstraints(0, 5, 1, 1, 0, 0,
                        GridBagConstraints.NORTH, GridBagConstraints.NONE,
                        new Insets(2, 2, 2, 2), 0, 0));
        addDialog.add(addNameText,
                new GridBagConstraints(GridBagConstraints.RELATIVE, 5, 1, 1, 0, 0,
                        GridBagConstraints.NORTH, GridBagConstraints.NONE,
                        new Insets(2, 2, 2, 2), 0, 0));
        addDialog.add(addAuthorLastNameLabel,
                new GridBagConstraints(0, 20, 1, 1, 0, 0,
                        GridBagConstraints.NORTH, GridBagConstraints.NONE,
                        new Insets(2, 2, 2, 2), 0, 0));
        addDialog.add(addAuthorLastNameText,
                new GridBagConstraints(GridBagConstraints.RELATIVE, 20, 1, 1, 0, 0,
                        GridBagConstraints.NORTH, GridBagConstraints.NONE,
                        new Insets(2, 2, 2, 2), 0, 0));
        addDialog.add(addAuthorFirstNameLabel,
                new GridBagConstraints(0, 35, 1, 1, 0, 0,
                        GridBagConstraints.NORTH, GridBagConstraints.NONE,
                        new Insets(2, 2, 2, 2), 0, 0));
        addDialog.add(addAuthorFirstNameText,
                new GridBagConstraints(GridBagConstraints.RELATIVE, 35, 1, 1, 0, 0,
                        GridBagConstraints.NORTH, GridBagConstraints.NONE,
                        new Insets(2, 2, 2, 2), 0, 0));
        addDialog.add(addAuthorPatronymicLabel,
                new GridBagConstraints(0, 50, 1, 1, 0, 0,
                        GridBagConstraints.NORTH, GridBagConstraints.NONE,
                        new Insets(2, 2, 2, 2), 0, 0));
        addDialog.add(addAuthorPatronymicText,
                new GridBagConstraints(GridBagConstraints.RELATIVE, 50, 1, 1, 0, 0,
                        GridBagConstraints.NORTH, GridBagConstraints.NONE,
                        new Insets(2, 2, 2, 2), 0, 0));
        addDialog.add(addPublisherLabel,
                new GridBagConstraints(0, 65, 1, 1, 0, 0,
                        GridBagConstraints.NORTH, GridBagConstraints.NONE,
                        new Insets(2, 2, 2, 2), 0, 0));
        addDialog.add(addPublisherText,
                new GridBagConstraints(GridBagConstraints.RELATIVE, 65, 1, 1, 0, 0,
                        GridBagConstraints.NORTH, GridBagConstraints.NONE,
                        new Insets(2, 2, 2, 2), 0, 0));
        addDialog.add(addTomesCountLabel,
                new GridBagConstraints(0, 80, 1, 1, 0, 0,
                        GridBagConstraints.NORTH, GridBagConstraints.NONE,
                        new Insets(2, 2, 2, 2), 0, 0));
        addDialog.add(addTomesCountText,
                new GridBagConstraints(GridBagConstraints.RELATIVE, 80, 1, 1, 0, 0,
                        GridBagConstraints.NORTH, GridBagConstraints.NONE,
                        new Insets(2, 2, 2, 2), 0, 0));
        addDialog.add(addCirculationLabel,
                new GridBagConstraints(0, 95, 1, 1, 0, 0,
                        GridBagConstraints.NORTH, GridBagConstraints.NONE,
                        new Insets(2, 2, 2, 2), 0, 0));
        addDialog.add(addCirculationText,
                new GridBagConstraints(GridBagConstraints.RELATIVE, 95, 1, 1, 0, 0,
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

    private class OkButtonActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if(!controller.isDataCorrect(addNameText.getText(),
                    addAuthorLastNameText.getText(),
                    addAuthorFirstNameText.getText(),
                    addAuthorPatronymicText.getText(),
                    addPublisherText.getText(),
                    addTomesCountText.getText(),
                    addCirculationText.getText())) Messages.incorrectData();
            else
            {
                Book newBook = new Book(addNameText.getText(),
                        addAuthorLastNameText.getText(),
                        addAuthorFirstNameText.getText(),
                        addAuthorPatronymicText.getText(),
                        addPublisherText.getText(),
                        Integer.parseInt(addTomesCountText.getText()),
                        Integer.parseInt(addCirculationText.getText()));

                if (!controller.addBook(newBook))
                    JOptionPane.showMessageDialog(addDialog, "Такая книга уже есть!", "", JOptionPane.WARNING_MESSAGE);
                else controller.getTableModel().fireTableDataChanged();
            }

            addDialog.dispose();

            recordsCountLabel.setText("Всего записей: " + controller.getTableModel().getRowCount());
            tableWithPages.updateTable();
        }
    }

    private JDialog addDialog;
    private JTextField addNameText = new JTextField(50);
    private JTextField addAuthorLastNameText = new JTextField(50);
    private JTextField addAuthorFirstNameText = new JTextField(50);
    private JTextField addAuthorPatronymicText = new JTextField(50);
    private JTextField addPublisherText = new JTextField(50);
    private JTextField addTomesCountText = new JTextField(50);
    private JTextField addCirculationText = new JTextField(50);
    private Controller controller;
    private JLabel recordsCountLabel = new JLabel();
    private TableWithPages tableWithPages;
}
