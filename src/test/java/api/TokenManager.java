package api;

public class TokenManager {


    private static String accessToken;

    public static void setToken(String token) {
        accessToken = token;
    }

    public static String getToken() {
        return accessToken;
    }
}
