package randome;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        for(int i=1;i<=5;i++){
            int res = new Random(10).nextInt(50);
            System.out.println(res);
        }
    }
}
