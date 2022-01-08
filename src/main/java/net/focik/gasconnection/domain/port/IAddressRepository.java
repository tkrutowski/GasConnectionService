package net.focik.gasconnection.domain.port;

import net.focik.addresses.domain.Address;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface IAddressRepository {
    Optional<Address> findAddressById(Long id);
}