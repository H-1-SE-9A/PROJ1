package nl.PROJ1.screens.other;

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
                "MMMMMMMMMMMM MMMMMMMMMMM MMMM MMMMMMMMMMM    MMMMMMMMMMMMMM MMMMMMMMMMMM MMMMMMMMMMM MMMMMMMMMM MMMMMMMMMMMM MMMMMMMMMMMM" + ANSI_RESET);
    }

    public static void promptLine() {
        System.out.println(ANSI_RED + "88888888 88888888 88888888 88888888 88888888 88888888 88888888 88888888 88888888 88888888 88888888 88888888 88888888 88888888" + ANSI_RESET);
    }
}