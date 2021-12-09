package io.learning.coffeeshop.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import io.learning.coffeeshop.domain.Coffee;
import reactor.core.publisher.Mono;

@Repository
public interface CoffeeRepository extends ReactiveCrudRepository<Coffee, String> {

	Mono<Coffee> findByName(String name);

	Mono<Void> deleteByName(String name);

}
