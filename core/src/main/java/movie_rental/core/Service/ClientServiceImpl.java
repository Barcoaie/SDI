package movie_rental.core.Service;

import movie_rental.core.Model.Client;
import movie_rental.core.Repository.ClientRepository;
import movie_rental.core.Validators.ClientValidator;
import movie_rental.core.Validators.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {
    public static final Logger log = LoggerFactory.getLogger(ClientServiceImpl.class);

    private final Validator<Client> clientValidator = new ClientValidator();

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> filterClientsByID(long op1) {
        return this.clientRepository.findAll().stream().filter(client->client.getId().equals(op1)).collect(Collectors.toList());
    }

    @Override
    public List<Client> filterClientsByName(String key) {
        return this.clientRepository.findAll().stream().filter(client -> client.getName().contains(key)).collect(Collectors.toList());
    }

    @Override
    public List<Client> filterClientsByCnp(long op3) {
        return this.clientRepository.findAll().stream().filter(client -> Long.toString(client.getCnp()).contains(Long.toString(op3))).collect(Collectors.toList());
    }

    @Override
    public List<Client> getAllClients(int opt) {
        log.trace("getAllClients - method entered");
        List<Client> clientList = null;
        if (opt == 1)
            clientList = clientRepository.findAll(Sort.by(Sort.Direction.ASC,"name"));
        if (opt == -1)
            clientList = clientRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
        log.trace("getAllClients: result = {}", clientList);
        log.trace("getAllClients - method finished");
        return clientList;
    }

    @Override
    public Client saveClient(Client client) {
        log.trace("saveClient - method entered: client = {}", client);
        clientValidator.validate(client);
        Client result = clientRepository.save(client);
        log.trace("saveClient: result = {}", result);
        log.trace("saveClient - method finished");
        return result;
    }

    @Override
    @Transactional
    public void deleteClient(Long id) {
        log.trace("deleteClient - method entered: id = {}", id);
        log.debug("deleteClient - client deleted: client = {}", this.clientRepository.findById(id));
        clientRepository.deleteById(id);
        log.trace("deleteClient - method finished");
    }

    @Override
    @Transactional
    public Client updateClient(Long id, Client client) {
        log.trace("updateClient - method entered: client= {}", client);
        Client update = clientRepository.findById(id).orElse(client);
        update.setName(client.getName());
        log.debug("updateClient - updated: client = {}", update);
        log.trace("updateClient - method finished");
        return update;
    }
}
