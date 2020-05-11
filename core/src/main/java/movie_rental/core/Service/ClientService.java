package movie_rental.core.Service;

import movie_rental.core.Model.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAllClients(int opt);
    Client saveClient(Client client);
    void deleteClient(Long id);
    Client updateClient(Long id, Client client);

    List<Client> filterClientsByID(long op1);

    List<Client> filterClientsByName(String key);

    List<Client> filterClientsByCnp(long op3);
}
