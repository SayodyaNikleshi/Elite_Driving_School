package lk.ijse.elitedrivingschoolsystemormcoursework.bo.custom;

import lk.ijse.elitedrivingschoolsystemormcoursework.bo.SuperBO;
import lk.ijse.elitedrivingschoolsystemormcoursework.dto.InstructorsDTO;
import lk.ijse.elitedrivingschoolsystemormcoursework.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface InstructorsBO extends SuperBO {
    List<InstructorsDTO> getAllInstructors() throws Exception;

    String getLastInstructorId() throws Exception;

    boolean saveInstructors(InstructorsDTO t) throws Exception;

    boolean updateInstructors(InstructorsDTO t) throws Exception;

    boolean deleteInstructors(String id) throws Exception;

    List<String> getAllInstructorIds() throws Exception;

    Optional<InstructorsDTO> findByInstructorId(String id) throws Exception;

    String generateNewInstructorsId();
}
