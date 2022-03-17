package nl.PROJ1;

import java.io.*;

public class ASON {
    private static void makeValue(String key, String value, String database) {
        try {
            File file = new File("ASON");
            file.mkdir();
            FileWriter fileWriter = new FileWriter("ASON/" + database, true);
            fileWriter.append(String.format("\"%s\":\"%s\",%n", key, value));
            fileWriter.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    private static void closeObject(String database) {
        try {
            File file = new File("ASON");
            file.mkdir();
            FileWriter fileWriter = new FileWriter("ASON/" + database, true);
            fileWriter.append(String.format("%n"));
            fileWriter.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public static void makeObject(String key1, String value1, String database) {
        makeValue(key1, value1, database);
        closeObject(database);
    }

    public static void makeObject(String key1, String value1, String key2, String value2, String database) {
        makeValue(key1, value1, database);
        makeValue(key2, value2, database);
        closeObject(database);
    }

    public static void makeObject(String key1, String value1, String key2, String value2, String key3, String value3, String database) {
        makeValue(key1, value1, database);
        makeValue(key2, value2, database);
        makeValue(key3, value3, database);
        closeObject(database);
    }

    public static boolean checkExist(String key, String value, String database) {
        try {
            BufferedReader bufferdReader = new BufferedReader(new FileReader("ASON/" + database));
            String line = bufferdReader.readLine();

            while (line != null) {
                if (line.contains(key)) {
                    String[] extraction = line.split(":");
                    extraction = extraction[1].split("\"");
                    String keyValue = extraction[1];
                    if (keyValue.equals(value)) {
                        return true;

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean checkMatch(String key, String value, String key2, String value2, String database) {
        try {
            BufferedReader bufferdReader = new BufferedReader(new FileReader("ASON/" + database));
            String line = bufferdReader.readLine();

            while (line != null) {
                if (line.contains(key)) {
                    String[] extraction = line.split(":");
                    extraction = extraction[1].split("\"");
                    if (extraction[1].equals(value)) {
                        line = bufferdReader.readLine();
                        if (line.contains(key2)) {
                            extraction = line.split(":");
                            extraction = extraction[1].split("\"");
                            if (extraction[1].equals(value2)) {
                                return true;
                            }
                        }
                    }
                }
                line = bufferdReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean checkMatch(String key, String value, String key2, String value2, String key3, String value3, String database) {
        try {
            BufferedReader bufferdReader = new BufferedReader(new FileReader("ASON/" + database));
            String line = bufferdReader.readLine();

            while (line != null) {
                if (line.contains(key)) {
                    String[] extraction = line.split(":");
                    extraction = extraction[1].split("\"");
                    if (extraction[1].equals(value)) {
                        line = bufferdReader.readLine();
                        if (line.contains(key2)) {
                            extraction = line.split(":");
                            extraction = extraction[1].split("\"");
                            if (extraction[1].equals(value2)) {
                                line = bufferdReader.readLine();
                                if (line.contains(key3)) {
                                    extraction = line.split(":");
                                    extraction = extraction[1].split("\"");
                                    if (extraction[1].equals(value3)) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
                line = bufferdReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}