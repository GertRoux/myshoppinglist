package com.luv2code.mylist.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.mylist.hibernate.model.RetailerEntity;
import com.luv2code.mylist.mvc.service.RetailerService;

@Controller
@RequestMapping("/retailer")
public class RetailerController extends BaseListController{
	
	@Autowired
	private RetailerService retailerService;
	
	@GetMapping("/list")
	public String listRetailers(Model theModel) {
		
		// get retailers from dao
		List<RetailerEntity> retailers = retailerService.getRetailers();
		
		//add retailers to spring-mvc model
		theModel.addAttribute("retailers", retailers);
		
		
		return "list-retailers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		RetailerEntity retailer = new RetailerEntity();
		
		theModel.addAttribute("retailer", retailer);
		
		return "retailer-form";
	}
	
	@PostMapping("/saveRetailer")
	public String saveRetailer(@ModelAttribute("retailer") RetailerEntity retailer) {
		
		retailerService.saveRetailer(retailer);
		
		return "redirect:/retailer/list";
	}
	
	@GetMapping("/showUpdateForm")
	public String showFormForEdit(Model theModel,
								  @RequestParam("retailerId") int retailerId) {
		
		RetailerEntity retailer = retailerService.getRetailerForId(retailerId);
		
		theModel.addAttribute("retailer", retailer);
		
		return "retailer-form";
	}
	
	@GetMapping("/deleteRetailer")
	public String deleteRetailer(Model theModel,
								  @RequestParam("retailerId") int retailerId) {
		
		retailerService.deleteRetailerForId(retailerId);
		
		return "redirect:/retailer/list";
	}
	
	@GetMapping("/search")
    public String searchRetailers(@RequestParam("theSearchName") String theSearchName,
                                    Model theModel) {

        // search customers from the service
        List<RetailerEntity> theRetailers = retailerService.searchRetailers(theSearchName);
                
        // add the customers to the model
        theModel.addAttribute("retailers", theRetailers);

        return "list-retailers";        
    }

}
