package pe.edu.i202221113.ef_restful_jpa_data_Cueto_Jose.sevice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.i202221113.ef_restful_jpa_data_Cueto_Jose.dto.CarDetailDto;
import pe.edu.i202221113.ef_restful_jpa_data_Cueto_Jose.dto.CarDto;
import pe.edu.i202221113.ef_restful_jpa_data_Cueto_Jose.entity.Car;
import pe.edu.i202221113.ef_restful_jpa_data_Cueto_Jose.repository.CarRepository;
import pe.edu.i202221113.ef_restful_jpa_data_Cueto_Jose.sevice.ManageService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    CarRepository carRepository;


    @Override
    public List<CarDto> getAllCars() throws Exception {
        List<CarDto> cars = new ArrayList<>();
        Iterable<Car> iterable = carRepository.findAll();
        iterable.forEach(car -> {
            CarDto carDto = new CarDto(car.getCarId(),
                    car.getMake(),
                    car.getModel(),
                    car.getLicensePlate(),
                    car.getOwnerName(),
                    car.getColor());
            cars.add(carDto);
        });
        return cars;
    }

    @Override
    public Optional<CarDto> getAllCarsById(int id) throws Exception {
        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> new CarDto(car.getCarId(),
                car.getMake(),
                car.getModel(),
                car.getLicensePlate(),
                car.getOwnerName(),
                car.getColor()));
    }

    @Override
    public Optional<CarDetailDto> getCarById(int id) throws Exception {
        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> new CarDetailDto(car.getCarId(),
                car.getMake(),
                car.getModel(),
                car.getLicensePlate(),
                car.getYear(),
                car.getOwnerName(),
                car.getOwnerContact(),
                car.getColor()));
    }

    @Override
    public boolean updateCar(CarDto carDto) throws Exception {
        Optional<Car> optional = carRepository.findById(carDto.carId());
        return optional.map(car -> {
            car.setMake(carDto.make());
            car.setModel(carDto.model());
            car.setOwnerName(carDto.ownerName());
            car.setLicensePlate(carDto.licensePlate());
            car.setColor(carDto.color());
            carRepository.save(car);
            return true;
        }).orElse(false);
    }

    @Override
    public boolean deleteCarById(int id) throws Exception {

        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> {
            carRepository.delete(car);
            return true;
        }).orElse(false);

    }

    @Override
    public boolean addCar(CarDetailDto carDetailDto) throws Exception {
        Car car = new Car();
        car.setMake(carDetailDto.make());
        car.setModel(carDetailDto.model());
        car.setYear(carDetailDto.year());
        car.setLicensePlate(carDetailDto.licensePlate());
        car.setOwnerName(carDetailDto.ownerName());
        car.setOwnerContact(carDetailDto.ownerContact());
        car.setColor(carDetailDto.color());
        carRepository.save(car);
        return true;
    }
}
