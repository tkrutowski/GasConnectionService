package net.focik.gasconnection.domain;

import lombok.AllArgsConstructor;
import net.focik.gasconnection.domain.dto.GasConnectionTaskCalendarDto;
import net.focik.gasconnection.domain.dto.IGasConnectionDto;
import net.focik.gasconnection.domain.port.IScopeGasConnectionRepository;
import net.focik.gasconnection.domain.share.DtoType;
import net.focik.gasconnection.infrastructure.dto.GasConnectionDbDto;
import net.focik.gasconnection.infrastructure.dto.ScopeGasConnectionDto;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
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
        List<ScopeGasConnectionDto> scopeGasConnectionList = scopeGasConnectionRepository.findScopeGasConnectionByIdTask(dbDto.getIdTask());
        GasConnectionTaskCalendarDto map = mapper.map(dbDto, GasConnectionTaskCalendarDto.class);

        if(scopeGasConnectionList.size() == 1){
            map.setGasCabinetProvider(scopeGasConnectionList.get(0).getGasCabinetProvider());
        }

        return map;
    }

}
