package lk.ijse.elitedrivingschoolsystemormcoursework.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class UserDTO {

    private String userId;
    private String userName;
    private String password;
    private String role;
    private String email;
    private String status;

}
