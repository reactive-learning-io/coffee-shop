package io.learning.coffeeshop.service;

import java.util.Objects;
import java.util.function.BiFunction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.learning.coffeeshop.domain.Coffee;
import io.learning.coffeeshop.exception.EntityNotFoundException;
import io.learning.coffeeshop.repository.CoffeeRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CoffeeService {

	@Autowired
	private CoffeeRepository coffeeRepository;

	@Transactional
	public Mono<Coffee> save(final Coffee coffee) {
		return this.coffeeRepository.save(coffee);
	}

	@Transactional
	public Mono<Coffee> update(final Coffee coffee) {
		return this.coffeeRepository
				.findByName(coffee.getName())
				.map(oldCoffee -> this.updates().apply(oldCoffee, coffee))
				.flatMap(this.coffeeRepository::save)
				.switchIfEmpty(Mono.error(new EntityNotFoundException(String.format("Coffee '%s' doesn't exists in store.", coffee.getName()))));
	}

	public Mono<Void> delete(final String name) {
		return this.coffeeRepository.deleteByName(name);
	}

	public Flux<Coffee> listAll() {
		return this.coffeeRepository.findAll();
	}

	private BiFunction<Coffee, Coffee, Coffee> updates() {
		return (oldCoffee, newCoffee) -> {
			if (Objects.nonNull(newCoffee.getPrice())) {
				oldCoffee.setPrice(newCoffee.getPrice());
			}
			if (Objects.nonNull(newCoffee.getServingType())) {
				oldCoffee.setServingType(newCoffee.getServingType());
			}
			return oldCoffee;
		};
	}

}
