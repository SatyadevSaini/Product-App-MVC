package com.incapp.controller;

import java.io.InputStream;
import java.security.PublicKey;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.incapp.bean.Product;
import com.incapp.repo.ProductRepo;



@Controller
public class MyController {
	
	
	@Autowired
	ProductRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/getAllProducts")
	public String getAllProduct( Model model) {
		
	 List<Product> data =	repo.getAllProduct();
	 
	 model.addAttribute("Data", data);
		
		
		return"GetAllproducts";
		
	}
	
	
	//addProduct 
	@RequestMapping("/addProduct")
	public String addProduct(@ModelAttribute Product p , Part image , Model model ) {
		
		InputStream img = null;
		try {
			if(image !=null) {
				img = image.getInputStream();
			}
			
		} catch (Exception e) {
			return null;
		}
		
		
		
	String result = repo.addProduct(p ,img);
	model.addAttribute("result", result);
    
		return"index";	
	}
    
	
	
	//getDatabyId
	@RequestMapping("/getproductbyid")
	
	public String getProductById(int pid , Model model) {
		
	Product p =	repo.getProductById(pid);
	
	model.addAttribute("result", p);

			return"another";
		
	}
	
	
	//getNameLike
	@RequestMapping("/getproductlikeName")
	
	public String getNameLike(String pname , Model model) {
		
	List<Product> data =repo.getProductByName(pname);
	
	model.addAttribute("Data1",data);
		
		return "LikeProduct";
		
	}
	
	
	
	
	@RequestMapping("/delete")
	public String deleteApp(int pid , Model model ) {
		
   String result	=repo.deleteProduct(pid);
  
   model.addAttribute("result", result);
		
		
		return"index";
	}
	
	
	
	@ModelAttribute
	public void commonValue(Model m) {
		
		List<Integer> idname = repo.getProductsId();
		m.addAttribute("idk", idname);
		
	}
	
	@RequestMapping("/updateBook")
	public String update(@ModelAttribute Product p , int id , Model model) {
		
		String result = repo.updateProduct(id , p);
		model.addAttribute("update", result);
		
		return"index";
	}
	
	
	
	//print images 
	@RequestMapping("/getImage")
	public void  getImage(int pid , HttpServletResponse httpServletResponse) {
		
		try {
			
			byte [] image = repo.getImage(pid);
		    httpServletResponse.getOutputStream().write(image);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	 
	 
	 
		
	}
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
