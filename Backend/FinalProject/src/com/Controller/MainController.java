package com.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.iVendorContact;
import com.Model.VendorContactBean;

@RestController
public class MainController {
	
	@Autowired
	iVendorContact dao;
	
	
	//view details of both vendor and contact
	@RequestMapping(value = "/viewList",headers="Accept=Application/json", method = RequestMethod.GET)
	public List viewVendorContactList() {

		List list = dao.getVendorDetails();
		return list;
	}
	
	
	
	// find details
		@RequestMapping(value = "/search/{search}", method = RequestMethod.GET, produces = "application/json")
		public List<VendorContactBean> find(@PathVariable("search") String search) {
			List list=dao.Search(search);
			return list;
		}
		
		
		
		// disable doctor
		@RequestMapping(value = "/disable", method = RequestMethod.PUT, produces = "application/json")
		public void disable(@RequestBody VendorContactBean vcb) {
			dao.disable(vcb);
		}
		
		//add and update vendor details
		@RequestMapping(value="/vendor/add",method={RequestMethod.POST,RequestMethod.PUT})
		public void insertVendor(@RequestBody VendorContactBean vbc)
		{
			System.out.println("insert");
			if(vbc.getVendorId()==0)
			{
				System.out.println("insert");
				dao.insertVendor(vbc);
			}
			else
			{
				System.out.println("update");
				dao.update(vbc);
			}
			
		}
		
		
		

		//Login
		@RequestMapping(value = "/api/login/{username}/{password}", method = RequestMethod.GET)
		public VendorContactBean getRole(@PathVariable("username") String username,@PathVariable("password") String password)
		{
		return dao.login(username, password);

		}

		//GET ALL VENDER DETAILS BY ID

		@RequestMapping(value = "/api/getVenderByid/{vendorid}", method = RequestMethod.GET , produces = "application/json")
		public VendorContactBean getVenderById(@ModelAttribute("mod") VendorContactBean mod,@PathVariable("vendorid") int vendorid)
		{
			System.out.println("get");
		List eachVenderList=dao.vendorListId(vendorid);
		mod=(VendorContactBean)eachVenderList.get(0);
		return  mod;
		}
	
		
		
	}

