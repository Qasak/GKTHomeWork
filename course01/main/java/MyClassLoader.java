import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) {
        String myPath = "/Users/mac/IdeaProjects/untitled/src/main/resources/" + name;
        byte[] classBytes = null;
        Path path = null;
        try {
            classBytes = Files.readAllBytes(Paths.get(myPath));
            System.out.println(classBytes.length);
            for(int i = 0; i < classBytes.length; i++) {
                classBytes[i] = (byte) (255 - classBytes[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        name = "Hello";
        Class clazz = defineClass(name, classBytes, 0, classBytes.length);
        return clazz;
    }

    public static void main(String[] args) {
        MyClassLoader loader = new MyClassLoader();
        Class<?> clazz = loader.findClass("Hello.xlass");
        try {
            Object obj = clazz.newInstance();
            Method method = clazz.getMethod("hello");
            method.invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}