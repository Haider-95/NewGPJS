package se.systementor.supershoppen1.shop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Subscriber {
    private String email;


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;


    public Integer getId() {
        return id;
      }
    
      public void setId(Integer id) {
        this.id = id;
      }

      public void setEmail(String v)
      {
          email = v;
      }
  

      public String getEmail()
      {
          return email;
      }

  
  
    
}

