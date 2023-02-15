package service.api;

import dto.*;

import java.util.UUID;

public interface IUserService {

    void add (UserCreate userCreate);

    PageOfUser getPageUsers(int page, int size);

    void updateUser(UUID uuid, String dt_update, UserCreate userCreate);
    void addUser(UserRegistration userRegistration);

    void verification(String code);

    void loging(UserLogin userLogin);

    User getCard(UUID uuid);

}
