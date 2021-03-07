package net.focik.gasconnection.infrastructure.jpa;

import lombok.AllArgsConstructor;
import net.focik.gasconnection.domain.port.IGasConnectionRepository;
import net.focik.gasconnection.infrastructure.dto.GasConnectionDbDto;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
@Primary
class GasConnectionRepositoryAdapter implements IGasConnectionRepository {

    private IGasConnectionDtoRepository gasConnectionDtoRepository;

    @Override
    public Integer add(GasConnectionDbDto gasConnectionDbDto) {
        return gasConnectionDtoRepository.save(gasConnectionDbDto).getIdTask();
    }

    @Override
    public Optional<GasConnectionDbDto> findById(Integer id) {
        return gasConnectionDtoRepository.findById(id);
    }
}
