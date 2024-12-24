package tn.nezih.tondeuse;

public class Position {
    private int x;
    private int y;
    private char orientation;

    public Position(int x, int y, char orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public char getOrientation() {
        return orientation;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void setOrientation(char orientation) {
        this.orientation = orientation;
    }


    public void advance(Pelouse pel){
        int new_y= y ;
        int new_x= x;

        switch (orientation) {
            case 'N': new_y++; break;
            case 'E': new_x++; break;
            case 'W': new_x--; break;
            case 'S': new_y--; break;
        }

        if (pel.insidePelouse(new_x, new_y)) {
            x = new_x;
            y = new_y;
        }
    }

    public void turnRight(){
        switch(orientation){
            case 'N': orientation='E'; break;
            case 'E': orientation='S'; break;
            case 'W': orientation='N'; break;
            case 'S': orientation='W'; break;
        }
    }

    public void turnLeft(){
        switch(orientation){
            case 'N': orientation='W'; break;
            case 'E': orientation='N'; break;
            case 'S': orientation='E'; break;
            case 'W': orientation='S'; break;
        }
    }

    @Override
    public String toString() {
        return x +" "+ y +" "+ orientation;
    }
}
