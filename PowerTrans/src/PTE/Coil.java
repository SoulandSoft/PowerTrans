package PTE;

import java.io.Serializable;
import android.util.Log;
public class Coil implements Serializable {

    //Fields
    private double voltage;                 // Voltage in V         must be set by user
    private double current;                 // Current in A         must be set by user
    private double n_of_turns;               // Number of turns     (computable)
    private double wire_diameter;            // Diameter of wire    (computable)
    private double power;                   // Power of coil       (computable)


    public void update(double v, double cur) {
        setVoltage(v);
        setCurrent(cur);

    }


    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;

    }

    public double getCurrent() {
        Log.d("AMOUNT", "Coil current is " + current);
        return current;
    }

    public void setCurrent(double current) {

        this.current = current;
    }


    public void calculate(double Bmax, double J, double Sst) {
        n_of_turns = 45.0 * voltage / (Bmax * Sst);
        wire_diameter = 1.13 * Math.sqrt(current / J);
    }

    public double getPower() {
        power = getCurrent() * getVoltage();
        return power;
    }


}
