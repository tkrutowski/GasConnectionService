package net.focik.gasconnection.application;

import lombok.AllArgsConstructor;
import net.focik.gasconnection.api.dto.IGasConnectionDto;
import net.focik.gasconnection.domain.GasConnection;
import net.focik.gasconnection.domain.GasConnectionFacade;
import net.focik.gasconnection.domain.port.primary.GetGasConnectionDtoUseCase;
import net.focik.gasconnection.domain.share.DtoType;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GetGasConnectionDtoService implements GetGasConnectionDtoUseCase {

    GasConnectionFacade gasConnectionFacade;

    @Override
    public IGasConnectionDto getGasConnectionById(int id, DtoType dtoType) {
        GasConnection gasConnectionById = gasConnectionFacade.getGasConnectionById(id);

        return ApiMapper.toDto(gasConnectionById, dtoType);
    }
}
