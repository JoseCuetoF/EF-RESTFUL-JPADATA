package pe.edu.i202221113.ef_restful_jpa_data_Cueto_Jose.response;

import pe.edu.i202221113.ef_restful_jpa_data_Cueto_Jose.dto.CarDto;

public record FindCarsResponse(String code,
                               String error,
                               Iterable<CarDto> cars) {
}
