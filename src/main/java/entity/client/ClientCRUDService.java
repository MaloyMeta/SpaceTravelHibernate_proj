package entity.client;



public class ClientCRUDService {
    private ClientDAO clientDao = new ClientDAO();

    public void create(Client client){
        if(client !=null){
            clientDao.create(client);
        }
    }

    public Client read(Long id){
       return clientDao.read(id);
    }

    public void update(Client client){
        clientDao.update(client);
    }

    public void delete(Long id){
        clientDao.delete(id);
    }

}
