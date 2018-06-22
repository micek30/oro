package Entity;

import javax.persistence.*;
import java.util.List;

@Entity
//@Table(name = "Cars", schema = "public", catalog = "lxhpnrqk")
@Table(name = "Cars", schema = "public", catalog = "postgres")
public class CarsEntity {
    private int idCar;
    private BrandsEntity brandsEntity;
    private CarDescEntity carDescEntity;


    public List<EmployeesEntity> employeesEntities;

    @Id
    @Column(name = "idCar")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    @ManyToOne
    @JoinColumn(name = "idBrand")
    public BrandsEntity getBrandsEntity() { return brandsEntity; }

    public void setBrandsEntity(BrandsEntity brandsEntity) {
        this.brandsEntity = brandsEntity;
    }


    @OneToOne
    @JoinColumn(name="idCarDesc")
    public CarDescEntity getCarDescEntity() {
        return carDescEntity;
    }

    public void setCarDescEntity(CarDescEntity carDescEntity) {
        this.carDescEntity = carDescEntity;
    }

    @ManyToMany(mappedBy = "carsEntities")
    public List<EmployeesEntity> getEmployeesEntities() {
        return employeesEntities;
    }

    public void setEmployeesEntities(List<EmployeesEntity> employeesEntities) {
        this.employeesEntities = employeesEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarsEntity that = (CarsEntity) o;

        if (idCar != that.idCar) return false;

        return true;
    }


    @Override
    public int hashCode() {
        return idCar;
    }

    @Override
    public String toString() {
        return "CarsEntity{" +
                "idCar=" + idCar +
//                ", brandsEntity=" + brandsEntity.toString() +
//                ", carDescEntity=" + carDescEntity.toString() +
//                ", employeesEntities=" + employeesEntities.toString() +
                '}';
    }
}
