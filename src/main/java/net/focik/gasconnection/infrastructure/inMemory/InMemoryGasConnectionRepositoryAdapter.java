package net.focik.gasconnection.infrastructure.inMemory;

import lombok.extern.java.Log;
import net.focik.gasconnection.domain.GasConnection;
import net.focik.gasconnection.domain.port.IGasConnectionRepository;
import net.focik.gasconnection.infrastructure.dto.GasConnectionDbDto;
import net.focik.gasconnection.infrastructure.dto.JpaMapper;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Optional;

@Component()
@Profile("test")
@Log
class InMemoryGasConnectionRepositoryAdapter implements IGasConnectionRepository {
    private HashMap<Integer, GasConnectionDbDto> gasConnectionDbDtoHashMap = new HashMap<>();


    @Override
    public Integer add(GasConnection gasConnection) {
        int i=0;
        GasConnectionDbDto dbDto = JpaMapper.toDto(gasConnection);
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
    public Optional<GasConnection> findById(Integer id) {
        Optional<GasConnectionDbDto> dbDto = Optional.ofNullable(gasConnectionDbDtoHashMap.get(id));

        if (dbDto.isEmpty())
            return Optional.empty();

        return Optional.ofNullable(JpaMapper.toDomain(dbDto.get()));
    }
}
