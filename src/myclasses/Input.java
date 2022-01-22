package myclasses;

import java.util.List;

public class Input {
    private int numberOfYears;
    private double santaBudget;
    private InitialData initialData;
    private List<AnnualChange> annualChanges;

    /**
     */
    public Input() {
    }

    /**
     * @param numberOfYears
     * @param santaBudget
     * @param initialData
     * @param annualChanges
     */
    public Input(final int numberOfYears, final double santaBudget, final InitialData initialData,
                 final List<AnnualChange> annualChanges) {
        this.numberOfYears = numberOfYears;
        this.santaBudget = santaBudget;
        this.initialData = initialData;
        this.annualChanges = annualChanges;
    }

    /**
     * @return
     */
    public int getNumberOfYears() {
        return numberOfYears;
    }

    /**
     * @param numberOfYears
     */
    public void setNumberOfYears(final int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    /**
     * @return
     */
    public double getSantaBudget() {
        return santaBudget;
    }

    /**
     * @param santaBudget
     */
    public void setSantaBudget(final double santaBudget) {
        this.santaBudget = santaBudget;
    }

    /**
     * @return
     */
    public InitialData getInitialData() {
        return initialData;
    }

    /**
     * @param initialData
     */
    public void setInitialData(final InitialData initialData) {
        this.initialData = initialData;
    }

    /**
     * @return
     */
    public List<AnnualChange> getAnnualChanges() {
        return annualChanges;
    }

    /**
     * @param annualChanges
     */
    public void setAnnualChanges(final List<AnnualChange> annualChanges) {
        this.annualChanges = annualChanges;
    }
}
