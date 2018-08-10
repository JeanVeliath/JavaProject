import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection {
    public static void main(String[] args) {
        Class m =MyC.class;
        Field[] fields = m.getDeclaredFields();
        for(Field f : fields){
            System.out.println(f.getName());
        }
        System.out.println("Methods: ");
        Method[] marray = m.getMethods();
        for(Method mt : marray){
            System.out.println(mt.getName());
        }
    }
}
