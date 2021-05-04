package net.focik.gasconnection.infrastructure.clients;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.focik.gasconnection.domain.port.IScopeGasConnectionRepository;
import net.focik.gasconnection.infrastructure.dto.ScopeGasConnectionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
@Log4j2
@Primary
@Profile("dev")
public class ScopeGasConnectionClient implements IScopeGasConnectionRepository {


    private RestTemplate restTemplate ;

    //TODO dodać stałą z propertisów
    private static final String URI = "http://scope-gasconnection-service/api/scopegasconnection/task/";

    public List<ScopeGasConnectionDto> findScopeGasConnectionByIdTask(Integer idtask) {
        List<ScopeGasConnectionDto> connectionDtos = new ArrayList<>();
        try {
            ResponseEntity<ScopeGasConnectionDto[]> response =
                    restTemplate.getForEntity(URI + idtask, ScopeGasConnectionDto[].class);

            connectionDtos = List.of(response.getBody());
        } catch (RestClientException ex) {
            log.error("Error", ex.fillInStackTrace());            //TODO może rzucić wyjątek
            return connectionDtos;
        }

        return connectionDtos;
    }
}
