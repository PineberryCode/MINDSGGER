
import java.util.ArrayList;
import java.util.List;


public class test {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(7);
        list.forEach((Integer x) -> System.out.println(x * 2));
    }
}
