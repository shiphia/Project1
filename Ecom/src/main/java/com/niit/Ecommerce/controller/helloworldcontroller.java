package com.niit.Ecommerce.controller;
 
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Ecombend.dao.SupplierDAO;

import com.niit.Ecombend.dao.UserDAO;
import com.niit.Ecombend.dao.cartDAO;
import com.niit.Ecombend.dao.categoryDAO;
import com.niit.Ecombend.dao.orderdao;
import com.niit.Ecombend.dao.productDAO;
import com.niit.Ecombend.models.Cart;
import com.niit.Ecombend.models.Category;
import com.niit.Ecombend.models.Product;
import com.niit.Ecombend.models.Supplier;
import com.niit.Ecombend.models.User;
import com.niit.Ecombend.models.order;

@Controller
public class helloworldcontroller {
	
	@Autowired
	UserDAO userdao;
	
	@Autowired
	productDAO productdao;
	
	@Autowired
	orderdao orderDao;
	
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
	@RequestMapping("/user")
	public  ModelAndView  indexU()
	{
		ModelAndView mv1 = new ModelAndView("redirect:/");
		return mv1;
		
	}
	@RequestMapping("/adding")
	public  ModelAndView  inde()
	{
		ModelAndView mv1 = new ModelAndView("adding");
		 List<Category> l=(List<Category>)categorydao.getallcategory();
			
		    System.out.println("Category List : "+l);
					mv1.addObject("cat",l);
		return mv1;
		
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
        p.setRole("ROLE_USER");
		userdao.saveUser(p);
	
		ModelAndView mv1 = new ModelAndView("logn");
		List<Category> l=(List<Category>)categorydao.getallcategory();
		
	    System.out.println("Category List : "+l);
				mv1.addObject("cat",l);
		return mv1;
	
	}
	
	
	@RequestMapping(value="/saveProduct",method=RequestMethod.POST)
	public  ModelAndView  saveP(@RequestParam("cid") int id ,@RequestParam("name") String name,@RequestParam("sid") int sid,@RequestParam("img") MultipartFile file,@RequestParam("price") Integer price,@RequestParam("stock") Integer stock)
	{
		
		System.out.println("in register .................."+name+""+price+""+stock);
		System.out.println("in controller");
		System.out.println(name+price+stock);
		Product p=new Product();
		
		p.setName(name);
		p.setPrice(price);
		
		p.setStock(stock);
		
		String img=file.getOriginalFilename();
	    p.setImg(img);
		 String filepath ="C:/Users/owner/workspace/Ecom/src/main/webapp/resources/images1/" + file.getOriginalFilename();
		 try {
				byte imagebyte[] = file.getBytes();
				BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(filepath));
				fos.write(imagebyte);
				fos.close();
				} catch (IOException e) {
				e.printStackTrace();}
		 
		
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
	public ModelAndView logn()
	{
		System.out.println("in controller");
		ModelAndView mv1 = new ModelAndView("logn");
		
		 List<Category> l=(List<Category>)categorydao.getallcategory();
			
		    System.out.println("Category List : "+l);
					mv1.addObject("cat",l);
					return mv1;
		
	}
	@RequestMapping("/cart")
	public ModelAndView cart(@RequestParam("id") int id)
	{
		ModelAndView mv1 = new ModelAndView("redirect:/user/cart");
		mv1.addObject("id",id);
		return mv1;
	}
	@RequestMapping("/mycart")
	public ModelAndView mycart()
	{
		return new ModelAndView("redirect:/user/mycart");
	}
	@RequestMapping("/user/mycart")
	public ModelAndView mcart()
	{
		ModelAndView mv1 = new ModelAndView("cart");
		 String name = SecurityContextHolder.getContext().getAuthentication().getName();
       List<Cart> ll=(List<Cart>)cartDao.getcartbyusernmae(name);
		
		
		mv1.addObject("ca",ll);
		int total=0;
		for(Cart cart1:ll)
		{
			int sum=cart1.getPid().getPrice()*cart1.getQuantity();
		total=total+sum;	
		}
		
		mv1.addObject("t",total);
		
		
List<Category> l=(List<Category>)categorydao.getallcategory();
		
		 
		
		mv1.addObject("cat",l);
			return mv1;
	}
	@RequestMapping("/user/cart")
	public ModelAndView userart(@RequestParam("id") int id)
	{
		
			
		     String name = SecurityContextHolder.getContext().getAuthentication().getName();
		     Cart cart=new Cart();
			
	int count=0,cartid=0;
	
	List<Cart> car=(List<Cart>)cartDao.getcartbyusernmae(name);
		
		for(Cart c:car )
		{
			Product ppp=c.getPid();
			if(ppp.getId()==id)
			{
				count=1;
				cartid=c.getId();
			}
		}
		if(count==1) //actually quantity update if want same product more than one
		{
			
			Cart c=cartDao.getcartbyid(cartid);
			int quantity=c.getQuantity();
			quantity=quantity+1;
			cartDao.updatequantity(cartid,quantity);
		}
		else //else condition for adding one quantity for one product
		{
			cart.setUsername(name);
	cart.setQuantity(1);
	Product p=new Product();
	p=cartDao.getprbyid(id);
	
	
	cart.setPid(p);
	cartDao.saveCart(cart);
		
	
}
		Product p=productdao.getProductById(id);
		p.setStock(p.getStock()-1);
		productdao.updateProduct(p);
		ModelAndView mv1 = new ModelAndView("redirect:/user/mycart");
		
	
		return mv1;
	
		
		
	}
	
	@RequestMapping("/user/cartup")
	public ModelAndView cartupdate(@RequestParam("cartid") int cartid) {
		
		ModelAndView mv1 = new ModelAndView("Cartupdate");
		List<Category> l=(List<Category>)categorydao.getallcategory();
		mv1.addObject("cat",l);
		Cart c= new Cart();
		c=cartDao.getcartbyid(cartid);
		mv1.addObject("ca",c);
		return mv1;
}

	
	@RequestMapping("/user/updatecart")
	public ModelAndView cart(@RequestParam("id") int cartid, @RequestParam("quantity") int quantity) {
		ModelAndView mv1 = new ModelAndView("redirect:/user/mycart");
		List<Category> l=(List<Category>)categorydao.getallcategory();
		mv1.addObject("cat",l);
	    Cart c= new Cart();
		String Username=SecurityContextHolder.getContext().getAuthentication().getName();
		c.setUsername(Username);
		c.setQuantity(quantity);
		cartDao.updatequantity(cartid,quantity);
		List<Cart> ll=(List<Cart>)cartDao.getcartbyusernmae(Username);
		
		
		mv1.addObject("ca",ll);
		int total=0;
		for(Cart cart:ll)
		{
		int sum=cart.getPid().getPrice()*cart.getQuantity();
		total=total+sum;	
		}
		
		mv1.addObject("t",total);
		return mv1;
	}

	@RequestMapping("/user/cartdel")
	public ModelAndView cartdelete(@RequestParam("cartid") int cartid) {
		
		cartDao.deletecart(cartid);
		ModelAndView mv1 = new ModelAndView("redirect:/user/mycart");
		List<Category> l=(List<Category>)categorydao.getallcategory();
		mv1.addObject("cat",l);
		String Username=SecurityContextHolder.getContext().getAuthentication().getName();
		
		List<Cart> ll=(List<Cart>)cartDao.getcartbyusernmae(Username);
		
		mv1.addObject("ca",ll);
		
		int total=0;
		for(Cart cart:ll)
		{
		int sum=cart.getPid().getPrice()*cart.getQuantity();
		total=total+sum;	
		}
		
		mv1.addObject("t",total);
		
		return mv1;

	}
	
	@RequestMapping("/admin")
	public ModelAndView admimi()
	{
		ModelAndView mv = new ModelAndView("redirect:/admin/add");
		
		return mv;
		
	}
	
	@RequestMapping("/admin/add")
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
	
	
	@RequestMapping("/admin/categorylist")
	public ModelAndView categorylist() {
		System.out.println("in controller");

		ModelAndView mv1 = new ModelAndView("categorylist");
List<Category> l=(List<Category>)categorydao.getallcategory();
		
	    System.out.println("Category List : "+l);
				mv1.addObject("cat",l);
				
		return mv1;
		
	}
	
	@RequestMapping("/admin/deletecategory")
	public ModelAndView delcat(@RequestParam("id") int id){
	List<Category> cat=(List<Category>)categorydao.getallcategory();

	ModelAndView mv= new ModelAndView("admin");
	mv.addObject("cat",cat);
	categorydao.deletecategory(id);
	return mv;
	}
     
	@RequestMapping("/admin/updatecategory")
	public ModelAndView upC(@RequestParam("id") int id) {
	System.out.println("reaching innnnn"+id);

	
	Category cat=categorydao.getcatbyid(id);
	ModelAndView mv1 = new ModelAndView("categoryupdate");

	mv1.addObject("cat",cat);
	return mv1;
	}



	
	@RequestMapping("/admin/supplierlist")
	public ModelAndView supplierlist() {
		System.out.println("in controller");

		ModelAndView mv1 = new ModelAndView("supplierlist");

		List<Supplier> ll=(List<Supplier>)supplierdao.getAllSupplier();
		 System.out.println("Supplier List : "+ll);
	      mv1.addObject("supp",ll);
	      return mv1;	
	}
	@RequestMapping("/admin/deletesupplier")
	  public ModelAndView delsup(@RequestParam("id") int id){
	   List<Supplier> sup=(List<Supplier>)supplierdao.getAllSupplier();
	   ModelAndView mv= new ModelAndView("admin");
	   mv.addObject("sup",sup);
	   supplierdao.deletesupplier(id);
	   return mv;
	}
	@RequestMapping("/admin/updatesupplier")
	public ModelAndView upS(@RequestParam("id") int id) {
	System.out.println("reaching innnnn"+id);

	Supplier sup=supplierdao.getSupplierById(id);
	ModelAndView mv1 = new ModelAndView("supplierupdate");

	mv1.addObject("sup",sup);
	return mv1;
	}
	
	@RequestMapping("/admin/productlist")
	public ModelAndView productlist() {
		System.out.println("in controller");

		ModelAndView mv1 = new ModelAndView("productlist");
     List<Product> l=(List<Product>)productdao.getAllProduct();
		
	    System.out.println("Product List : "+l);
				mv1.addObject("pro",l);
				 
		return mv1;
		
	}
	
	@RequestMapping("/selectcat")
	public ModelAndView ca(@RequestParam("id") int id) {
	List<Product> p=(List<Product>)productdao.getprbycatid(id);

		ModelAndView mv1 = new ModelAndView("listpro");
		List<Category> cat=(List<Category>)categorydao.getallcategory();
		mv1.addObject("cat",cat);
		mv1.addObject("pro",p);
		return mv1;
		
	}

	@RequestMapping("/user/selectcat")
	public ModelAndView caUser(@RequestParam("id") int id) {

		ModelAndView mv1 = new ModelAndView("redirect:/selectcat");
		mv1.addObject("id",id);
		return mv1;
		
	}
		
	
	@RequestMapping("/deleteproduct")
	  public ModelAndView delpro(@RequestParam("id") int id){
	   List<Product> pro=(List<Product>)productdao.getAllProduct();
	   ModelAndView mv= new ModelAndView("redirect:/admin");
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
	
		ModelAndView mv1 = new ModelAndView("redirect:/admin");
		
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
	
		ModelAndView mv1 = new ModelAndView("redirect:/admin");
		
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
	
		ModelAndView mv1 = new ModelAndView("redirect:/admin");
		
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
		ModelAndView mv1 = new ModelAndView("redirect:/admin");
		 List<Category> l=(List<Category>)categorydao.getallcategory();
		
	    System.out.println("Category List : "+l);
				mv1.addObject("cat",l);
				
		List<Supplier> ll=(List<Supplier>)supplierdao.getAllSupplier();
		 System.out.println("Supplier List : "+l);
	      mv1.addObject("supp",ll);
	     
		Product p=productdao.getProductById(id);
		Category cc=new Category();
		cc=categorydao.getcatbyid(cid);
		p.setCategory(cc);
		
		Supplier su=new Supplier();
		su=supplierdao.getSupplierById(sid);
		p.setSupplier(su);
		
		p.setId(sid);
		p.setId(cid);
		p.setId(id);
		p.setName(name);
		
		p.setPrice(price);
		
		p.setStock(stock);
		
		productdao.saveupdateProduct(p);
		
		
		
				
		
		return mv1;
	
	}
	@RequestMapping("/user/ship")
	public ModelAndView buy(){
	
		ModelAndView mv1 = new ModelAndView("ship");
		 ArrayList<Category> l=(ArrayList<Category>)categorydao.getallcategory();
			mv1.addObject("cat",l);
		return mv1;
	}
	@RequestMapping("/user/bill")
	public ModelAndView bill(@RequestParam("first") String first, @RequestParam("last") String last, @RequestParam("address") String address, @RequestParam("state") String state, @RequestParam("city") String city, @RequestParam("mob") String mob, @RequestParam("pin") String pin)
	{
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		String ship=first+","+last+","+address+","+state+","+city+","+mob+","+pin;
		order o = new order();
		o.setShip(ship);
		o.setBill(ship);
		o.setUsername(name);
		orderDao.saveOrder(o);
		ModelAndView mv1 = new ModelAndView("bill");
		order p= new order();
		p=orderDao.getorbyusername(name);
		mv1.addObject("ord",p.getBill());
        List<Category> l=(List<Category>)categorydao.getallcategory();
		mv1.addObject("cat",l);
		return mv1;
	}
	
	@RequestMapping("/user/order")
	public ModelAndView order(@RequestParam("first") String first, @RequestParam("last") String last, @RequestParam("address") String address, @RequestParam("state") String state, @RequestParam("city") String city, @RequestParam("mob") String mob, @RequestParam("pin") String pin){
		ModelAndView mv1 = new ModelAndView("order");
		String Username=SecurityContextHolder.getContext().getAuthentication().getName();
		String bill=first+","+last+","+address+","+state+","+city+","+mob+","+pin;
		order b=orderDao.getorbyusername(Username);
		b.setBill(bill);
		orderDao.updateOrder(b);
		order o=new order();
		o=orderDao.getorbyusername(Username);
		mv1.addObject("bill",o.getBill());
		mv1.addObject("ship",o.getShip());
		ArrayList<Cart> ll=(ArrayList<Cart>)cartDao.getcartbyusernmae(Username);
		
		
		mv1.addObject("ca",ll);
		int total=0;
		for(Cart cart:ll)
		{
		int sum=cart.getPid().getPrice()*cart.getQuantity();
		total=total+sum;	
		}
		
		mv1.addObject("t",total);

List<Category> l=(List<Category>)categorydao.getallcategory();
		mv1.addObject("cat```````````````````````````````````````````````",l);
		return mv1;
}
	
	@RequestMapping("/user/payment")
	public ModelAndView payment(){
		ModelAndView mv1 = new ModelAndView("payment");
		String Username=SecurityContextHolder.getContext().getAuthentication().getName();
        ArrayList<Cart> ll=(ArrayList<Cart>)cartDao.getcartbyusernmae(Username);
	    for(Cart c: ll)
	    {
	    	cartDao.deletecart(c.getId());
	    }
        List<Category> l=(List<Category>)categorydao.getallcategory();
		mv1.addObject("cat",l);
		return mv1;
	}
	
	@RequestMapping("/user/thank")
	public ModelAndView thank(){
		ModelAndView mv1 = new ModelAndView("thank");
List<Category> l=(List<Category>)categorydao.getallcategory();
		mv1.addObject("cat",l);
		return mv1;
	}
	
	/*error invalid username*/
	@RequestMapping("/invalid")
	public ModelAndView error()
	{
		ModelAndView mv = new ModelAndView("authentication");
		ArrayList<Category> cc=(ArrayList<Category>)categorydao.getallcategory();
		mv.addObject("cat",cc);
		return mv;
		
	}
	/*error access denied*/
	@RequestMapping("/authFa")
	public ModelAndView err()
	{
		ModelAndView mv = new ModelAndView("invalid");
		ArrayList<Category> cc=(ArrayList<Category>)categorydao.getallcategory();
		mv.addObject("cat",cc);
		return mv;
		
	}
	
	/*single product*/
	@RequestMapping("/product")
	public ModelAndView product(@RequestParam("id") int id){
		Product p=new Product();
		p=productdao.getProductById(id);
		ModelAndView mv = new ModelAndView("product");
		mv.addObject("pr",p);
		
		return mv;
		
	}
	
}	
	
	
	
	
	
	
	
