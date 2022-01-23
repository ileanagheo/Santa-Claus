package myclasses;

import enums.Category;
import enums.Cities;

import java.util.List;

public class ChildOut {
    private int id;
    private String lastName;
    private String firstName;
    private Cities city;
    private int age;
    private List<Category> giftsPreferences;
    private double averageScore;
    private List<Double> niceScoreHistory;
    private double assignedBudget;
    private List<GiftOut> receivedGifts;

    /**
     * This is the structure that the children are shown in output
     * @param id : ID
     * @param lastName : last name
     * @param firstName : fisrt name
     * @param city : city
     * @param age : age
     * @param giftsPreferences : gifts preferences
     * @param averageScore : average score
     * @param niceScoreHistory : nice score history
     * @param assignedBudget : assigned budget
     * @param receivedGifts : received gifts
     */
    public ChildOut(final int id, final String lastName, final String firstName, final Cities city,
                    final int age, final List<Category> giftsPreferences, final double
                            averageScore, final List<Double> niceScoreHistory, final double
                            assignedBudget, final List<GiftOut> receivedGifts) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.city = city;
        this.age = age;
        this.giftsPreferences = giftsPreferences;
        this.averageScore = averageScore;
        this.niceScoreHistory = niceScoreHistory;
        this.assignedBudget = assignedBudget;
        this.receivedGifts = receivedGifts;
    }

    /**
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id sets id
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName sets last name
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName sets first name
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return city
     */
    public Cities getCity() {
        return city;
    }

    /**
     * @param city sets city
     */
    public void setCity(final Cities city) {
        this.city = city;
    }

    /**
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age sets age
     */
    public void setAge(final int age) {
        this.age = age;
    }

    /**
     * @return giftsPreferences
     */
    public List<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    /**
     * @param giftsPreferences sets gifts preferences
     */
    public void setGiftsPreferences(final List<Category> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    /**
     * @return averageScore
     */
    public double getAverageScore() {
        return averageScore;
    }

    /**
     * @param averageScore sets average score
     */
    public void setAverageScore(final double averageScore) {
        this.averageScore = averageScore;
    }

    /**
     * @return niceScoreHistory
     */
    public List<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    /**
     * @param niceScoreHistory sets nice score history
     */
    public void setNiceScoreHistory(final List<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    /**
     * @return assignedBudget
     */
    public double getAssignedBudget() {
        return assignedBudget;
    }

    /**
     * @param assignedBudget sets assigned budget
     */
    public void setAssignedBudget(final double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    /**
     * @return receivedGifts
     */
    public List<GiftOut> getReceivedGifts() {
        return receivedGifts;
    }

    /**
     * @param receivedGifts sets received gifts
     */
    public void setReceivedGifts(final List<GiftOut> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }
}
