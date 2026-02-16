package model;

public class Greetings {
        public void welcome() throws InterruptedException {
                System.out.print("                 ------------------------------------------------ WELCOME ");
                Thread.sleep(100);
                System.out.print("TO ");
                Thread.sleep(100);
                System.out.print("SPOTIFY ");
                Thread.sleep(100);
                System.out.print("BACKEND ");
                Thread.sleep(100);

                System.out.println("SYSTEM ------------------------------------------------");

                for (int i = 0; i < 20; i++) {
                        System.out.print("                                            . ");
                        Thread.sleep(50);
                }

                System.out.println();
                System.out.println();
                System.out.println(
                                "                                                                           ====================");
                Thread.sleep(100);
                System.out.println(
                                "                                                                         ||                    ||");
                System.out.println(
                                "                                                                         ||                    ||");
                System.out.println(
                                "                                                                         ||    1.USER LOGIN    ||");
                System.out.println(
                                "                                                                         ||    2.ADMIN  LOGIN  ||");
                System.out.println(
                                "                                                                         ||                    ||");
                System.out.println(
                                "                                                                         ||                    ||");
                Thread.sleep(100);
                System.out.println(
                                "                                                                           ====================");
        }

        //

        public void enter() {
                System.out.print("                                                                           ENTER:- ");
        }

}
