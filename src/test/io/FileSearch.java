package test.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

public class FileSearch {
	public static void main(String[] args) throws IOException {
			File f= new File("C:\\Users\\woshizbh\\Desktop\\java");
			new FileSearch().search(f, "java");
	}

	public void search(File file, String search) throws IOException {
		if (!file.isFile()) {
			// 列出该目录下的所有文件和目录
			File files[] = file.listFiles();
			// 遍历files[]数组
			for (File f : files) {
				// 递归
				search(f, "java");
			}
		} else {
			FileInputStream fio =new FileInputStream(file);
			String javaContent =IOUtils.toString(fio,"UTF-8");
			System.out.println(javaContent);
			System.out.println("------------------------------");
		}
	}
}
