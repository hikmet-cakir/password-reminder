package command;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import entity.User;

import util.FileUtil;
import util.Interaction;

public class CreateUserCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Please enter the credential informations for save process");
        String[] credentialInformations = Interaction.takeCredentialInformations();

        ObjectMapper mapper = new ObjectMapper();
        User user = new User(credentialInformations[0], credentialInformations[1]);
        try {
            String rawUser = mapper.writeValueAsString(user);
            FileUtil.writeToUserFile(rawUser);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
