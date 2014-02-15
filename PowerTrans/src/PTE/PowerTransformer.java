package PTE;

import java.util.ArrayList;

public class PowerTransformer {
    enum Construction_Type {Shell, Core, Toroid}

    private Coil primary;                           // Primary coil is only one.
    private ArrayList<Coil> secondaries;            // Secondary coils may by multiple.
    private double power;
    private Construction_Type core;

    public double get_Power() {
        power = 0;
        for (Coil c : secondaries) {
            power += c.getPower();
        }
        return power;
    }

    // Magic numbers!!!
    public double get_Bmax(double power) {
        double Bmax = 0;
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

        return Bmax;
    }

    public double get_J(double power) {
        double J = 0;
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

        return J;
    }

    public double get_kpd() {
        double kpd = 0;
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

        }
        return kpd;
    }
    // Kzok (Window copper filling) = 0.3
    // Kst  (Steel filling ) = 0.9
}
