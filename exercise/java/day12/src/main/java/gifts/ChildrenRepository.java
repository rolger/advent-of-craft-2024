package gifts;

public interface ChildrenRepository {
    Child findChildByName(String childName);

    void add(Child child);
}
