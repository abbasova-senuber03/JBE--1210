package happyFamilyProject;

import java.util.Arrays;

class Family {

    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;

    public Family(){}
    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new Human[0];
    }

    public Human getMother() { return mother; }
    public Human getFather() { return father; }
    public Human[] getChildren() { return children; }
    public Pet getPet() { return pet; }

    public void setPet(Pet pet) { this.pet = pet; }

    public void addChild(Human child) {
        Human[] newChildren = new Human[children.length + 1];
        for(int i=0;i<children.length;i++){
            newChildren[i]=children[i];
        }
        newChildren[children.length] = child;
        children = newChildren;
        //child.setFamily(this);
    }

    public boolean deleteChild(int index) {
        if (index < 0 || index >= children.length) return false;
        Human[] newChildren = new Human[children.length - 1];
        for (int i = 0, j = 0; i < children.length; i++) {
            if (i != index) newChildren[j++] = children[i];
        }
        children = newChildren;
        return true;
    }

    public int countFamily() {
        return 2 + children.length + (pet != null ? 1 : 0);
    }

    @Override
    public String toString() {
        return "Family{mother=" + mother + ", father=" + father + ", children=" + Arrays.deepToString( getChildren()) +
                ", pet=" + pet + "}";
    }
}