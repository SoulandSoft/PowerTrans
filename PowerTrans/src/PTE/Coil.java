package PTE;

public class Coil {

    //Fields
    private double voltage;                 // Voltage in V         must be set by user
    private double current;                 // Current in A         must be set by user
    private float n_of_turns;               // Number of turns     (computable)
    private float wire_diameter;            // Diameter of wire    (computable)
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

    public float getWire_diameter() {
        return wire_diameter;
    }

    public void setWire_diameter(float wire_diameter) {
        this.wire_diameter = wire_diameter;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

}
