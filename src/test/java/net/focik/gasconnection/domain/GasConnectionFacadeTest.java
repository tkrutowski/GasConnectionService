package net.focik.gasconnection.domain;

import net.focik.gasconnection.domain.dto.GasConnectionTaskCalendarDto;
import net.focik.gasconnection.domain.dto.IGasConnectionDto;
import net.focik.gasconnection.domain.port.IGasConnectionRepository;
import net.focik.gasconnection.domain.share.DtoType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@ActiveProfiles("dev")
@SpringBootTest
class GasConnectionFacadeTest {


    @Autowired
    private IGasConnectionRepository gasConnectionRepository;

    @Autowired
    private GasConnectionFactory gasConnectionFactory;

    @Autowired
    GasConnectionFacade gasConnectionFacade;// = new GasConnectionFacade(gasConnectionRepository, gasConnectionFactory);

    @Test
    void addGasConnection() {
    }

    @Test
    void should_return_GasConnectionTaskCalendarDto_when_DtoType_TaskCalendar_given() {
        //given
        final DtoType dtoType = DtoType.TASK_CALENDAR;
        final Integer idTask=1;

        //when
        IGasConnectionDto gasConnectionDto = gasConnectionFacade.getGasConnectionDto(idTask, dtoType);

        //then
        assertTrue(gasConnectionDto.getClass() == GasConnectionTaskCalendarDto.class);

    }
}