package lab.UseXFile;

import java.io.File;

import lab.FileManage.XFile;

public class MyClass {

	public static void main(String[] args) {
//		String text = XFile.readText("c:\\temp\\TestXFile.txt");
//		System.out.println(text);
		File src = new File("c:\\temp\\TestXFileFolderSrc\\TestXFile.txt");
		File dst = new File("c:\\temp\\TestXFileFolderDst");
		XFile.copy(src, dst);
	}

}
