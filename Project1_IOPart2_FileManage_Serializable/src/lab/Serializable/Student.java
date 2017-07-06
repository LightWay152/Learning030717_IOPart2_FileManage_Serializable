package lab.Serializable;

import java.io.Serializable;

public class Student implements Serializable{
	public String name;
	public double mark;
	public transient int age;//transient: can not read/write object file
	
	public Student(String name, double mark, int age) {
		super();
		this.name = name;
		this.mark = mark;
		this.age = age;
	}
	
	public void print(){
		System.out.println(">Name: "+this.name);
		System.out.println(">Mark: "+this.mark);
		System.out.println(">Age: "+this.age);
	}	
}
