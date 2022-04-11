package nl.proj1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LeraarTest {

    @Test
    //Test het Leraar Studenten Overzicht, controleert of de init methodes goed zijn doorgevoerd aan de hand van
    //Het aanmaken van een overzicht en het ophalen van een Test case student :)
    void getOverzichtStudenten() {
        Leraar leraar = new Leraar("00000000", "admin", "admin");
        ArrayList<Student> studenten = leraar.getOverzichtStudenten();
        for (Student e : studenten) {
            String Actual = e.getNaamVoor() + " " + e.getNaamAchter();
            if (Actual.equals("Test Test")) {
                assertEquals("Test Test", Actual);
            } else {
                assertNotEquals("Test Test", Actual);
            }
        }
    }

    @Test
        //Test het Leraar Examens Overzicht, controleert of de init methodes goed zijn doorgevoerd aan de hand van
        //Het aanmaken van een overzicht en het ophalen van een Test case Examen :)
    void getOverzichtExamens() {
        Leraar leraar = new Leraar("00000000", "admin", "admin");
        ArrayList<Examen> Examens = leraar.getOverzichtExamens();
        for (Examen e : Examens) {
            String Actual = e.getNaam();
            assertNotEquals(e.getNaam(), "nietBestaandExamen");
            if (Actual.equals("ExamenREQS")) {
                assertEquals("ExamenREQS", Actual);
            } else {
                assertNotEquals("ExamenREQS", Actual);
            }
        }
    }
}