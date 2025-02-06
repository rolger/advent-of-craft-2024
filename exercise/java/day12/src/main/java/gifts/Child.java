package gifts;

public class Child {

    private final String name;
    private final String behavior;
    private ToyWishList wishlist;

    public Child(String name, String behavior) {
        this.name = name;
        this.behavior = behavior;
    }

    public String getBehavior() {
        return behavior;
    }

    public String getName() {
        return name;
    }

    public void setWishList(Toy firstChoice, Toy secondChoice, Toy thirdChoice) {
        this.wishlist = new ToyWishList(firstChoice, secondChoice, thirdChoice);
    }

    public Toy getLastWish() {
        return wishlist.getLastWish();
    }

    public Toy getSecondWish() {
        return wishlist.getSecondWish();
    }

    public Toy getFirstWish() {
        return wishlist.getFirstWish();
    }
}
