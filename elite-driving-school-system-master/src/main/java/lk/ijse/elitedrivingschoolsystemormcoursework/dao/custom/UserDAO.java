package lk.ijse.elitedrivingschoolsystemormcoursework.dao.custom;

import lk.ijse.elitedrivingschoolsystemormcoursework.dao.CrudDAO;
import lk.ijse.elitedrivingschoolsystemormcoursework.entity.User;

public interface UserDAO extends CrudDAO<User> {
    User getUserByUsername(String inputUsername);
}
