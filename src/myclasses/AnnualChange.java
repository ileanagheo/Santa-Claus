package myclasses;

import enums.CityStrategyEnum;

import java.util.List;

public class AnnualChange {
    private double newSantaBudget;
    private List<Cadou> newGifts;
    private List<Copil> newChildren;
    private List<ChildUpdate> childrenUpdates;
    private CityStrategyEnum strategy;

    /**
     */
    public AnnualChange() {
    }

    /**
     * @param newSantaBudget
     * @param newGifts
     * @param newChildren
     * @param childrenUpdates
     * @param strategy
     */
    public AnnualChange(final double newSantaBudget, final List<Cadou> newGifts, final List<Copil>
            newChildren, final List<ChildUpdate> childrenUpdates, final CityStrategyEnum strategy) {
        this.newSantaBudget = newSantaBudget;
        this.newGifts = newGifts;
        this.newChildren = newChildren;
        this.childrenUpdates = childrenUpdates;
        this.strategy = strategy;
    }

    /**
     * @return
     */
    public double getNewSantaBudget() {
        return newSantaBudget;
    }

    /**
     * @param newSantaBudget
     */
    public void setNewSantaBudget(final double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    /**
     * @return
     */
    public List<Cadou> getNewGifts() {
        return newGifts;
    }

    /**
     * @param newGifts
     */
    public void setNewGifts(final List<Cadou> newGifts) {
        this.newGifts = newGifts;
    }

    /**
     * @return
     */
    public List<Copil> getNewChildren() {
        return newChildren;
    }

    /**
     * @param newChildren
     */
    public void setNewChildren(final List<Copil> newChildren) {
        this.newChildren = newChildren;
    }

    /**
     * @return
     */
    public List<ChildUpdate> getChildrenUpdates() {
        return childrenUpdates;
    }

    /**
     * @return
     */
    public CityStrategyEnum getStrategy() {
        return strategy;
    }

    /**
     * @param strategy
     */
    public void setStrategy(final CityStrategyEnum strategy) {
        this.strategy = strategy;
    }

    /**
     * @param childrenUpdates
     */
    public void setChildrenUpdates(final List<ChildUpdate> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }
}
