import Engine.EntityCore;
import Engine.FillBrandsDatabase;
import Engine.FillCarDatabase;
import Engine.FillEmpDatabase;
import Entity.EmployeesEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner odczyt = new Scanner(System.in);
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        int choice = 0;

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
                case 2:
                    selectEmp();
                    showMenu();
                    break;
                case 3:
                    filteredSelectEmp();
                    showMenu();
                    break;
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
        System.out.println("2 - Select Employees");
        System.out.println("3 - Select employees with WHERE clause");
        System.out.println("4 - Finish program");
        System.out.print("\n\nEnter your choice: ");
    }
    private static void selectEmp(){
        EntityCore entityCore = new EntityCore();
        Query query = entityCore.getEntityManager().createQuery("from EmployeesEntity");
        List<EmployeesEntity> employeesEntities = query.getResultList();

        entityCore.start();

            for (int i=0; i < employeesEntities.size() - 1; i++) {
                System.out.println(employeesEntities.get(i).toString());
            }

        entityCore.end();
    }
    private static void filteredSelectEmp(){


        System.out.print("Search by name(a) or IdEmployee(b)? ");
        String choice = odczyt.next();

        while (!"a".equals(choice)&&!"b".equals(choice)){
            System.out.println("Choice unknown");
            System.out.print("Do you want search by name(A) or IdEmployee(B)? ");
            choice = odczyt.next();
        }
        if("a".toLowerCase().equals(choice)){
            selectByName();
        }else {
            selectById();
        }


    }
    private static void selectByName(){
        EntityCore entityCore = new EntityCore();
        entityCore.start();

        System.out.println("Podaj imie pracownika: ");
        String name = odczyt.next();
        List<EmployeesEntity> employeesEntities = new ArrayList<>();

        try {
            Query query = entityCore.getEntityManager().createQuery("from EmployeesEntity ");
            employeesEntities = query.getResultList();
            for (int i = 0; i < employeesEntities.size(); i++) {
                if (employeesEntities.get(i).toString().contains(name)) {
                    System.out.println(employeesEntities.get(i).toString());
                }
            }
        }catch (Exception e){
            System.out.println("Employee not found");

        }finally {
            entityCore.end();
        }

    }
    private static void selectById(){
        EntityCore entityCore = new EntityCore();
        entityCore.start();

        System.out.println("Podaj id referencji do pobrania");
        int idx = odczyt.nextInt();
        try {
            EmployeesEntity employeesEntity = entityCore.getEntityManager().getReference(EmployeesEntity.class, idx);
            System.out.println(employeesEntity.toString());
        }catch (Exception e){
            System.out.println("Employee not found");
        }finally {
            entityCore.end();
        }

        //entityCore.end();
    }
}
