package se.systementor.supershoppen1.shop.model;

import org.springframework.data.repository.CrudRepository;

public interface SubscriberRepository extends CrudRepository<Subscriber, Integer> {
    public Subscriber findByEmail(String email);
}
