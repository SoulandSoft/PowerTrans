package PTE;

/**
 * Created with IntelliJ IDEA.
 * User: mrsoul
 * Date: 1/8/14
 * Time: 4:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class Coil {

    //Fields
    private double voltage = 0;                 // Voltage in V         must be set by user
    private double current = 0;                 // Current in A         must be set by user
    private float n_of_turns = 0;               // Number of turns     (computable)
    private float wire_diameter = 0;        // Diameter of wire    (computable)
    private double power = 0;               // Power of coil

    //Constructors
    public Coil (double v, double cur){
        setVoltage(v);
        setCurrent(cur);
        setPower(getVoltage()*getCurrent());
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
