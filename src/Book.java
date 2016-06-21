public class Book
{
    public Book()
    {
        name = "";
        author = new Author();
        publisher = new Publisher();
        circulation = 0;
        tomesCount = 0;
        allTomes = 0;
    }

    public Book(String name, String lastName, String firstName, String patronymic, String publisher, int tomes, int circulation)
    {
        this.name = name;
        this.author = new Author(lastName, firstName, patronymic);
        this.publisher = new Publisher(publisher);
        tomesCount = tomes;
        this.circulation = circulation;
        this.allTomes = tomesCount*this.circulation;
    }

    public String getName()
    {
        return name;
    }

    public String getAuthorName()
    {
        return author.getFirstName();
    }

    public String getAuthorSurname()
    {
        return author.getLastName();
    }

    public String getAuthorPatronymic()
    {
        return author.getPatronymic();
    }

    public String getPublisher()
    {
        return publisher.getName();
    }

    public int getTomesCount()
    {
        return this.tomesCount;
    }

    public int getCirculation()
    {
        return this.circulation;
    }

    public int getAllTomes() { return this.allTomes; }

    public void setName(String newName)
    {
        this.name = newName;
    }

    public void setAuthor(String aSurname, String aName, String aPatronymic)
    {
        this.author.setLastName(aSurname);
        this.author.setFirstName(aName);
        this.author.setPatronymic(aPatronymic);
    }

    public void setPublisher(String pName)
    {
        this.publisher.setName(pName);
    }

    public void setTomesCount(int newCount)
    {
        this.tomesCount = newCount;
    }

    public void setCirculation(int newCirculation)
    {
        this.circulation = newCirculation;
    }

    public void setAllTomes(int newAllTomes)
    {
        this.allTomes = newAllTomes;
    }

    public boolean equals(Object book)
    {
        if(!(book instanceof Book)) return false;

        if(book == this) return true;

        Book tmpBook = (Book) book;

        if(!this.name.equals(tmpBook.getName())) return false;
        if(!this.author.getFirstName().equals(tmpBook.getAuthorName())) return false;
        if(!this.author.getLastName().equals(tmpBook.getAuthorSurname())) return false;
        if(!this.author.getPatronymic().equals(tmpBook.getAuthorPatronymic())) return false;
        if(!this.publisher.getName().equals(tmpBook.getPublisher())) return false;
        if(this.tomesCount != tmpBook.getTomesCount()) return false;
        return (this.circulation == tmpBook.getCirculation());
    }

    public int hashCode()
    {
        final int hashConst = 31;

        int hash = 1;
        hash = hash * hashConst + name.hashCode();
        hash = hash * hashConst + author.hashCode();
        hash = hash * hashConst + publisher.hashCode();
        hash = hash * hashConst + tomesCount;
        hash = hash * hashConst + circulation;

        return hash;
    }

    public boolean isAuthorEquals(Book toCompare)
    {
        return (this.getAuthorSurname().equals(toCompare.getAuthorSurname())
                && this.getAuthorName().equals(toCompare.getAuthorName())
                && this.getAuthorPatronymic().equals(toCompare.getAuthorPatronymic()));
    }

    public boolean isPublisherEquals(Book toCompare)
    {
        return this.getPublisher().equals(toCompare.getPublisher());
    }

    public boolean isNameEquals(Book toCompare)
    {
        return this.getName().equals(toCompare.getName());
    }

    private String name;
    private int circulation;
    private int tomesCount;
    private Author author;
    private Publisher publisher;
    private int allTomes;
}
