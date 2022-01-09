package myclasses;

import java.util.List;

public class ChildrenOneYear {
    List<ChildOut> children;

    public ChildrenOneYear() {
    }

    public ChildrenOneYear(List<ChildOut> children) {
        this.children = children;
    }

    public List<ChildOut> getChildren() {
        return children;
    }

    public void setChildren(List<ChildOut> children) {
        this.children = children;
    }
}
