package ro.sd.a2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.a2.controller.FirstController;
import ro.sd.a2.dto.ClientCreationDTO;
import ro.sd.a2.dto.ClientDTO;
import ro.sd.a2.dto.ClientTableRowDTO;
import ro.sd.a2.builder.ClientBuilder;
import ro.sd.a2.entity.Client;
import ro.sd.a2.repository.ClientRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@Service
public class ClientService {

    private static final Logger log = LoggerFactory.getLogger(FirstController.class);

    private final ClientRepository clientRepository;

    private final ClientBuilder clientBuilder;

    @Autowired
    public ClientService(ClientRepository clientRepository, ClientBuilder clientMapper) {
        this.clientRepository = clientRepository;
        this.clientBuilder = clientMapper;
    }

    /**
     * Method for getting all client information from the db
     * @return client information to be displayed in the frontend table.
     */
    public List<ClientTableRowDTO> findAll(){
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(clientBuilder::toClientTableRowDTO)
                .collect(Collectors.toList());
    }

    /**
     * Method to get a list of all clients from the db
     * @return a list with all the clients from our database.
     */
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    /**
     * Method to update a client from the db
     * @param id keeps the auto-generated id that is assigned to each client individually. With it we determine which client we choose to update.
     * @param client object containing the client information
     */
    public void update(String id, Client client){
        clientRepository.save(client);
    }

    /**
     * Method to delete a client by its id from the db
     * @param id keeps the auto-generated id that is assigned to each client individually. With it we determine which client we choose to delete.
     */
    public void delete(String id){
        clientRepository.deleteById(id);
    }

    /**
     * Method to get a client by his id.
     * @param id keeps the auto-generated id that is assigned to each client individually. With it we determine which client we choose.
     * @return the client with the specified id
     */
    public Optional<Client> get(String id){
        return clientRepository.findById(id);
    }

    /**
     * Method to insert a new client in the db using DTOs, useful for communicating with the frontend
     * @param clientDTO object containing client information from frontend form input fields
     */
    public void insertClient(ClientCreationDTO clientDTO){
        clientRepository.save(clientBuilder.toClientEntity(clientDTO));
    }
}

