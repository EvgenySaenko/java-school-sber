package ru.sber.javaschool.task1;

import java.io.*;

public class EncryptedClassLoader extends ClassLoader {
    private final String key;
    private final File dir;

    public EncryptedClassLoader(String key, File dir, ClassLoader parent) {//ключ папка где файл
        super(parent);
        this.key = key;
        this.dir = dir;
    }

//    @Override
//    protected Class<?> findClass(String className) throws ClassNotFoundException {
//
//        String classPath = className.replaceAll("[.]","\\\\");
//        byte [] arrByte = fetchClassFromFS(dir + classPath.substring(0, classPath.lastIndexOf("\\")) + "\\")
//    }
//
//
//    public void encryptedClass(String className) throws FileNotFoundException {
//        String classPath = className.replaceAll("[.]","\\\\");
//        String s = dir + classPath.substring(0,classPath.lastIndexOf("\\")) + "\\" +
//                className.substring(className.lastIndexOf('.') + 1) + ".class";
//        byte[] bytes = fetchClassFromFS(s);
//        OutputStream os = new FileOutputStream(s);
//        for (int i = 0; i < bytes.length; i++) {
//            bytes[i] ^= key;
//        }
//        os.write(bytes,0,bytes.length);
//        os.close();
//    }
//
//    private byte [] fetchClassFromFS(String path){
//        InputStream is = new FileInputStream(path);
//
//        long length = new File(path).length();
//
//        byte[] bytes = new byte[(int)length];
//
//
//
//
//    }
}
