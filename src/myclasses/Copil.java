package myclasses;

import enums.Category;

import java.util.ArrayList;
import java.util.List;

public class Copil {
    //Clasa de tip Copil ce contine toate datele copilului si preferintele

    private int id;
    private String lastName;
    private String firstName;
    private String city;
    private int age;
    private Double niceScore;
    private List<Category> giftsPreferences = new ArrayList<>();
    private double averageScore;
    private List<Double> niceScoreHistory = new ArrayList<>();
    private double assignedBudget;
    private List<Cadou> receivedGifts = new ArrayList<>();

    public Copil() {
    }

    public Copil(int id, String lastName, String firstName, String city, int age, List<Category> giftsPreferences, double niceScore) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.city = city;
        this.age = age;
        this.giftsPreferences = giftsPreferences;
        this.niceScore = niceScore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public void setNiceScore(double niceScore) {
        this.niceScore = niceScore;
    }

    public List<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public void setGiftsPreferences(List<Category> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public List<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public void setNiceScoreHistory(List<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    public double getAssignedBudget() {
        return assignedBudget;
    }

    public void setAssignedBudget(double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    public List<Cadou> getReceivedGifts() {
        return receivedGifts;
    }

    public void setReceivedGifts(List<Cadou> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }

    public int compareTo(Copil o) {
        return Integer.compare(this.getId(), o.getId());
    }
}
