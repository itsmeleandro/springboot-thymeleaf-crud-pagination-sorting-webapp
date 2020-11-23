package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.Empleado;
import org.springframework.data.domain.Page;

import net.javaguides.springboot.model.Empleado;

public interface EmpleadoService {
	List<Empleado> getAllEmpleado();
	void saveEmployee(Empleado empleado);
	Empleado getEmployeeById(long id);
	void deleteEmployeeById(long id);
	Page<Empleado> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
