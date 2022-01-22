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

    /**
     */
    public Copil() {
    }

    /**
     * @param id
     * @param lastName
     * @param firstName
     * @param city
     * @param age
     * @param giftsPreferences
     * @param niceScore
     */
    public Copil(final int id, final String lastName, final String firstName, final String city,
                 final int age, final List<Category> giftsPreferences, final double niceScore) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.city = city;
        this.age = age;
        this.giftsPreferences = giftsPreferences;
        this.niceScore = niceScore;
    }

    /**
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(final String city) {
        this.city = city;
    }

    /**
     * @return
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(final int age) {
        this.age = age;
    }

    /**
     * @return
     */
    public Double getNiceScore() {
        return niceScore;
    }

    /**
     * @param niceScore
     */
    public void setNiceScore(final double niceScore) {
        this.niceScore = niceScore;
    }

    /**
     * @return
     */
    public List<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    /**
     * @param giftsPreferences
     */
    public void setGiftsPreferences(final List<Category> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    /**
     * @return
     */
    public double getAverageScore() {
        return averageScore;
    }

    /**
     * @param averageScore
     */
    public void setAverageScore(final double averageScore) {
        this.averageScore = averageScore;
    }

    /**
     * @return
     */
    public List<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    /**
     * @param niceScoreHistory
     */
    public void setNiceScoreHistory(final List<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    /**
     * @return
     */
    public double getAssignedBudget() {
        return assignedBudget;
    }

    /**
     * @param assignedBudget
     */
    public void setAssignedBudget(final double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    /**
     * @return
     */
    public List<Cadou> getReceivedGifts() {
        return receivedGifts;
    }

    /**
     * @param receivedGifts
     */
    public void setReceivedGifts(final List<Cadou> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }

    /**
     * @param o
     * @return
     */
    public int compareTo(final Copil o) {
        return Integer.compare(this.getId(), o.getId());
    }
}
