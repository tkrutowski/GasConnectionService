package net.focik.gasconnection.domain;

import lombok.AllArgsConstructor;
import net.focik.gasconnection.domain.dto.IGasConnectionDto;
import net.focik.gasconnection.domain.port.IGasConnectionRepository;
import net.focik.gasconnection.domain.share.DtoType;
import net.focik.gasconnection.infrastructure.dto.GasConnectionDbDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GasConnectionFacade {

    private IGasConnectionRepository gasConnectionRepository;
    private GasConnectionFactory gasConnectionFactory;

    public Integer addGasConnection(GasConnectionDbDto customerDbDto) {
         return gasConnectionRepository.add(customerDbDto);
    }


    public IGasConnectionDto getGasConnectionDto(Integer id, DtoType dtoType) {
        int i=0;
        Optional<GasConnectionDbDto> byId = gasConnectionRepository.findById(id);

        if(byId.isEmpty())
            return null;

        return gasConnectionFactory.createGasConnectionByDtoType(byId.get(), dtoType);

    }
}
