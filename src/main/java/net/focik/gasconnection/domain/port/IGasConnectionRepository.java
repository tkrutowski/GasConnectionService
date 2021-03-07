package net.focik.gasconnection.domain.port;

import net.focik.gasconnection.infrastructure.dto.GasConnectionDbDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface IGasConnectionRepository {

    Integer add(GasConnectionDbDto gasConnectionDbDto);

    Optional<GasConnectionDbDto> findById(Integer id);
//
//    List<Client> findAll();
//
//    void delete(Long id);
//
//    Optional<Client> edit(Client author);
//
//    Optional<Client> findByNip(String nip);
}
