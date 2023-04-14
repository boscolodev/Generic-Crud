package br.com.gbs.financal;

import br.com.gbs.financal.model.dto.TipoRequestDTO;
import br.com.gbs.financal.model.entities.Tipo;
import br.com.gbs.financal.repositories.TipoRepository;
import br.com.gbs.financal.services.TipoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Optional;


@SpringBootTest
class FinancalApplicationTests {

	@Mock
	TipoRepository repository;
	@InjectMocks
	TipoService service;


	Tipo tipo;
	TipoRequestDTO requestDTO;
	Long id = 1L;

	@BeforeEach
	public void setUp(){

		tipo = new Tipo("Teste");
		tipo.setId(1L);

		requestDTO = new TipoRequestDTO(1L, "Request DTO");
	}

	@Test
	void checkEntityIsDTO() throws Exception {

		Mockito.when(repository.findById(id)).thenReturn(Optional.of(tipo));
		Tipo result = service.findById(id);


		Assertions.assertNotNull(result);
		Assertions.assertInstanceOf(requestDTO.getClass(), result);

	}

}
