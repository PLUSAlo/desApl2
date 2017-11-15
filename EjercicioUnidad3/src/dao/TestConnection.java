



package dao;

import java.util.List;

import model.Client;

public class TestConnection {
	public static void main(String[] args) {
		ClientDAOImpl clientDAOImpl = new ClientDAOImpl();
		clientDAOImpl.createClient(new Client(1L, "Manzano", 41819273,41819273, "alo@gmail.com"));
		
		//clientDAOImpl.deleteClient(4L);
		
		
		//clientDAOImpl.updateClient(new Client(2L, "Manzano", 41819273,41819273, "alo@gmail.com"));
		List<Client> clients =clientDAOImpl.readAllClients();
		for(Client client: clients) {
			System.out.println(client);
		}
	}
}
