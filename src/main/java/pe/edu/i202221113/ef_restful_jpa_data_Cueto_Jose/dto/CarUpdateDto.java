package pe.edu.i202221113.ef_restful_jpa_data_Cueto_Jose.dto;

public record CarUpdateDto(Integer id,
                           String make,
                           String model,
                           int year,
                           String licensePlate,
                           String ownerName,
                           String ownerContact,
                           String color) {
}
