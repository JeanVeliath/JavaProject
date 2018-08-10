import java.util.ArrayList;
import java.util.List;

public class Sample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("asd");
        list.add("sdgf");
        list.add("DFSdf");
        list.add("sdfg");
        list.forEach((n)-> System.out.println(n));
    }
}
