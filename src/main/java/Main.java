import Engine.EntityCore;
import Engine.FillBrandsDatabase;
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
        while(choice != 9){
            switch (choice){
                case 0:
                    showMenu();
                    break;
                case 1:
                    FillBrandsDatabase fillBrandsDatabase= new FillBrandsDatabase() {};
                    fillBrandsDatabase.randBrands();
                    break;
                case 2:
                    FillEmpDatabase fillEmpDatabase = new FillEmpDatabase();
                    fillEmpDatabase.randEmp();
                    showMenu();
                    break;
//                case 3:
//                    FillOrderDatabase fillOrderDatabase = new FillOrderDatabase();
//                    System.out.println("\nPodaj ile chcesz wprowadzic zamowien");
//                    int n = odczyt.nextInt();
//                    fillOrderDatabase.makeOrder(n);
//                    showMenu();
//                    break;
//                case 4:
//                    selectOrder();
//                    showMenu();
//                    break;
//                case 5:
//                    selectOrderWhere();
//                    showMenu();
//                    break;
//                case 6:
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
        System.out.println("0 - Menu: ");
        System.out.println("1 - Fill database with brands");
        System.out.println("2 - Fill database with cars");
        System.out.println("3 - Fill database with employees");
        System.out.println("4 - Select cars");
        System.out.println("5 - Select employees with WHERE clause");
        System.out.println("9 - Finish program");
        System.out.print("\n\nEnter your choice: ");
    }
}
