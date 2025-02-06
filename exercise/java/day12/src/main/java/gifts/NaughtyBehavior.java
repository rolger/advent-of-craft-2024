package gifts;

public class NaughtyBehavior extends ChildBehavior {
    public NaughtyBehavior( ToyWishList wishlist) {
        super(wishlist);
    }

    @Override
    public Toy wish() {
        return wishlist.getLastWish();
    }
}
