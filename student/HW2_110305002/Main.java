import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Please type (1)type and (2)number of initial people or capital and (3)years: ");
        Scanner sc = new Scanner(System.in);

        try {
            while (sc.hasNext()) {
                int type = sc.nextInt(); // 讀取型態（0:人口, 1:資本）

                switch (type) {
                    case 0: // population
                        int people = sc.nextInt(); // 初始人口
                        int years = sc.nextInt();  // 年數
                        if (people <= 0 || years < 0) {
                            throw new IllegalArgumentException("Initial people must be > 0 and years >= 0");
                        }
                        int generations = years / 30 + 1; // 幾代（每30年一代，+1包含初始值）
                        int prate = 2; // 每代人口變2倍
                        GeomProgression<Integer> Population = new GeomProgression<>(people, prate);
                        Population.printProgression(generations); // 印出人口數列
                        break;

                    case 1: // capital
                        double initial = sc.nextDouble(); // 初始資本
                        int cyears = sc.nextInt();        // 年數
                        if (initial < 0 || cyears < 0) {
                            throw new IllegalArgumentException("Initial capital and years must be >= 0");
                        }
                        int citems = cyears + 1;          // 幾年（+1包含初始值）
                        double crate = 1.02;              // 每年資本乘1.02
                        GeomProgression<Double> Capital = new GeomProgression<>(initial, crate);
                        Capital.printProgression(citems); // 印出資本數列
                        break;

                    default:
                        throw new Exception("InvalidType please enter type for 0 or 1");
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}