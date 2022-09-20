package com.gocheeta.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gocheeta.app.model.Branch;
import com.gocheeta.app.model.Customer;
import com.gocheeta.app.model.Driver;
import com.gocheeta.app.model.Ride;
import com.gocheeta.app.model.UserDetails;
import com.gocheeta.app.model.Vehicle;
import com.gocheeta.app.model.VehicleType;
import com.gocheeta.app.service.BranchService;
import com.gocheeta.app.service.CustomerService;
import com.gocheeta.app.service.DriverService;
import com.gocheeta.app.service.RideService;
import com.gocheeta.app.service.UserDetailsService;
import com.gocheeta.app.service.VehicleService;
import com.gocheeta.app.service.VehicleTypeService;

@Controller
public class UserDetailsController {

	@Autowired
	private UserDetailsService detailsService;
	
	@Autowired
	private CustomerService customerService;
	

	@Autowired
	private VehicleTypeService vehicleTypeService;
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private DriverService driverService;
	
	@Autowired
	private BranchService branchService;
	
	@Autowired
	private RideService rideService;
	
	
	@PostMapping("/saveUserDetails")
	public String saveUserDetails(@ModelAttribute ("userdetail") UserDetails userDetails , @ModelAttribute ("customer") Customer customer) {
		userDetails.setType("customer");
		detailsService.saveUserDetails(userDetails);
		
		customer.setEmail(userDetails.getUsername());
		customer.setUserdetail_id(userDetails);
		customerService.saveCustomer(customer);
		
	
		return "redirect:/index";
		
	}
	
	@RequestMapping("/addVehicle")
	public String addVehicleType(@ModelAttribute ("vehicle") VehicleType type,Model model) {
		vehicleTypeService.save(type);
		model.addAttribute("ride", rideService.getAllRides());
		return "admin_dashboard";
	}

	
	@PostMapping("/adminlogin")
	public String adminLogin(@ModelAttribute UserDetails userDetails,Model model) {
		
		List<UserDetails> oauthUser = detailsService.getAllUserDetails();
		for (UserDetails i : oauthUser) {
			 
            // Iterate all elements of List
            if(i.getUsername().equals(userDetails.getUsername())&&i.getPassword().equals(userDetails.getPassword()))
            {
            	model.addAttribute("driver", driverService.getAllDrivers());
        		model.addAttribute("vehicle",new VehicleType());
        		model.addAttribute("ride", rideService.getAllRides());
            	model.addAttribute("admin", i);
        		return "admin_dashboard";
            }
        }		
		return "admin_signin";
	}
	
	@PostMapping("/saveDriverDetails")
	public String saveDriverDetails(@ModelAttribute ("userdetail") UserDetails userDetails , @ModelAttribute ("driver") Driver driver,@ModelAttribute ("branches") Branch branch, @ModelAttribute ("vehicle") Vehicle vehicle, @ModelAttribute ("vehicleType") VehicleType vehicleType, Model model) {
		userDetails.setType("driver");
		detailsService.saveUserDetails(userDetails);
		
		List<VehicleType> vehicleTypes =  vehicleTypeService.getAllVehicleTypes();
		for (VehicleType type : vehicleTypes) {
			if(type.getIdvehicle_type() == (vehicleType.getIdvehicle_type())) {
				vehicle.setVehicle_type(vehicleType);
			}
		}
		
		List<Branch> branchs =  branchService.getAllBranches();
		ArrayList branchTotal =  new ArrayList();
		
		for (Branch branchFor : branchs) {
			if(branchFor.getIdbranch()==(branch.getIdbranch())) 
			{
				driver.setBranch_id(branch);
			}
			
			getTotal(branchFor);
			

			
		}
		
		vehicleService.saveVehicle(vehicle);
		
		driver.setVehicle_id(vehicle);
		driver.setUserdetail_id(userDetails);
		driver.setStatus("active");
		driverService.saveDriver(driver);
		
		model.addAttribute("vehicle",new VehicleType());
		model.addAttribute("driver", driverService.getAllDrivers());
		model.addAttribute("ride", rideService.getAllRides());
		return "admin_dashboard";
		
	}

	private double getTotal(Branch branchFor) {
		List <Ride> rides =  rideService.getAllRides();
		double total = 0;
		for (Ride ride : rides) {
			
			if(branchFor.getIdbranch() == (ride.getBranch().getIdbranch())) 
			{
				total = total + ride.getPrice();
			}			
		}
		
		return total;
		
	}
	

	
}
