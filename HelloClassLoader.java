import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HelloClassLoader extends ClassLoader{

    public static void main(String[] args) throws Exception{
        Class zz = new HelloClassLoader().findClass("Hello");
        Object newInstance = zz.newInstance();
        zz.getMethod("hello").invoke(newInstance);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(Paths.get("E:\\Hello.xlass"));
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