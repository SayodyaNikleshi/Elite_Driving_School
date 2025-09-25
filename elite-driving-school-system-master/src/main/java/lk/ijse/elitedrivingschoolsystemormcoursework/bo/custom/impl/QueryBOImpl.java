package lk.ijse.elitedrivingschoolsystemormcoursework.bo.custom.impl;

import lk.ijse.elitedrivingschoolsystemormcoursework.bo.custom.QueryBO;
import lk.ijse.elitedrivingschoolsystemormcoursework.dao.DAOFactory;
import lk.ijse.elitedrivingschoolsystemormcoursework.dao.DAOTypes;
import lk.ijse.elitedrivingschoolsystemormcoursework.dao.custom.QueryDAO;

public class QueryBOImpl implements QueryBO {
    private final QueryDAO queryDAO = (QueryDAO) DAOFactory.getInstance().getDAO(DAOTypes.QUERY);
    @Override
    public double getTotalCourseAmountByStudentId(String studentId) throws Exception {
        return queryDAO.getTotalCourseAmountByStudentId(studentId);
}

}
