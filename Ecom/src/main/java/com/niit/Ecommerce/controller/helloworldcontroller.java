package com.niit.Ecommerce.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Ecombend.dao.SupplierDAO;

import com.niit.Ecombend.dao.UserDAO;
import com.niit.Ecombend.dao.cartDAO;
import com.niit.Ecombend.dao.categoryDAO;
import com.niit.Ecombend.dao.productDAO;
import com.niit.Ecombend.models.Category;
import com.niit.Ecombend.models.Product;
import com.niit.Ecombend.models.Supplier;
import com.niit.Ecombend.models.User;

@Controller
public class helloworldcontroller {
	
	@Autowired
	UserDAO userdao;
	
	@Autowired
	productDAO productdao;
	
	@Autowired
	categoryDAO categorydao;
	
	@Autowired
	cartDAO cartDao;
	
	@Autowired

	SupplierDAO supplierdao;
	
	String message = "Welcome to Spring MVC!";
 
	
	@RequestMapping("/hello/{name}")		
	public ModelAndView showMessage(@PathVariable("name") String n) {
		System.out.println("in controller");
 
		ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("msg", "Success");
		mv.addObject("name", n);
		
		return mv;
	}
	@RequestMapping("/")
	public  ModelAndView  index()
	{
		ModelAndView mv1 = new ModelAndView("index");
		 List<Category> l=(List<Category>)categorydao.getallcategory();
		
	    System.out.println("Category List : "+l);
				mv1.addObject("cat",l);
		return mv1;
		
	}
	@RequestMapping("/adding")
	public String adding()
	
	{
		
		return "adding";
		
	}
	
	@RequestMapping(value="/saveUser",method=RequestMethod.POST)
	public  ModelAndView  saveU(@RequestParam("first_name") String name,@RequestParam("last_name") String lastname,@RequestParam("email") String email,@RequestParam("password") String pass)
	{
		
		System.out.println("in register .................."+name+""+lastname +""+email+""+pass);
		System.out.println("in controller");
		System.out.println(name+email+pass);
		User p=new User();
		
		p.setName(name);
		p.setEmail(email);
		
		p.setPassword(pass);
		
		userdao.saveUser(p);
	
		ModelAndView mv1 = new ModelAndView("logn");
		
		return mv1;
	
	}
	
	
	@RequestMapping(value="/saveProduct",method=RequestMethod.POST)
	public  ModelAndView  saveP(@RequestParam("cid") int id ,@RequestParam("name") String name,@RequestParam("sid") int sid,@RequestParam("price") Integer price,@RequestParam("stock") Integer stock)
	{
		
		System.out.println("in register .................."+name+""+price+""+stock);
		System.out.println("in controller");
		System.out.println(name+price+stock);
		Product p=new Product();
		
		p.setName(name);
		p.setPrice(price);
		
		p.setStock(stock);
		
		Category c=categorydao.getcatbyid(id);
		Supplier s=supplierdao.getSupplierById(sid);
		
		p.setCategory(c);
		p.setSupplier(s);
		
		productdao.saveProduct(p);
		
	
		ModelAndView mv1 = new ModelAndView("admin");
List<Category> l=(List<Category>)categorydao.getallcategory();
		
	    System.out.println("Category List : "+l);
				mv1.addObject("cat",l);
				
		List<Supplier> ll=(List<Supplier>)supplierdao.getAllSupplier();
		 System.out.println("Supplier List : "+l);
	      mv1.addObject("supp",ll);
				
		
		return mv1;
	
	}
	@RequestMapping("/logn")
	public String logn()
	{
		return "logn";
		
	}
	@RequestMapping("/cart")
	public ModelAndView cart()
	{
		System.out.println("in controller");
		ModelAndView mv1 = new ModelAndView("cart");
		return mv1;
	
		
	}
	
	@RequestMapping("/admin")
	public ModelAndView admin() {
		System.out.println("in controller");
		ModelAndView mv1 = new ModelAndView("admin");
		 List<Category> l=(List<Category>)categorydao.getallcategory();
		
	    System.out.println("Category List : "+l);
				mv1.addObject("cat",l);
				
		List<Supplier> ll=(List<Supplier>)supplierdao.getAllSupplier();
		 System.out.println("Supplier List : "+l);
	      mv1.addObject("supp",ll);
				

		
		return mv1;
	}
	@RequestMapping("/categorylist")
	public ModelAndView categorylist() {
		System.out.println("in controller");

		ModelAndView mv1 = new ModelAndView("categorylist");
List<Category> l=(List<Category>)categorydao.getallcategory();
		
	    System.out.println("Category List : "+l);
				mv1.addObject("cat",l);
				
		return mv1;
		
	}
	
	@RequestMapping("/deletecategory")
	public ModelAndView delcat(@RequestParam("id") int id){
	List<Category> cat=(List<Category>)categorydao.getallcategory();
	ModelAndView mv= new ModelAndView("admin");
	mv.addObject("cat",cat);
	categorydao.deletecategory(id);
	return mv;
	}
     
	@RequestMapping("/updatecategory")
	public ModelAndView upC(@RequestParam("id") int id) {
	System.out.println("reaching innnnn"+id);

	
	Category cat=categorydao.getcatbyid(id);
	ModelAndView mv1 = new ModelAndView("categoryupdate");

	mv1.addObject("cat",cat);
	return mv1;
	}



	
	@RequestMapping("/supplierlist")
	public ModelAndView supplierlist() {
		System.out.println("in controller");

		ModelAndView mv1 = new ModelAndView("supplierlist");

		List<Supplier> ll=(List<Supplier>)supplierdao.getAllSupplier();
		 System.out.println("Supplier List : "+ll);
	      mv1.addObject("supp",ll);
	      return mv1;	
	}
	@RequestMapping("/deletesupplier")
	  public ModelAndView delsup(@RequestParam("id") int id){
	   List<Supplier> sup=(List<Supplier>)supplierdao.getAllSupplier();
	   ModelAndView mv= new ModelAndView("admin");
	   mv.addObject("sup",sup);
	   supplierdao.deletesupplier(id);
	   return mv;
	}
	@RequestMapping("/updatesupplier")
	public ModelAndView upS(@RequestParam("id") int id) {
	System.out.println("reaching innnnn"+id);

	Supplier sup=supplierdao.getSupplierById(id);
	ModelAndView mv1 = new ModelAndView("supplierupdate");

	mv1.addObject("sup",sup);
	return mv1;
	}
	
	@RequestMapping("/productlist")
	public ModelAndView productlist() {
		System.out.println("in controller");

		ModelAndView mv1 = new ModelAndView("productlist");
     List<Product> l=(List<Product>)productdao.getAllProduct();
		
	    System.out.println("Product List : "+l);
				mv1.addObject("pro",l);
				 
		return mv1;
		
	}
	@RequestMapping("/deleteproduct")
	  public ModelAndView delpro(@RequestParam("id") int id){
	   List<Product> pro=(List<Product>)productdao.getAllProduct();
	   ModelAndView mv= new ModelAndView("admin");
	   mv.addObject("pro",pro);
	   productdao.deleteProduct(id);
	   return mv;
	}
	@RequestMapping("/updateproduct")
	public ModelAndView upP(@RequestParam("id") int id) {
	System.out.println("reaching innnnn"+id);

	Product pro=productdao.getProductById(id);
	ModelAndView mv1 = new ModelAndView("productupdate");
	 List<Category> l=(List<Category>)categorydao.getallcategory();
		
	    System.out.println("Category List : "+l);
				mv1.addObject("cat",l);
				
		List<Supplier> ll=(List<Supplier>)supplierdao.getAllSupplier();
		 System.out.println("Supplier List : "+l);
	      mv1.addObject("supp",ll);

	mv1.addObject("pro",pro);
	
	return mv1;
	}
	
	@RequestMapping(value="/saveCategory",method=RequestMethod.POST)
	public  ModelAndView  saveC(@RequestParam("name") String name)
	{
		
		System.out.println("in register .................."+name);
		System.out.println("in controller");
		System.out.println(name);
		Category c=new Category();
		
		c.setName(name);
		
		
		categorydao.saveCategory(c);
	
		ModelAndView mv1 = new ModelAndView("admin");
		
		return mv1;
	
	}
	@RequestMapping(value="/saveupdatecategory")
	public  ModelAndView  saveC(@RequestParam("id") int id,@RequestParam("name") String name)
	{
		
		System.out.println("in register .................."+id+""+name);
		System.out.println("in controller");
		System.out.println(id);
		System.out.println(name);
		Category c=new Category();
		
		c.setId(id);
		c.setName(name);
		
		
		categorydao.updatecategory(c);
	
		ModelAndView mv1 = new ModelAndView("admin");
		
		return mv1;
	
	}
	@RequestMapping(value="/saveSupplier")
	public  ModelAndView  saveSU(@RequestParam("name") String name,@RequestParam("address") String address)
	{
		
		System.out.println("in register .................."+name+""+address);
		System.out.println("in controller");
		System.out.println(name);
		System.out.println(address);
		Supplier su=new Supplier();
		
		su.setName(name);
		su.setAddress(address);
		
		
		supplierdao.saveSupplier(su);
	
		ModelAndView mv1 = new ModelAndView("admin");
		
		return mv1;
	
	}
	@RequestMapping(value="/saveupdatesupplier")
	public  ModelAndView  saveSU(@RequestParam("id") int id,@RequestParam("name") String name,@RequestParam("address") String address)
	{
		
		System.out.println("in register .................."+id+""+name+""+address);
		System.out.println("in controller");
		System.out.println(id);
		
		Supplier su=new Supplier();
		
		su.setId(id);
		su.setName(name);
		su.setAddress(address);
		
		
		
		supplierdao.saveupdatesupplier(su);
	
		ModelAndView mv1 = new ModelAndView("admin");
		
		return mv1;
	
	}
	
	@RequestMapping(value="/saveupdateproduct")
	public  ModelAndView  saveP(@RequestParam("id") int id ,@RequestParam("sid") int sid,@RequestParam("cid") int cid,@RequestParam("name") String name ,@RequestParam("price") int price ,@RequestParam("stock") int stock )
	{
		
		System.out.println("in register .................."+sid+""+cid+""+id+""+name+""+price+""+stock);
		System.out.println("in controller");
		System.out.println(cid);
		System.out.println(sid);
		System.out.println(id);
		System.out.println(name);
		System.out.println(price);
		System.out.println(stock);
		ModelAndView mv1 = new ModelAndView("admin");
		 List<Category> l=(List<Category>)categorydao.getallcategory();
		
	    System.out.println("Category List : "+l);
				mv1.addObject("cat",l);
				
		List<Supplier> ll=(List<Supplier>)supplierdao.getAllSupplier();
		 System.out.println("Supplier List : "+l);
	      mv1.addObject("supp",ll);
	     
		Product p=new Product();
		p.setId(sid);
		p.setId(cid);
		p.setId(id);
		p.setName(name);
		
		p.setPrice(price);
		
		p.setStock(stock);
		
		productdao.saveupdateProduct(p);
		
		
		
				
		
		return mv1;
	
	}
	
	
}
	
	
	
	
	
	
	
	
