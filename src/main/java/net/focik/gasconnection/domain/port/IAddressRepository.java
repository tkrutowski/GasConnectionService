package net.focik.gasconnection.domain.port;

import net.focik.gasconnection.infrastructure.dto.AddressDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface IAddressRepository {
    Optional<AddressDto> findAddressById(Integer id);
}