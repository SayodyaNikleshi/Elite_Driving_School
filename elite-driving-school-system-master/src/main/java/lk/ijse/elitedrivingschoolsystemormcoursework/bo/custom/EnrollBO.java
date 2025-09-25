package lk.ijse.elitedrivingschoolsystemormcoursework.bo.custom;

import lk.ijse.elitedrivingschoolsystemormcoursework.bo.SuperBO;
import lk.ijse.elitedrivingschoolsystemormcoursework.dto.StudentsDTO;

public interface EnrollBO extends SuperBO {
    public boolean saveStudents(StudentsDTO dto) throws Exception;
    public boolean updateStudents(StudentsDTO dto) throws Exception;
}
