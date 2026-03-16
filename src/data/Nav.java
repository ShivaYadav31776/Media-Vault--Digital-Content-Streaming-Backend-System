package data;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Stack;

public class Nav {

    private static Stack<String> history = new Stack<>();
    private static String FILE_PATH = System.getProperty("user.dir") + File.separator + "data" + File.separator + "Nav.csv";
    private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private static String currentUser = "";

    // add action to stack and save to csv
    public static void log(String username, String action) {
        currentUser = username;
        String entry = username + "," + LocalDateTime.now().format(fmt) + "," + action;
        history.push(entry);
        save(entry);
    }

    // save one entry to csv
    public static void save(String entry) {
        try {
            File file = new File(FILE_PATH);
            file.getParentFile().mkdirs();
            if (!file.exists()) file.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            bw.write(entry);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("Nav save error: " + e.getMessage());
        }
    }

    // load user history from csv into stack
    public static void load(String username) {
        history.clear();
        currentUser = username;
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) return;
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(username + ",")) {
                    history.push(line);
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Nav load error: " + e.getMessage());
        }
    }

    // show full history
    public static void display() {
        System.out.println("\n  ========================================");
        System.out.println("       NAVIGATION HISTORY - " + currentUser);
        System.out.println("  ========================================");
        if (history.isEmpty()) {
            System.out.println("  No activity recorded.");
        } else {
            Stack<String> temp = (Stack<String>) history.clone();
            int i = 1;
            while (!temp.isEmpty()) {
                String[] parts = temp.pop().split(",", 3);
                System.out.printf("  %2d. [%s]  %s%n", i++, parts[1], parts[2]);
            }
        }
        System.out.println("  ========================================\n");
    }

    // clear stack on logout
    public static void clear() {
        history.clear();
        currentUser = "";
    }
}