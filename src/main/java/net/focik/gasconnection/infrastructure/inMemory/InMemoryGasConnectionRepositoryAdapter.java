package net.focik.gasconnection.infrastructure.inMemory;

import lombok.extern.java.Log;
import net.focik.gasconnection.domain.port.IGasConnectionRepository;
import net.focik.gasconnection.infrastructure.dto.GasConnectionDbDto;

import java.util.HashMap;
import java.util.Optional;

//@Component()
//@Primary
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
        dbDto.setId(id);
        gasConnectionDbDtoHashMap.put(id,dbDto);
        log.info("Succssec id = " + id);
        return id;
    }


    @Override
    public Optional<GasConnectionDbDto> findById(Integer id) {
        return Optional.ofNullable(gasConnectionDbDtoHashMap.get(id));
    }
}
