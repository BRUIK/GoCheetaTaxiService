package com.gocheeta.app.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gocheeta.app.model.Branch;
import com.gocheeta.app.model.Customer;
import com.gocheeta.app.model.Ride;
import com.gocheeta.app.model.UserDetails;
import com.gocheeta.app.model.VehicleType;
import com.gocheeta.app.service.BranchService;
import com.gocheeta.app.service.CustomerService;
import com.gocheeta.app.service.RideService;
import com.gocheeta.app.service.VehicleTypeService;

@Controller
public class RidePlacementController {

	@Autowired
	private RideService rideService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private VehicleTypeService vehicleTypeService;
	
	@Autowired
	private BranchService branchService;
	
	@PostMapping("/saveride")
	public String saveUserDetails(@ModelAttribute ("customerdetail") UserDetails  userDetails , @ModelAttribute ("ride") Ride ride , @ModelAttribute ("ridevehicle") VehicleType vehicleType , @ModelAttribute ("ridebranch") Branch branch,Model model) {
		System.out.println(userDetails.getUsername());
		System.out.println(ride.getPickup());
	
		
		if(userDetails.getUsername() == null) 
		{
			
			return "signin";
			
		} else {
			
			List< Customer> customers =  customerService.getAllCustomers();
			for (Customer customer : customers) {
				if(customer.getEmail().equals(userDetails.getUsername())) {
					ride.setCustomer(customer);					
				}
			}
			
			List<Branch> branchs =  branchService.getAllBranches();
			for (Branch branchFor : branchs) {
				if(branchFor.getIdbranch()==(branch.getIdbranch())) 
				{
					ride.setBranch(branchFor);
				}
			}
			
			List<VehicleType> vehicleTypes =  vehicleTypeService.getAllVehicleTypes();
			for (VehicleType type : vehicleTypes) {
				if(type.getIdvehicle_type() == (vehicleType.getIdvehicle_type())) {
					ride.setVehicleType(type);
				}
			}
			

			ride.setDatetime(new Date());
			ride.setStatus("placed");
			
			System.out.println(ride.getDrop()+" "+ride.getPickup()+" "+ride.getPrice()+" "+ride.getBranch().getIdbranch());
			System.out.println(ride.getCustomer().getCus_id()+" "+ride.getStatus()+" "+ride.getVehicleType().getName()+" "+ride.getDatetime());
			
			try {
				rideService.saveRide(ride);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			List <Ride> list = rideService.getAllRides();
			List <Ride> allRides = new ArrayList<Ride>();
			for (Ride rides : list) {
				if(rides.getCustomer().getCus_id() == (ride.getCustomer().getCus_id())) {
					allRides.add(rides);
				}
			}
			model.addAttribute("rides", allRides);
			
			return "account";
		}
				
	}
	
}
