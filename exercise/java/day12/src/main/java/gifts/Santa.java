package gifts;

public class Santa {

    private final ChildrenRepository childrenRepository;

    public Santa(ChildrenRepository childrenRepository) {
        this.childrenRepository = childrenRepository;
    }

    public Toy chooseToyForChild(String childName){
        Child child = childrenRepository.findChildByName(childName);

        if(Behavior.NAUGHTY.equals(child.getBehavior()))
            return child.getLastWish();

        if(Behavior.NICE.equals(child.getBehavior()))
            return child.getSecondWish();

        if(Behavior.VERY_NICE.equals(child.getBehavior()))
            return child.getFirstWish();

        return null;
    }
}
