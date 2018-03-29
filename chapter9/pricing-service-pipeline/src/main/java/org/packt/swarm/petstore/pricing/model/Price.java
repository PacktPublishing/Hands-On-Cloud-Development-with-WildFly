package org.packt.swarm.petstore.pricing.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "Price")
@NamedQueries({
        @NamedQuery(name="Price.findByItemId",
                query="SELECT p FROM Price p WHERE p.itemId = :itemId"),
})
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "price_sequence")
    @SequenceGenerator(name = "price_sequence", sequenceName = "price_id_seq")
    @JsonIgnore
    private int id;

    @Column(name="item_id")
    private String itemId;

    @Column
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
