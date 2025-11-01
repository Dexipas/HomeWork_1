package studandbook;

public class Book {
    private String name;
    private int pages;
    private int yearRelease;

    public Book(String name, int pages, int yearRelease){
        this.name = name;
        this.pages = pages;
        this.yearRelease = yearRelease;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return  true;
        if(!(obj instanceof Book book)) return false;
        return (name == book.name) && (pages == book.pages) && (yearRelease == book.yearRelease);
    }

    public int getYearRelease() {
        return yearRelease;
    }

    public String getName() {
        return name;
    }

    public int getPages() {
        return pages;
    }
}
