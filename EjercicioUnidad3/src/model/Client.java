package model;

import java.io.Serializable;

public class Client implements Serializable {

	private Long id;
	private String address;
	private int phone;
	private int cellphone;
	private String email;
	
	
	public Client(Long id, String address, int phone, int cellphone, String email) {
		super();
		this.id = id;
		this.address = address;
		this.phone = phone;
		this.cellphone = cellphone;
		this.email = email;
	}
	
	
	public Client() {
		this(0L,"",0,0,"");
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getPhone() {
		return phone;
	}


	public void setPhone(int phone) {
		this.phone = phone;
	}


	public int getCellphone() {
		return cellphone;
	}


	public void setCellphone(int cellphone) {
		this.cellphone = cellphone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Client [id=" + id + ", address=" + address + ", phone=" + phone + ", cellphone=" + cellphone
				+ ", email=" + email + "]";
	}

	
	
}
