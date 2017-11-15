package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Client;

public class ClientDAOImpl implements ClientDAO{
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public ClientDAOImpl() {
		getConnection();
	}
	
	
	public Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb","alo","12345");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	

	@Override
	public void createClient(Client client) {
		if(connection!=null) {
			try {
				preparedStatement= connection.prepareStatement("INSERT INTO clients (address, phone, cellphone, email)"+" values(?,?,?,?);");
				
				preparedStatement.setString(1,client.getAddress());
				preparedStatement.setInt(2,client.getPhone());
				preparedStatement.setInt(3,client.getCellphone());
				preparedStatement.setString(4,client.getEmail());
			
				preparedStatement.execute();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	public Client readClient(Long id) {
		Client client =null;
		if(connection!= null) {
			try {
				preparedStatement= connection.prepareStatement("SELECT * FROM clients WHERE id=?;");
				preparedStatement.setLong(1, id);
				resultSet= preparedStatement.executeQuery();
				
				if(resultSet.next()) {
					client = new Client(
					resultSet.getLong(1),
					resultSet.getString(2),
					resultSet.getInt(3),
					resultSet.getInt(4),
					resultSet.getString(5)
							);
				}
				}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return client;
		
	}

	@Override
	public List<Client> readAllClients() {
		List<Client> clients =new ArrayList<Client>();
		if(connection!= null) {
			try {
				preparedStatement= connection.prepareStatement("SELECT * FROM clients");
				resultSet= preparedStatement.executeQuery();
				
			while(resultSet.next()) {
			Client client= new Client(
					resultSet.getLong(1),
					resultSet.getString(2),
					resultSet.getInt(3),
					resultSet.getInt(4),
					resultSet.getString(5)
							);
			clients.add(client);
			}
				}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return clients;
	}

	@Override
	public void updateClient(Client client) {
		if(connection!=null) {
			try {
				preparedStatement= connection.prepareStatement("UPDATE clients SET address=?, phone=?, cellphone=?, email=?  WHERE id=?;");
				
				preparedStatement.setString(1,client.getAddress());
				preparedStatement.setInt(2,client.getPhone());
				preparedStatement.setInt(3,client.getCellphone());
				preparedStatement.setString(4,client.getEmail());
				preparedStatement.setLong(5,client.getId());
				preparedStatement.execute();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	public void deleteClient(Long id) {
		if(connection!=null) {
			try {
				preparedStatement= connection.prepareStatement("DELETE FROM clients WHERE id=?;");
				
				preparedStatement.setLong(1, id);
				preparedStatement.execute();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}


}