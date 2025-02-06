package gifts;

public class Santa {

    private final ChildrenRepository childrenRepository;

    public Santa(ChildrenRepository childrenRepository) {
        this.childrenRepository = childrenRepository;
    }

    public Toy chooseToyForChild(String childName){
        Child child = childrenRepository.findChildByName(childName);

        if("naughty".equals(child.getBehavior()))
            return child.getWishlist().get(child.getWishlist().size() - 1);

        if("nice".equals(child.getBehavior()))
            return child.getWishlist().get(1);

        if("very nice".equals(child.getBehavior()))
            return child.getWishlist().get(0);

        return null;
    }
}
