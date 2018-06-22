//package Entity;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
////@Table(name = "EmpCar", schema = "public", catalog = "lxhpnrqk")
//@Table(name = "EmpCar", schema = "public", catalog = "postgres")
//public class EmpCarEntity {
//    private int idEmpCar;
//    private List<CarsEntity> carsEntities;
//    private List<EmployeesEntity> employeesEntities;
//
//    @Id
//    @Column(name = "idEmpCar")
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    public int getIdEmpCar() {
//        return idEmpCar;
//    }
//
//    public void setIdEmpCar(int idEmpCar) {
//        this.idEmpCar = idEmpCar;
//    }
//
//    @ManyToMany
//    public List<CarsEntity> getCarsEntities() {
//        return carsEntities;
//    }
//
//    public void setCarsEntities(List<CarsEntity> carsEntities) {
//        this.carsEntities = carsEntities;
//    }
//
//    @ManyToMany
//    public List<EmployeesEntity> getEmployeesEntities() {
//        return employeesEntities;
//    }
//
//    public void setEmployeesEntities(List<EmployeesEntity> employeesEntities) {
//        this.employeesEntities = employeesEntities;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        EmpCarEntity that = (EmpCarEntity) o;
//
//        if (idEmpCar != that.idEmpCar) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        return idEmpCar;
//    }
//}
