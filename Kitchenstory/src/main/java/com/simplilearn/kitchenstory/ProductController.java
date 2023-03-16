package com.simplilearn.kitchenstory;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
	
	@Autowired
	AdminDao ad_dao;
	@Autowired
	AdminRepo arepo;
	
	@Autowired
	UserDao u_dao;
	@Autowired
	UserRepo urepo;
	@Autowired
	ProductRepo prepo;
	@Autowired
	PoductDao Pdao;
	float Total=20000.0f;
	@ResponseBody
	@RequestMapping("/")
	public ModelAndView displaypage(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index.jsp");
		return mv;
	}
	@RequestMapping("/loginadmin")
	public ModelAndView adminlogin(HttpServletRequest req,HttpServletResponse res) {
		ModelAndView mv=new ModelAndView();
		String ad_email = req.getParameter("ad_email");
		String ad_password=req.getParameter("ad_password");
		Admin admin=arepo.findByadminpwd(ad_email, ad_password);
		if(admin!=null) {
			
			mv.setViewName("AdminMainIndex.jsp");
			
			}
		else {
			mv.setViewName("fail.jsp");
		}
		return mv;
	}
	@RequestMapping("/loginuser")
	public ModelAndView userlogin(HttpServletRequest req,HttpServletResponse res) {
		ModelAndView mv=new ModelAndView();
		String username = req.getParameter("username");
		String password=req.getParameter("password");
		User u=urepo.findByuserpwd(username, password);
		if(u!=null) {
			List<Product> list=Pdao.getall();
			mv.setViewName("UserMain.jsp");
			mv.addObject("list", list);
			
		}
		else {
			mv.setViewName("fail.jsp");
		}
		return mv;
	}

	@ResponseBody
	@RequestMapping("/registeruser")
	public ModelAndView registermslogin(HttpServletRequest req,HttpServletResponse res) {
		ModelAndView mv=new ModelAndView();
		User u=new User();
		u.setUsername(req.getParameter("username"));
		u.setEmail(req.getParameter("useremail"));
		u.setPassword(req.getParameter("userpwd"));
		User uu=u_dao.insert(u);			
		if(uu!=null) {
			
		mv.setViewName("User_succ_reg.jsp");
		}
		
		return mv;
	}
	@ResponseBody
	@RequestMapping("/registeradmin")
	public ModelAndView registeradmin(HttpServletRequest req,HttpServletResponse res) {
		ModelAndView mv=new ModelAndView();
		Admin a=new Admin();
		
		a.setAd_email(req.getParameter("ad_email"));
		a.setAd_password(req.getParameter("ad_pwd"));
		Admin ad=ad_dao.insert(a);			
		if(ad!=null) {
		mv.setViewName("Admin_succ_reg.jsp");
		}
		
		return mv;
	}
		
	@RequestMapping("/insertproduct")
	public ModelAndView insertControl(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		Product s=new Product();
		s.setId(Integer.parseInt(request.getParameter("pid")));
		s.setName(request.getParameter("pname"));
		s.setCategory(request.getParameter("pcategory"));
		s.setDescription(request.getParameter("pdescription"));
		s.setPrice(Float.parseFloat(request.getParameter("pprice")));
		
		Product ep=Pdao.insert(s);
		List<Product> list=Pdao.getall();
		if(ep!=null) {
			System.out.println("insertion is successful!\n");
			mv.setViewName("display.jsp");
			mv.addObject("list",list);
		}
		return mv;
	} 
	@RequestMapping("/deleteproduct")
	public ModelAndView deleteControl(HttpServletRequest request,HttpServletResponse response,@RequestParam("deleteid") Integer id) {
		ModelAndView mv=new ModelAndView();
        Product p=new Product();
		Pdao.deletebyId(id);
		List<Product> list=Pdao.getall();
		if(list!=null) {
			System.out.println("deleteion is successful!\n");
			mv.setViewName("display.jsp");
			mv.addObject("list",list);
		}
		else {
			System.out.println("Check the Product id..Deletion unsuccessful!\n");
		}
			
		
		
		return mv;
	} 

	@RequestMapping("/getallproducts")
	public ModelAndView displayAll(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
	List<Product> list=Pdao.getall();
	mv.setViewName("display.jsp");
	mv.addObject("list",list);	
		return mv;
	}

	@RequestMapping("/updateproduct")
	public ModelAndView updateAll(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
	List<Product> list=Pdao.getall();
	mv.setViewName("display.jsp");
	mv.addObject("list",list);	
		return mv;
	}
	@RequestMapping("/editproduct")
	public ModelAndView edit(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		Product s=new Product();
		s.setId(Integer.parseInt(request.getParameter("pid")));
		s.setName(request.getParameter("pname"));
		s.setCategory(request.getParameter("pcategory"));
		s.setDescription(request.getParameter("pdescription"));
		s.setPrice(Float.parseFloat(request.getParameter("pprice")));
		Product p=new Product();
		if(p!=null) {
			System.out.println("Edit is successful!\n");
			mv.setViewName("prodcut_updated.jsp");
			
		}
		return mv;
	}
	@RequestMapping("/buynow")
	public ModelAndView buynow(HttpServletRequest request,HttpServletResponse response,@RequestParam("pid") Integer id, @RequestParam("price") Float price) {
		

		ModelAndView mv=new ModelAndView();
		
		float  remain;
		
		
		remain=Total-price;
		if(remain>0)
		{
			System.out.println("Product Bought!\n");
			Pdao.deletebyId(id);
			List<Product> list=Pdao.getall();
			mv.setViewName("BuySuccess.jsp");
			mv.addObject("list",list);
		}
		else {
			System.out.println("Low Balance...");
			List<Product> list=Pdao.getall();
			mv.setViewName("UserMain.jsp");
			mv.addObject("list",list);
		
		}
		return mv;
	}
	@RequestMapping("/Payment")
	public ModelAndView Payment(HttpServletRequest request,HttpServletResponse response,@RequestParam("pid") Integer id,@RequestParam("price") Float price) {
		

		ModelAndView mv=new ModelAndView();
		Product s=new Product();
		float Total=20000.0f;
		float  remain;
		remain=Total-price;
		if(remain>price)
		{
			System.out.println("Product Bought!\n");
			Pdao.deletebyId(id);
			List<Product> list=Pdao.getall();
			mv.setViewName("UserMain.jsp");
			mv.addObject("list",list);
		}
		
		
		
		return mv;
	}
	}


