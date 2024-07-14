package com.navaera.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.navaera.assignment.entity.Customer;
import com.navaera.assignment.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/main")
    public String redirectToMain() {
        return "Main"; // Redirect to the root URL
    }

	@GetMapping("/viewCustomerList")
	public String getAllCustomer(Model model) {
		List<Customer> allCustomer = customerService.getAllCustomer();
		System.out.println(allCustomer);
		model.addAttribute("allCustomers", allCustomer);
		return "ViewCustomerList";
	}

	@GetMapping("/addCustomer")
	public String addCustomer(@ModelAttribute("message") String message, Model model) {
		model.addAttribute("customer", new Customer());
		model.addAttribute("message", message);
		return "AddCustomer";

	}

//	@PostMapping("/saveCustomer")
//	public String saveCustomer(Customer customer, RedirectAttributes redirectAttributes) {
//        System.out.println("done");
//		if (customerService.saveOrUpdate(customer)) {
//			redirectAttributes.addFlashAttribute("message", "Save SyccessFully");
//
//			return "redirect:/viewCustomerList";
//		}
//		redirectAttributes.addFlashAttribute("message", "Save Failure");
//		return "redirect:/addCustomer";
//	}
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer, Model m,
			@Validated BindingResult result) {
		if (result.hasErrors()) {
			String defaultMessage = result.getFieldError().getDefaultMessage();
			System.out.println(defaultMessage);
			return "AddCustomer";
		} else {
			System.out.println(customer);
			if (customerService.saveOrUpdate(customer)) {
				m.addAttribute("allCustomers", customerService.getAllCustomer());
				return "ViewCustomerList";
			}
			return "AddCustomer";
		}
	}
//		if (customerService.saveOrUpdate(customer)) {
//			redirectAttributes.addFlashAttribute("message", "Save SyccessFully");
//
//			return "redirect:/viewCustomerList";
//		}
//		redirectAttributes.addFlashAttribute("message", "Save Failure");

	@GetMapping("editCustomer/{id}")
	public String editCustomer(@PathVariable Long id, Model model) {
//		model.addAttribute("customer", customerService.getCustomerById(id));
		System.out.println(id + "---------------");
		Customer customerById = customerService.getCustomerById(id);
		model.addAttribute("customer", customerById);
		return "EditCustomer";
	}

	@GetMapping("deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable Long id, Model m) {
//		model.addAttribute("customer", customerService.getCustomerById(id));
		System.out.println(id + "---------------");
		if (customerService.deleteById(id)) {
			m.addAttribute("message", "Deleted Successfully");
			return "redirect:/customer/viewCustomerList";
		}
		m.addAttribute("message", "Error while Deleting ???");
		return "redirect:/customer/viewCustomerList";
	}

	@PostMapping("editSaveCustomer")
	public String editSaveCustomer(Customer customer, Model m) {
		if (customerService.saveOrUpdate(customer)) {
			m.addAttribute("message", "Updated Successfully");
			return "redirect:/customer/viewCustomerList";
		}
		m.addAttribute("message", "Edit  Failure");
		return "redirect:/customer/viewCustomerList";
	}

}
