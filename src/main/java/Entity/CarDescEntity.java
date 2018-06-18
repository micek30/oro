package Entity;

import javax.persistence.*;

@Entity
@Table(name = "CarDesc", schema = "public", catalog = "lxhpnrqk")
public class CarDescEntity {
    private int idDesc;
    private CarDescEntity carDescEntity;
    private String color;
    private Integer year;

    @Id
    @Column(name = "idDesc")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getIdDesc() {
        return idDesc;
    }

    public void setIdDesc(int idDesc) {
        this.idDesc = idDesc;
    }




    @OneToOne
    @JoinColumn(name="idCar")
    public CarDescEntity getCarDescEntity() {
        return carDescEntity;
    }
    public void setCarDescEntity(CarDescEntity carDescEntity) {
        this.carDescEntity = carDescEntity;
    }


    @Basic
    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Basic
    @Column(name = "year")
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarDescEntity that = (CarDescEntity) o;

        if (idDesc != that.idDesc) return false;
        if (carDescEntity != null ? !carDescEntity.equals(that.carDescEntity) : that.carDescEntity != null)
            return false;
        if (color != null ? !color.equals(that.color) : that.color != null) return false;
        return year != null ? year.equals(that.year) : that.year == null;
    }

    @Override
    public int hashCode() {
        int result = idDesc;
        result = 31 * result + (carDescEntity != null ? carDescEntity.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        return result;
    }
}
