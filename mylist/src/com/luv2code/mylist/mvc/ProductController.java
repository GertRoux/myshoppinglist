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

import com.luv2code.mylist.hibernate.model.Product;
import com.luv2code.mylist.mvc.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController extends BaseListController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/list")
	public String showForm(Model theModel) {
		
		theModel.addAttribute("products", productService.getAllProducts());
		
		return "list-products";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Product product = new Product();
		
		theModel.addAttribute("product", product);
		
		return "product-form";
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("product") Product product) {
		
		productService.saveProduct(product);
		
		return "redirect:/product/list";
	}
	
	@GetMapping("/showUpdateForm")
	public String showFormForEdit(Model theModel,
								  @RequestParam("productId") int productId) {
		
		Product product = productService.getProductForId(productId);
		
		theModel.addAttribute("product", product);
		
		return "product-form";
	}
	
	@GetMapping("/deleteProduct")
	public String deleteProduct(Model theModel,
								  @RequestParam("productId") int productId) {
		
		productService.deleteProductForId(productId);
		
		return "redirect:/product/list";
	}
	
	@GetMapping("/search")
    public String searchProducts(@RequestParam("theSearchName") String theSearchName,
                                    Model theModel) {

        // search products from the service
        List<Product> theProducts = productService.searchProducts(theSearchName);
                
        // add the productss to the model
        theModel.addAttribute("products", theProducts);

        return "list-products";        
    }
}
