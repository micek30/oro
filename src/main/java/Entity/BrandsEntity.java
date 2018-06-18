package Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Brands", schema = "public", catalog = "lxhpnrqk")
public class BrandsEntity {
    private int idBrand;
    private String name;
    public List<CarsEntity> carsEntities;

    @Id
    @Column(name = "idBrand")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(int idBrand) {
        this.idBrand = idBrand;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "brandsEntity")
    public List<CarsEntity> getCarsEntities() {
        return carsEntities;
    }

    public void setCarsEntities(List<CarsEntity> carsEntities) {
        this.carsEntities = carsEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BrandsEntity that = (BrandsEntity) o;

        if (idBrand != that.idBrand) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return carsEntities != null ? carsEntities.equals(that.carsEntities) : that.carsEntities == null;
    }

    @Override
    public int hashCode() {
        int result = idBrand;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (carsEntities != null ? carsEntities.hashCode() : 0);
        return result;
    }
}
