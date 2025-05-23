package entity.client;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "client")
public class Client{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 200)
    private String name;
}