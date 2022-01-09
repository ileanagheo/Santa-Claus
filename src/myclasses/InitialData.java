package myclasses;

import java.util.List;

public class InitialData {
    private List<Copil> children;
    private List<Cadou> santaGiftsList;

    public InitialData() {
    }

    public InitialData(List<Copil> children, List<Cadou> santaGiftsList) {
        this.children = children;
        this.santaGiftsList = santaGiftsList;

    }

    public List<Copil> getChildren() {
        return children;
    }

    public void setChildren(List<Copil> children) {
        this.children = children;
    }

    public List<Cadou> getSantaGiftsList() {
        return santaGiftsList;
    }

    public void setSantaGiftsList(List<Cadou> santaGiftsList) {
        this.santaGiftsList = santaGiftsList;
    }
}
