package com.mycompany.springmvc.controller;

import com.mycompany.springmvc.entities.Trainer;
import com.mycompany.springmvc.service.TrainerService;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/")
public class TrainerController {

	@Autowired
	TrainerService service;
	
	@Autowired
	MessageSource messageSource;

	/*
	 * This method will list all existing employees.
	 */
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listTrainers(ModelMap model) {

		List<Trainer> trainers = service.findAllTrainers();
		model.addAttribute("trainers", trainers);
		return "alltrainers";
	}

	/*
	 * This method will provide the medium to add a new employee.
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newTrainer(ModelMap model) {
		Trainer trainer = new Trainer();
		model.addAttribute("trainer", trainer);
		model.addAttribute("edit", false);
		return "registration";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving employee in database. It also validates the user input
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveTrainer(@Valid Trainer trainer, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		}
                
		service.saveTrainer(trainer);

		model.addAttribute("success", "Trainer " + trainer.getFirst_name() + " registered successfully");
		return "success";
	}


	/*
	 * This method will provide the medium to update an existing employee.
	 */
	@RequestMapping(value = { "/edit-{id}-trainer" }, method = RequestMethod.GET)
	public String editTrainer(@PathVariable int id, ModelMap model) {
		Trainer trainer = service.findById(id);
		model.addAttribute("trainer", trainer);
		model.addAttribute("edit", true);
		return "registration";
	}
	
	/*
	 * This method will be called on form submission, handling POST request for
	 * updating employee in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-{id}-trainer" }, method = RequestMethod.POST)
	public String updateTrainer(@Valid Trainer trainer, BindingResult result,
			ModelMap model, @PathVariable int id) {

		if (result.hasErrors()) {
			return "registration";
		}

		service.updateTrainer(trainer);

		model.addAttribute("success", "Trainer " + trainer.getFirst_name()	+ " updated successfully");
		return "success";
	}

	
	/*
	 * This method will delete an employee by it's SSN value.
	 */
	@RequestMapping(value = { "/delete-{id}-trainer" }, method = RequestMethod.GET)
	public String deleteTrainer(@PathVariable int id) {
		service.deleteTrainerById(id);
		return "redirect:/list";
	}

}
