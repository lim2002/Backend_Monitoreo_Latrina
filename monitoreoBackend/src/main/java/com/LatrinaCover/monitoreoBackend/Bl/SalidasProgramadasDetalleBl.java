package com.LatrinaCover.monitoreoBackend.Bl;

import com.LatrinaCover.monitoreoBackend.Dto.SalidasProgramadasDetalleDto;
import com.LatrinaCover.monitoreoBackend.Entity.SalidasProgramadasDetalle;
import com.LatrinaCover.monitoreoBackend.Repository.SalidasProgramadasDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalidasProgramadasDetalleBl {

    @Autowired
    private SalidasProgramadasDetalleRepository salidasProgramadasDetalleRepository;

    //obtener las salida programadas detalle por idSalidaProgramada
    public List<SalidasProgramadasDetalleDto> getByIdSalidaProgramada(Integer idSalidaProgramada){
        List<SalidasProgramadasDetalle> detalles = salidasProgramadasDetalleRepository.findByIdSalidaProgramada(idSalidaProgramada);
        return detalles.stream().map(detalle -> new SalidasProgramadasDetalleDto(
                detalle.getIdSalidaProgramadaDetalle(),
                detalle.getSalidaProgramada().getIdSalidaProgramada(),
                detalle.getNotaSalida().getIdNotaSalida(),
                detalle.getNotaSalidaDetalle().getIdNotaSalidaDetalle(),
                detalle.getProductoNombre(),
                detalle.getProductoCodigo(),
                detalle.getCantidad(),
                detalle.getDescripcion(),
                detalle.getPrecioUnitario(),
                detalle.getEstadoObservacion(),
                detalle.getEstadoEntrega(),
                detalle.getStatus()
        )).toList();
    }
}
