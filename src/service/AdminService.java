package service;

public class AdminService {
    public void showAnalytics() throws InterruptedException {
        int arr[] = { 100, 200, 300 };
        for (int i = 0; i < 3; i++) {
            System.out.print(
                    "                                                                           SONG " + i + 1 + ": ");
            for (int j = 10; j < arr[i]; j = j + 10) {
                System.out.print("█");
                try {
                    Thread.sleep(20);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
            Thread.sleep(100);
            System.out.println();
        }
    }
}
