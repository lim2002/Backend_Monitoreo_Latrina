package com.LatrinaCover.monitoreoBackend.Servicios;

import java.util.*;
import static java.lang.Math.*;

public class GeoUtils {

    // Radio medio de la Tierra en metros
    private static final double R = 6371_000;

    public static double haversineMeters(double lat1, double lon1, double lat2, double lon2) {
        double phi1 = toRadians(lat1);
        double phi2 = toRadians(lat2);
        double dPhi = toRadians(lat2 - lat1);
        double dLambda = toRadians(lon2 - lon1);

        double a = sin(dPhi/2)*sin(dPhi/2)
                + cos(phi1)*cos(phi2)*sin(dLambda/2)*sin(dLambda/2);
        double c = 2 * atan2(sqrt(a), sqrt(1 - a));
        return R * c;
    }

    // Punto simple
    public static record Punto(Integer nombre, double lat, double lon) { }

    // Devuelve la lista ordenada por distancia al origen
    public static List<Punto> ordenarPorDistancia(double origenLat, double origenLon, List<Punto> pts) {
        return pts.stream()
                .sorted(Comparator.comparingDouble(p -> haversineMeters(origenLat, origenLon, p.lat(), p.lon())))
                .toList();
    }

    // Si además quieres la distancia en el resultado:
    public static record PuntoConDist(Punto punto, double distanciaMetros) { }

    public static List<PuntoConDist> ordenarYCalcular(double origenLat, double origenLon, List<Punto> pts) {
        return pts.stream()
                .map(p -> new PuntoConDist(p, haversineMeters(origenLat, origenLon, p.lat(), p.lon())))
                .sorted(Comparator.comparingDouble(PuntoConDist::distanciaMetros))
                .toList();
    }
}
