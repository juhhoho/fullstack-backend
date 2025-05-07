package _2025.fullstack.backend.common.apiPayload.failure.customException;

public class UserException {
    public static class UserIdNotExistException extends RuntimeException{}
    public static class UsernameNotExistException extends RuntimeException{}
    public static class UsernameAlreadyExistException extends RuntimeException{}
    public static class PasswordNotValidException extends RuntimeException{}
    public static class RefreshTokenNotValidException extends RuntimeException{}
}
