package net.focik.gasconnection.domain;

import net.focik.gasconnection.api.dto.GasConnectionTaskCalendarDto;
import net.focik.gasconnection.domain.port.IGasConnectionRepository;
import net.focik.gasconnection.domain.share.DtoType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@SpringBootTest
class GasConnectionFacadeTest {

//    @Autowired
//    private GasConnectionFactory gasConnectionFactory;

    @Autowired
    GasConnectionFacade gasConnectionFacade;// = new GasConnectionFacade(gasConnectionRepository, gasConnectionFactory);

//    @Test
//    void addGasConnection() {
//    }

    @Test
    void should_return_GasConnection_when_id_1_given() {
        //given
        final Integer idTask=1;

        //when
        GasConnection result = gasConnectionFacade.getGasConnectionById(idTask);

        //then
        assertTrue(result.getClass() == GasConnection.class);

    }
}