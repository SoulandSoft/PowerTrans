package PTE;


import java.util.ArrayList;


public class PowerTransformer {
    enum CoreType {Shield, Straight, Toroid}

    private Coil primary;                           // Primary coil is only one.
    private ArrayList<Coil> secondaries;            // Secondary coils may by multiple.
    private double power;


    public double getPower() {
        power = 0;
        for (Coil c : secondaries) {
            power += c.getPower();
        }
        return power;
    }

    public double getBmax(double power, CoreType core) {
        double Bmax = 0;
        switch (core) {
            case Shield:
                if (power > 5.0 && power < 15.0) {
                    Bmax = 1.2;
                }
                break;
            case Straight:
                break;
            case Toroid:
                break;
            default:
                break;
        }

        return Bmax;
    }

}
