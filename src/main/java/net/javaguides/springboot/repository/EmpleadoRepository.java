package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{

}
