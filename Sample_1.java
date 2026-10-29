package Run2;
import java.util.Scanner;
import java.io.Serializable;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

class Student implements  Serializable{
private	long studentRollNo;
private	String studentName;
private	String studentCourse;
private	String studentBranch;
private	String studentPassword;
private	String studentFatherName;
private	int studentSemester;
private	String studentAddress;
	Student(long studentRollNo,String studentName,String studentCourse,String studentBranch,String studentPassword,String studentFatherName,int studentSemester,String studentAddress){
		this.studentRollNo=studentRollNo;
		this.studentName=studentName;
		this.studentCourse=studentCourse;
		this.studentBranch=studentBranch;
		this.studentPassword=studentPassword;
		this.studentFatherName=studentFatherName;
		this.studentSemester=studentSemester;
		this.studentAddress=studentAddress;
	}
	long getRollNumber() {
		return studentRollNo;
	}
	void setStudentPassword(String studentPassword) {
		this.studentPassword=studentPassword;
	}

 public long getStudentRollNo() {
	return studentRollNo;
}
 public String getStudentPassword() {
	 return studentPassword;
 }
	
	void displayStudent() {
		System.out.println("Student RollNo: "+studentRollNo);
		System.out.println("Student Name: "+studentName);
		System.out.println("Student Course: "+studentCourse);
		System.out.println("Student Branch: "+studentBranch);
		System.out.println("Student Father's Name: "+studentFatherName);
		System.out.println("Student Semester: "+studentSemester);
		System.out.println("Student Address: "+studentAddress);
	}
}
class Teacher implements Serializable{
	private String teacherID;
	private String teacherName;
	private String teacherSubject;
	private String teacherQualification;
	private String teacherPassword;
	private String teacherAddress;
	boolean flag3;
	Teacher(String teacherID,String teacherName,String teacherSubject,String teacherQualification,String teacherPassword,String teacherAddress){
		this.teacherID=teacherID;
		this.teacherName=teacherName;
		this.teacherSubject=teacherSubject;
		this.teacherQualification=teacherQualification;
		this.teacherPassword=teacherPassword;
		this.teacherAddress=teacherAddress;
	}
	String getTeacherID() {
		return teacherID;
	}	
	String getTeacherPassword() {
		return teacherPassword;
	}
	void setTeacherPassword(String teacherPassword) {
		 this.teacherPassword=teacherPassword;
	}

	void displayTeacher() {
		System.out.println("Teacher ID: "+teacherID);
		System.out.println("Teacher Name: "+teacherName);
		System.out.println("Teacher Subject Name: "+teacherSubject);
		System.out.println("Teacher Qualification: "+teacherQualification);
		System.out.println("Teacher Address: "+teacherAddress);
	}
}
class Course implements Serializable{
	private String courseID;
	private String courseName;
	Course(String courseID,String courseName){
		this.courseID=courseID;
		this.courseName=courseName;
	}
	void displayCourses() {
		System.out.println("Course ID: "+courseID);
		System.out.println("Course Name: "+courseName);	
	}
	String getCourseCode() {
		return courseID;
	}
	String getCourseName() {
		return courseName;
	}
}
 class College{
	 Scanner sc=new Scanner(System.in);
	 boolean flag2;
	 boolean flag3;
	 boolean flag4;
	ArrayList<Student> students=new ArrayList<Student>();
	ArrayList<Teacher> teachers=new ArrayList<Teacher>();
	ArrayList<Course> courses=new ArrayList<Course>();
	ArrayList<Admin> admin=new ArrayList<Admin>();
	
	
	 
	public void addStudents(Student s) {
		students.add(s);
	}
	void addTeachers(Teacher t) {
		teachers.add(t);
	}
	void addCourse(Course c) {
		courses.add(c);
	}
	void registerAdmin(Admin a) {
		admin.add(a);
	}
	void viewStudents() {
		if(students.isEmpty()) {
			System.out.println("Not Data Registered");
		}
		else {
		for(Student s:students) {
			s.displayStudent();
			System.out.println();
		}
	}
}
	void viewTeacher() {
		if(teachers.isEmpty()) {
			System.out.println("Not Data Registered");
		}
		else {
		for(Teacher t:teachers) {
			t.displayTeacher();
			System.out.println();
		}
		}
	}
	void deleteStudent(long rollNo) {
		if(students==null) {
			System.out.println("Not Registered");
			return;
		}
		for(Student s:students) {
		if(s.getStudentRollNo()==rollNo) {
		      students.remove(s);
			saveData();
			return;
		}
		}
	}
	void deleteTeacher(String ID) {
		if(teachers==null) {
			System.out.println("Not Registered");
			return;
		}
		for(Teacher t:teachers) {
		if(ID.equals(t.getTeacherID())) {
			teachers.remove(t);
			saveData();
			return;
		}
		}
	}
	void deleteCourses(String code) {
		if(courses==null) {
			System.out.println("Not Registered");
			return;
		}
		for(Course c:courses) {
			if(code.equals(c.getCourseCode())) {
			courses.remove(c);
			saveData();
			return;
			}
		}
		System.out.println("Invalid code");
	}
	void viewCourse() {
		if(courses.isEmpty()) {
			System.out.println("Not Registered");
			return;
		}
		for(Course c:courses) {
			if(courses.isEmpty()) {
				System.out.println("Not Registered");
				return;
			}
			c.displayCourses();
		}
	}
  void viewAdmin() {
	  for(Admin a: admin) {
		  if(admin.isEmpty()) {
			  System.out.println("Not Register");
		  }
		  a.displayAdminDetails();
	  }
  }
	public void searchStudent(long studentRollNo) {
		for(Student s: students) {
		  if(s.getStudentRollNo()==studentRollNo) {
			  s.displayStudent();
			  return;
		  }

		}
		System.out.println("Student Not Found");
	}
	void searchTeacher(String teacherID) {
		for(Teacher t: teachers) {
			if(teacherID.equals(t.getTeacherID())) {
				t.displayTeacher();
				return;
			}
		}
		System.out.println("Teacher Not Found");
	}
	void result(long rollNumber){
		for(Student s:students) {
			if(rollNumber==s.getRollNumber()) {
		    System.out.println();
			s.displayStudent();
			System.out.println("MATHS: 70");
			System.out.println("PHYSICS: 60");
			System.out.println("ELECTRONICS: 80");
			System.out.println("MECHANICS: 78");
			System.out.println("SOFT SKILL: 50");
			System.out.println("SGPA: 8.7");
			System.out.println("Status: PASS");
			return;
			}
		}
		System.out.println("Invalid RollNumber");
	}
	void teacherAttendence(String ID) {
		for(Teacher t:teachers) {
			System.out.print("Enter Teacher ID: ");
			if(ID.equals(t.getTeacherID())) {
			t.displayTeacher();
			System.out.println("Total Number of Days:75 ");
			System.out.println(" Present Days:65 ");
			System.out.println("Absent Days:10 ");
			System.out.println("Attendence: 86.7%");
			return;
			}
		}
		System.out.println("Invalid ID");
	}
	void attendence(long rollNumber) {
		for(Student s:students) {
			if(rollNumber==s.getRollNumber()) {
				searchStudent(rollNumber);
				System.out.println("Total Number of Day: 75");
				System.out.println("Present: 65");
				System.out.println("Absent: 10");
				System.out.println("Attendence: 86.67%");
				return;
			}
		}
		System.out.println("Invalid Roll Number ");
	}
	
	public boolean studentLogIn(long studentRollNo,String studentPasswrod) {
		for(Student s: students){
			if( s.getStudentRollNo()== studentRollNo && s.getStudentPassword().equals(studentPasswrod)) {
				return flag2=true;
			}
			
		}
		return flag2=false;
	}
	public boolean teacherLogIn(String teacherID,String teacherPassword) {
		for(Teacher t: teachers) {
			if(teacherID.equals(t.getTeacherID())&& t.getTeacherPassword().equals(teacherPassword)) {
				return flag3=true;
			}
			
		}
		return flag3=false;
	}
	public boolean adminLogIn(String adminID,String adminPassword) {
		for(Admin a: admin) {
			if(adminID.equals(a.getUserID())&& a.getUserPassword().equals(adminPassword)) {
				return flag4=true;
			}
			
		}
		return flag4=false;
	}
	
void changeStudentPassword(String newPassword) {
	 for(Student s:students) {
		 s.setStudentPassword(newPassword);
	 }
}
void changeTeacherPassword(String newPassword) {
	for(Teacher t: teachers) {
		t.setTeacherPassword(newPassword);
	}
}

void courseSchedule(String courseCode,int semester) {
	for(Course c: courses) {
		if(courseCode.equals(c.getCourseCode())) {
			sc.nextLine();
			System.out.print("Enter Course Name: ");
			String name=sc.nextLine();
			System.out.print("Enter Subject Name: ");
			String subject=sc.nextLine();
			System.out.print("Enter Faculty Name: ");
			String faculty=sc.nextLine();
			System.out.print("Enter Date: ");
			String date=sc.nextLine();
			System.out.print("Enter Timing: ");
			String time=sc.nextLine();
			System.out.print("Enter Room: ");
			int room=sc.nextInt();
			System.out.println();
			System.out.println("Course Code: "+c.getCourseCode());
			System.out.println("Course Name: "+name);
			System.out.println("Semester: "+semester);
			System.out.println("Subject Name: "+subject);
			System.out.println("Faculty Name: "+faculty);
			System.out.println("Date: "+date);
			System.out.println("Time: "+time);
			System.out.println("Room Number: "+room);
		}
	}
}
 void saveData() {
	 try {
	    FileOutputStream fos1=new FileOutputStream("student.data");
	    ObjectOutputStream oos1=new ObjectOutputStream(fos1);
	    oos1.writeObject(students);
	    oos1.close();
	    FileOutputStream fos2=new FileOutputStream("teacher.data");
	    ObjectOutputStream oos2=new ObjectOutputStream(fos2);
	    oos2.writeObject(teachers);
	    oos2.close();
	    FileOutputStream fos3=new FileOutputStream("course.data");
	    ObjectOutputStream oos3=new ObjectOutputStream(fos3);
	    oos3.writeObject(courses);
	    oos3.close();
	 
	 
	 }catch(IOException e) {
		 System.out.println(e.getMessage());
	 }
}
 @SuppressWarnings("unchecked")
 void loadData() {
	 try {
	 FileInputStream fis1=new FileInputStream("student.dat");
	 ObjectInputStream ois1=new ObjectInputStream(fis1);
	 students=(ArrayList<Student>) ois1.readObject();
	 FileInputStream fis2=new FileInputStream("student.dat");
	 ObjectInputStream ois2=new ObjectInputStream(fis2);
	 teachers=(ArrayList<Teacher>) ois2.readObject();
	 FileInputStream fis3=new FileInputStream("student.dat");
	 ObjectInputStream ois3=new ObjectInputStream(fis3);
	courses=(ArrayList<Course>) ois3.readObject();
	 }catch(Exception e) {
		 System.out.println(e.getMessage());
	 }
	 
 } 
 }
class Admin  {
	private String userID;
	private String userPassword;
	private String userName;
	boolean flag;
	
	Admin(String userName,String userID,String userPassword){
		this.userName=userName;
		this.userID=userID;
		this.userPassword=userPassword;
	}

	void displayAdminDetails() {
		System.out.println("Admin Name: "+userName);
		System.out.println("Admin ID: "+userID);
	}
	String getUserName() {
		return userName;
	}
	String getUserID() {
		return userID;
	}
	String getUserPassword() {
		return userPassword;
	}
	
}
public class Sample_1 {
  public static void main (String args []){
	  Scanner sc=new Scanner(System.in);
	  College college=new College();
	  college.loadData();
	  boolean press3=true;
	  System.out.println("No Previous Data Found Register First");
	  while(press3) {
	  System.out.println("===============================================================");
	  System.out.println("             WELCOME TO COLLEGE PORTAL");
	  System.out.println("===============================================================");
	  System.out.println();
	  System.out.println("1.Admin");
	  System.out.println("2.Student");
	  System.out.println("3.Teacher");
	  System.out.println("4.Exit");
	  System.out.println();
	  System.out.print("Enter: ");
	  int choice=sc.nextInt();
	  if(choice==1) {
		  boolean check3=true;
		  while(check3) {
		  System.out.println();
		 System.out.println("1.LogIn");
		 System.out.println("2.Registration");
		 System.out.println("3.Exit");
		 System.out.println();
		 System.out.print("Enter: ");
		 int option=sc.nextInt();
		 if(option==1) {
			  System.out.println("=====================================================");
			  System.out.println("           ADMIN LOG IN");
			  System.out.println("=====================================================");
			  sc.nextLine();
			 System.out.print("Enter userID: ");
			 String ID1=sc.nextLine();
			 System.out.print("Enter Password: ");
			 String password1=sc.nextLine();
			 boolean press2=college.adminLogIn(ID1, password1);
			 if(press2==true) {
				 System.out.println("Logged In SuccessFully");
				 boolean press=true;
					 while(press) {
						 System.out.println();
					 System.out.println("=======================================================");
					  System.out.println("                 ADMIN DASHBOARD");
					  System.out.println("======================================================");
					  System.out.println("1.Add Student");
					  System.out.println("2.View All Student");
					  System.out.println("3.Search Student");
					  System.out.println("4.Delete Student");
					  System.out.println("5.Add Teacher");
					  System.out.println("6.View All Teacher");
					  System.out.println("7.Search Teacher");
					  System.out.println("8.Delete Teacher");
					  System.out.println("9.Assign Course To Teachers");
					  System.out.println("10.Add Courses");
					  System.out.println("11.View Courses");
					  System.out.println("12.Delete Courses");
					  System.out.println("13.Schedule Exam");
					  System.out.println("14.View Results");
					  System.out.println("15.View Students Attendence");
					  System.out.println("16.View Teachers Attendence");
					  System.out.println("17.Log Out");	
					  System.out.println();
					 System.out.print("Enter: ");
					 int option1=sc.nextInt();
					   if(option1==1) {
						      System.out.println("How many Students you have to Add");
						      System.out.print("Enter: ");
						      int n=sc.nextInt();
						      while(n>0) {
							   System.out.print("Enter Student Roll Number: ");
							   int ID3=sc.nextInt();
							   sc.nextLine();
							   System.out.print("Enter Student Name: ");
							   String name3=sc.nextLine();
							   System.out.print("Enter Student Course: ");
							   String course3=sc.nextLine();
							   System.out.print("Enter Student Branch: ");
							   String branch3=sc.nextLine();
							   System.out.print("Enter Student Password: ");
							   String password3=sc.nextLine();
							   System.out.print("Enter Student Father'Name: ");
							   String fatherName=sc.nextLine();
							   System.out.print("Enter Student Semester: ");
							   int semester=sc.nextInt();
							   sc.nextLine();
							   System.out.print("Enter Student Address: ");
							   String studentAddress=sc.nextLine();
							   System.out.println();
							   college.addStudents(new Student(ID3,name3,course3,branch3,password3,fatherName,semester,studentAddress));
							   n--;
							   college.saveData();
					   }
						      System.out.println("Student Added");
					   }
					   else if(option1==2) {
						   System.out.println("============================================");
							  System.out.println("               STUDENT LIST ");
							  System.out.println("=========================================");
							  college.viewStudents();
					   }
					   else if(option1==3) {
						      System.out.println("============================================");
							  System.out.println("              SEARCHING ");
							  System.out.println("============================================");
							  System.out.print("Enter Roll Number Of Student For Searching: ");
							  int ID4=sc.nextInt();
							  System.out.println("Searching Complete");
							  System.out.println();
							  college.searchStudent(ID4);
					   }
					   else if(option1==4) {
						   System.out.println("===================================================");
							  System.out.println("                  DELETE STUDENT ");
							  System.out.println("================================================");
							  System.out.print("Enter Roll Number Of Student For Delete: ");
							  int ID4=sc.nextInt();
							  System.out.println();
							  college.searchStudent(ID4);
							  college.deleteStudent(ID4);
							  System.out.println();
							  System.out.println("Student Profile Has been Deleted");
					   }
					   else if(option1==5) {
						   System.out.println("How many Teacher you have to Add");
						      System.out.print("Enter: ");
						      int n=sc.nextInt();
						      while(n>0) {
						       sc.nextLine();
							   System.out.print("Enter Teacher ID: ");
							   String ID5=sc.nextLine();
							   System.out.print("Enter Teacher Name: ");
							   String name5=sc.nextLine();
							   System.out.print("Enter Teacher Subject: ");
							   String subject=sc.nextLine();
							   System.out.print("Enter Teacher Qualification: ");
							   String qualification=sc.nextLine();
							   System.out.print("Enter LogIn Password: ");
							   String password5=sc.nextLine();
							   System.out.print("Enter Address: ");
							   String address2=sc.nextLine();
							   college.addTeachers(new Teacher(ID5,name5,subject,qualification,password5,address2));
							   n--;
							   college.saveData();
						      }
						      System.out.println("Teachers Added");
						   }
					   else if(option1==6) {
						      System.out.println("===================================================");
							  System.out.println("                 TEACHER LIST ");
							  System.out.println("===================================================");
						   college.viewTeacher();
						   System.out.println();
					   }
					   else if(option1==7) {
						      System.out.println("===================================================");
							  System.out.println("                  SEARCHING ");
							  System.out.println("===================================================");
						   System.out.print("Enter ID of Teacher For Searching: ");
						   String ID6=sc.next();
						   System.out.println("Searching Complete");
						   System.out.println();
						   college.searchTeacher(ID6);
					   }
					   else if(option1==8) {
						      System.out.println("==================================================");
							  System.out.println("                DELETE TEACHER ");
							  System.out.println("==================================================");
							  System.out.print("Enter ID Of Teacher For Delete: ");
							  String ID4=sc.next();
							  college.searchTeacher(ID4);
							  college.deleteTeacher(ID4);
							  System.out.println("");
							  System.out.println("Teacher Profile Has been Deleted");
					   }
					   else if(option1==9) {
						   System.out.print("How many Teacher you want to assign: ");
						   int n=sc.nextInt();
						   while(n>0) {
							sc.nextLine();
						   System.out.print("Enter the Name of Teacher: ");
						   String teachername=sc.nextLine();
						   System.out.print("Enter the Course to be assign: ");
						   String coursename=sc.nextLine();
						   System.out.println();
						   System.out.println("Teacher Name: "+teachername);
						   System.out.println("Assigned Course: "+coursename);
						   n--;
						   }
						   
					   }
					   else if(option1==10) {
						   System.out.print("How Many Course have you Want to Add: ");
						   int n=sc.nextInt();
						   while(n>0) {
						       sc.nextLine();
							   System.out.print("Enter the Course Code: ");
							   String code=sc.nextLine();
							   System.out.println();
							   System.out.print("Enter the Course Name For Adding: ");
							   String course=sc.nextLine();
							   college.addCourse(new Course(code,course));
							   System.out.println();
							   n--;
						   }
						   System.out.println("Courses Added");
					   }
					   else if(option1==11) {
						      System.out.println("=============================================");
							  System.out.println("               COURSES LIST ");
							  System.out.println("=============================================");
						   college.viewCourse();
						   System.out.println();
						   
					   }
					   else if(option1==13) {
						      System.out.println("==================================================");
							  System.out.println("                EXAM SCHEDULE ");
							  System.out.println("==================================================");
						      System.out.print("Enter Course Code For Schedule: ");
						      String courseCode=sc.next();
						      System.out.print("Enter the Semester: ");
						      int sem=sc.nextInt();
						      System.out.print("How many Subjects: ");
						      int n=sc.nextInt();
						      while(n>0) {
						    	  System.out.println();
						      college.courseSchedule(courseCode,sem);
						      System.out.println();
						      n--;
						      }
					   }
					   else if(option1==12) {
						      System.out.println("==================================================");
							  System.out.println("                DELETE COURSES ");
							  System.out.println("==================================================");
						  System.out.print("Enter the Course Code: ");
						  String courseCode=sc.next();
						  college.deleteCourses(courseCode);
						  System.out.println("Course delete Successfully");
					   }
					   else if(option1==14) {
						      System.out.println("=========================================");
							  System.out.println("               RESULT");
							  System.out.println("=========================================");
						      System.out.print("Enter The Student Roll Number: ");
						   long roll=sc.nextLong();
						      System.out.println("=========================================");
							  System.out.println("                MARKSHEET ");
							  System.out.println("=========================================");
						   college.result(roll);
					   }
					   else if(option1==15){
						      System.out.println("=====================================================");
							  System.out.println("                STUDENT ATTENDENCE");
							  System.out.println("=====================================================");
						      System.out.print("Enter the Roll Number: ");
						  long rollNumber=sc.nextLong();
						  college.attendence(rollNumber);
					   }else if(option1==16) {
						      System.out.println("=====================================================");
							  System.out.println("                TEACHER ATTENDENCE");
							  System.out.println("=====================================================");
							  System.out.print("Enter Teacher ID: ");
							  String ID=sc.next();
							  college.teacherAttendence(ID);
					   }
					   else if(option1==17) {
						   System.out.println("Logged Out");
						   break;
						   }
					   else {
						   System.out.println("Invalid Choice");
					   }
					 }
			    } else {
			    	System.out.println("Invalid Input");
			 }
				 }
		 else if(option==2) {
			 System.out.println("=====================================================");
			  System.out.println("           ADMIN REGISTRATION ");
			  System.out.println("=====================================================");
			  sc.nextLine();
				 System.out.print("Enter Name: ");
				 String name1=sc.nextLine();
				 System.out.print("Create userID: ");
				 String ID1=sc.nextLine();
				 System.out.print("Create Password: ");
				 String password1=sc.nextLine();
				 System.out.println("Registered SuccessFully");
				 college.registerAdmin(new Admin(name1,ID1,password1));
				 college.viewAdmin();
				 break;
		 }
		 else if(option==3) {
			 break;
		 }
		 else {
			 System.out.println("Invalid Input");
		 }
		  }
	  }
	  else if(choice==2) {
		  boolean press4=true;
				  while(press4) {
          System.out.println("=================================================");
          System.out.println("                   STUDENT MENU");
          System.out.println("=================================================");
          System.out.println("1.LogIn");
          System.out.println("2.Exit");
          System.out.println();
          System.out.print("Enter: ");
          int option3=sc.nextInt();
          if(option3==1) {
        	 System.out.print("Enter Student Roll Number: ");
        	 int ID6=sc.nextInt();
        	 System.out.print("Enter Password: ");
        	 String password5=sc.next();
        	boolean check=college.studentLogIn(ID6, password5);
        	if(check==true) {
        		System.out.println("LogIn Succesfully");
        		boolean check2=true;
        		while(check2) {
					 System.out.println();
        		  System.out.println("============================================");
				  System.out.println("            STUDENT DASHBOARD");
				  System.out.println("============================================");
				  System.out.println("1.View Your Details");
				  System.out.println("2.View Result");
				  System.out.println("3.View Attendence");
                  System.out.println("4.View Courses");
				  System.out.println("5.Change Password");
				  System.out.println("6.Log Out");
                  System.out.println();
		          System.out.print("Enter: ");
		          int press5=sc.nextInt();
		          if(press5==1) {
		        	  System.out.println("=========================================");
					  System.out.println("           STUDENT DETAILS");
					  System.out.println("=========================================");
		        	 college.searchStudent(ID6);
		          }
		          else if(press5==2) {
		        	  System.out.println("=========================================");
					  System.out.println("               RESULT");
					  System.out.println("=========================================");
					  System.out.print("Enter The Roll Number: ");
					  long rollNumber=sc.nextLong();
		        	  college.result(rollNumber);
		        	
		          }
		          else if(press5==3) {
		        	  System.out.println("=========================================");
					  System.out.println("              ATTENDENCE");
					  System.out.println("=========================================");
		        	  System.out.println("Attendence: 78.9%");
		          }
		          else if(press5==4) {
		        	 college.viewCourse();
		        	  
		          }
		          else if(press5==5) {
		        	  System.out.print("Enter the Old Password: ");
		        	  String oldpass=sc.next();
		        	  System.out.print("Enter the New Password: ");
		        	  String newpass=sc.next();
		        	  System.out.print("Re-Enter the New Password: ");
		        	  String newpass1=sc.next();
		        	  if(newpass.equals(newpass1)) {
		        		  college.changeStudentPassword(newpass);
		        	  }else {
		        	  System.out.println("Password Unmatched");
		        	  }
		        
		          }
		          else if(press5==6){
		        	  System.out.println("Logged Out");
		        	  break;
		          }
		          else {
		        	  System.out.println("Invalid choice");
		          }
        		}
        	}
        	else{
        		System.out.println("Invalid Input");
        	}
   
          }
          else if(option3==2) {
        	  break;
          }
          else {
        	  System.out.println("Invalid Input");
          }
				  }
	  }
	  else if(choice==3) {
		  System.out.println("===============================================");
          System.out.println("                  TEACHER MENU");
          System.out.println("===============================================");
          System.out.println("1.LogIn");
          System.out.println("2.Exit");
          System.out.println();
          System.out.print("Enter: ");
          int press8=sc.nextInt();
          if(press8==1) {
        	  System.out.print("Enter ID: ");
        	  String ID9=sc.next();
        	  System.out.print("Enter Password: ");
        	  String password4=sc.next();
        	 boolean check3=college.teacherLogIn(ID9,password4);
        	   if(check3==true) {
      			   System.out.println("LogIn Succesfully");
        		   boolean choice4=true;
        		   while(choice4) {
						 System.out.println();
        		   System.out.println("===============================================");
 				  System.out.println("              TEACHER DASHBOARD");
 				  System.out.println("===============================================");
 				  System.out.println("1.View Your Details");
 				  System.out.println("2.View Student Details ");
 				  System.out.println("3.View Attendence");
 				  System.out.println("4.View Student's Attendence");
 				  System.out.println("5.View Student List");
 				  System.out.println("6.Add or Update Marks Of Student");
 				  System.out.println("7.Password Change");
 				  System.out.println("8.Log Out");
 				  System.out.println();
 		          System.out.print("Enter: ");
 		          int press6=sc.nextInt();
 		          if(press6==1) {
 		        	 System.out.println("=============================================");
 		             System.out.println("                TEACHER DETAILS");
 		             System.out.println("=============================================");
 		        	  college.searchTeacher(ID9);
 		          }
 		          else if(press6==2) {
 		        	  System.out.print("Enter the Roll Number of Student: ");
 		        	  long rollNo=sc.nextLong();
 		        	  college.searchStudent(rollNo);
 		          }
 		          else if(press6==3) {
 		        	 System.out.println("===============================================");
					  System.out.println("                 ATTENDENCE");
					  System.out.println("==============================================");
 		        	  System.out.println("Attendence: 67.9%");
 		          }
 		          else if(press6==4){
 		        	  System.out.println("=====================================================");
					  System.out.println("                STUDENT ATTENDENCE");
					  System.out.println("=====================================================");
					  System.out.print("Enter Roll Number: ");
					  long rollNo1=sc.nextLong();
					  college.searchStudent(rollNo1);
					  System.out.println("Student Attendence: 84.78%");
 		          }
 		          else if(press6==5) {
 		        	 System.out.println("========================================================");
					  System.out.println("                      STUDENT LIST ");
					  System.out.println("=======================================================");
					  college.viewStudents();
 		          }
 		          else if(press6==6) {
 		        	 System.out.println("==============================================================");
					  System.out.println("                   STUDENT MARKS UPDATE ");
					  System.out.println("==============================================================");
 		        	  System.out.print("Enter Sudent Roll Number: ");
 		        	  long rollNo2=sc.nextInt();
 		        	  college.searchStudent(rollNo2);
 		        	  System.out.println("Press enter to Add marks");
 		        	  sc.next();
 		        	 System.out.print("Enter Subject1 Name: ");
 		        	 String subject1=sc.next();
 		        	 System.out.print("Enter Mark1: ");
 		        	 int mark1=sc.nextInt();
 		        	System.out.print("Enter Subject2 Name: ");
		        	 String subject2=sc.next();
		        	 System.out.print("Enter Mark2: ");
		        	 int mark2=sc.nextInt();
		        	 System.out.print("Enter Subject3 Name: ");
 		        	 String subject3=sc.next();
 		        	 System.out.print("Enter Mark3: ");
 		        	 int mark3=sc.nextInt();
 		        	System.out.print("Enter Subject4 Name: ");
		        	 String subject4=sc.next();
		        	 System.out.print("Enter Mark4: ");
		        	 int mark4=sc.nextInt();
		        	 System.out.print("Enter Subject5 Name: ");
 		        	 String subject5=sc.next();
 		        	 System.out.print("Enter Mark5: ");
 		        	 int mark5=sc.nextInt();
 		        	 System.out.println("Press Enter to Proceed");
 		        	 sc.next();
 		        	 college.searchStudent(rollNo2);
 		        	 System.out.println(subject1+"="+mark1);
 		        	 System.out.println(subject2+"="+mark2);
 		        	 System.out.println(subject3+"="+mark3);
 		        	 System.out.println(subject4+"="+mark4);
 		        	 System.out.println(subject5+"="+mark5);
 		          }
 		          else if(press6==7) {
 		        	 System.out.print("Enter the Old Password: ");
 		        	 String oldpass=sc.next();
 		        	System.out.print("Enter the New Password: ");
		        	 String newpass=sc.next();
		        	 System.out.print("Re-Enter the Old Password: ");
 		        	 String newpass1=sc.next();
 		        	 if(newpass.equals(newpass1)) {
 		        	college.changeTeacherPassword( newpass);
 		        	 }
 		        	 else {
 		        	 System.out.println("Unmatched Password");
 		        	 }
 		          }
 		          else if(press6==8){
 		        	  System.out.println("Logged Out Succefully");
 		        	  break;
 		          }
 		          else {
 		        	  System.out.println("Invalid Input");
 		          }
        	   }
        	   }
        	   else if(press8==2) {
        		   break;
        	   }  
          } 
	  }
	  else if(choice==4) {
		  System.out.println("THANK YOU VISIT AGAIN....!!!");
		  break;
	  }
	  else {
		  System.out.println("Invalid choice");
	  }
	 }
  }
}


