package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import net.javaguides.springboot.model.Empleado;
import net.javaguides.springboot.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Empleado;
import net.javaguides.springboot.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImp implements EmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Override
	public List<Empleado> getAllEmpleado() {
		return empleadoRepository.findAll();
	}


	@Override
	public void saveEmployee(Empleado empleado) {
		this.empleadoRepository.save(empleado);
	}

	@Override
	public Empleado getEmployeeById(long id) {
		Optional<Empleado> optional = empleadoRepository.findById(id);
		Empleado empleado = null;
		if (optional.isPresent()) {
			empleado = optional.get();
		} else {
			throw new RuntimeException(" Employee not found for id :: " + id);
		}
		return empleado;
	}

	@Override
	public void deleteEmployeeById(long id) {
		this.empleadoRepository.deleteById(id);
	}

	@Override
	public Page<Empleado> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.empleadoRepository.findAll(pageable);
	}
}
