import Engine.FillBrandsDatabase;
import Engine.FillCarDatabase;
import Engine.FillEmpDatabase;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        int choice = 0;
        Scanner odczyt = new Scanner(System.in);
        while(choice != 4){
            switch (choice){
                case 0:
                    showMenu();
                    break;
                case 1:
                    FillBrandsDatabase fillBrandsDatabase= new FillBrandsDatabase() {};
                    fillBrandsDatabase.randBrands();

                    FillEmpDatabase fillEmpDatabase = new FillEmpDatabase();
                    fillEmpDatabase.oneEmp();
                    FillCarDatabase fillCarDatabase = new FillCarDatabase();
                    fillCarDatabase.oneCars();

                    fillEmpDatabase.randEmp();
                    fillCarDatabase.randCars();
                    showMenu();
                    break;
//                case 2:
//                    selectOrder();
//                    showMenu();
//                    break;
//                case 3:
//                    selectOrderWhere();
//                    showMenu();
//                    break;
//                case 4:
//                    EntityCore entityCore = new EntityCore();
//                    entityCore.start();
//                    entityCore.end();
//                    break;
                default:
                    break;
            }
            choice = odczyt.nextInt();
        }

        entityManager.close();
        entityManagerFactory.close();
    }

    private static void showMenu(){
        System.out.println("Menu: ");
        System.out.println("1 - Fill database");
        System.out.println("2 - Select cars");
        System.out.println("3 - Select employees with WHERE clause");
        System.out.println("4 - Finish program");
        System.out.print("\n\nEnter your choice: ");
    }
}
