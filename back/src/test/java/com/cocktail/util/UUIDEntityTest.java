package com.cocktail.util;

import com.cocktail.common.exception.BusinessException;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UUIDEntityTest {

	@Resource
	UUIDGenerator generator;

	@Test
	@Transactional
	public void save() throws Exception {
		// given

		// when
		String uuid = generator.getUUID();

		// then
		Optional<UUIDEntity> byId = generator.uuidRepository.findById(uuid);
		Assertions.assertThat(byId).get();
	}

	@Test
	public void stacktrace() throws Exception {
		// given

		// when
		throw new BusinessException();
		// then

	}

}