package josh_chapter5;

import java.lang.reflect.Method;

public class JoshStringMeta {
    public static void main(String[] args) {
        try {
            for (Method m : String.class.getDeclaredMethods()) {
                if (m.getParameterCount() == 0) {
                    m.invoke("");
                }
            }
        } catch (Exception e) {
            System.out.println("Nah");
            System.exit(0);
        }
        System.out.println("Yah");
    }

}