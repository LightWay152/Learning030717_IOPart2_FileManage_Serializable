package lab.FileManage;

import java.io.File;

public class FileManage {
	static int count = 0;

	public static void main(String[] args) {
		//demo1();//View info a file in path
		//demo2();//View info disk in path
		//demo3();//View info of file and folder in path
		//demo4();//Work with file and folder in path
		
//		Explore file and folder in path
//		File file = new File("c:/");
//		exploreDir(file);//explore all files in path
//		System.out.println(count);//total files in path
		
//		//Delete file and folder using Recursive
//		File java = new File("c:/temp/DeleteFoldersAndFiles/java");
//		delete(java);
		
		//Copy file and folder using Recursive
		File src = new File("c:/temp/CopyFoldersAndFilesSrc/java");
		File dst = new File("c:/temp/CopyFoldersAndFilesDst/java");
		copy(src,dst);
		
	}

	private static void copy(File src, File dst) {
		if(src.isFile()){
			byte[] data = XFile.read(src.getAbsolutePath());
			File newFile = new File(dst,src.getName());
			XFile.write(data, newFile.getAbsolutePath());
		}else if(src.isDirectory()){
			String name = src.getName();
			File newDir = new File(dst,name);
			newDir.mkdir();
			File[] subs=src.listFiles();
			if(subs!=null){
				for(File sub:subs){
					copy(sub,newDir);
				}
			}
		}
	}

	private static void delete(File java) {
		if(java.isDirectory()){
			File[] subs = java.listFiles();
			if(subs != null){
				for(File sub:subs){
					delete(sub);
				}
			}
		}
		java.delete();
	}

	private static void exploreDir(File file) {
		if(file.isFile()){
			System.out.println(file.getPath());
			count++;
		}else if(file.isDirectory()){
			File[] subs = file.listFiles();
			if(subs != null){
				for(File sub:subs){
					exploreDir(sub);
				}
			}		
		}
	}

	private static void demo4() {
		File folder = new File("c:/temp/Demo4CreateFolder");
		//folder.mkdir();//create folder FileManageDemo4CreateFolder
		
		//move folder FileManageDemo4CreateFolder into FileManageDemo4RenameToFolder
		folder.renameTo(new File("c:/temp/Demo4RenameToFolder"));
		
		File folder2 = new File("c:/temp/Demo4DelteFileOrFolder");
		folder.delete();//file can delete empty/unempty file but only delete empty folder
	}

	private static void demo3() {
		String path="c:/temp/";
		File folder = new File(path);
		File[] subs = folder.listFiles();
		for(File s:subs){
			if(s.isDirectory()){
				System.out.println("<DIR>: "+s.getName());
			}
		}
		for(File s:subs){
			if(s.isFile()){
				System.out.println("<FILE>: "+s.getName()+"\t("+s.length()+")");
			}
		}
	}

	private static void demo2() {
		File[] drives= File.listRoots();
		for(File f:drives){
			System.out.println(f.getAbsolutePath());
		}
	}

	private static void demo1() {
		String path="c:/temp/FileManageDemo.txt";
		File file = new File(path);
		
		System.out.println("getName: "+file.getName());
		System.out.println("getPath: "+file.getPath());
		System.out.println("getParent: "+file.getParent());
		System.out.println("getAbsolute Path: "+file.getAbsolutePath());
		System.out.println("length: "+file.length());
		System.out.println("lastModified: "+file.lastModified());
		System.out.println("isFile: "+file.isFile());
	}

}
