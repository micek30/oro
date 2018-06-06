package Engine;

import Entity.BrandsEntity;

public class FillBrandsDatabase {

    public String[] brandName = {"Ford", "Skoda", "Opel", "Seat", "BMW", "Fiat", "Audi", "Renault", "Citroen", "Nissan", "Chevrolet", "Mercedes", "Mini", "Hyundai", "Kia", "Suzuki", "Dacia", "Jaguar", "VW", "Alfa Romeo"};

    public BrandsEntity fillBrandsDatabase(){

        StringBuilder desc = new StringBuilder();
        desc.append("BMW");

        BrandsEntity brandsEntity = new BrandsEntity();


        for (int i = 0; i < brandName.length-1; i++) {
            desc.append(", ").append(brandName[i]);
        }

        brandsEntity.setName(desc.toString());


        EntityCore entityCore = new EntityCore();
        entityCore.start();

        entityCore.getEntityManager().persist(brandsEntity);

        entityCore.end();


        return brandsEntity;
    }

    public void randBrands(){
        EntityCore entityCore = new EntityCore();

        entityCore.start();

        for (String aBrandsName : brandName) {
            BrandsEntity brandsEntity = new BrandsEntity();
            brandsEntity.setName(aBrandsName);
            entityCore.getEntityManager().persist(brandsEntity);
        }

        entityCore.end();
    }
}
