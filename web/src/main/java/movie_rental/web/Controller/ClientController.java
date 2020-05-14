package movie_rental.web.Controller;

import movie_rental.core.Model.Client;
import movie_rental.core.Service.ClientService;
import movie_rental.web.Converter.ClientConverter;
import movie_rental.web.Dto.ClientDto;
import movie_rental.web.Dto.ClientsDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClientController {
    public static final Logger log = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientConverter clientConverter;

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public List<ClientDto> getClients() {
        log.trace("getClients - method entered");
        List<Client> clients = clientService.getAllClients(1);
        log.trace("getClients - clientsDto = {}", clients);
        log.trace("getClients - method finished");
        return new ArrayList<>(clientConverter.convertModelsToDtos(clients));
    }

    @RequestMapping(value = "/clients", method = RequestMethod.POST)
    ClientDto saveClient(@RequestBody ClientDto clientDto) {
        log.trace("saveClient - method entered");
        ClientDto result = clientConverter.convertModelToDto(clientService.saveClient(
                clientConverter.convertDtoToModel(clientDto)));
        log.trace("saveClient - result = {}", result);
        log.trace("saveClient - method finished");
        return result;
    }

    @RequestMapping(value = "/clients/{id}", method = RequestMethod.PUT)
    public ClientDto updateClient(@PathVariable Long id,
                           @RequestBody ClientDto clientDto) {
        log.trace("updateClient - method entered: id = {}, clientDto = {}", id, clientDto);
        ClientDto result = clientConverter.convertModelToDto(clientService.updateClient(id,
                clientConverter.convertDtoToModel(clientDto)));
        log.trace("updateClient - update = {}", result);
        log.trace("updateClient - method finished");
        return result;
    }

    @RequestMapping(value = "/clients/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteClient(@PathVariable Long id) {
        log.trace("deleteClient - method entered");
        clientService.deleteClient(id);
        log.trace("client deleted - clientID = {}", id);
        log.trace("deleteClient - method finished");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
