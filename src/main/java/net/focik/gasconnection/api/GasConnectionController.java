package net.focik.gasconnection.api;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.focik.gasconnection.domain.GasConnectionFacade;
import net.focik.gasconnection.domain.dto.IGasConnectionDto;
import net.focik.gasconnection.domain.share.DtoType;
import net.focik.gasconnection.infrastructure.dto.GasConnectionDbDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@AllArgsConstructor
//@NoArgsConstructor
@RequestMapping("/api/gasconnection")
class GasConnectionController {

    private GasConnectionFacade gasConnectionFacade;

    @PostMapping
    public Integer addGasConnection(@RequestBody GasConnectionDbDto gasConnectionDbDto){
        return gasConnectionFacade.addGasConnection(gasConnectionDbDto);
    }

    @GetMapping("/{id}")
    ResponseEntity<IGasConnectionDto> getGasConnection(@PathVariable Integer id, @RequestParam(name = "type", defaultValue = "GAS_CONNECTION") DtoType dtoType){
        int i=0;
        log.info("GASCONNECTION-SERVICE: Try find gasconnection for  id = " + id + "and type: "+dtoType);
        IGasConnectionDto gasConnectionDto = gasConnectionFacade.getGasConnectionDto(id, dtoType);
        log.info(gasConnectionDto != null ? "GASCONNECTION-SERVICE: Found gasconnection for id = " + id : "GASCONNECTION-SERVICE: Not found gasconnection for id = " + id);

        if(gasConnectionDto == null)
            return new ResponseEntity<>((IGasConnectionDto) null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(gasConnectionDto, HttpStatus.OK);








    }

}
