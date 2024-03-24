package tn.esprit.coexist.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import tn.esprit.coexist.entity.Carpooling;
import tn.esprit.coexist.entity.CarpoolingType;
import tn.esprit.coexist.entity.Day;
import tn.esprit.coexist.repository.CarpoolingRepository;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@AllArgsConstructor
@Aspect
@Slf4j
public class CarpoolingServiceImp implements CarpoolingService{
CarpoolingRepository carpoolingRepository;

    @Override
    public Carpooling addCarpooling(Carpooling carpooling) {
        if (carpooling.getCarpoolingType().equals(CarpoolingType.DAILY)) {
            carpooling.setDepartureTime(null);
            log.info("sssssssss");
        } else {
           carpooling.setDay(null);
           carpooling.setTime(null);
            log.info("aaaaaaaaa");
        }
        return carpoolingRepository.save(carpooling);
    }

    @Override
    public void delateCarpooling(Integer carpoolingId) {
        carpoolingRepository.deleteById(carpoolingId);
    }

    @Override
    public void updateCarpooling(Integer carpoolingId, Carpooling carpooling) {
       carpooling.setCarpoolingID(carpoolingId);
       carpoolingRepository.save(carpooling);
    }

    @Override
    public Carpooling updateCarpooling(Carpooling carpooling) {
        if (carpooling.getCarpoolingType().equals(CarpoolingType.DAILY)) {
            carpooling.setDepartureTime(null);
            log.info("sssssssss");
        } else {
            carpooling.setDay(null);
            carpooling.setTime(null);
            log.info("aaaaaaaaa");
        }
        return carpoolingRepository.save(carpooling);

    }

    @Override
    public List<Carpooling> getAllCarpooling() {
        return carpoolingRepository.findAll();
    }

    @Override
    public Carpooling findCarpooling(Integer carpoolingId) {
        return carpoolingRepository.findById(carpoolingId).get();
    }

    @Override
    public List<Carpooling> findByLongitudeDepartureAndLatitudeDeparture(String longitudeDeparture, String latitudeDeparture) {

        return carpoolingRepository.findByLongitudeDepartureAndLatitudeDeparture(longitudeDeparture, latitudeDeparture);
    }

    @Override
    public List<Carpooling> findByLongitudeDepartureAndLatitudeDepartureAndLatitudeDestinationAndLongitudeDestination(String longitudeDeparture, String latitudeDeparture, String latitudeDestination, String longitudeDestination) {
        List<Carpooling> result = carpoolingRepository.findByLongitudeDepartureAndLatitudeDeparture(longitudeDeparture, latitudeDeparture);
        log.info("Result: {}", result);
        return carpoolingRepository.findByLongitudeDepartureAndLatitudeDepartureAndLatitudeDestinationAndLongitudeDestination(longitudeDeparture, latitudeDeparture, latitudeDestination, longitudeDestination);

    }

    @Override
    public List<Carpooling> findByLongitudeDepartureAndLatitudeDepartureAndDepartureTime(String longitudeDeparture, String latitudeDeparture, LocalDateTime departureTime) {
        return carpoolingRepository.findByLongitudeDepartureAndLatitudeDepartureAndDepartureTime(longitudeDeparture, latitudeDeparture, departureTime);

    }

    @Override
    public List<Carpooling> findByDepartureTime(LocalDateTime departureTime) {
        return carpoolingRepository.findByDepartureTime(departureTime);

    }

    @Override
    public List<Carpooling> findCarpoolingByAttributes(
            LocalDateTime departureTime,
            String longitudeDeparture,
            String latitudeDestination,
            String latitudeDeparture,
            String longitudeDestination,
            Integer availableSeats,
            float costPerSeat,
            Day day,
            LocalTime time,
            CarpoolingType carpoolingType,
            Long registrationNumber
    ) {
        return carpoolingRepository.findCarpoolingByAttributes(
                departureTime,
                longitudeDeparture,
                latitudeDestination,
                latitudeDeparture,
                longitudeDestination,
                availableSeats,
                costPerSeat,
                day,
                time,
                carpoolingType,
                registrationNumber
        );
    }

    @Override
    public List<Carpooling> findByCarpoolingType(CarpoolingType carpoolingType) {
        return carpoolingRepository.findByCarpoolingType(carpoolingType);
    }


}
