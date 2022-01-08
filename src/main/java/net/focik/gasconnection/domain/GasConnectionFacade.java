package net.focik.gasconnection.domain;

import lombok.AllArgsConstructor;
import net.focik.gasconnection.infrastructure.dto.GasConnectionDbDto;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GasConnectionFacade {

    private GasConnectionFactory gasConnectionFactory;

    public Integer addGasConnection(GasConnectionDbDto customerDbDto) {
         return null;// gasConnectionRepository.add(customerDbDto);
    }


    public GasConnection getGasConnectionById(Integer id) {
        int i=0;

        return gasConnectionFactory.createGasConnectionById(id);

    }
}
