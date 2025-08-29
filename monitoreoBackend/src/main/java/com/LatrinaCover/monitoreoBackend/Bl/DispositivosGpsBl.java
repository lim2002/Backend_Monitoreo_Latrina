package com.LatrinaCover.monitoreoBackend.Bl;

import com.LatrinaCover.monitoreoBackend.Dto.DispositivosGpsDto;
import com.LatrinaCover.monitoreoBackend.Entity.DispositivosGps;
import com.LatrinaCover.monitoreoBackend.Repository.DispositivosGpsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DispositivosGpsBl {

    @Autowired
    private DispositivosGpsRepository dispositivosGpsRepository;

    //Guardar dispositivo GPS
    public void saveDispositivoGps(DispositivosGpsDto dispositivoGpsDto){
        DispositivosGps dispositivosGps = new DispositivosGps();
        dispositivosGps.setCodigo(dispositivoGpsDto.getCodigo());
        dispositivosGps.setModelo(dispositivoGpsDto.getModelo());
        //activo 1=creado y disponible, 0=no disponible
        dispositivosGps.setActivo(1);
        dispositivosGps.setStatus(1);
        dispositivosGpsRepository.save(dispositivosGps);
    }
    //Mostrar dispositivos GPS con  status 1
    public List<DispositivosGpsDto> getDispositivosGps(){
        List<DispositivosGps> dispositivosGps = dispositivosGpsRepository.findByStatus(1);
        List<DispositivosGpsDto> dispositivosGpsDtos = new ArrayList<>();
        for (DispositivosGps dispositivoGps : dispositivosGps) {
            dispositivosGpsDtos.add(new DispositivosGpsDto(dispositivoGps.getIdDispositivo(), dispositivoGps.getCodigo(), dispositivoGps.getModelo(), dispositivoGps.getActivo(), dispositivoGps.getStatus()));
        }
        return dispositivosGpsDtos;
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
