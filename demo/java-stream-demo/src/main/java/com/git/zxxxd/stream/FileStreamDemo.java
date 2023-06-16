package com.git.zxxxd.stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileStreamDemo {
    //通过 Files.line 方法得到一个流，并且得到的每个流是给定文件中的一行
    public static void main(String[] args) throws IOException {
        String path1 = FileStreamDemo.class.getClassLoader().getResource("data.txt").getPath();
        Path path = Paths.get(path1);
        Stream<String> fileStream = Files.lines(path, Charset.defaultCharset());
        fileStream.forEach(System.out::println);
    }
}
