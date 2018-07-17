package pres;

import dao.DaoImpl;
import dao.IDao;
import metier.IMetier;
import metier.MetierImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Presentation {

    private static MetierImpl metier;

    public static void main(String[] args){
  //      DaoImpl dao=new DaoImpl();
  //      metier=new MetierImpl();
  //      metier.setDao(dao);
  //      System.out.println(metier.calcul());

        try {
            Scanner scanner=new Scanner(new File("config.txt"));
            String daoClassName=scanner.next();
            String metierClassName=scanner.next();
            System.out.println(daoClassName);
            System.out.println(metierClassName);

            // Instanciation dynamique
            Class cDao=Class.forName(daoClassName);
            IDao dao =(IDao) cDao.newInstance();
            System.out.println(dao.getValue());

            Class cMetier=Class.forName(metierClassName);
            IMetier metier =(IMetier) cMetier.newInstance();

            //Appel par réflexion
            Method m1=cMetier.getMethod("setDao",new Class[]{IDao.class});
            m1.invoke(metier, new Object[]{dao});

            System.out.println(metier.calcul());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
