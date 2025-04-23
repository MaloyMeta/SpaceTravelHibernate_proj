package entity.ticket;


public class TicketCRUDService {
    private TicketDAO ticketDao = new TicketDAO();

    public void create(Ticket ticket){
        if(ticket != null){
            ticketDao.create(ticket);
        }
    }

    public Ticket read(Long id){
        return ticketDao.read(id);
    }

    public void update(Ticket ticket){
        if(ticket != null){
            ticketDao.update(ticket);
        }
    }

    public void delete(Long id){
        ticketDao.delete(id);
    }
}
