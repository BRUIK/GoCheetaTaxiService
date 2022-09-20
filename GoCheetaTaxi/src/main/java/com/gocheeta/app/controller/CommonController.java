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
import org.springframework.web.bind.annotation.RequestParam;

import com.gocheeta.app.model.Branch;
import com.gocheeta.app.model.Customer;
import com.gocheeta.app.model.Driver;
import com.gocheeta.app.model.Ride;
import com.gocheeta.app.model.UserDetails;
import com.gocheeta.app.model.Vehicle;
import com.gocheeta.app.model.VehicleType;
import com.gocheeta.app.service.BranchService;
import com.gocheeta.app.service.DriverService;
import com.gocheeta.app.service.RideService;
import com.gocheeta.app.service.UserDetailsService;
import com.gocheeta.app.service.VehicleTypeService;

@Controller
public class CommonController {

	@Autowired
	private BranchService branchService;
	
	@Autowired
	private VehicleTypeService vehicleTypeService;
	
	@Autowired
	private UserDetailsService detailsService;
	
	@Autowired
	private DriverService driverService;
	
	@Autowired
	private RideService rideService;
	
	static Model model;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("branches", branchService.getAllBranches());
		if(vehicleTypeService.getAllVehicleTypes().isEmpty()) {
			System.out.println("empty");
		} else {
			System.out.println("not empty");
		}
		model.addAttribute("vehicleType",vehicleTypeService.getAllVehicleTypes());
		model.addAttribute("customerdetail",new UserDetails());
		model.addAttribute("ride",new Ride());
		model.addAttribute("ridebranch",new Branch());
		model.addAttribute("ridevehicle",new VehicleType());
		return "index";
	}
	
	@GetMapping("/index")
	public String viewHomePageIndex(Model model) {
		model.addAttribute("branches", branchService.getAllBranches());
		if(vehicleTypeService.getAllVehicleTypes().isEmpty()) {
			System.out.println("empty");
		} else {
			System.out.println("not empty");
		}
		model.addAttribute("vehicleType",vehicleTypeService.getAllVehicleTypes());
		model.addAttribute("customerdetail", new UserDetails());
		model.addAttribute("ride",new Ride());
		model.addAttribute("ridebranch",new Branch());
		model.addAttribute("ridevehicle",new VehicleType());
		return "index";
	}
	
	@PostMapping("/customerlogin")
	public String customerLogin(@ModelAttribute UserDetails userDetails,Model model) {
		
		List<UserDetails> oauthUser = detailsService.getAllUserDetails();
		for (UserDetails i : oauthUser) {
			 
            // Iterate all elements of List
            if(i.getUsername().equals(userDetails.getUsername())&&i.getPassword().equals(userDetails.getPassword())) 
            {
            	if(i.getType().equalsIgnoreCase("customer")) 
            	{
            		
            		model.addAttribute("branches", branchService.getAllBranches());
                	model.addAttribute("vehicleType",vehicleTypeService.getAllVehicleTypes());
                	model.addAttribute("userdetail", i);
                	model.addAttribute("customerdetail", i);
                	model.addAttribute("ride",new Ride());
            		model.addAttribute("ridebranch",new Branch());
            		model.addAttribute("ridevehicle",new VehicleType());
            		return "index";
            		
            	} else if(i.getType().equalsIgnoreCase("driver")) {
            		
            		List <Ride> rideLists = new ArrayList<Ride>();
            		
            		System.out.println("initialdf" +" "+userDetails.getId());
            		
            		List<Driver> drivers =  driverService.getAllDrivers();
            		for (Driver driver : drivers) {
            			if(driver.getUserdetail_id().getId()==i.getId()) 
            			{
            				model.addAttribute("driver",driver);
            				model.addAttribute("userdetail", i);
            				
            				List<Ride> rides = rideService.getAllRides();
            				for (Ride ride : rides) {
            					if(ride.getBranch().getIdbranch()==driver.getBranch_id().getIdbranch()) {          						
            						
            						if (ride.getVehicleType().getIdvehicle_type()== driver.getVehicle_id().getVehicle_type().getIdvehicle_type() ) {
            							
            							rideLists.add(ride);
            							
            						}
            					}
            				}            				
            				model.addAttribute("rides",rideLists);
            				//model = CommonController.model;
            			}
            		}
            		
            		return "driver_dashboard";
            		
            	}
            	
            }
        }
		
		return "signin";
	}
	
	@GetMapping("/acceptride")
	public String riderAcceptence(Model model, @RequestParam(name = "key", defaultValue = "0") int key,@RequestParam(name = "key2", defaultValue = "0") int key2) {
		System.out.println(key);
		List <Ride> rideLists = new ArrayList<Ride>();
		
		
		List<Driver> drivers =  driverService.getAllDrivers();
		for (Driver driver : drivers) {
			if(driver.getUserdetail_id().getId()==key2) 
			{
				model.addAttribute("driver",driver);
				model.addAttribute("userdetail", driver.getUserdetail_id());
				
				List<Ride> rides = rideService.getAllRides();
				for (Ride ride : rides) {
					if(ride.getBranch().getIdbranch()==driver.getBranch_id().getIdbranch()) {          						
						
						if (ride.getVehicleType().getIdvehicle_type()== driver.getVehicle_id().getVehicle_type().getIdvehicle_type() ) {
							
							if(ride.getId()==key) {
								ride.setStatus("accepted");
								rideService.saveRide(ride);
							}
							
							rideLists.add(ride);
							
							
						}
					}
				}            				
				model.addAttribute("rides",rideLists);
				//model = CommonController.model;
			}
	}
		return "driver_dashboard";
	}
	
	@GetMapping("/endride")
	public String riderEnd(Model model, @RequestParam(name = "key", defaultValue = "0") int key,@RequestParam(name = "key2", defaultValue = "0") int key2) {
		System.out.println(key);
		List <Ride> rideLists = new ArrayList<Ride>();
		
		
		List<Driver> drivers =  driverService.getAllDrivers();
		for (Driver driver : drivers) {
			if(driver.getUserdetail_id().getId()==key2) 
			{
				model.addAttribute("driver",driver);
				model.addAttribute("userdetail", driver.getUserdetail_id());
				
				List<Ride> rides = rideService.getAllRides();
				for (Ride ride : rides) {
					if(ride.getBranch().getIdbranch()==driver.getBranch_id().getIdbranch()) {          						
						
						if (ride.getVehicleType().getIdvehicle_type()== driver.getVehicle_id().getVehicle_type().getIdvehicle_type() ) {
							
							if(ride.getId()==key) {
								ride.setStatus("end");
								rideService.saveRide(ride);
							}
							
							rideLists.add(ride);							
						}
					}
				}            				
				model.addAttribute("rides",rideLists);
				//model = CommonController.model;
			}
	}
		return "driver_dashboard";
	}
	
	@GetMapping("/cancelride")
	public String riderCancel(Model model, @RequestParam(name = "key", defaultValue = "0") int key,@RequestParam(name = "key2", defaultValue = "0") int key2) {
		System.out.println(key);
		List <Ride> rideLists = new ArrayList<Ride>();
		
		
		List<Driver> drivers =  driverService.getAllDrivers();
		for (Driver driver : drivers) {
			if(driver.getUserdetail_id().getId()==key2) 
			{
				model.addAttribute("driver",driver);
				model.addAttribute("userdetail", driver.getUserdetail_id());
				
				List<Ride> rides = rideService.getAllRides();
				for (Ride ride : rides) {
					if(ride.getBranch().getIdbranch()==driver.getBranch_id().getIdbranch()) {          						
						
						if (ride.getVehicleType().getIdvehicle_type()== driver.getVehicle_id().getVehicle_type().getIdvehicle_type() ) {
							
							if(ride.getId()==key) {
								ride.setStatus("cancelled");
								rideService.saveRide(ride);
							}							
							rideLists.add(ride);							
						}
					}
				}            				
				model.addAttribute("rides",rideLists);
				//model = CommonController.model;
			}
	}
		return "driver_dashboard";
	}
	
	
	
	@GetMapping("/signup")
	public String viewSignup(Model model) {
		model.addAttribute("userdetail",new UserDetails());
		model.addAttribute("customer",new Customer());
		return "signup";
	}
	
	@GetMapping("/driversignup")
	public String driverSignup(Model model) {
		model.addAttribute("userdetail",new UserDetails());
		model.addAttribute("driver",new Driver());
		model.addAttribute("branches",branchService.getAllBranches());
		model.addAttribute("vehicle",new Vehicle());
		model.addAttribute("vehicleType",vehicleTypeService.getAllVehicleTypes());
		return "driver_signup";
	}
	
	@GetMapping("/signin")
	public String viewSignin(Model model) {
		//model.addAttribute("userdetail",new UserDetails());
		return "signin";
	}
	
	@GetMapping("/dashboard")
	public String viewAdminHomePageIndex() {
		return "admin_dashboard";
	}
	
	@GetMapping("/addvehicletype")
	public String adminaddvehicle(Model model) {
		model.addAttribute("vehicle",new VehicleType());
		return "admin_add_vehicle_type";
	}
	
	@RequestMapping("/adminsignin")
	public String viewAdminHomePageSignIn() {
		return "admin_signin";
	}
}
