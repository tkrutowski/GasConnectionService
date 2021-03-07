package net.focik.gasconnection.api;

import lombok.AllArgsConstructor;
import net.focik.gasconnection.domain.GasConnectionFacade;
import net.focik.gasconnection.domain.dto.IGasConnectionDto;
import net.focik.gasconnection.domain.share.DtoType;
import net.focik.gasconnection.infrastructure.dto.GasConnectionDbDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/gasconnection")
class GasConnectionController {

    private GasConnectionFacade gasConnectionFacade;

    @PostMapping
    public Integer addGasConnection(@RequestBody GasConnectionDbDto gasConnectionDbDto){
        return gasConnectionFacade.addGasConnection(gasConnectionDbDto);
    }

    @GetMapping("/{id}")
    IGasConnectionDto getGasConnection(@PathVariable Integer id, @RequestParam(name = "type", defaultValue = "GAS_CONNECTION") DtoType dtoType){
        int i=0;
        return gasConnectionFacade.getGasConnectionDto(id, dtoType);
    }

}
