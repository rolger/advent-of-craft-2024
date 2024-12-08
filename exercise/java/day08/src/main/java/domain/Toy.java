package domain;

public class Toy {

    public enum State {
        UNASSIGNED, IN_PRODUCTION, COMPLETED
    }

    private final String name;
    private State state;
    private boolean isChanged;

    public Toy(String name, State state) {
        this.name = name;
        this.state = state;
        this.isChanged = true;
    }

    public String getName() {
        return name;
    }

    public boolean isChanged() {
        return isChanged;
    }

    public void setChanged(boolean changed) {
        isChanged = changed;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void assignToElf() {
        if (this.getState() == State.UNASSIGNED) {
            this.setState(State.IN_PRODUCTION);
            setChanged(true);
        }
    }

}