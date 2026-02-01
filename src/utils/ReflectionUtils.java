package utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtils {

    public static void inspect(Class<?> clazz) {
        System.out.println("=== Reflection Inspect ===");
        System.out.println("Class: " + clazz.getName());

        System.out.println("\nFields:");
        for (Field f : clazz.getDeclaredFields()) {
            System.out.println("- " + f.getType().getSimpleName() + " " + f.getName());
        }

        System.out.println("\nMethods:");
        for (Method m : clazz.getDeclaredMethods()) {
            System.out.println("- " + m.getName() + "()");
        }

        System.out.println("==========================");
    }
}
