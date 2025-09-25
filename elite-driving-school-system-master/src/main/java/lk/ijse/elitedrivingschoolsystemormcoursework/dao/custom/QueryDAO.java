package lk.ijse.elitedrivingschoolsystemormcoursework.dao.custom;

import lk.ijse.elitedrivingschoolsystemormcoursework.dao.SuperDAO;

public interface QueryDAO extends SuperDAO {
    public int getStudentCountForLesson(String lessonId);
    double getTotalCourseAmountByStudentId(String studentId) throws Exception;
}
