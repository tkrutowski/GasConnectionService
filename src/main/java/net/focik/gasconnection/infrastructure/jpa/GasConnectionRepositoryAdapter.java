package net.focik.gasconnection.infrastructure.jpa;

import lombok.AllArgsConstructor;
import net.focik.gasconnection.domain.GasConnection;
import net.focik.gasconnection.domain.port.IGasConnectionRepository;
import net.focik.gasconnection.infrastructure.dto.GasConnectionDbDto;
import net.focik.gasconnection.infrastructure.dto.JpaMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
@Primary
class GasConnectionRepositoryAdapter implements IGasConnectionRepository {


    private IGasConnectionDtoRepository gasConnectionDtoRepository;

    @Override
    public Integer add(GasConnection gasConnection) {
        GasConnectionDbDto gasConnectionDbDto = JpaMapper.toDto(gasConnection);
        return gasConnectionDtoRepository.save(gasConnectionDbDto).getIdTask();
    }

    @Override
    public Optional<GasConnection> findById(Integer id) {

        Optional<GasConnectionDbDto> byId = gasConnectionDtoRepository.findById(id);

        if(byId.isEmpty())
            return Optional.empty();

        return Optional.of(JpaMapper.toDomain(byId.get()));
    }
}
