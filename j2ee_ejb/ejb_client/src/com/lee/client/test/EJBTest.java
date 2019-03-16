package com.lee.client.test;

import com.lee.client.sessionbean.LibrarySessionBeanRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.*;
import java.util.List;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: lixiaofan0122@gmail.com
 * Date: 3/7/19
 * Time: 4:55 PM
 */
public class EJBTest {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static Object getEJB(String path)
    {
        try{
            Properties jndiProps = new Properties();
            jndiProps.put(Context.URL_PKG_PREFIXES,"org.jboss.ejb.client.naming");
            jndiProps.put("jboss.naming.client.ejb.context", true);

            final Context context = new InitialContext(jndiProps);
            return context.lookup(path);
        }catch (NamingException e){
            e.printStackTrace();
        }

        return null;
    }

    private void showGUI() {
        System.out.println("**********************************");
        System.out.println("Welcome To My Book Store");
        System.out.println("**********************************");
        System.out.print("Option\n1.Add Book\n2.Exit\nEnter Choice: ");
    }

    private void TestStatelessEJB() {
        try {
            int choice = 1;
            //LibrarySessionBeanRemote librarySessionBeanRemote = (LibrarySessionBeanRemote)ctx.lookup("ejb:/ejb_server_ejb_exploded/LibrarySessionBean!com.lee.server.sessionbean.LibrarySessionBeanRemote");
            LibrarySessionBeanRemote librarySessionBeanRemote = (LibrarySessionBeanRemote)getEJB(
                    "ejb:/ejb_server_ejb_exploded/LibrarySessionBean!com.lee.server.sessionbean.LibrarySessionBeanRemote");
            while (choice != 2)
            {
                String bookName;
                showGUI();
                String strChoice = bufferedReader.readLine();
                choice = Integer.parseInt(strChoice);
                if(choice == 1)
                {
                    System.out.print("Enter Book Name:");
                    bookName = bufferedReader.readLine();
                    librarySessionBeanRemote.addBook(bookName);
                }
                else if(choice == 2)
                {
                    break;
                }
            }
            List<String> booksList = librarySessionBeanRemote.getBooks();
            System.out.println("Book(s) entered so far: " + booksList.size());
            for(int i = 0; i<booksList.size();++i )
            {
                System.out.println((i+1)+". " + booksList.get(i));
            }

            LibrarySessionBeanRemote librarySessionBeanRemote1 = (LibrarySessionBeanRemote)getEJB(
                    "ejb:/ejb_server_ejb_exploded/LibrarySessionBean!com.lee.server.sessionbean.LibrarySessionBeanRemote");

            List<String> booksList1 = librarySessionBeanRemote1.getBooks();
            System.out.println("Book(s) 1 entered so far: " + booksList1.size());
            for(int i = 0; i<booksList1.size();++i )
            {
                System.out.println((i+1)+". " + booksList1.get(i));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if(bufferedReader != null){
                    bufferedReader.close();
                }
            }catch (IOException ex){
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        EJBTest ejbTest = new EJBTest();

        ejbTest.TestStatelessEJB();
    }
}
