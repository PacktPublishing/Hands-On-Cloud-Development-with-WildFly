package org.packt.swarm.petstore.catalog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "item")
@NamedQueries({
        @NamedQuery(name="Item.findById",
                query="SELECT i FROM Item i WHERE i.itemId = :itemId"),
})
public class Item {

    //4
    @Id
    @JsonIgnore
    private int id;

    //5
    @Column(length = 30)
    private String itemId;

    //6
    @Column(length = 30)
    private String name;
    @Column
    private int quantity;

    @Column
    private String description;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
