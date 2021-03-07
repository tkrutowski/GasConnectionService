package net.focik.gasconnection.infrastructure.inMemory;

import lombok.extern.java.Log;
import net.focik.gasconnection.domain.port.IGasConnectionRepository;
import net.focik.gasconnection.infrastructure.dto.GasConnectionDbDto;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Optional;

@Component()
@Profile("dev")
@Log
class InMemoryGasConnectionRepositoryAdapter implements IGasConnectionRepository {
    private HashMap<Integer, GasConnectionDbDto> gasConnectionDbDtoHashMap = new HashMap<>();


    @Override
    public Integer add(GasConnectionDbDto dbDto) {
        int i=0;
    log.info("Try add into inMemoryDb clientDbDto: "+dbDto.toString());
        if(dbDto == null)
            throw new NullPointerException("ClientDbDto cannot be null");
        Integer id = gasConnectionDbDtoHashMap.size() + 1;
        dbDto.setIdTask(id);
        gasConnectionDbDtoHashMap.put(id,dbDto);
        log.info("Succssec id = " + id);
        return id;
    }


    @Override
    public Optional<GasConnectionDbDto> findById(Integer id) {
        return Optional.ofNullable(gasConnectionDbDtoHashMap.get(id));
    }
}
