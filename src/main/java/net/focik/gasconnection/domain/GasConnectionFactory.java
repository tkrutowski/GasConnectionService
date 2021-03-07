package net.focik.gasconnection.domain;

import lombok.AllArgsConstructor;
import net.focik.gasconnection.domain.dto.GasConnectionTaskCalendarDto;
import net.focik.gasconnection.domain.dto.IGasConnectionDto;
import net.focik.gasconnection.domain.share.DtoType;
import net.focik.gasconnection.infrastructure.dto.GasConnectionDbDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class GasConnectionFactory {

    private ModelMapper mapper;

    IGasConnectionDto createGasConnectionByDtoType(GasConnectionDbDto dbDto, DtoType dtoType){
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

        GasConnectionTaskCalendarDto map = mapper.map(dbDto, GasConnectionTaskCalendarDto.class);

        return map;
    }

}
