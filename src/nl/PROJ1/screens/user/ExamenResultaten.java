package nl.PROJ1.screens.user;
import nl.PROJ1.ASON;
import nl.PROJ1.Objects.User;
import nl.PROJ1.screens.other.Login;

import java.util.ArrayList;
import java.util.Scanner;

public class ExamenResultaten {
    public static ArrayList<String> ingeschrevenExamens = User.getIngeschrevenExamens();
    public static ArrayList<String> examenResultaten = User.getResultaten();
    public static ArrayList<String> isStudentIngeschreven = User.getIsStudentIngeschreven();

    public ExamenResultaten(ArrayList<String> ingeschrevenExamens, ArrayList<String> examenResultaten, ArrayList<String> isStudentIngeschreven){
        this.ingeschrevenExamens = ingeschrevenExamens;
        this.examenResultaten = examenResultaten;
        this.isStudentIngeschreven = isStudentIngeschreven;
    }
    public static int startExamenResultaten() {

        int counter = 1;
        for(int i = 0; i < ingeschrevenExamens.size(); i++){
            System.out.println(counter + ") " + ingeschrevenExamens.get(i));
            counter++;
        }
        System.out.println("0) Return");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        for (int i = 0; i < counter; i++) {
            if ((choice - 1) == i) {
            String str = ingeschrevenExamens.get(i);
                System.out.println("bekende resultaten voor dit examen zijn : ");
                for (int j = 0; j<examenResultaten.size(); j++){
                    if (examenResultaten.get(j).startsWith(str)){
                        System.out.println(examenResultaten.get(j));
                    }
                }
            }
            else if(choice == 0){
                return 2;
            }



        }

            return 4;
        }


}