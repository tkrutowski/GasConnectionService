package net.focik.gasconnection.domain;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import net.focik.addresses.domain.Address;
import net.focik.gasconnection.domain.exceptions.GasConnectionDoesNotExistException;
import net.focik.gasconnection.domain.port.IAddressRepository;
import net.focik.gasconnection.domain.port.IGasConnectionRepository;
import net.focik.gasconnection.domain.port.IScopeGasConnectionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
@Log
class GasConnectionFactory {

    IAddressRepository addressRepository;
    //private IScopeGasConnectionRepository scopeGasConnectionRepository;
    private IGasConnectionRepository gasConnectionRepository;

    public GasConnection createGasConnectionById(Integer id) {
        Optional<GasConnection> byId = gasConnectionRepository.findById(id);

        if(byId.isEmpty())
            throw new GasConnectionDoesNotExistException(id);

        GasConnection gasConnection = byId.get();
        gasConnection.setAddress(getAddress(gasConnection.getAddress().getId()));

        return gasConnection;
    }

    private Address getAddress(Long idAddress) {
        Optional<Address> addressById = addressRepository.findAddressById(idAddress);

        if(addressById.isEmpty())
            return new Address(idAddress, "brak danych", "brak danych", "brak danych","brak danych",null);

        return addressById.get();
    }

}
