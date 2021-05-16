package net.focik.gasconnection.domain;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import net.focik.gasconnection.domain.dto.GasConnectionTaskCalendarDto;
import net.focik.gasconnection.domain.dto.IGasConnectionDto;
import net.focik.gasconnection.domain.port.IScopeGasConnectionRepository;
import net.focik.gasconnection.domain.share.DtoType;
import net.focik.gasconnection.infrastructure.dto.GasConnectionDbDto;
import net.focik.gasconnection.infrastructure.dto.ScopeGasConnectionDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@Log
class GasConnectionFactory {

    private ModelMapper mapper;

    private IScopeGasConnectionRepository scopeGasConnectionRepository;

    IGasConnectionDto createGasConnectionByDtoType(GasConnectionDbDto dbDto, DtoType dtoType) {
        IGasConnectionDto gasConnectionDto = null;

        switch (dtoType) {
            case TASK_CALENDAR:
                gasConnectionDto = createGasConnectionTaskCalendarDto(dbDto);
                break;
            case GAS_CONNECTION:
                break;
        }


        return gasConnectionDto;
    }

    private GasConnectionTaskCalendarDto createGasConnectionTaskCalendarDto(GasConnectionDbDto dbDto) {
        GasConnectionTaskCalendarDto mappedDto = mapper.map(dbDto, GasConnectionTaskCalendarDto.class);

        List<ScopeGasConnectionDto> scopeGasConnectionList = scopeGasConnectionRepository.findScopeGasConnectionByIdTask(dbDto.getIdTask());

        if(scopeGasConnectionList.size() == 1){
            mappedDto.setGasCabinetProvider(scopeGasConnectionList.get(0).getGasCabinetProvider());
        }
        else
            mappedDto.setGasCabinetProvider("Brak danych.");

        return mappedDto;
    }

}
