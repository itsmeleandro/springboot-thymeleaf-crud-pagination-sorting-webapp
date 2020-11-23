package net.javaguides.springboot.controller;

import java.util.List;

import net.javaguides.springboot.model.Empleado;
import net.javaguides.springboot.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.javaguides.springboot.model.Empleado;
import net.javaguides.springboot.service.EmpleadoService;

@Controller
public class RegistrarEmpleado {

	@Autowired
	private EmpleadoService empleadoService;



	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		// create model attribute to bind form data
		Empleado empleado = new Empleado();
		model.addAttribute("empleado", empleado);
		return "new_employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("empleado") Empleado empleado) {
		// save employee to database
		System.out.println("LLEGAAAAAAAAA!!!!!");
		empleadoService.saveEmployee(empleado);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// get employee from the service
		Empleado empleado = empleadoService.getEmployeeById(id);
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("empleado", empleado);
		return "update_employee";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable (value = "id") long id) {
		
		// call delete employee method 
		this.empleadoService.deleteEmployeeById(id);
		return "redirect:/";
	}
	
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<Empleado> page = empleadoService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Empleado> listEmpleados = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listEmployees", listEmpleados);
		return "index";
	}
}
