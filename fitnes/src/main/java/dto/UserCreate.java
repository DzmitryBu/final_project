package dto;

import util.UserRole;
import util.UserStatus;
import java.time.LocalDateTime;
import java.util.UUID;

public class UserCreate {

    private UUID uuid;

    private LocalDateTime dt_create;

    private LocalDateTime dt_update;

    private String mail;

    private String fio;

    private UserRole role;

    private UserStatus status;
    private String password;


    public UserCreate(UUID uuid, LocalDateTime dt_create, LocalDateTime dt_update, String mail,
                      String fio, UserRole role, UserStatus status, String password) {
        this.uuid = uuid;
        this.dt_create = dt_create;
        this.dt_update = dt_update;
        this.mail = mail;
        this.fio = fio;
        this.role = UserRole.USER;
        this.status = status;
        this.password = password;
    }
}
