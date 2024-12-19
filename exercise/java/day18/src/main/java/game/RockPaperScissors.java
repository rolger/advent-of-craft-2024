package game;

public class RockPaperScissors {
    private RockPaperScissors() {
    }

    public static Result play(Choice player1, Choice player2) {
        if (player1.beatsWithMessage(player2).isPresent()) {
            return new Result(Winner.PLAYER_1, player1.beatsWithMessage(player2).get());
        }

        if (player2.beatsWithMessage(player1).isPresent()) {
            return new Result(Winner.PLAYER_2, player2.beatsWithMessage(player1).get());
        }

        return new Result(Winner.DRAW, "same choice");
    }
}