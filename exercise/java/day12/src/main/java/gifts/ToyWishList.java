package gifts;

import java.util.List;

public class ToyWishList {
    private final List<Toy> wishlist;

    public ToyWishList(Toy firstChoice, Toy secondChoice, Toy thirdChoice) {
        wishlist = List.of(firstChoice, secondChoice, thirdChoice);
    }

    public Toy getFirstWish() {
        return wishlist.getFirst();
    }

    public Toy getSecondWish() {
        return wishlist.get(1);
    }

    public Toy getLastWish() {
        return wishlist.getLast();
    }

}
