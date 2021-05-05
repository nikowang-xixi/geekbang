import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HelloClassLoader extends ClassLoader{

    public static void main(String[] args) throws Exception{
        Class zz = new HelloClassLoader().findClass("Hello");
        Object newInstance = zz.newInstance();
        Method[] methods = zz.getMethods();
        methods[0].invoke(newInstance);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(Paths.get("E:\\应用软件\\极客学习\\作业相关\\作业相关\\Hello\\Hello.xlass"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i=0; i< bytes.length; i++) {
            int org = 255 - Byte.toUnsignedInt(bytes[i]);
            bytes[i] = (byte) org;
        }

        return defineClass(name, bytes, 0, bytes.length);
    }
}