import org.springframework.lang.Nullable;

public class Test {
    public static void main(String[] args){
        func1(null);
    }
    public static void func1(@Nullable Integer i1){
        System.out.println(i1);
    }
}
