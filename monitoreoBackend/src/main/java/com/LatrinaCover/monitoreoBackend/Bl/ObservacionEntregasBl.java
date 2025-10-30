package com.LatrinaCover.monitoreoBackend.Bl;

import com.LatrinaCover.monitoreoBackend.Dto.ObservacionEntregasDto;
import com.LatrinaCover.monitoreoBackend.Dto.SalidasProgramadasDetalleDto;
import com.LatrinaCover.monitoreoBackend.Entity.ObservacionEntregas;
import com.LatrinaCover.monitoreoBackend.Entity.SalidasProgramadas;
import com.LatrinaCover.monitoreoBackend.Entity.SalidasProgramadasDetalle;
import com.LatrinaCover.monitoreoBackend.Entity.Usuarios;
import com.LatrinaCover.monitoreoBackend.Repository.ObservacionEntregasRepository;
import com.LatrinaCover.monitoreoBackend.Repository.SalidasProgramadasDetalleRepository;
import com.LatrinaCover.monitoreoBackend.Repository.SalidasProgramadasRepository;
import com.LatrinaCover.monitoreoBackend.Repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ObservacionEntregasBl {

    @Autowired
    private ObservacionEntregasRepository observacionEntregasRepository;

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private SalidasProgramadasDetalleRepository salidasProgramadasDetalleRepository;

    @Autowired
    private SalidasProgramadasRepository salidasProgramadasRepository;

    //mostrar observaciones por id de programacion salida
    public List<ObservacionEntregasDto> getObservacionesByProgramacionSalidaId(Integer id) {
        List<ObservacionEntregas> observaciones = observacionEntregasRepository.findByProgramacionSalidaId(id);
        return observaciones.stream().map(observacion -> new ObservacionEntregasDto(
                observacion.getIdObservacionEntrega(),
                observacion.getConductor().getIdUsuario(),
                observacion.getSalidasProgramadasDetalle().getIdSalidaProgramadaDetalle(),
                observacion.getObservacion(),
                observacion.getEstadoEntrega(),
                observacion.getStatus()
        )).toList();
    }

    //obtener observacion por id
    public ObservacionEntregasDto getObservacionByIdSalidaProgramadaDetalle(Integer id) {
        ObservacionEntregas observacion = observacionEntregasRepository.findObservacionBySalidasProgramadaDetalle(id);
        return new ObservacionEntregasDto(
                observacion.getIdObservacionEntrega(),
                observacion.getConductor().getIdUsuario(),
                observacion.getSalidasProgramadasDetalle().getIdSalidaProgramadaDetalle(),
                observacion.getObservacion(),
                observacion.getEstadoEntrega(),
                observacion.getStatus()
        );
    }

    //guardar una observacion
    public void saveObservacion(ObservacionEntregasDto observacionDto) {
        ObservacionEntregas observacion = new ObservacionEntregas();

        Usuarios conductor = usuariosRepository.findByIdUsuario(observacionDto.getIdConductor().intValue());
        observacion.setConductor(conductor);

        SalidasProgramadasDetalle salidaDetalle = salidasProgramadasDetalleRepository.findByIdSalidaProgramadaDetalle(observacionDto.getIdSalidasProgramadasDetalle());
        observacion.setSalidasProgramadasDetalle(salidaDetalle);

        observacion.setObservacion(observacionDto.getObservacion());
        observacion.setEstadoEntrega(observacionDto.getEstadoEntrega());
        observacion.setStatus(observacionDto.getStatus());

        observacionEntregasRepository.save(observacion);

        //Modificamos los registros en SalidasProgramadasDetalle
        SalidasProgramadasDetalle detalle = salidaDetalle;
        detalle.setEstadoObservacion(1); // 1 = Con Observación
        detalle.setEstadoEntrega(observacionDto.getEstadoEntrega());
        salidasProgramadasDetalleRepository.save(detalle);
    }


}
