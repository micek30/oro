
package Engine;

import Entity.BrandsEntity;
import Entity.CarDescEntity;
import Entity.CarsEntity;
import Entity.EmployeesEntity;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class FillCarDatabase extends Randoms {

    private String[] color = {"bialy", "czarny", "czerwony"};


    private CarDescEntity randCarDesc() {
        StringBuilder desc = new StringBuilder();
         desc.append("bialy");

        CarDescEntity carDescEntity = new CarDescEntity();
        Randoms randoms = new Randoms();
        int idx = randoms.randInt(0,2);
        desc.append(", ").append(color[idx]);

        carDescEntity.setColor(desc.toString());
        carDescEntity.setYear(randoms.randInt(2000,2018));

        EntityCore entityCore = new EntityCore();
        entityCore.start();

        entityCore.getEntityManager().persist(carDescEntity);

        entityCore.end();


        return carDescEntity;
    }

    private BrandsEntity chooseBrand(EntityCore entityCore) {
        List<BrandsEntity> brandsEntities;
        BrandsEntity brandsEntity;
        Query query = entityCore.getEntityManager().createQuery("from BrandsEntity");
        brandsEntities = query.getResultList();

        brandsEntity = brandsEntities.get(randInt(1, brandsEntities.size() - 1));

        return brandsEntity;
    }

    private List<EmployeesEntity> chosenEmp(EntityCore entityCore){
        List<EmployeesEntity> employeesEntities;
        List<EmployeesEntity> employeesEntities1 = new ArrayList<>();


        Query query = entityCore.getEntityManager().createQuery("from EmployeesEntity ");
        employeesEntities = query.getResultList();
        Randoms randoms = new Randoms();
        int idx = randoms.randInt(0,10);
        for(int i = 0; i < idx; i++) {
            employeesEntities1.add(employeesEntities.get(randInt(0, employeesEntities.size() - 1)));
        }

        return employeesEntities1;
    }

    public void randCars() {
        EntityCore entityCore = new EntityCore();

        entityCore.start();

        for (int i = 0; i < 5; i++) {
            CarsEntity carsEntity = new CarsEntity();
            carsEntity.setBrandsEntity(chooseBrand(entityCore));
            carsEntity.setCarDescEntity(randCarDesc());
            carsEntity.setEmployeesEntities(chosenEmp(entityCore));

            entityCore.getEntityManager().persist(carsEntity);
        }

        entityCore.end();
    }
    public void oneCars() {
        EntityCore entityCore = new EntityCore();

        entityCore.start();

        CarsEntity carsEntity = new CarsEntity();
        carsEntity.setBrandsEntity(chooseBrand(entityCore));
        carsEntity.setCarDescEntity(randCarDesc());
        //carsEntity.setEmployeesEntities(chosenEmp(entityCore));

        entityCore.getEntityManager().persist(carsEntity);


        entityCore.end();
    }


}