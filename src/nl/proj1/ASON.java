package nl.proj1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

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

    public static void makeObject(String key1, String value1,String key2, String value2,String key3, String value3, String database) {
        makeValue(key1, value1, database);
        makeValue(key2, value2, database);
        makeValue(key3, value3, database);
        closeObject(database);
    }
    public static void makeObject(String key1, String value1,String key2, String value2,String key3, String value3,String key4, String value4, String database) {
        makeValue(key1, value1, database);
        makeValue(key2, value2, database);
        makeValue(key3, value3, database);
        makeValue(key4, value4, database);
        closeObject(database);
    }

    public static void makeObject(String key1, String value1,String key2, String value2,String key3, String value3,String key4, String value4,String key5, String value5, String database) {
        makeValue(key1, value1, database);
        makeValue(key2, value2, database);
        makeValue(key3, value3, database);
        makeValue(key4, value4, database);
        makeValue(key5, value5, database);
        closeObject(database);
    }

    public static void addKey(String key, String database) {
        try {
            FileWriter fileWriter = new FileWriter("ASON/temp");
            BufferedReader bufferdReader = new BufferedReader(new FileReader("ASON/" + database));
            String line = bufferdReader.readLine();
            while (line != null) {
                if (line.isBlank()) {
                    fileWriter.append(String.format("\"%s\":\"Null\",%n", key));
                    fileWriter.append("\n");
                } else {
                    fileWriter.append(line);
                    fileWriter.append("\n");
                }
                line = bufferdReader.readLine();
            }
            fileWriter.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        copyTempTo(database);
    }

    private static void copyTempTo(String database) {
        try {
            FileWriter fileWriter = new FileWriter("ASON/" + database);
            BufferedReader bufferdReader = new BufferedReader(new FileReader("ASON/temp"));
            String line = bufferdReader.readLine();
            while (line != null) {
                fileWriter.append(line);
                fileWriter.append("\n");
                line = bufferdReader.readLine();
            }
            fileWriter.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> stripValue(String key, String database) {
        ArrayList<String> list = new ArrayList<>();
        try {
            BufferedReader bufferdReader = new BufferedReader(new FileReader("ASON/" + database));
            String line = bufferdReader.readLine();

            while (line != null) {
                if (line.contains(key)) {
                    String[] extraction = line.split(":");
                    extraction = extraction[1].split("\"");
                    list.add(extraction[1]);
                }
                line = bufferdReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void changeValue(String privateKey, String keyValue, String key, String value, String database) {
        try {
            FileWriter fileWriter = new FileWriter("ASON/temp");
            BufferedReader bufferdReader = new BufferedReader(new FileReader("ASON/" + database));
            String line = bufferdReader.readLine();
            while (line != null) {
                if (line.contains(privateKey)) {
                    String[] extraction = line.split(":");
                    extraction = extraction[1].split("\"");
                    if (extraction[1].equals(keyValue)) {
                        fileWriter.append(line);
                        fileWriter.append("\n");
                        line = bufferdReader.readLine();
                        while (!line.isBlank()) {
                            if (line.contains(key)) {
                                fileWriter.append(String.format("\"%s\":\"%s\",%n", key, value));
                                line = bufferdReader.readLine();
                                if (line == null || line.isBlank()) {
                                    break;
                                }
                            }
                            fileWriter.append(line);
                            fileWriter.append("\n");
                            line = bufferdReader.readLine();
                            if (line == null) {
                                break;
                            }
                        }
                    }
                }
                if (line == null) {
                    break;
                }
                fileWriter.append(line);
                fileWriter.append("\n");

                line = bufferdReader.readLine();


            }
            fileWriter.close();

        } catch (
                IOException e) {
            e.printStackTrace();
        }
        copyTempTo(database);
    }

    public static String getValue(String privateKey, String keyValue, String key, String database) {
        try {
            BufferedReader bufferdReader = new BufferedReader(new FileReader("ASON/" + database));
            String line = bufferdReader.readLine();
            while (line != null) {
                if (line.contains(privateKey)) {
                    String[] extraction = line.split(":");
                    extraction = extraction[1].split("\"");
                    if (extraction[1].equals(keyValue)) {
                        line = bufferdReader.readLine();
                        while (!line.isBlank()) {
                            if (line.contains(key)) {
                                extraction = line.split(":");
                                extraction = extraction[1].split("\"");
                                return extraction[1];
                            }
                            line = bufferdReader.readLine();
                            if (line == null) {
                                break;
                            }
                        }
                    }
                }
                if (line == null) {
                    break;
                }
                line = bufferdReader.readLine();
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return "Null";
    }

    public static ArrayList<String> getArrayValue(String privateKey, String keyValue, String key, String database){
        String[] First;
        ArrayList<String> x = new ArrayList<>();
        ArrayList<String> y = new ArrayList<>();
        x = ASON.stripValue(privateKey, database);
        for (int i = 0; i < x.size(); i++) {
            if (x.get(i).equals(keyValue)) {
                x = ASON.stripValue(key, database);
                First = x.get(i).split("-");
                y.addAll(Arrays.asList(First));
            }
        }
        return y;
    }

    public static void addArrayValue(String privateKey, String keyValue, String key, String value, String database){
        if(getValue(privateKey,keyValue,key,database).equals("")){
            changeValue(privateKey,keyValue,key,value,database);
        }
        else {
            changeValue(privateKey,keyValue,key,getValue(privateKey,keyValue,key,database) + "-" + value,database);
        }
    }
}