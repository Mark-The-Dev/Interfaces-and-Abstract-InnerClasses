package InnerClasses;

import java.util.ArrayList;

public class Gearbox {
    private ArrayList<Gear> gears;
    private int maxGears;
    private int currentGear = 0;
    private boolean clutchIsIn;

    public Gearbox(int maxGears) {
        this.maxGears = maxGears;
        this.gears = new ArrayList<Gear>();
        Gear neutral = new Gear(0, 0.0);
        this.gears.add(neutral);

        for (int i=0; i< maxGears; i++){
            addGear(i, i*5.3);
        }
    }

    public void operateClutch(boolean in){
        this.clutchIsIn = in;
    }

    public void addGear(int num, double ratio){
        if ((num > 0) && (num <= maxGears)){
            this.gears.add(new Gear(num, ratio));
        }
    }

    public void changeGear(int newGear){
        if (newGear >= 0 && (newGear < this.gears.size()) && this.clutchIsIn){
            this.currentGear = newGear;
            System.out.println("Gear " + newGear + " selected.");
        } else {
            System.out.println("Grind noise. . . ut oh!");
        }
    }

    public double wheelSpeed(int revs){
        if (clutchIsIn){
            System.out.println("Scream!!");
            return 0.0;
        } else {
            return revs * gears.get(currentGear).getRatio();
        }
    }

    private class Gear {
        private int gearNumber;
        public double ratio;

        public Gear(int gearNumber, double ratio) {
            this.gearNumber = gearNumber;
            this.ratio = ratio;
        }

        public double getRatio() {
            return ratio;
        }

        public double driveSpeed(int revs){
            return revs * this.ratio;
        }
    }
}
