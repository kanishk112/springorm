package com.orm;

import com.orm.dao.StudentDao;
import com.orm.entities.Student;
//import jdk.internal.org.jline.utils.InputStreamReader;
import org.hibernate.dialect.identity.JDataStoreIdentityColumnSupport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main(String[] args) {
    ApplicationContext context=new ClassPathXmlApplicationContext("configure.xml");
    StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
//    Student student=new Student(123,"Kanishk","Jalandhar");
//    int r=studentDao.insert(student);
//    System.out.println("done "+r);

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        boolean flag=true;
        while (flag){
            System.out.println("************** Welcome to the Application ***************");
            System.out.println("Press 1 for Insertion");
            System.out.println("Press 2 for Deletion");
            System.out.println("Press 3 for Updation");
            System.out.println("Press 4 To see the details of one student");
            System.out.println("Press 5 To see the details of All students");
            System.out.println("Press 6 to exit!!");

            try{
                int input=Integer.parseInt(br.readLine());
                switch (input){
                    case 1:
                        System.out.println("Enter student Id: ");
                        int id=Integer.parseInt(br.readLine());

                        System.out.println("Enter student Name: ");
                        String name= br.readLine();

                        System.out.println("Enter Student City");
                        String city= br.readLine();

                        Student s=new Student();
                        s.setStudentId(id);
                        s.setsCity(city);
                        s.setsName(name);

                        int r=studentDao.insert(s);
                        System.out.println("Student inserted into database :) "+r);
                        System.out.println("-----------------------------------");
                        break;
                    case 2:
                        System.out.println("Enter student Id: ");
                        int it=Integer.parseInt(br.readLine());
                        studentDao.deleteStudent(it);
                        System.out.println("------------------------------------");
                        break;
                    case 3:
                        System.out.println("Enter student Id: ");
                        int ir=Integer.parseInt(br.readLine());
                        Student student=studentDao.getStudent(ir);
                        studentDao.updateStudent(student);
                        System.out.println("------------------------------------");
                        break;
                    case 4:
                        System.out.println("Enter student Id: ");
                        int i=Integer.parseInt(br.readLine());
                        Student studentt=studentDao.getStudent(i);
                        System.out.println("Student Id: "+studentt.getStudentId());
                        System.out.println("Student Name: "+studentt.getsName());
                        System.out.println("Student City Name: "+studentt.getsCity());
                        System.out.println("------------------------------------");
                        break;
                    case 5:
                        List<Student> allStudents=studentDao.getAllStudents();
                        for (Student st:allStudents)
                        {
                            System.out.println("Student Id: "+st.getStudentId());
                            System.out.println("Student Name: "+st.getsName());
                            System.out.println("Student City Name: "+st.getsCity());
                            System.out.println("------------------------------------");
                        }
                        break;
                    case 6:
                        flag=false;
                        break;
                }
            }
            catch(Exception e)
            {
                System.out.println("-------------------- Invalid Input!! ------------------");
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Thankyou for using the application Hope you Liked it!!!");
    }
}
