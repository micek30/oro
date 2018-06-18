package Entity;

import javax.persistence.*;

@Entity
@Table(name = "EmpCar", schema = "public", catalog = "lxhpnrqk")
public class EmpCarEntity {
    private int idEmpCar;

    @Id
    @Column(name = "idEmpCar")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getIdEmpCar() {
        return idEmpCar;
    }

    public void setIdEmpCar(int idEmpCar) {
        this.idEmpCar = idEmpCar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmpCarEntity that = (EmpCarEntity) o;

        if (idEmpCar != that.idEmpCar) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idEmpCar;
    }
}
