package com.example.yin.utils;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

public class TestFileUtil {

    public static InputStream getResourcesFileInputStream(String fileName) {
        //Thread.currentThread() -- 这个方法返回当前执行线程的 Thread 实例。
        //getContextClassLoader  -- 每个线程都有一个关联的类加载器（ClassLoader），这个方法返回当前线程的类加载器。类加载器负责加载类和资源。
        //getResourceAsStream    -- 这是 ClassLoader 的一个方法，它接受一个资源名（通常是相对于类路径的路径）作为参数，并尝试作为输入流返回该资源
        // "" + fileName  实际上是将 fileName 转换为字符串，以便作为 getResourceAsStream() 方法的参数。
        return Thread.currentThread().getContextClassLoader().getResourceAsStream("" + fileName);
    }

    public static String getPath() {
        return TestFileUtil.class.getResource("/").getPath();
    }

    public static TestPathBuild pathBuild() {
        return new TestPathBuild();
    }

    public static File createNewFile(String pathName) {
        File file = new File(getPath() + pathName);
        if (file.exists()) {
            file.delete();
        } else {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
        }
        return file;
    }

    public static File readFile(String pathName) {
        return new File(getPath() + pathName);
    }

    public static File readUserHomeFile(String pathName) {
        return new File(System.getProperty("user.home") + File.separator + pathName);
    }

    /**
     * build to test file path
     **/
    public static class TestPathBuild {
        private TestPathBuild() {
            subPath = new ArrayList<>();
        }

        private final List<String> subPath;

        public TestPathBuild sub(String dirOrFile) {
            subPath.add(dirOrFile);
            return this;
        }

        public String getPath() {
            //Apache Commons Collections 的 CollectionUtils.isEmpty 方法来检查集合是否为空
            if (CollectionUtils.isEmpty(subPath)) {
                // TestFileUtil 类的类路径根目录
                return TestFileUtil.class.getResource("/").getPath();
            }
            if (subPath.size() == 1) {
                return TestFileUtil.class.getResource("/").getPath() + subPath.get(0);
            }
            StringBuilder path = new StringBuilder(TestFileUtil.class.getResource("/").getPath());
            path.append(subPath.get(0));
            for (int i = 1; i < subPath.size(); i++) {
                path.append(File.separator).append(subPath.get(i));
            }
            return path.toString();
        }

    }

}