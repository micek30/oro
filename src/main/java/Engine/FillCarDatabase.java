//
//package application.model;
//
//
//import Engine.EntityCore;
//import Engine.Randoms;
//import Entity.BrandsEntity;
//import Entity.CarDescEntity;
//
//import javax.persistence.Query;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Random;
//
//public class FillOrderDatabase extends Randoms {
//
//    private String[] color = {"bialy", "czarny", "czerwony"};
//
//
//    private CarDescEntity randCarDesc() {
//        StringBuilder desc = new StringBuilder();
//        desc.append("Opis: ");
//
//        CarDescEntity carDescEntity = new CarDescEntity();
//
//        int hMuch = randInt(1, 3);
//        for (int i = 0; i < hMuch; i++) {
//            int idx = randInt(0, color.length - 1);
//            desc.append(", ").append(color[idx]);
//        }
//
//        carDescEntity.setColor(desc.toString());
//
//
//        EntityCore entityCore = new EntityCore();
//        entityCore.start();
//
//        entityCore.getEntityManager().persist(carDescEntity);
//
//        entityCore.end();
//
//
//        return carDescEntity;
//    }
//
//    private List<BrandsEntity> chooseBrand(EntityCore entityCore) {
//        List<BrandsEntity> brandsEntities;
//        List<BrandsEntity> brandsEntities1 = new ArrayList<>();
//
//        Query query = entityCore.getEntityManager().createQuery("from BrandsEntity");
//        brandsEntities = query.getResultList();
//
//        int idx = randInt(1, 6);
//        for (int i = 0; i < idx; i++) {
//            brandsEntities1.add(brandsEntities.get(randInt(0, brandsEntities.size() - 1)));
//        }
//
//        return brandsEntities1;
//    }
//
//    private List<DrinkEntity> chosenDrink(EntityCore entityCore) {
//        List<DrinkEntity> drinkEntities;
//        List<DrinkEntity> drinkEntities1 = new ArrayList<>();
//
//
//        Query query = entityCore.getEntityManager().createQuery("from DrinkEntity ");
//        drinkEntities = query.getResultList();
//
//        int idx = randInt(1, 6);
//        for (int i = 0; i < idx; i++) {
//            drinkEntities1.add(drinkEntities.get(randInt(0, drinkEntities.size() - 1)));
//        }
//
//        return drinkEntities1;
//    }
//
//    public void makeOrder(int max) {
//        EntityCore entityCore = new EntityCore();
//
//        entityCore.start();
//
//        for (int i = 0; i < max; i++) {
//            OrderEntity orderEntity = new OrderEntity();
//            orderEntity.setKind(randInt(1, 3));
//            orderEntity.setStatus(3);
//            orderEntity.setStartDatetime(new Date());
//            orderEntity.setEndDatetime(new Date());
//            orderEntity.setDescriptionEntity(randOrderDescription());
//            orderEntity.setDishEntities(chosenDish(entityCore));
//            orderEntity.setDrinkEntities(chosenDrink(entityCore));
//
//            entityCore.getEntityManager().persist(orderEntity);
//        }
//
//        entityCore.end();
//    }
//
//
//}
//© 2018GitHub,Inc.
//        Terms
//        Privacy
//        Security
//        Status
//        Help
//        Contact GitHub
//        API
//        Training
//        Shop
//        Blog
//        About
//        Press h to open a hovercard with more details.