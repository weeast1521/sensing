import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자 야구 게임을 시작합니다.");
        Random random = new Random();

        boolean check = true;

        while (check){
            Number[] r = new Number[3];
            r[0] = random.nextInt(0,10);
            r[1] = -1;
            r[2] = -1;

            while (r[0].equals(r[1])){
                r[1] = random.nextInt(0,10);
            }

            while(r[0].equals(r[2]) || r[1].equals(r[2])){
                r[2] = random.nextInt(0,10);
            }

            while (true) {
                Number[] k = new Number[3];
                System.out.print("숫자를 입력해주세요 : ");

                for (int i = 0; i < 3; i++) {
                    k[i] = scanner.nextInt();
                }

                for (int i = 0; i < 3; i++) {
                    if k[i].equals(r[i]) {
                        continue;
                    }
                    for (int j = 0; j < 3; j++) {
                        if k[i].equals(r[j]) {

                        }
                    }
                }
            }
        }
    }
}
