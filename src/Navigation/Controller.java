package Navigation;

import nl.proj1.*;

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
        Prompt.promptLine();
        System.out.println(Prompt.ANSI_GREEN  + "Je hebt Examen Resultaten gekozen, selecteer hieronder een examen" + Prompt.ANSI_RESET);
        int counter = 1;
        for (Examen e : student.getIngeschrevenExamens()) {
            System.out.println(counter + ")" + e.getNaam());
            counter++;
        }
        System.out.println("0) Return");

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
        Prompt.promptLine();
        System.out.println(Prompt.ANSI_GREEN  + "Je hebt Examen ِafnemen gekozen, selecteer hieronder een examen" + Prompt.ANSI_RESET);
        int counter = 1;
        for (Examen e : student.getIngeschrevenExamens()) {
            System.out.println(counter + ")" + e.getNaam());
            counter++;

        }
        System.out.println("0) Return");

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
        Prompt.promptLine();
        System.out.println(Prompt.ANSI_GREEN  + "Je hebt Inschrijven voor een examen gekozen, selecteer hieronder een examen" + Prompt.ANSI_RESET);
        int counter = 1;
        ArrayList<Examen> nietIngeschreven = new ArrayList<>();
        for(int i= 0; i< overzichtExamens.size(); i++){
                Examen e = overzichtExamens.get(i);
                boolean endState = false;
                for (int j = 0; j < student.getIngeschrevenExamens().size(); j++){
                    if(student.getIngeschrevenExamens().get(j).getNaam().equals(overzichtExamens.get(i).getNaam())){
                        endState = true;
                    }
                }
                if(!endState){
                System.out.println(counter + ")" + e.getNaam());
                nietIngeschreven.add(e);
                counter++;}
            }

        System.out.println("0) Return");

        String input = Prompt.askInput();
        try {
            int parseInput = Integer.parseInt(input);
            if (parseInput == 0) {
                position = 1;
            } else {
                Examen examen = nietIngeschreven.get(parseInput-1);
                student.examenInschrijven(nietIngeschreven.get(parseInput-1));
        System.out.println(Prompt.ANSI_GREEN  + "Je bent nu ingeschreven voor het examen " + examen.getNaam() +  Prompt.ANSI_RESET);

            }
        } catch (Exception e) {
            checkScreen();
        }
        checkScreen();
    }

    private void screenScorebordPerExamen() {
        Prompt.promptLine();
        System.out.println(Prompt.ANSI_GREEN + "Je hebt hoogste cijfers per specifieke examen gekozen, kies een examen hieronder" +  Prompt.ANSI_RESET);

        int counter = 1;
        for (Examen e : overzichtExamens) {
            System.out.println(counter + ")" + e.getNaam());
            counter++;
        }
        System.out.println("0) Return");

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
        Prompt.promptLine();
        System.out.println(Prompt.ANSI_GREEN + "Je hebt behaalde resultaten van een specifieke student gekozen, kies een student hieronder" +  Prompt.ANSI_RESET);

        int counter = 1;
        for (Student s : leraar.getOverzichtStudenten()) {
            System.out.println(counter + ")" + s.getNummerGebruiker());
            counter++;
        }
        System.out.println("0) Return");

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
        Prompt.promptLine();
        System.out.println(Prompt.ANSI_GREEN + "Je hebt examens per specifieke student gekozen, kies een student hieronder" +  Prompt.ANSI_RESET);

        int counter = 1;
        for (Student s : leraar.getOverzichtStudenten()) {
            System.out.println(counter + ")" + s.getNummerGebruiker());
            counter++;
        }
        System.out.println("0) return");

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
        Prompt.promptLine();
        System.out.println(Prompt.ANSI_GREEN + "Je hebt studenten per specifieke examen gekozen, kies een examen hieronder" +  Prompt.ANSI_RESET);

        int counter = 1;
        for (Examen e : overzichtExamens) {
            System.out.println(counter + ")" + e.getNaam());
            counter++;
        }
        System.out.println("0) Return");

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
        Prompt.promptLine();
        System.out.println(Prompt.ANSI_GREEN + "Welkom bij admin portal!" +  Prompt.ANSI_RESET);

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
        Prompt.promptLine();
        System.out.println(Prompt.ANSI_GREEN + "Welkom bij studenten portal!" +  Prompt.ANSI_RESET);
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

