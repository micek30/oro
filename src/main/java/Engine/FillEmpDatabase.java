package Engine;

import Entity.BrandsEntity;
import Entity.CarsEntity;
import Entity.EmployeesEntity;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FillEmpDatabase {

    public String[] empName = {"Adam", "Jan", "Monika", "Aleksandra", "Katarzyna"};
    public EmployeesEntity fillemployeesDatabase(){

        StringBuilder desc = new StringBuilder();
        desc.append("Adam");

        EmployeesEntity employeesEntity = new EmployeesEntity();


        for (int i = 0; i < empName.length-1; i++) {
            desc.append(", ").append(empName[i]);
        }

        employeesEntity.setName(desc.toString());


        EntityCore entityCore = new EntityCore();
        entityCore.start();

        entityCore.getEntityManager().persist(employeesEntity);

        entityCore.end();


        return employeesEntity;
    }
    private List<CarsEntity> chosenCar(EntityCore entityCore){
        List<CarsEntity> carsEntities;
        List<CarsEntity> carsEntities1 = new ArrayList<>();


        Query query = entityCore.getEntityManager().createQuery("from CarsEntity ");
        carsEntities = query.getResultList();
        Randoms randoms = new Randoms();
        int idx = randoms.randInt(0,10);
        for(int i = 0; i < idx; i++) {
            carsEntities1.add(carsEntities.get(randoms.randInt(0, carsEntities.size() - 1)));
        }

        return carsEntities1;
    }

    public void randEmp(){
        EntityCore entityCore = new EntityCore();
        Random random = new Random();
        Randoms randoms = new Randoms();
        entityCore.start();


        for (int i=0;i<10;i++){
            EmployeesEntity employeesEntity = new EmployeesEntity();
            int idx = randoms.randInt(0,4);
            employeesEntity.setName(empName[idx]);
            employeesEntity.setSalary(random.nextInt(4000 + 1 - 1500) + 1500);
            employeesEntity.setCarsEntities(chosenCar(entityCore));
            entityCore.getEntityManager().persist(employeesEntity);
        }

        entityCore.end();
    }
    public void oneEmp(){
        EntityCore entityCore = new EntityCore();
        Random random = new Random();
        Randoms randoms = new Randoms();
        entityCore.start();

        EmployeesEntity employeesEntity = new EmployeesEntity();
        int idx = randoms.randInt(0,4);
        employeesEntity.setName(empName[idx]);
        employeesEntity.setSalary(random.nextInt(4000 + 1 - 1500) + 1500);
        //employeesEntity.setCarsEntities(chosenCar(entityCore));
        entityCore.getEntityManager().persist(employeesEntity);

        entityCore.end();
    }

}
