package fr.limayrac.banque.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "compte")
@Data
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero", length = 50)
    private String numero;

    @Column(name = "montant", length = 50)
    private int montant;

    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;

    public Compte(){
        super();
    }
}
