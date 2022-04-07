package nl.PROJ1.Objects;

public class BerekenCijferNumering {

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public static void geslaagdPlusCijfer(int vgoed, int vtotaal, double nterm) {
        double vcijfer = 9.0 * vgoed / vtotaal + nterm;
        double vcijferaf = round(vcijfer, 1);
        if (vcijferaf >= 5.5) {
            System.out.println("Je bent geslaagd! Je cijfer is: " + vcijferaf);
        } else {
            System.out.println("Je bent niet geslaagd! Je cijfer is: " + vcijferaf);
        }
    }
}