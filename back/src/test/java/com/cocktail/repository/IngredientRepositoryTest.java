package com.cocktail.repository;

import com.cocktail.domain.Ingredient;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class IngredientRepositoryTest {

	@Autowired
	IngredientRepository ingredientRepository;

	@Test
	public void 조회() throws Exception {
		// given
		Long id = 1L;

		// when
		Optional<Ingredient> ing = ingredientRepository.findById(id);

		// then
		Assertions.assertThat(ing.isPresent()).isTrue();
	}

}