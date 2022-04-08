package nl.ardemium;

import java.util.Scanner;

public class Prompt {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001b[31m";

    public static void promptLogo() {
        System.out.println(ANSI_RED + "\nMM'\"\"\"\"\"`MMM M\"\"MMMMM\"\"M M\"\"M M\"\"\"\"\"\"\"\"`M    M\"\"\"\"\"`'\"\"\"`YM MMP\"\"\"\"\"\"\"MM MP\"\"\"\"\"\"`MM M\"\"\"\"\"\"\"\"M MM\"\"\"\"\"\"\"\"`M MM\"\"\"\"\"\"\"`MM \n" +
                "M  .mmm,  MM M  MMMMM  M M  M Mmmmmm   .M    M  mm.  mm.  M M' .mmmm  MM M  mmmmm..M Mmmm  mmmM MM  mmmmmmmM MM  mmmm,  M \n" +
                "M  MMMMM  MM M  MMMMM  M M  M MMMMP  .MMM    M  MMM  MMM  M M         `M M.      `YM MMMM  MMMM M`      MMMM M'        .M \n" +
                "M  MM  M  MM M  MMMMM  M M  M MMP  .MMMMM    M  MMM  MMM  M M  MMMMM  MM MMMMMMM.  M MMMM  MMMM MM  MMMMMMMM MM  MMMb. \"M \n" +
                "M  `MM    MM M  `MMM'  M M  M M' .MMMMMMM    M  MMM  MMM  M M  MMMMM  MM M. .MMM'  M MMMM  MMMM MM  MMMMMMMM MM  MMMMM  M \n" +
                "MM.    .. `M Mb       dM M  M M         M    M  MMM  MMM  M M  MMMMM  MM Mb.     .dM MMMM  MMMM MM        .M MM  MMMMM  M \n" +
                "MMMMMMMMMMMT MMMMMMMMMMY MMMP MMMMMMMMMME    MMMMMMMMMMMMMM MMMMMMMMMMMH MMMMMMMMMME MMMMMMMMML MMMMMMMMMMMP MMMMMMMMMMMM\n" + ANSI_RESET);
    }

    public static String askInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }












































































































































































































































































































































































































    public static void promptHelp() {
        System.out.println("_____/\\\\\\\\\\\\\\\\\\\\\\_______________/\\\\\\\\\\________________/\\\\\\\\\\\\\\\\\\\\\\___        \n" +
                " ___/\\\\\\/////////\\\\\\___________/\\\\\\///\\\\\\____________/\\\\\\/////////\\\\\\_       \n" +
                "  __\\//\\\\\\______\\///__________/\\\\\\/__\\///\\\\\\_________\\//\\\\\\______\\///__      \n" +
                "   ___\\////\\\\\\________________/\\\\\\______\\//\\\\\\_________\\////\\\\\\_________     \n" +
                "    ______\\////\\\\\\____________\\/\\\\\\_______\\/\\\\\\____________\\////\\\\\\______    \n" +
                "     _________\\////\\\\\\_________\\//\\\\\\______/\\\\\\________________\\////\\\\\\___   \n" +
                "      __/\\\\\\______\\//\\\\\\_________\\///\\\\\\__/\\\\\\___________/\\\\\\______\\//\\\\\\__  \n" +
                "       _\\///\\\\\\\\\\\\\\\\\\\\\\/____/\\\\\\____\\///\\\\\\\\\\/______/\\\\\\_\\///\\\\\\\\\\\\\\\\\\\\\\/___ \n" +
                "        ___\\///////////_____\\///_______\\/////_______\\///____\\///////////_____");
        System.out.println("\nused as an appeal for urgent assistance.\n" +
                "\"Help! I'm drowning!\"\n");
    }

}
