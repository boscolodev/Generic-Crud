package br.com.gbs.financal;


import br.com.gbs.financal.services.ExampleServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Optional;


@SpringBootTest
class FinancalApplicationTests {

    @InjectMocks
    ExampleServiceImp service;

    @Mock
    ExampleServiceImp repository;

    private Long existId;
    private Long nonExistId;

    @BeforeEach
    void setUp(){
        existId = 1L;
        nonExistId = 100L;
    }

    @Test
    void shouldReturnEntityWhenIdExists(){
    }


}
