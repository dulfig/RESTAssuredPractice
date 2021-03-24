package models;

public class Developer{

    String id;
    String firstName;
    String lastName;
    String favoriteLanguage;
    int yearStarted;

    public Developer(){}

    public Developer(String firstName, String lastName, String favoriteLanguage, int yearStarted) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.favoriteLanguage = favoriteLanguage;
        this.yearStarted = yearStarted;
    }

    public Developer(String id, String firstName, String lastName, String favoriteLanguage, int yearStarted) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.favoriteLanguage = favoriteLanguage;
        this.yearStarted = yearStarted;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public int getYearStarted() {
        return yearStarted;
    }

    public void setYearStarted(int yearStarted) {
        this.yearStarted = yearStarted;
    }

}
