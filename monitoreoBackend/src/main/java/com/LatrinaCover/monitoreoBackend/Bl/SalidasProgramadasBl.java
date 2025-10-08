package com.LatrinaCover.monitoreoBackend.Bl;

import com.LatrinaCover.monitoreoBackend.Dto.*;
import com.LatrinaCover.monitoreoBackend.Entity.*;
import com.LatrinaCover.monitoreoBackend.Repository.*;
import com.LatrinaCover.monitoreoBackend.Servicios.GeoUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalidasProgramadasBl {

    @Autowired
    private SalidasProgramadasRepository salidasProgramadasRepository;

    @Autowired
    private NotasSalidasRepository notasSalidasRepository;

    @Autowired
    private SalidasProgramadasDetalleRepository salidasProgramadasDetalleRepository;

    @Autowired
    private NotasSalidaDetalleRepository notasSalidaDetalleRepository;

    @Autowired
    private UbicacionClientesRepository ubicacionClientesRepository;

    @Autowired
    private ProgramacionDistribucionRepository programacionDistribucionRepository;

    @Autowired
    private ClientesRepository clientesRepository;

    //agregar las salidas programadas y las salidas detalle a la base de datos
    @Transactional
    public void agregarSalidasProgramadasYDetalle(Integer idProgramacion, List<NotaSalidaMasterAddDto> notasSalidasDtos){


        Integer idNotaSalidaGenerada = 0;

        //bucle para extraer la ubicacion de NotasSalidaMasterAddDto
        //origen
        double lat0 = -16.522623, lon0 = -68.117335;
        //Lista
        List<GeoUtils.Punto> puntos = new ArrayList<>();
        //bucle para rellenar la lista de puntos
        for (NotaSalidaMasterAddDto nota : notasSalidasDtos) {
            String[] p = nota.getUbicaciones().getUbicacion().split(",");
            double lat = Double.parseDouble(p[0].trim());
            double lon = Double.parseDouble(p[1].trim());
            puntos.add(new GeoUtils.Punto(nota.getIdNotaSalida(), lat, lon));
        }
        List<GeoUtils.Punto> ordenados = GeoUtils.ordenarPorDistancia(lat0, lon0, puntos);

        //revisar cada nota de salida
        for (NotaSalidaMasterAddDto notaSalidaMasterDto : notasSalidasDtos) {
            SalidasProgramadas salidasProgramadas = new SalidasProgramadas();


            ProgramacionDistribucion programacionDistribucion = programacionDistribucionRepository.getReferenceById(idProgramacion);
            salidasProgramadas.setProgramacion(programacionDistribucion);

            NotasSalidas notaSalida = notasSalidasRepository.findById(notaSalidaMasterDto.getIdNotaSalida()).orElseThrow(() -> new IllegalArgumentException(
                    "No existe notas_salidas con id " + notaSalidaMasterDto.getIdNotaSalida()
            ));;
            salidasProgramadas.setNotaSalida(notaSalida);


            Clientes cliente = clientesRepository.getReferenceById(notaSalidaMasterDto.getCliente().getIdCliente().intValue());
            salidasProgramadas.setCliente(cliente);

            UbicacionClientes ubicacionClientes = ubicacionClientesRepository.findByIdUbicacionCliente(notaSalidaMasterDto.getUbicaciones().getIdUbicacionCliente());
            salidasProgramadas.setUbicacionCliente(ubicacionClientes);

            salidasProgramadas.setNroSalida(notaSalidaMasterDto.getNroSalida().toString());

            salidasProgramadas.setEstadoEntrega(1);
            //asigan la orden de prioridad
            Integer prioridad = null;
            for (int i = 0; i < ordenados.size(); i++) {
                // Usa el getter correcto de tu Punto: getId() o getIdNotaSalida()
                if (ordenados.get(i).nombre().equals(notaSalidaMasterDto.getIdNotaSalida())) {
                    prioridad = i + 1; // prioridad 1-based según ordenados
                    break;
                }
            }
            if (prioridad == null) {
                // si NO está en 'ordenados' (p.ej. no tiene coords), va después de los ordenados,
                // manteniendo unicidad con tu contador existente.
                prioridad = ordenados.size() + (++idNotaSalidaGenerada);
            }
            salidasProgramadas.setOrdenPrioridadRuta(prioridad);

            salidasProgramadas.setUbicacionEntrega(notaSalidaMasterDto.getUbicaciones().getUbicacion());
            salidasProgramadas.setFechaEntregaConfirmada(null);
            salidasProgramadas.setStatus(1);
            salidasProgramadasRepository.save(salidasProgramadas);

            //revisar cada detalle de la nota de salida
            List<NotasSalidaDetalle> notasSalidasDetalles = notasSalidaDetalleRepository.findNotasSalidaDetalleByIdNotaSalida(notaSalidaMasterDto.getIdNotaSalida());
            for (NotasSalidaDetalle notasSalidasDetalle : notasSalidasDetalles) {
                SalidasProgramadasDetalle salidasProgramadasDetalle = new SalidasProgramadasDetalle();
                salidasProgramadasDetalle.setSalidaProgramada(salidasProgramadas);
                salidasProgramadasDetalle.setNotaSalida(notaSalida);
                salidasProgramadasDetalle.setNotaSalidaDetalle(notasSalidasDetalle);
                salidasProgramadasDetalle.setProductoNombre(notasSalidasDetalle.getProductoNombre());
                salidasProgramadasDetalle.setProductoCodigo(notasSalidasDetalle.getProductoCodigo());
                salidasProgramadasDetalle.setCantidad(notasSalidasDetalle.getCantidad().intValue());
                salidasProgramadasDetalle.setDescripcion(notasSalidasDetalle.getDescripcion());
                salidasProgramadasDetalle.setPrecioUnitario(notasSalidasDetalle.getPrecioUnitario());
                salidasProgramadasDetalle.setEstadoObservacion(2); //1=hay , 2=no hay
                salidasProgramadasDetalle.setEstadoEntrega(1);// 1=en proceso, 2=entregado, 3=atrasado
                salidasProgramadasDetalle.setStatus(1);
                salidasProgramadasDetalleRepository.save(salidasProgramadasDetalle);
            }
        }


    }

    //obtener las salidas programadas por id de programacion
    @Transactional
    public List<SalidasProgramadasDto> getSalidasProgramadasByIdProgramacion(Integer idProgramacion){
        List<SalidasProgramadas> list = salidasProgramadasRepository.findByIdProgramacion(idProgramacion);
        System.out.println(list.size());
        return list.stream()
                .map(sp -> new SalidasProgramadasDto(
                        sp.getIdSalidaProgramada(),
                        sp.getProgramacion().getIdProgramacion(),
                        sp.getNotaSalida().getIdNotaSalida(),
                        ClientesDto.of(sp.getCliente()),
                        UbicacionClientesDto.of(sp.getUbicacionCliente()),
                        sp.getNroSalida(),
                        sp.getEstadoEntrega(),
                        sp.getOrdenPrioridadRuta(),
                        sp.getUbicacionEntrega(),
                        sp.getFechaEntregaConfirmada(), // <--
                        sp.getStatus()
                ))
                .toList();
    }

}
