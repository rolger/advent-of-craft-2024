package gifts;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ChildrenRepository {
    private final List<Child> children;

    public ChildrenRepository() {
        children = new ArrayList<>();
    }

    Child findChildByName(String childName) {
        return children.stream()
                .filter(child -> child.getName().equals(childName))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public void add(Child child) {
        children.add(child);
    }
}
