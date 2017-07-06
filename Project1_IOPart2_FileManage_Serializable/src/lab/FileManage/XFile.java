package lab.FileManage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class XFile {
	/**
	 * Copy file or folder
	 * 
	 * @param src is file is a folder need to copy (source folder)
	 * @param dst is destination folder
	 * */
	public static void copy(File src,File dst){
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
	
	/**
	 * Delete file or folder
	 * 
	 * @param src file is a folder need to delete (source folder)
	 * @param dst is destination folder
	 * */
	public static void delete(File file){
		if(file.isDirectory()){
			File[] subs = file.listFiles();
			if(subs != null){
				for(File sub:subs){
					delete(sub);
				}
			}
		}
		file.delete();
	}
	
	/**
	 * Write file or folder
	 * 
	 * @param text is content need to write into file
	 * @param path is path of file need to write
	 * */
	public static void writeText(String text,String path){
		byte[] data = text.getBytes();
		write(data,path);
	}
	
	/**
	 * Read file or folder
	 * 
	 * @param path is content need to read into file
	 * @return content of file need to write
	 * */
	public static String readText(String path){
		byte[] data = read(path);
		return new String (data);
	}
	
	/**
	 * Write binary file
	 * 
	 * @param data is content need to write into file
	 * @param path is content need to write into file
	 * */
	public static void write(byte[] data, String path) {
		try{
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(data);
			fos.close();
			
			System.out.println("Write file successfully!");
		
		}
		catch(Exception e){
			System.out.println("Write file failed!");
		}
	}
	
	/**
	 * Read binary file
	 * 
	 * @param path is content need to read into file
	 * @return content of file read in path
	 * */
	public static byte[] read(String path) {
		try{
			FileInputStream fos = new FileInputStream(path);
			byte[] data = new byte[fos.available()];
			fos.read(data);
			fos.close();
			return data;
		}
		catch(Exception e){
			return null;
		}
	}
}
