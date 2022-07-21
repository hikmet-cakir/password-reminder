package security;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.User;
import util.FileUtil;

public class Authentication {
    public static boolean hasAccess(String... credentialInformations) {
        String username = credentialInformations[0];
        String password = credentialInformations[1];

        String userInformation = FileUtil.readUserInformation();
        ObjectMapper mapper = new ObjectMapper();
        try {
            User user = mapper.readValue(userInformation, User.class);
            return user.getUsername().equals(username)
                    && user.getPassword().equals(password);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean hasUser() {
        String user = FileUtil.readUserInformation();
        return !user.isBlank();
    }
}
