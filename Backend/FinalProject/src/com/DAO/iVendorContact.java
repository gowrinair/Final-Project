package com.DAO;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.Model.VendorContactBean;

public interface iVendorContact {

	void setTemplate(JdbcTemplate template);

	//View all vendors and their contacts
	List<VendorContactBean> getVendorDetails();

	//search details
	List<VendorContactBean> Search(String search);

	int update(VendorContactBean vbc);

	// disable medicine
	int disable(VendorContactBean vcb);

	int insertVendor(VendorContactBean vc);

	// Login
	VendorContactBean login(String username, String password);

	List<VendorContactBean> vendorListId(int vendorid);

}