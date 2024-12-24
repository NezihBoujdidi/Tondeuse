package tn.nezih.tondeuse;

public class Pelouse {
    private final int Max_X;
    private final int Max_Y;

    public Pelouse(int Max_X, int Max_Y) {
        this.Max_X = Max_X;
        this.Max_Y = Max_Y;
    }

    public int getMax_X() {
        return Max_X;
    }

    public int getMax_Y() {
        return Max_Y;
    }

    public boolean insidePelouse(int X, int Y) {
        return (X >= 0) && (X <= Max_X) && (Y >= 0) && (Y <= Max_Y);
    }
}
