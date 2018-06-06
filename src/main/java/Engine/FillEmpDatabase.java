package Engine;

import Entity.BrandsEntity;
import Entity.EmployeesEntity;
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

    public void randEmp(){
        EntityCore entityCore = new EntityCore();
        Random random = new Random();

        entityCore.start();

        for (String aEmpName : empName) {
            EmployeesEntity employeesEntity = new EmployeesEntity();
            employeesEntity.setName(aEmpName);
            employeesEntity.setSalary(random.nextInt(4000 + 1 - 1500) + 1500);
            entityCore.getEntityManager().persist(employeesEntity);
        }

        entityCore.end();
    }

}
