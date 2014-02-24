package PTE;

public class Coil {

    //Fields
    private double voltage;                 // Voltage in V         must be set by user
    private double current;                 // Current in A         must be set by user
    private double n_of_turns;               // Number of turns     (computable)
    private double wire_diameter;            // Diameter of wire    (computable)
    private double power;                   // Power of coil       (computable)

    //Constructors
    public Coil(double v, double cur) {
        setVoltage(v);
        setCurrent(cur);
        setPower(getVoltage() * getCurrent());
    }


    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;

    }

    public double getCurrent() {
        return current;
    }

    public void setCurrent(double current) {

        this.current = current;
    }

    public double getWire_diameter() {
        return wire_diameter;
    }

    public double getN_of_turns() {
        return n_of_turns;
    }

    public void calculate(double Bmax, double J, double Sst){
        n_of_turns = 45.0*voltage/(Bmax * Sst);
        wire_diameter = 1.13 *Math.sqrt(current/J);
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

}
