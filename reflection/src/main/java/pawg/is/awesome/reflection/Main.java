package pawg.is.awesome.reflection;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static class ReflectionExample {
        private final String myAwesomeName;

        public ReflectionExample(String myAwesomeName) {
            this.myAwesomeName = myAwesomeName;
        }

        public void display() {
            System.out.printf("display method was called, field value is: %s%n", myAwesomeName);
        }

    }

    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("pawg.is.awesome.reflection.Main$ReflectionExample");
            System.out.printf("Class Name: %s%n", clazz.getName());

            // Inspecting fields
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                System.out.printf("Field: %s%n", field.getName());
            }

            // Inspecting methods
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.printf("Method: %s%n", method.getName());
            }

            // Invoking method
            ReflectionExample obj = new ReflectionExample("Amazing-Zelazny-Mordulec");
            Method method = obj.getClass().getMethod("display");
            method.invoke(obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace(System.err);
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}