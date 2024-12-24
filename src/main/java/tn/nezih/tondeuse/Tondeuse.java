package tn.nezih.tondeuse;

public class Tondeuse {
    private final Position currentPosition;
    private final Pelouse pelouse;

    public Tondeuse(Position initialPosition, Pelouse pelouse) {
        this.currentPosition = initialPosition;
        this.pelouse = pelouse;
    }

    public void executeListOfInstructions(String instructions) {
        for (char instruction : instructions.toCharArray()) {
            switch (instruction){
                case 'A': currentPosition.advance(pelouse);
                            break;
                case 'D': currentPosition.turnRight();
                            break;
                case 'G': currentPosition.turnLeft();
                            break;
                default:
                    throw new IllegalArgumentException("Instruction invalide: " + instruction);
            }
        }
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public Pelouse getPelouse() {
        return pelouse;
    }

    @Override
    public String toString() {
        return "Tondeuse{" +
                "currentPosition=" + currentPosition +
                ", pelouse=" + pelouse +
                '}';
    }
}
