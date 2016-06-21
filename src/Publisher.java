public class Publisher
{
    public Publisher()
    {
        name = "";
    }

    public Publisher(String publisher)
    {
        name = publisher;
    }

    public String getName() { return name; }

    public void setName(String newName)
    {
        this.name = newName;
    }

    private String name;
}
