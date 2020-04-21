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

import com.luv2code.mylist.hibernate.model.Price;
import com.luv2code.mylist.hibernate.model.Product;
import com.luv2code.mylist.hibernate.model.RetailerEntity;
import com.luv2code.mylist.mvc.service.PriceService;
import com.luv2code.mylist.mvc.service.ProductService;
import com.luv2code.mylist.mvc.service.RetailerService;

@Controller
@RequestMapping("/price")
public class PriceController extends BaseListController{
	
	@Autowired
	private PriceService priceService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private RetailerService retailerService;
	
	@RequestMapping("/list")
	public String showPricesList(Model theModel) {
		
		theModel.addAttribute("prices", priceService.getAllPrices());
		
		return "list-prices";
	}
		
	@RequestMapping("/showFormForAdd")
	public String showForm(Model theModel) {
		theModel.addAttribute("price", new com.luv2code.mylist.mvc.model.Price());
		
		//get all the products
		theModel.addAttribute("products", productService.getAllProducts());
		//get all the retailers
		theModel.addAttribute("retailers", retailerService.getRetailers());
		
		return "price-form";
	}

	@PostMapping("/savePrice")
	public String savePrice(@ModelAttribute("price") com.luv2code.mylist.mvc.model.Price price) {
		
		Product theProduct = productService.getProductForId(Integer.parseInt(price.getProduct()));
		
		RetailerEntity retailer = retailerService.getRetailerForId(Integer.parseInt(price.getRetailer()));
		
		Price thePrice = new Price(price.getPrice(), price.getDateOfPurchase(), retailer, theProduct);
		priceService.savePrice(thePrice);
		
		return "redirect:/price/list";
	}
	
	@GetMapping("/showUpdateForm")
	public String showFormForEdit(Model theModel,
								  @RequestParam("priceId") int priceId) {
		
		Price price = priceService.getPriceForId(priceId);
		
		theModel.addAttribute("price", price);
		
		return "price-form";
	}
	
	@GetMapping("/deletePrice")
	public String deletePrice(Model theModel,
								  @RequestParam("priceId") int priceId) {
		
		priceService.deletePriceForId(priceId);
		
		return "redirect:/price/list";
	}
	
	@GetMapping("/search")
    public String searchPrices(@RequestParam("theSearchName") String theSearchName,
                                    Model theModel) {

        // search prices from the service
        List<Price> thePrices = priceService.searchPrices(theSearchName);
                
        // add the productss to the model
        theModel.addAttribute("prices", thePrices);

        return "list-prices";        
    }
}
