package utng.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utng.dom.OrderDOM;
import utng.model.Order;

/**
 * Servlet implementation class OrderController
 */
@WebServlet("/OrderController")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Order order; 
	private List<Order> orders;
	private OrderDOM orderDOM;
	private List<String> ids= new ArrayList<String>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderController() {
        super();
        order= new Order();
        orders = new ArrayList<Order>();
        orderDOM = new OrderDOM();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btn_save")!=null) {
    		try {
		     	order.setCustomerId(Integer.parseInt(request.getParameter("customerId")));
		}catch (NumberFormatException e) {
			order.setCustomerId(000);
		}
		
			order.setShipName(request.getParameter("shipName"));
    		order.setShipAddress(request.getParameter("shipAddress"));

    		if(order.getId()=="") {
    			String newId="std"+String.format("%05d",1);
    			order.setId(newId);
    			if(orders.size()>0) {
    				ids.clear();
    				for(Order s : orders ) {
    					ids.add(s.getId());
    				}
    				for(int i=0; i<=ids.size();i++) {
    				newId="std"+String.format("%05d",i+1);
    				if(!ids.contains(newId)) {
    					order.setId(newId);
    					break;
    				}
    			
    			}
    		}
    			
    			orderDOM.add(order);
    			
    		}else {
    			orderDOM.update(order);
    			
    		}
    			orders = orderDOM.getOrders();
    			request.setAttribute("orders", orders);
    			request.getRequestDispatcher("order_list.jsp").forward(request, response);
    	}else if(request.getParameter("btn_new")!=null) {
    		order = new Order();
    		request.getRequestDispatcher("order_form.jsp").forward(request, response);
       	}else if(request.getParameter("btn_edit")!=null) {
       		try {
       			String id= request.getParameter("id");
       			order = orderDOM.findById(id);
       		}catch(IndexOutOfBoundsException e) {
       			order = new Order();
       		}
       		request.setAttribute("order",order);
       		request.getRequestDispatcher("order_form.jsp").forward(request, response);
      	}else if(request.getParameter("btn_delete")!=null) {
      		try {
      			String id= request.getParameter("id");
      			orderDOM.delete(id);
      			orders= orderDOM.getOrders();
      		}catch(Exception e){
      			e.printStackTrace();
      	}
      		request.setAttribute("orders", orders);
      		request.getRequestDispatcher("order_list.jsp").forward(request, response);
      	}else {
      		orders = orderDOM.getOrders();
      		request.setAttribute("orders", orders);
      		request.getRequestDispatcher("order_list.jsp").forward(request, response);
      	}
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
