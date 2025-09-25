package lk.ijse.elitedrivingschoolsystemormcoursework.bo.custom;

import lk.ijse.elitedrivingschoolsystemormcoursework.bo.SuperBO;

public interface QueryBO extends SuperBO {
    double getTotalCourseAmountByStudentId(String studentId) throws Exception;

}
