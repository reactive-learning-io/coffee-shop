package io.learning.coffeeshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.learning.coffeeshop.domain.Coffee;
import io.learning.coffeeshop.service.CoffeeService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/coffees")
public class CoffeeRestController {

	@Autowired
	private CoffeeService coffeeService;

	@GetMapping(produces = MediaType.APPLICATION_NDJSON_VALUE)
	public Flux<Coffee> listCoffees() {
		return coffeeService.listAll();
	}

	@PostMapping
	public Mono<Coffee> save(@RequestBody Coffee coffee) {
		return coffeeService.save(coffee);
	}

	@PatchMapping("/{name}")
	public Mono<Coffee> update(@PathVariable("name") String name, @RequestBody Coffee coffee) {
		coffee.setName(name);
		return coffeeService.update(coffee);
	}

	@DeleteMapping("/{name}")
	public Mono<Void> update(@PathVariable("name") String name) {
		return coffeeService.delete(name);
	}

}
