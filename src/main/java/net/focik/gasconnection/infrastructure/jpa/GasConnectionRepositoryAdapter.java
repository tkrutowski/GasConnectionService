package net.focik.gasconnection.infrastructure.jpa;

import lombok.AllArgsConstructor;
import net.focik.gasconnection.domain.port.IGasConnectionRepository;
import net.focik.gasconnection.infrastructure.dto.GasConnectionDbDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
class GasConnectionRepositoryAdapter implements IGasConnectionRepository {

    private IGasConnectionDtoRepository gasConnectionDtoRepository;

    @Override
    public Integer add(GasConnectionDbDto gasConnectionDbDto) {
        return gasConnectionDtoRepository.save(gasConnectionDbDto).getId();
    }

    @Override
    public Optional<GasConnectionDbDto> findById(Integer id) {
        return gasConnectionDtoRepository.findById(id);
    }
}
