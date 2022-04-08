package Navigation;

import nl.ardemium.*;

import java.util.ArrayList;

public class Controller {

    int position;
    Leraar leraar;
    Student student;
    private ArrayList<Examen> overzichtExamens;

    public Controller(User sessionUser, int position) {
        if (sessionUser.getClass() == Leraar.class) {
            this.leraar = ((Leraar) sessionUser);
        } else {
            this.student = ((Student) sessionUser);
        }
        this.position = position;
        this.overzichtExamens = initOverzichtExamens();
        checkScreen();
    }

    private ArrayList<Examen> initOverzichtExamens() {
        ArrayList<Examen> overzichtExamens = new ArrayList<>();
        ArrayList<String> examens = ASON.stripValue("examen", "dbOverzichtExamens");
        for (String s : examens) {
            overzichtExamens.add(new Examen(s));
        }
        return overzichtExamens;
    }

    public void checkScreen() {
        switch (position) {
            case 0 -> System.out.print("");
            case 1 -> screenUserPortal();
            case 2 -> screenAdminPortal();
            case 3 -> screenStudentenPerExamen();
            case 4 -> screenExamensPerStudent();
            case 5 -> screenResultatetnVanStudent();
            case 6 -> screenScorebordPerExamen();
            case 7 -> screenInschrijvenExamen();
            case 8 -> screenExamenAfnemen();
            case 9 -> screenExamenResultaten();
            default -> checkScreen();
        }
    }

    private void screenExamenResultaten() {
        int counter = 1;
        for (Examen e : student.getIngeschrevenExamens()) {
            System.out.println(counter + ")" + e.getNaam());
            counter++;
        }
        System.out.println("0) Exit");

        String input = Prompt.askInput();
        try {
            int parseInput = Integer.parseInt(input);
            if (parseInput == 0) {
                position = 1;
            } else {
                student.examenResultaten(student.getIngeschrevenExamens().get(parseInput - 1));
            }
        } catch (Exception e) {
            checkScreen();
        }
        checkScreen();
    }

    private void screenExamenAfnemen() {
        int counter = 1;
        for (Examen e : student.getIngeschrevenExamens()) {
            System.out.println(counter + ")" + e.getNaam());
            counter++;

        }
        System.out.println("0) Exit");

        String input = Prompt.askInput();
        try {
            int parseInput = Integer.parseInt(input);
            if (parseInput == 0) {
                position = 1;
            } else {
                student.examenAfnemen(student.getIngeschrevenExamens().get(parseInput - 1));
            }
        } catch (Exception e) {
            checkScreen();
        }
        checkScreen();
    }

    private void screenInschrijvenExamen() {
        int counter = 1;
        ArrayList<Examen> nietIngeschreven = new ArrayList<>();
        for (Examen e : overzichtExamens) {
            if(!student.getIngeschrevenExamens().contains(e)){
                System.out.println(counter + ")" + e.getNaam());
                nietIngeschreven.add(e);
                counter++;
            }
        }
        System.out.println("0) Exit");

        String input = Prompt.askInput();
        try {
            int parseInput = Integer.parseInt(input);
            if (parseInput == 0) {
                position = 1;
            } else {
                student.examenInschrijven(nietIngeschreven.get(parseInput-1));
            }
        } catch (Exception e) {
            checkScreen();
        }
        checkScreen();
    }

    private void screenScorebordPerExamen() {
        int counter = 1;
        for (Examen e : overzichtExamens) {
            System.out.println(counter + ")" + e.getNaam());
            counter++;
        }
        System.out.println("0) Exit");

        String input = Prompt.askInput();
        try {
            int parseInput = Integer.parseInt(input);
            if (parseInput == 0) {
                position = 2;
            } else {
                leraar.scorebord(overzichtExamens.get(parseInput-1));
            }
        } catch (Exception e) {
            checkScreen();
        }
        checkScreen();
    }

    private void screenResultatetnVanStudent() {
        int counter = 1;
        for (Student s : leraar.getOverzichtStudenten()) {
            System.out.println(counter + ")" + s.getNummerGebruiker());
            counter++;
        }
        System.out.println("0) Exit");

        String input = Prompt.askInput();
        try {
            int parseInput = Integer.parseInt(input);
            if (parseInput == 0) {
                position = 2;
            } else {
                leraar.behaaldeResultaten(leraar.getOverzichtStudenten().get(parseInput-1));
            }
        } catch (Exception e) {
            checkScreen();
        }
        checkScreen();
    }

    private void screenExamensPerStudent() {
        int counter = 1;
        for (Student s : leraar.getOverzichtStudenten()) {
            System.out.println(counter + ")" + s.getNummerGebruiker());
            counter++;
        }
        System.out.println("0) Exit");

        String input = Prompt.askInput();
        try {
            int parseInput = Integer.parseInt(input);
            if (parseInput == 0) {
                position = 2;
            } else {
                leraar.ingeschrevenExamens(leraar.getOverzichtStudenten().get(parseInput-1));
            }
        } catch (Exception e) {
            checkScreen();
        }
        checkScreen();
    }

    private void screenStudentenPerExamen() {
        int counter = 1;
        for (Examen e : overzichtExamens) {
            System.out.println(counter + ")" + e.getNaam());
            counter++;
        }
        System.out.println("0) Exit");

        String input = Prompt.askInput();
        try {
            int parseInput = Integer.parseInt(input);
            if (parseInput == 0) {
                position = 2;
            } else {
                leraar.ingeschrevenStudenten(overzichtExamens.get(parseInput-1));
            }
        } catch (Exception e) {
            checkScreen();
        }
        checkScreen();
    }

    private void screenAdminPortal() {

        System.out.printf("1) %s%n2) %s%n3) %s%n4) %s%n0) %s%n",
                "Zie alle ingeschreven studenten voor een specifiek examen",
                "Zie alle ingeschreven examens voor een specifieke student",
                "Zie alle behaalde resultaten van een specifieke student",
                "Zie de hoogste cijfers die behaald zijn voor een specifiek examen",
                "Uitloggen");
        String input = Prompt.askInput();
        try {
            switch (Integer.parseInt(input)) {
                case 0:
                    position = 0;
                    break;
                case 1:
                    position = 3;
                    break;
                case 2:
                    position = 4;
                    break;
                case 3:
                    position = 5;
                    break;
                case 4:
                    position = 6;
                    break;
                default:
                    checkScreen();
                    break;
            }
        } catch (Exception e) {
            checkScreen();
        }
        checkScreen();
    }

    private void screenUserPortal() {

        System.out.printf("1) %s%n2) %s%n3) %s%n0) %s%n",
                "Inschrijven voor een examen",
                "Examen afnemen",
                "Examen Resultaten",
                "Uitloggen");
        String input = Prompt.askInput();
        try {
            switch (Integer.parseInt(input)) {
                case 0:
                    position = 0;
                    break;
                case 1:
                    position = 7;
                    break;
                case 2:
                    position = 8;
                    break;
                case 3:
                    position = 9;
                    break;
                default:
                    checkScreen();
                    break;
            }
        } catch (Exception e) {
            checkScreen();
        }
        checkScreen();
    }

}

