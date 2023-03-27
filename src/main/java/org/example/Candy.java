package org.example;

public class Candy {
    private String name;
    private int rating;
    private String origin;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Candy(String name, int rating, String origin) {
        this.name = name;
        this.rating = rating;
        this.origin = origin;

    }

    public String getStatus() {
        if (this.rating < 6) {
            return "Boo!!!";
        }
        else {
            return "Treat!!";
        }
    }

    @Override
    public String toString(){
        return  this.name+ ", " +this.rating+ ", " + this.origin;
    }

}