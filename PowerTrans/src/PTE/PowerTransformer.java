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
                else if(power > 15.0 && power < 50){
                    Bmax=1.3;
                }
                else if (power > 50 && power < 300){
                    Bmax=1.35;
                }
                else if (power > 300 && power < 1000){
                    Bmax= 1.35 - 0.15*(power - 300.0)/700.0;    // varies from 1.35 for 300 to  1.2 for 1000
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
