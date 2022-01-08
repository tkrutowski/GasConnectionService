package net.focik.gasconnection.domain.port.primary;

import net.focik.gasconnection.api.dto.IGasConnectionDto;
import net.focik.gasconnection.domain.share.DtoType;

public interface GetGasConnectionDtoUseCase {
    IGasConnectionDto getGasConnectionById(int id, DtoType dtoType);
}
