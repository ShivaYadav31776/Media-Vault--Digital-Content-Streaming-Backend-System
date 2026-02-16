package service;

public class Menu {
        public void userMenu() throws InterruptedException {
                System.out.println();
                System.out.println();

                System.out.println(
                                "                                                                      ================================");
                Thread.sleep(100);
                System.out.println(
                                "                                                                    ||                                ||");
                System.out.println(
                                "                                                                    ||        1. REGISTER / LOGIN     ||");
                System.out.println(
                                "                                                                    ||        2. BROWSE SONGS         ||");
                System.out.println(
                                "                                                                    ||        3. SEARCH SONGS         ||");
                System.out.println(
                                "                                                                    ||        4. TRENDING SONGS       ||");
                System.out.println(
                                "                                                                    ||                                ||");
                Thread.sleep(100);
                System.out.println(
                                "                                                                      ================================");

        }

        // admin
        public void AdminMenu() throws InterruptedException {
                System.out.println();
                System.out.println();

                System.out.println(
                                "                                                                      ================================");
                Thread.sleep(100);
                System.out.println(
                                "                                                                    ||                                ||");
                System.out.println(
                                "                                                                    ||        1. ADD SONGS            ||");
                System.out.println(
                                "                                                                    ||        2. DELETE SONG          ||");
                System.out.println(
                                "                                                                    ||        3. SHOW ANALYTICS       ||");
                System.out.println(
                                "                                                                    ||        4. TRENDING SONGS       ||");
                System.out.println(
                                "                                                                    ||        5. SHOW SONG          ||");
                System.out.println(
                                "                                                                    ||                                ||");
                Thread.sleep(100);
                System.out.println(
                                "                                                                      ================================");

        }
}
