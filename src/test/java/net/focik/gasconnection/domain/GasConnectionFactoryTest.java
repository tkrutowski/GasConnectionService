package net.focik.gasconnection.domain;

import net.focik.gasconnection.domain.dto.GasConnectionTaskCalendarDto;
import net.focik.gasconnection.domain.port.IScopeGasConnectionRepository;
import net.focik.gasconnection.domain.share.DtoType;
import net.focik.gasconnection.infrastructure.clients.ScopeGasConnectionClient;
import net.focik.gasconnection.infrastructure.dto.GasConnectionDbDto;
import net.focik.gasconnection.infrastructure.dto.ScopeGasConnectionDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
class GasConnectionFactoryTest {


//    @Autowired
//    ModelMapper mapper;
//
//    @Qualifier("inMemeoryScopeGasConnectionRepository")
//    @Autowired
//    IScopeGasConnectionRepository scopeGasConnectionRepository;
@Autowired
    GasConnectionFactory factory;// = new GasConnectionFactory(mapper, scopeGasConnectionRepository);

    @Test
    void createGasConnectionByDtoType() {
        //given
        final DtoType dtoType = DtoType.TASK_CALENDAR;
        final GasConnectionDbDto dbDto = createDto();

        //when
        GasConnectionTaskCalendarDto taskCalendarDto = (GasConnectionTaskCalendarDto) factory.createGasConnectionByDtoType(dbDto, dtoType);

        //then
        assertEquals(1, taskCalendarDto.getIdTask());
        assertEquals(2, taskCalendarDto.getIdCustomer());
        assertEquals(3, taskCalendarDto.getIdSurveyor());
        assertEquals(4, taskCalendarDto.getIdAddress());
        assertEquals("task3", taskCalendarDto.getTaskNo());
        assertEquals(true, taskCalendarDto.getIsPgn());
        assertEquals("Klient", taskCalendarDto.getGasCabinetProvider());
    }

    private GasConnectionDbDto createDto() {
        return new GasConnectionDbDto(1,2,3, "task3",true,4);
    }
}