package PTE;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;

public class PowerTransformer implements Serializable {

    enum Construction_Type {Shell, Core, Toroid}

    // constants
    public static final double Kzok = 0.3;
    public static final double Kst = 0.9;

    public Coil primary;                           // Primary coil is only one.
    public ArrayList<Coil> secondaries;            // Secondary coils may by multiple.
    private double power;
    private Construction_Type core;
    private double min_SstSok;
    private double Sst;
    private double Sok;
    private double Bmax;
    private double J;
    private double kpd;
    private double CosFi;
        public PowerTransformer() {

        core = Construction_Type.Shell;
        primary = new Coil();
        primary.setVoltage(0);
        secondaries = new ArrayList<Coil>();
        power = 0;
    }

    public double get_Power() {

        power = 0;
        for (Coil c : secondaries) {
            power += c.getPower();
        }
        return power;
    }

    public double get_Bmax() {

    switch (core) {

            case Shell:
                if (power >= 5.0 && power < 15.0) {
                    Bmax = 1.1 + 0.2 * (power - 5.0) / 10.0;                  // varies from 1.3 on 50 to  1.35 on 150
                } else if (power >= 15.0 && power < 50.0) {
                    Bmax = 1.3;
                } else if (power >= 50.0 && power < 150.0) {
                    Bmax = 1.3 + 0.05 * (power - 50) / 100.0;               // varies from 1.3 on 50 to  1.35 on 150
                } else if (power >= 150.0 && power < 300.0) {
                    Bmax = 1.35;
                } else if (power >= 300.0 && power <= 1000.0) {
                    Bmax = 1.35 - 0.15 * (power - 300.0) / 700.0;         // varies from 1.35 on 300 to  1.2 on 1000
                }
                break;

            case Core:
                if (power >= 5.0 && power < 15.0) {
                    Bmax = 1.55;
                } else if (power >= 15 && power <= 1000.0) {
                    Bmax = 1.65;
                }
                break;

            case Toroid:
                if (power >= 5.0 && power < 150.0) {
                    Bmax = 1.7;
                } else if (power >= 150.0 && power < 300.0) {
                    Bmax = 1.65;
                } else if (power >= 300.0 && power <= 1000.0) {
                    Bmax = 1.6;
                }
                break;


            default:
                break;
        }
        Log.d("AMOUNT", "BMax is " + Bmax);
        return Bmax;

    }

    public double get_J() {

        switch (core) {
            case Shell:
                if (power >= 5.0 && power < 15.0) {
                    J = 3.9 - 0.9 * (power - 5.0) / 10.0;                 // varies from 3.9 on 5 to  3.0 on 15
                } else if (power >= 15.0 && power < 50.0) {
                    J = 3.0 - 0.6 * (power - 15.0) / 35.0;               // varies from 3.0 jn 15 to 2.4 on 50
                } else if (power >= 50.0 && power < 150.0) {
                    J = 2.4 - 0.4 * (power - 50) / 100.0;               // varies from 2.4 on 50 to  2.0 on 150
                } else if (power >= 150.0 && power < 300.0) {
                    J = 2.0 - 0.3 * (power - 150) / 150;                  // varies form 2.0 on 150 to 1.7 on 300
                } else if (power >= 300.0 && power <= 1000.0) {
                    J = 1.7 - 0.3 * (power - 300.0) / 700.0;            // varies from 1.7 on 300 to  1.4 on 1000
                }
                break;

            case Core:
                if (power >= 5.0 && power < 15.0) {
                    J = 3.8 - 0.3 * (power - 5.0) / 10.0;                 // varies from 3.9 on 5 to  3.0 on 15
                } else if (power >= 15.0 && power < 50.0) {
                    J = 3.5 - 0.8 * (power - 15.0) / 35.0;               // varies from 3.0 jn 15 to 2.4 on 50
                } else if (power >= 50.0 && power < 150.0) {
                    J = 2.7 - 0.3 * (power - 50) / 100.0;               // varies from 2.4 on 50 to  2.0 on 150
                } else if (power >= 150.0 && power < 300.0) {
                    J = 2.4 - 0.1 * (power - 150) / 150;                  // varies form 2.0 on 150 to 1.7 on 300
                } else if (power >= 300.0 && power <= 1000.0) {
                    J = 1.3 - 0.5 * (power - 300.0) / 700.0;            // varies from 1.7 on 300 to  1.4 on 1000
                }
                break;

            case Toroid:
                if (power >= 5.0 && power < 50.0) {
                    J = 5.0 - 0.5 * (power - 5) / 45.0;                 // varies from 5.0 on 5 to  4.5 on 50
                } else if (power >= 50.0 && power < 150.0) {
                    J = 4.5 - 1.0 * (power - 50) / 100.0;               // varies from 4.5 on 50 to  3.5 on 150
                } else if (power >= 150.0 && power < 300.0) {
                    J = 3.5;
                } else if (power >= 300.0 && power <= 1000.0) {
                    J = 3.0;
                }
                break;
        }

        Log.d("AMOUNT", "J is " + J);
        return J;
    }

    public double get_kpd() {

        switch (core) {
            case Shell:
                if (power >= 2.0 && power < 15.0) {
                    kpd = 0.5 + 0.1 * (power - 2.0) / 13.0;
                } else if (power >= 15.0 && power < 50.0) {
                    kpd = 0.6 + 0.2 * (power - 15.0) / 35.0;
                } else if (power >= 50.0 && power < 150.0) {
                    kpd = 0.8 + 0.1 * (power - 50) / 100.0;
                } else if (power >= 150.0 && power < 300.0) {
                    kpd = 0.9 + 0.03 * (power - 150) / 150;
                } else if (power >= 300.0 && power <= 1000.0) {
                    kpd = 0.93 + 0.03 * (power - 300.0) / 700.0;
                }
                break;

            case Core:    // Same as Toroid, because they are taped
            case Toroid:
                if (power >= 2.0 && power < 50.0) {
                    kpd = 0.76 + 0.11 * (power - 2.0) / 48.0;
                } else if (power >= 50.0 && power < 150.0) {
                    kpd = 0.88 + 0.04 * (power - 50) / 100.0;
                } else if (power >= 150.0 && power < 300.0) {
                    kpd = 0.92 + 0.03 * (power - 150) / 150;
                } else if (power >= 300.0 && power <= 1000.0) {
                    kpd = 0.96;
                }
                break;
        }
        Log.d("AMOUNT", "kpd is " + kpd);
        return kpd;
    }

    public double get_CosFi() {


        get_Power();
        if (power >= 2.0 && power < 15.0) {
            CosFi = 0.85 + 0.05 * (power - 2.0) / 13.0;
        } else if (power >= 50.0 && power < 150.0) {
            CosFi = 0.9 + 0.03 * (power - 50) / 100.0;
        } else if (power >= 150.0 && power < 300.0) {
            CosFi = 0.93 + 0.02 * (power - 150) / 150;
        } else if (power >= 300.0 && power <= 1000.0) {
            CosFi = 0.94;
        }
        Log.d("AMOUNT", "CosFi is " + CosFi);
        return CosFi;
    }

    public double calc_I_primary() {

        primary.setCurrent(get_Power() / (primary.getVoltage() * get_kpd() * get_CosFi()));
        return primary.getCurrent();
    }

    public double calc_min_SstSok() {

        min_SstSok = 0.901 * get_Power() / (get_Bmax() * get_J() * Kzok * Kst * get_kpd());
        return min_SstSok;
    }

    public void calc_secondaries() {

        for (Coil c : secondaries) {
            c.calculate(get_Bmax(), get_J(), Sst);
        }
    }

    public void set_Sst(double S) {

        Sst = S;
    }

    public void set_Sok(double S) {

        Sok = S;
    }

    public void remove_secondary(int index) {

        secondaries.remove(index);
    }

    public void add_secondary() {

        secondaries.add(new Coil());
    }

    public void setCore(int ind){
        switch (ind) {
            case 0: core = Construction_Type.Shell;
                break;
            case 1: core = Construction_Type.Core;
                break;
            case 2: core = Construction_Type.Toroid;
                break;
            default: break;
        }
    }
    public void calculate() {

    calc_min_SstSok();
    calc_I_primary();
    calc_secondaries();

    }
}