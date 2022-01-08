package net.focik.gasconnection.infrastructure.clients;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.focik.addresses.domain.Address;
import net.focik.addresses.domain.AddressFacade;
import net.focik.addresses.domain.exceptions.AddressDoesNotExistException;
import net.focik.gasconnection.domain.port.IAddressRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
@Log4j2
public class GasConnectionAddressRepositoryAdapter implements IAddressRepository {

    AddressFacade addressFacade;

    public Optional<Address> findAddressById(Long id) {

        Address address;
        log.info("GASCONNECTION-SERVICE: Try find address for id = " + id);
        try {
            address = addressFacade.getAddress(id);
            log.info( "GASCONNECTION-SERVICE: Found address for id = " + id );
        }catch (AddressDoesNotExistException e){
            //TODO może rzucić wyjątek albo legger error
            log.info( "GASCONNECTION-SERVICE: Not found address for id = " + id );
            return Optional.empty();
        }catch (Exception ex){
            //TODO może rzucić wyjątek albo legger error
            log.error("GasConnectionAddressRepositoryAdapter_findAddressById. Message: "+ex.getMessage());
            return Optional.empty();
        }
        return Optional.ofNullable(address);
    }
}
