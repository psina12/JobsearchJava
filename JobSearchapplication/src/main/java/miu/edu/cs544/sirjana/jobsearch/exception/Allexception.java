package miu.edu.cs544.sirjana.jobsearch.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class Allexception extends RuntimeException{

    public Allexception(String message)
    {
        super(message);

    }

    public Allexception(int id)
    {
        super("Id not Found"+id);

    }
}
