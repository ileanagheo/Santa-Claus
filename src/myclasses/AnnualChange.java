package myclasses;

import java.util.List;

public class AnnualChange {
    private double newSantaBudget;
    private List<Cadou> newGifts;
    private List<Copil> newChildren;
    private List<ChildUpdate> childrenUpdates;

    public AnnualChange() {
    }

    public AnnualChange(double newSantaBudget, List<Cadou> newGifts, List<Copil> newChildren, List<ChildUpdate> childrenUpdates) {
        this.newSantaBudget = newSantaBudget;
        this.newGifts = newGifts;
        this.newChildren = newChildren;
        this.childrenUpdates = childrenUpdates;
    }

    public double getNewSantaBudget() {
        return newSantaBudget;
    }

    public void setNewSantaBudget(double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    public List<Cadou> getNewGifts() {
        return newGifts;
    }

    public void setNewGifts(List<Cadou> newGifts) {
        this.newGifts = newGifts;
    }

    public List<Copil> getNewChildren() {
        return newChildren;
    }

    public void setNewChildren(List<Copil> newChildren) {
        this.newChildren = newChildren;
    }

    public List<ChildUpdate> getChildrenUpdates() {
        return childrenUpdates;
    }

    public void setChildrenUpdates(List<ChildUpdate> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }
}
