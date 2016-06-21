import javax.swing.*;
import java.awt.*;

public class SearchAndDeleteConditions extends JPanel
{
    public SearchAndDeleteConditions()
    {
        super();
        createPanel();
    }
    
    private void createPanel()
    {
        tabs = new JTabbedPane();

        textSurname.setText("");
        textName.setText("");
        textPatronymic.setText("");
        textSurname2.setText("");
        textName2.setText("");
        textPatronymic2.setText("");
        textPublisher.setText("");
        textSurname3.setText("");
        textName3.setText("");
        textPatronymic3.setText("");
        textTomesFrom.setText("");
        textTomesTo.setText("");
        textBookName.setText("");
        textCirculation.setText("");
        textAllTomes.setText("");
        
        createTabFIO();
        createTabFIOAndPublisher();
        createTabFIOAndTomes();
        createTabName();
        createTabCirculation();
        createTabAllTomes();

        add(tabs);
    }

    private void createTabFIO()
    {
        JPanel tabFIO = new JPanel(new GridLayout(3, 2));

        JLabel labelSurname = new JLabel("Фамилия автора:");
        JLabel labelName = new JLabel("Имя автора:");
        JLabel labelPatronymic = new JLabel("Отчество автора:");

        tabFIO.add(labelSurname);
        tabFIO.add(textSurname);
        tabFIO.add(labelName);
        tabFIO.add(textName);
        tabFIO.add(labelPatronymic);
        tabFIO.add(textPatronymic);

        tabs.add(tabFIO, "По ФИО автора");
    }

    private void createTabFIOAndPublisher()
    {
        JPanel tabFIOAndPublisher = new JPanel(new GridLayout(4, 2));

        JLabel labelPublisher = new JLabel("Издательство:");
        JLabel labelSurname = new JLabel("Фамилия автора:");
        JLabel labelName = new JLabel("Имя автора:");
        JLabel labelPatronymic = new JLabel("Отчество автора:");

        tabFIOAndPublisher.add(labelSurname);
        tabFIOAndPublisher.add(textSurname2);
        tabFIOAndPublisher.add(labelName);
        tabFIOAndPublisher.add(textName2);
        tabFIOAndPublisher.add(labelPatronymic);
        tabFIOAndPublisher.add(textPatronymic2);
        tabFIOAndPublisher.add(labelPublisher);
        tabFIOAndPublisher.add(textPublisher);

        tabs.add(tabFIOAndPublisher, "По ФИО автора и издательству");
    }

    private void createTabFIOAndTomes()
    {
        JPanel tabFIOAndTomes = new JPanel(new GridBagLayout());

        JLabel labelSurname = new JLabel("Фамилия автора:");
        JLabel labelName = new JLabel("Имя автора:");
        JLabel labelPatronymic = new JLabel("Отчество автора:");
        JLabel labelTomes = new JLabel("Количество томов:");
        JLabel labelFrom = new JLabel("от:");
        JLabel labelTo = new JLabel("до:");

        tabFIOAndTomes.add(labelSurname,
                new GridBagConstraints(0, 0, 1, 1, 1, 1,
                        GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                        new Insets(0, 0, 0, 0), 0, 0));
        tabFIOAndTomes.add(textSurname3,
                new GridBagConstraints(GridBagConstraints.RELATIVE, 0, 1, 1, 1, 1,
                        GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                        new Insets(0, 0, 0, 0), 0, 0));
        tabFIOAndTomes.add(labelName,
                new GridBagConstraints(0, 10, 1, 1, 1, 1,
                        GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                        new Insets(0, 0, 0, 0), 0, 0));
        tabFIOAndTomes.add(textName3,
                new GridBagConstraints(GridBagConstraints.RELATIVE, 10, 1, 1, 1, 1,
                        GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                        new Insets(0, 0, 0, 0), 0, 0));
        tabFIOAndTomes.add(labelPatronymic,
                new GridBagConstraints(0, 20, 1, 1, 1, 1,
                        GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                        new Insets(0, 0, 0, 0), 0, 0));
        tabFIOAndTomes.add(textPatronymic3,
                new GridBagConstraints(GridBagConstraints.RELATIVE, 20, 1, 1, 1, 1,
                        GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                        new Insets(0, 0, 0, 0), 0, 0));

        JPanel panelTomes = new JPanel(new GridBagLayout());

        panelTomes.add(labelTomes,
                new GridBagConstraints(0, 0, 1, 1, 1, 1,
                        GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                        new Insets(0, 0, 0, 0), 0, 0));
        panelTomes.add(labelFrom,
                new GridBagConstraints(0, 10, 1, 1, 1, 1,
                        GridBagConstraints.NORTH, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 0, 0), 0, 0));
        panelTomes.add(textTomesFrom,
                new GridBagConstraints(GridBagConstraints.RELATIVE, 10, 1, 1, 1, 1,
                        GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 0, 0), 0, 0));
        panelTomes.add(labelTo,
                new GridBagConstraints(0, 20, 1, 1, 1, 1,
                        GridBagConstraints.NORTH, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 0, 0), 0, 0));
        panelTomes.add(textTomesTo,
                new GridBagConstraints(GridBagConstraints.RELATIVE, 20, 1, 1, 1, 1,
                        GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 0, 0), 0, 0));

        tabFIOAndTomes.add(panelTomes,
                new GridBagConstraints(0, GridBagConstraints.RELATIVE, 1, 1, 1, 1,
                        GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 0, 0), 0, 0));

        tabs.add(tabFIOAndTomes, "По ФИО автора и количеству томов");
    }

    private void createTabName()
    {
        JPanel tabName = new JPanel(new FlowLayout());

        JLabel labelName = new JLabel("Название книги: ");

        tabName.add(labelName);
        tabName.add(textBookName);

        tabs.add(tabName, "По названию книги");
    }

    private void createTabCirculation()
    {
        JPanel tabCirculation = new JPanel();

        ButtonGroup groupCirculation = new ButtonGroup();
        groupCirculation.add(lessCirculation);
        groupCirculation.add(moreCirculation);

        tabCirculation.add(lessCirculation);
        tabCirculation.add(moreCirculation);
        tabCirculation.add(textCirculation);

        tabs.add(tabCirculation, "По тиражу");
    }

    private void createTabAllTomes()
    {
        JPanel tabAllTomes = new JPanel();

        ButtonGroup groupAllTomes = new ButtonGroup();
        groupAllTomes.add(lessAllTomes);
        groupAllTomes.add(moreAllTomes);

        tabAllTomes.add(lessAllTomes);
        tabAllTomes.add(moreAllTomes);
        tabAllTomes.add(textAllTomes);

        tabs.add(tabAllTomes, "По общему количеству томов");
    }

    JTabbedPane tabs = new JTabbedPane();
    JTextField textSurname = new JTextField(30);
    JTextField textName = new JTextField(30);
    JTextField textPatronymic = new JTextField(30);
    JTextField textSurname2 = new JTextField(30);
    JTextField textName2 = new JTextField(30);
    JTextField textPatronymic2 = new JTextField(30);
    JTextField textPublisher = new JTextField(30);
    JTextField textSurname3 = new JTextField(30);
    JTextField textName3 = new JTextField(30);
    JTextField textPatronymic3 = new JTextField(30);
    JTextField textTomesFrom = new JTextField(5);
    JTextField textTomesTo = new JTextField(5);
    JTextField textBookName = new JTextField(30);
    JRadioButton lessCirculation = new JRadioButton("Меньше");
    JRadioButton moreCirculation = new JRadioButton("Больше");
    JTextField textCirculation = new JTextField(10);
    JRadioButton lessAllTomes = new JRadioButton("Меньше");
    JRadioButton moreAllTomes = new JRadioButton("Больше");
    JTextField textAllTomes = new JTextField(15);
}
