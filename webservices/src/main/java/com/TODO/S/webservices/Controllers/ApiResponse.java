package com.TODO.S.webservices.Controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.TODO.S.webservices.TODOitem;

@Data
@AllArgsConstructor
public class ApiResponse<T> {
    private String message;
    private String  status;
    private T data ;
}
