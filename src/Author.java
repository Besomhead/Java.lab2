public class Author
{
    private String lastName;
    private String firstName;
    private String patronymic;

    public Author()
    {
        lastName = "";
        firstName = "";
        patronymic = "";
    }

    public Author(String lastName, String firstName, String patronymic)
    {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getPatronymic()
    {
        return patronymic;
    }

    public void setLastName(String newLN)
    {
        this.lastName = newLN;
    }

    public void setFirstName(String newFN)
    {
        this.firstName = newFN;
    }

    public void setPatronymic(String newPatr)
    {
        this.patronymic = newPatr;
    }

}
