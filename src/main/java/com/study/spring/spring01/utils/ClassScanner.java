package com.study.spring.spring01.utils;

import com.google.common.collect.Lists;
import com.study.spring.spring01.annotations.HandlerType;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ClassScanner {

    public static List<Class> scan(String packagePath, Class targetAnnotationClass) {
        List<String> classNames = getClassName(packagePath);

        List<Class> classes = Lists.newArrayList();
        classNames.stream().forEach(t -> {
            try {
                Class clazz = Thread.currentThread().getContextClassLoader().loadClass(t);
                if (clazz.getAnnotation(targetAnnotationClass) != null) {
                    classes.add(clazz);
                }
            } catch (ClassNotFoundException e) {
                System.out.println(e);
            }
        });

        return classes;
    }

    private static List<String> getClassName(String packagePath) {
        String filePath = ClassLoader.getSystemResource("").getPath() + packagePath.replace('.', '/');

        List<String> fileNames = getClassName(filePath, packagePath, null);

        return fileNames;
    }

    private static List<String> getClassName(String filePath, String packageName, List<String> classNames) {
        File file = new File(filePath);
        List<String> className = new ArrayList<>();
        if (file.isDirectory()) {
            for (File f : file.listFiles((t) -> {return t.isDirectory() || t.getName().endsWith(".class");})) {
                if (f.isDirectory()) {
                    className.addAll(getClassName(f.getPath(), packageName + "." + f.getName(), className));
                } else {
                    className.add(packageName + "." + f.getName().substring(0, f.getName().length()-6));
                }
            }
        }

        return className;
    }

    public static void main(String[] args) {
        String path = "com.study.spring.spring01";
        List<Class> names = scan(path, HandlerType.class);
    }
}
