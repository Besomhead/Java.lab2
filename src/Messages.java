import javax.swing.*;

public final class Messages
{
    private Messages()
    {

    }

    public static boolean noDataMessage(Controller controller)
    {
        if(controller.getCount() == 0)
        {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Таблица пуста!", "", JOptionPane.WARNING_MESSAGE);
            return true;
        }

        return false;
    }

    public static void nothingFounded()
    {
        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Таких книг нет!", "", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void incorrectData()
    {
        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Неверный формат данных!", "", JOptionPane.ERROR_MESSAGE);
    }
}
