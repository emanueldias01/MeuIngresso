package br.com.emanueldias.MeuIngresso.exceptions;

import br.com.emanueldias.MeuIngresso.dto.erro.ErrorDTO;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Configuration
@RestControllerAdvice
public class HandlerException {

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO notFoundElementException(NotFoundElementException ex){
        return new ErrorDTO(
                ex.getLancamento(),
                ex.getMessage()
        );
    }
}
