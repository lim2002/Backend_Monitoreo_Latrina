package com.LatrinaCover.monitoreoBackend.Bl;

import com.LatrinaCover.monitoreoBackend.Dto.DispositivosGpsDto;
import com.LatrinaCover.monitoreoBackend.Entity.DispositivosGps;
import com.LatrinaCover.monitoreoBackend.Repository.DispositivosGpsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DispositivosGpsBl {

    @Autowired
    private DispositivosGpsRepository dispositivosGpsRepository;

    //Guardar dispositivo GPS
    public DispositivosGpsDto saveDispositivoGps(DispositivosGpsDto dispositivoGpsDto){
        DispositivosGps dispositivosGps = new DispositivosGps();
        dispositivosGps.setCodigo(dispositivoGpsDto.getCodigo());
        dispositivosGps.setModelo(dispositivoGpsDto.getModelo());
        //activo 1=creado y disponible, 0=no disponible
        dispositivosGps.setActivo(1);
        dispositivosGps.setStatus(1);
        dispositivosGpsRepository.save(dispositivosGps);
        dispositivoGpsDto.setIdDispositivo(dispositivosGps.getIdDispositivo());
        return dispositivoGpsDto;
    }
    //Mostrar dispositivos GPS
    public Page<DispositivosGpsDto> getDispositivosGps(String q, Integer page, Integer size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<DispositivosGps> dispositivosGpsPage;

        if ("all".equalsIgnoreCase(q)) {
            dispositivosGpsPage = dispositivosGpsRepository.findByStatus(pageable);
        } else {
            dispositivosGpsPage = dispositivosGpsRepository.findByAll(q, pageable);
        }

        List<DispositivosGpsDto> dispositivosGpsDtos = new ArrayList<>(dispositivosGpsPage.getContent().size());

        for (DispositivosGps dispositivoGps : dispositivosGpsPage.getContent()) {
            dispositivosGpsDtos.add(new DispositivosGpsDto(
                    dispositivoGps.getIdDispositivo(),
                    dispositivoGps.getCodigo(),
                    dispositivoGps.getModelo(),
                    dispositivoGps.getActivo(),
                    dispositivoGps.getStatus()
            ));
        }

        // devolvemos paginado, pero de DTOs
        return new PageImpl<>(dispositivosGpsDtos, pageable, dispositivosGpsPage.getTotalElements());
    }
    //Mostrar dispositivos GPS con activo 1 y status 1
    public List<DispositivosGpsDto> getDispositivosGpsDisponibles(){
        List<DispositivosGps> dispositivosGps = dispositivosGpsRepository.findByStatusAndActivo(1,1);
        List<DispositivosGpsDto> dispositivosGpsDtos = new ArrayList<>();
        for (DispositivosGps dispositivoGps : dispositivosGps) {
            dispositivosGpsDtos.add(new DispositivosGpsDto(dispositivoGps.getIdDispositivo(), dispositivoGps.getCodigo(), dispositivoGps.getModelo(), dispositivoGps.getActivo(), dispositivoGps.getStatus()));
        }
        return dispositivosGpsDtos;
    }

    //Obtener dispositivo GPS por id
    public DispositivosGpsDto getDispositivoGpsById(Integer idDispositivo){
        DispositivosGps dispositivosGps = dispositivosGpsRepository.findByIdDispositivoGps(idDispositivo);
        DispositivosGpsDto dispositivoGpsDto = new DispositivosGpsDto(dispositivosGps.getIdDispositivo(), dispositivosGps.getCodigo(), dispositivosGps.getModelo(), dispositivosGps.getActivo(), dispositivosGps.getStatus());
        return dispositivoGpsDto;
    }




    //Modificar dispositivo GPS
    public void updateDispositivoGps(DispositivosGpsDto dispositivoGpsDto){
        DispositivosGps dispositivosGps = new DispositivosGps();
        dispositivosGps.setIdDispositivo(dispositivoGpsDto.getIdDispositivo());
        dispositivosGps.setCodigo(dispositivoGpsDto.getCodigo());
        dispositivosGps.setModelo(dispositivoGpsDto.getModelo());
        dispositivosGps.setActivo(dispositivoGpsDto.getActivo());
        dispositivosGps.setStatus(dispositivoGpsDto.getStatus());
        dispositivosGpsRepository.save(dispositivosGps);
    }

    //Eliminar dispositivo GPS (status 0)
    public void deleteDispositivoGps(Integer idDispositivo){
        DispositivosGps dispositivosGps = new DispositivosGps();
        dispositivosGps.setIdDispositivo(idDispositivo);
        dispositivosGps.setStatus(0);
        dispositivosGpsRepository.save(dispositivosGps);
    }
}
