package Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Brands", schema = "public", catalog = "postgres")
public class BrandsEntity {
    private int idBrand;
    private String name;
    private String localization;
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

    @Basic
    @Column(name = "localization")
    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
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
        if (localization != null ? !localization.equals(that.localization) : that.localization != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idBrand;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (localization != null ? localization.hashCode() : 0);
        return result;
    }
}
