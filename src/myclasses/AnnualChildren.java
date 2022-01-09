package myclasses;

import java.util.List;

public class AnnualChildren {
    List<ChildrenOneYear> annualChildren;

    public AnnualChildren() {
    }

    public AnnualChildren(List<ChildrenOneYear> annualChildren) {
        this.annualChildren = annualChildren;
    }

    public List<ChildrenOneYear> getAnnualChildren() {
        return annualChildren;
    }

    public void setAnnualChildren(List<ChildrenOneYear> annualChildren) {
        this.annualChildren = annualChildren;
    }
}
