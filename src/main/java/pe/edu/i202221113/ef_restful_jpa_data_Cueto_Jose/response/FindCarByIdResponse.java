package pe.edu.i202221113.ef_restful_jpa_data_Cueto_Jose.response;

import pe.edu.i202221113.ef_restful_jpa_data_Cueto_Jose.dto.CarDetailDto;

public record FindCarByIdResponse(String code,
                                  String error,
                                  CarDetailDto car) {
}
