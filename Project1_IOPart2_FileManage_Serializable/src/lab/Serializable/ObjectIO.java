package lab.Serializable;

import java.awt.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ObjectIO {

	public static void main(String[] args) {
		//demo1();//write object file
		demo2();//read object file
	}
	
	private static void demo2() {
		try {
			String path="c:/temp/students.dat"; 
//			List<Student> list = new ArrayList<Student>();
//			for(){
//				
//			}
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
			Student sv1 = (Student)ois.readObject();
			sv1.print();
			ois.close();
			System.out.println("Read file successfully!");
		} catch (SecurityException e) {
			System.out.println("Security Exception!");
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} catch (ClassNotFoundException e) {
			System.out.println("Class Not Found Exception!");
		} catch (IOException e) {
			System.out.println("IO Exception!");
		}
	}

	private static void demo1(){
		Student sv1 = new Student("Tuan",9,20);
		Student sv2 = new Student("Truong",4,18);
		
		try {
			String path="c:/temp/students.dat";
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
			oos.writeObject(sv1);
			oos.writeObject(sv2);
			oos.close();
			System.out.println("Write file successfully!");
		} catch (FileNotFoundException e) {
			System.out.println("Write file failed!");
		} catch (IOException e) {
			System.out.println("Write file failed!");
		}
	}

}
