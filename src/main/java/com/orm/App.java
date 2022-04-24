package com.orm;

import com.orm.dao.StudentDao;
import com.orm.entities.Student;
import jdk.internal.org.jline.utils.InputStreamReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;

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
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
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
