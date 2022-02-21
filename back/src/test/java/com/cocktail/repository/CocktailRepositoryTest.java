package com.cocktail.repository;

import com.cocktail.domain.Cocktail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CocktailRepositoryTest {

	@Autowired
	CocktailRepository cocktailRepository;

	@Test
	public void Id로_조회() throws Exception {
		// given
		Long id = 19L;

		// when
		Cocktail cocktail = cocktailRepository.findById(id).get();

		// then
		System.out.println("cocktail = " + cocktail);

	}

	@Transactional
	@Test
	public void 저장() throws Exception {
		Cocktail cocktail = Cocktail.builder().name("cocktailA").build();

		Long savedId = cocktailRepository.save(cocktail).getId();

		Cocktail resultedCocktail = cocktailRepository.findById(savedId).get();

		org.junit.jupiter.api.Assertions.assertNotNull(resultedCocktail);
		assertThat(cocktail.getName()).isEqualTo(resultedCocktail.getName());
	}

	@Test
	public void 이름으로조회() throws Exception {
		// given

		// when
		Page<Cocktail> jack = cocktailRepository.findByNameContaining("Jack", Pageable.unpaged());

		// then
		Assert.assertFalse(jack.isEmpty());
		assertThat("Jack Coke").isEqualTo(jack.stream().findFirst().get().getName());
	}

	@Test
	public void findByIngredientId() throws Exception {
		// given
		Long ingredientId = 4L;

		// when
		List<Cocktail> cocktails = cocktailRepository.findContainingIngredientId(ingredientId);

		// then
		// System.out.println("cocktails = " + cocktails);
		assertThat(cocktails.size()).isEqualTo(1);
	}

}