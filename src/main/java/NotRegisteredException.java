public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String name) {
        super("Геймер с ником '" + name + "' не найден");
    }
}