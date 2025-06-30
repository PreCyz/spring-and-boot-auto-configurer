package awesome.pawg.reflection;


import awesome.pawg.annotations.Pawg;

import java.lang.reflect.*;

public class Main {

    @Pawg("awesomeAnnotation")
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
            ReflectionExample reflectionExample = new ReflectionExample("Amazing-Zelazny-Mordulec");
            Method _method = reflectionExample.getClass().getMethod("display");
            _method.invoke(reflectionExample);

            // Invoking method
            Class<?> _clazz = Class.forName("pawg.is.awesome.reflection.Main$ReflectionExample");
            Constructor<?>[] declaredConstructors = _clazz.getDeclaredConstructors();
            declaredConstructors[0].setAccessible(true);
            Object obj = declaredConstructors[0].newInstance("Amazing-Zelazny-Mordulec");
            Method method = obj.getClass().getMethod("display");
            _clazz.cast(method.invoke(obj));
        } catch (ClassNotFoundException e) {
            e.printStackTrace(System.err);
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

}