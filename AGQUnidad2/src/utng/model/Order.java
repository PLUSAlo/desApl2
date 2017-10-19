package utng.model;

import java.io.Serializable;


public class Order implements Serializable {
	private String id;
	private int customerId;
	private String shipName;
	private String shipAddress;
	
	public Order() {
		this("",0, "","");
	}

	public Order(String id, int customerId, String shipName, String shipAddress) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.shipName = shipName;
		this.shipAddress = shipAddress;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public String getShipAddress() {
		return shipAddress;
	}

	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customerId=" + customerId + ", shipName=" + shipName + ", shipAddress="
				+ shipAddress + "]";
	}

	
	


}
