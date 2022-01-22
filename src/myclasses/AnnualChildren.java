package myclasses;

import java.util.List;

public class AnnualChildren {
    private List<ChildrenOneYear> annualChildren;

    /**
     */
    public AnnualChildren() {
    }

    /**
     * @param annualChildren
     */
    public AnnualChildren(final List<ChildrenOneYear> annualChildren) {
        this.annualChildren = annualChildren;
    }

    /**
     * @return
     */
    public List<ChildrenOneYear> getAnnualChildren() {
        return annualChildren;
    }

    /**
     * @param annualChildren
     */
    public void setAnnualChildren(final List<ChildrenOneYear> annualChildren) {
        this.annualChildren = annualChildren;
    }
}
