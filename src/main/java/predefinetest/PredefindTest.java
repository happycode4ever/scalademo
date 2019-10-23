package predefinetest;

public class PredefindTest {
    public static void main(String[] args) {
        Son son = new Son();
        int length = son.arr.length;
        int range = son.range;
        System.out.println(length);
        System.out.println(range);
    }
}
class Father{
    int range = 10;
    int[] arr = new int[range];
}
class Son extends Father{
    int range = 30;
}
