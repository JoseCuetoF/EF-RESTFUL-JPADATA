package pe.edu.i202221113.ef_restful_jpa_data_Cueto_Jose.dto;

public record CarDetailDto(Integer id,
                           String make,
                           String model,
                           String licensePlate,
                           int year,
                           String ownerName,
                           String ownerContact,
                           String color) {
}
