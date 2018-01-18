package jayantb95.recyclerview.dataModel;

/**
 * Created by Jayant on 18-01-2018.
 */

public class MovieModel {
    private String title;
    private String genre;
    private String year;

    public MovieModel() {
    }


    public MovieModel(String title, String genre, String year) {
        this.title = title;
        this.genre = genre;
        this.year = year;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String name) {
        this.title = name;
    }


    public String getYear() {
        return year;
    }


    public void setYear(String year) {
        this.year = year;
    }


    public String getGenre() {
        return genre;
    }


    public void setGenre(String genre) {
        this.genre = genre;
    }
}