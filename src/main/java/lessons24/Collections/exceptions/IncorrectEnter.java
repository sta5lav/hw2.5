package lessons24.Collections.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class IncorrectEnter extends RuntimeException{
    public IncorrectEnter(String message) {
        super(message);
    }
}
