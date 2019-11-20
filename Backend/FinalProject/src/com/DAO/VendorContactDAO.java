package com.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import com.Model.VendorContactBean;

public class VendorContactDAO implements iVendorContact {

	JdbcTemplate template;

	/* (non-Javadoc)
	 * @see com.DAO.iVendorContact#setTemplate(org.springframework.jdbc.core.JdbcTemplate)
	 */
	@Override
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	//View all vendors and their contacts
	/* (non-Javadoc)
	 * @see com.DAO.iVendorContact#getVendorDetails()
	 */
	@Override
	public List<VendorContactBean> getVendorDetails() {
	return template
				.query("select vendorid,vendorname,address,location,service,pincode,vstatus,contactid,contactname,department,email,phone  from tb_vendor join tb_contact using (vendorid) where vstatus='yes'  ",
	new RowMapper<VendorContactBean>() {

	@Override
	public VendorContactBean mapRow(ResultSet rs, int row)
	throws SQLException {

	VendorContactBean vc = new VendorContactBean();

	//getting and setting the objects
	vc.setVendorId(rs.getInt(1));
	vc.setVendorName(rs.getString(2));
	vc.setAddress(rs.getString(3));
	vc.setLocation(rs.getString(4));
	vc.setService(rs.getString(5));
	vc.setPincode(rs.getInt(6));
	vc.setvStatus(rs.getString(7));

	//contact details
	vc.setContactId(rs.getInt(8));
	vc.setContactName(rs.getString(9));
	vc.setDepartment(rs.getString(10));
	vc.setEmail(rs.getString(11));
	vc.setPhone(rs.getString(12));

	return vc;
	}
	});

	}

	
	//search details
		/* (non-Javadoc)
		 * @see com.DAO.iVendorContact#Search(java.lang.String)
		 */
		@Override
		public List<VendorContactBean> Search(String search) {
			return template.query("select tb_vendor.vendorid,vendorname,address,location,service,pincode,contactname,tb_contact.vendorid,department,email,phone from tb_vendor join tb_contact on (tb_vendor.vendorid=tb_contact.vendorid) where vendorname like'"
							+ search + "%' or location like'" + search + "%' or service like'" +search+"%'",
							new RowMapper<VendorContactBean>() {

								public VendorContactBean mapRow(ResultSet rs, int row)
										throws SQLException {
									VendorContactBean vend = new VendorContactBean();
									vend.setVendorId(rs.getInt(1));
									vend.setVendorName(rs.getString(2));
									vend.setAddress(rs.getString(3));
									vend.setLocation(rs.getString(4));
									vend.setService(rs.getString(5));
									vend.setPincode(rs.getInt(6));
									vend.setContactName(rs.getString(7));
									vend.setVendorId(rs.getInt(8));
									vend.setDepartment(rs.getString(9));
									vend.setEmail(rs.getString(10));
									vend.setPhone(rs.getString(11));

									return vend;
								}

							});
		}
		
		
		
		
		
		
		
	
	
		/* (non-Javadoc)
		 * @see com.DAO.iVendorContact#update(com.Model.VendorContactBean)
		 */
		@Override
		public int update(VendorContactBean vbc)
		{
			String sql="update tb_vendor set vendorname=?,address=?,location=?,service=?,pincode=?,vstatus=? where vendorid=?";
			template.update(sql,new Object[] {vbc.getVendorName(),vbc.getAddress(),vbc.getLocation(),vbc.getService(),vbc.getPincode(),vbc.getvStatus(),vbc.getVendorId()});
			String sql1="update tb_contact set contactname=?,department=?,email=?,phone=? where vendorid=?";
			return template.update(sql1, new Object[] {vbc.getContactName(),vbc.getDepartment(),vbc.getEmail(),vbc.getPhone(),vbc.getVendorId()});
		}
		// disable medicine
		/* (non-Javadoc)
		 * @see com.DAO.iVendorContact#disable(com.Model.VendorContactBean)
		 */
		@Override
		public int disable(VendorContactBean vcb) {
			String sql = "update tb_vendor set vstatus='no' where vendorid=? ";
			return template.update(sql, new Object[] { vcb.getVendorId() });

		}
		

	
		
		/* (non-Javadoc)
		 * @see com.DAO.iVendorContact#insertVendor(com.Model.VendorContactBean)
		 */
		@Override
		public int insertVendor(VendorContactBean vc) {

		String sql = "insert into tb_vendor(vendorname,address,location,service,pincode,vstatus) values(?,?,?,?,?,?)";

			template.update(sql, new Object[] { vc.getVendorName(),vc.getAddress(),vc.getLocation(),vc.getService(),vc.getPincode(),"yes"
			});

			// get maximum vendorId
			String sq2 = "select max(vendorid) from tb_vendor";
			int vendorId = template.queryForObject(sq2, Integer.class);

			// insert contact details
			String sql3 = "insert into tb_contact(contactname,vendorId,department,email,phone) values(?,?,?,?,?)";

			return template.update(sql3, new Object[] { vc.getContactName(),
			vendorId, vc.getDepartment(), vc.getEmail(), vc.getPhone() });

		}
		
		
		
		
		// Login
		/* (non-Javadoc)
		 * @see com.DAO.iVendorContact#login(java.lang.String, java.lang.String)
		 */
		@Override
		public VendorContactBean login(String username, String password) {

		String sql = "select userId from tb_login where username = ? and password = ?";
		
		VendorContactBean vbc= template.queryForObject(sql, new Object[] {username, password},new BeanPropertyRowMapper<VendorContactBean>(VendorContactBean.class));
		int userid=vbc.getUserId();
		return vbc;
		}

		
		
		/* (non-Javadoc)
		 * @see com.DAO.iVendorContact#vendorListId(int)
		 */
		@Override
		public List<VendorContactBean> vendorListId(int vendorid) {
			return template
			.query("select vendorid,vendorname,address,location,service,pincode,vstatus,contactid,contactname,department,email,phone from tb_vendor join tb_contact using (vendorid) where vendorid="+vendorid+"",
			new RowMapper<VendorContactBean>() {

			@Override
			public VendorContactBean mapRow(ResultSet rs, int row)throws SQLException {
			// TODO Auto-generated method stub

			VendorContactBean mod = new VendorContactBean();
			mod.setVendorId(rs.getInt(1));
			mod.setVendorName(rs.getString(2));
			mod.setAddress(rs.getString(3));
			mod.setLocation(rs.getString(4));
			mod.setService(rs.getString(5));
			mod.setPincode(rs.getInt(6));
			mod.setvStatus(rs.getString(7));
			mod.setContactId(rs.getInt(8));
			mod.setContactName(rs.getString(9));
			mod.setDepartment(rs.getString(10));
			mod.setEmail(rs.getString(11));
			mod.setPhone(rs.getString(12));
			return mod;
			}
			});

			}
	

}