package se.systementor.supershoppen1.shop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Product {
    private String name;
    private int price;
    private int categoryId;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private int stockLevel;
    private String description;

    public Integer getId() {
        return id;
      }
    
      public void setId(Integer id) {
        this.id = id;
      }

      public void setName(String v)
      {
          name = v;
      }
  

      public String getName()
      {
          return name;
      }

    public void setPrice(int d) {
        price = d;
    }
    public int getPrice() {
        return price;
    }
  
    public void setCategory(int d) {
        categoryId = d;
    }
    public int getCategory() {
        return categoryId;
    }

    public void setStockLevel(int i) {
        //Added stock level
        stockLevel = i;
    }

    public int getStockLevel() {
        //Added stock level
        return stockLevel;
    }


    public void setDescription(String string) {
        description = string;
    }
    public String getDescription() {
        return description;
    }

    
}

