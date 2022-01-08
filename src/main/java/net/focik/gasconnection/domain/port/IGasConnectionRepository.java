package net.focik.gasconnection.domain.port;

import net.focik.gasconnection.domain.GasConnection;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface IGasConnectionRepository {

    Integer add(GasConnection gasConnection);

    Optional<GasConnection> findById(Integer id);

}
