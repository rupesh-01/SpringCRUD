package com.rupesh.springboot.cruddemo.controller;

import com.rupesh.springboot.cruddemo.entity.Employee;
import com.rupesh.springboot.cruddemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;
    public EmployeeController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }
    @GetMapping("/list")
    public String listEmployee(Model theModel){
        List<Employee> theEmployees = employeeService.findAll();
        theModel.addAttribute("employees", theEmployees);
        return "employees/list-employees";
    }
    @GetMapping("/showFormAdd")
    public String showForm(Model theModel){
        Employee theEmployee = new Employee();
        theModel.addAttribute("employee", theEmployee);
        return "employees/showForm";
    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
        employeeService.save(theEmployee);
        return "redirect:/employees/list";
    }
    @GetMapping("/showFormUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel){
        Employee theEmployee = employeeService.findById(theId);
        theModel.addAttribute("employee", theEmployee);
        return "employees/showForm";
    }
    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("employeeId") int theId){
        employeeService.deleteById(theId);
        return "redirect:/employees/list";
    }
}
