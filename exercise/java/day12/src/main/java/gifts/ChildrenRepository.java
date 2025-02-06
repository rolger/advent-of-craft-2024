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
        Optional<Child> found = Optional.empty();
        for (int i = 0; i < children.size(); i++) {
            Child currentChild = children.get(i);
            if (currentChild.getName().equals(childName)) {
                found = Optional.of(currentChild);
            }
        }
        return found.orElseThrow(NoSuchElementException::new);
    }

    public void add(Child child) {
        children.add(child);
    }
}
