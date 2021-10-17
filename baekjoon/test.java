import java.util.*;

public class test {
    public static void main(String[] args) {
        String[] arr = { "ab1", "ab5", "ab13", "ab278", "ab99" };
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
