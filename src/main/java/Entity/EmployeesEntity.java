package Entity;

import javax.persistence.*;
import java.util.List;

@Entity
//@Table(name = "Employees", schema = "public", catalog = "lxhpnrqk")
@Table(name = "Employees", schema = "public", catalog = "postgres")
public class EmployeesEntity {
    private int idEmp;
    private String name;
    private int salary;

    //public List<CarsEntity> carsEntities;
    public List<CarsEntity> carsEntities;

    @Id
    @Column(name = "idEmp")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(int idEmp) {
        this.idEmp = idEmp;
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
    @Column(name = "salary")
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @ManyToMany//(mappedBy = "employeesEntities")
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

        EmployeesEntity that = (EmployeesEntity) o;

        if (idEmp != that.idEmp) return false;
        if (salary != that.salary) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEmp;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + salary;
        return result;
    }
}
