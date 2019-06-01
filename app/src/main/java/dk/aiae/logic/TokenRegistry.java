package dk.aiae.logic;

import io.swagger.client.model.Token;

public class TokenRegistry {
    private static Token token;

    public TokenRegistry(){
    }

    /**
     * Adds the token to the variable
     * @param newToken The token to set
     */
    public static void addToken(Token newToken){
        token = newToken;
    }

    /**
     * Retrieves the token stored
     * @return The token stored
     */
    public static Token getToken(){
        return token;
    }
}
