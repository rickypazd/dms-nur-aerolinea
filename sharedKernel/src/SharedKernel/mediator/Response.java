package SharedKernel.mediator;

import com.google.gson.Gson;

public class Response<T> {
    public T data;
    public int status;
    public Exception exception;

    public boolean hasException() {
        return exception != null;
    }
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
