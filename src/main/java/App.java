import Entity.Client.Client;
import Entity.Client.ClientCRUDService;
import Entity.Planet.Planet;
import Entity.Planet.PlanetCRUDService;
import Entity.Ticket.Ticket;
import Entity.Ticket.TicketCRUDService;

import java.time.Instant;

public class App {
    public static void main(String[] args) {
       ClientCRUDService clientService = new ClientCRUDService();
       PlanetCRUDService planetService = new PlanetCRUDService();
       TicketCRUDService ticketService = new TicketCRUDService();

        Client client = new Client();
        client.setName("Max");
        clientService.create(client);
        System.out.println("Створено: " + clientService.read(client.getId()));

        Planet planet = new Planet();
        planet.setId("PLU");
        planet.setName("Pluto");
        planetService.create(planet);
        System.out.println("Створено: " + planetService.read("PLU"));

        client.setName("UpdatedClient");
        clientService.update(client);
        System.out.println("Оновлено: " + clientService.read(client.getId()));

        planetService.delete("PLU");
        System.out.println("Планету PLU видалено.");

        Planet from = planetService.read("MARS");
        Planet to = planetService.read("VEN");
        Client existingClient = clientService.read(1L);
        Ticket ticket = new Ticket();
        ticket.setClient(existingClient);
        ticket.setCreatedAt(Instant.now());
        ticket.setFromPlanet(from);
        ticket.setToPlanet(to);

        ticketService.create(ticket);
    }
}