package gifts;

public class Santa {

    private final ChildrenRepository childrenRepository;

    public Santa(ChildrenRepository childrenRepository) {
        this.childrenRepository = childrenRepository;
    }

    public Toy chooseToyForChild(String childName){
        Child child = childrenRepository.findChildByName(childName);

        return child.computeWish();
    }
}
