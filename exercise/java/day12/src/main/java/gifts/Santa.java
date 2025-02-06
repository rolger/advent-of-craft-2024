package gifts;

public class Santa {

    private final ChildrenRepository childrenRepository;

    public Santa(ChildrenRepository childrenRepository) {
        this.childrenRepository = childrenRepository;
    }

    public Toy chooseToyForChild(String childName){
        Child child = childrenRepository.findChildByName(childName);

        if("naughty".equals(child.getBehavior()))
            return child.getLastWish();

        if("nice".equals(child.getBehavior()))
            return child.getSecondWish();

        if("very nice".equals(child.getBehavior()))
            return child.getFirstWish();

        return null;
    }
}
