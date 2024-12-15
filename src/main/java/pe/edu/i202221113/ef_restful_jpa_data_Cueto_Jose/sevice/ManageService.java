package pe.edu.i202221113.ef_restful_jpa_data_Cueto_Jose.sevice;

import pe.edu.i202221113.ef_restful_jpa_data_Cueto_Jose.dto.CarDetailDto;
import pe.edu.i202221113.ef_restful_jpa_data_Cueto_Jose.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface ManageService {

    List<CarDto> getAllCars() throws Exception;

    Optional<CarDto> getAllCarsById(int carId) throws Exception;

    Optional<CarDetailDto> getCarById(int id) throws Exception;

    boolean updateCar(CarDto carDto) throws Exception;

    boolean deleteCarById(int id) throws Exception;

    boolean addCar(CarDetailDto carDetailDto) throws Exception;
}
