package lk.ijse.elitedrivingschoolsystemormcoursework.bo.custom.impl;

import lk.ijse.elitedrivingschoolsystemormcoursework.bo.custom.CourseBO;
import lk.ijse.elitedrivingschoolsystemormcoursework.bo.exception.DuplicateException;
import lk.ijse.elitedrivingschoolsystemormcoursework.bo.exception.NotFoundException;
import lk.ijse.elitedrivingschoolsystemormcoursework.dao.DAOFactory;
import lk.ijse.elitedrivingschoolsystemormcoursework.dao.DAOTypes;
import lk.ijse.elitedrivingschoolsystemormcoursework.dao.custom.CourseDAO;
import lk.ijse.elitedrivingschoolsystemormcoursework.dto.CourseDTO;
import lk.ijse.elitedrivingschoolsystemormcoursework.entity.Course;
import lk.ijse.elitedrivingschoolsystemormcoursework.bo.util.EntityDTOConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourseBOImpl implements CourseBO {
    private final CourseDAO courseDAO = (CourseDAO) DAOFactory.getInstance().getDAO(DAOTypes.COURSE);
    private final EntityDTOConverter converter = new EntityDTOConverter();

    @Override
    public List<CourseDTO> getAllCourses() throws Exception {
        List<Course> courses = courseDAO.getAll();
        List<CourseDTO> courseDTOS = new ArrayList<>();
        for (Course course : courses) {
            courseDTOS.add(converter.getCourseDTO(course));
        }
        return courseDTOS;
    }

    @Override
    public String getLastCourseId() throws Exception {
        return courseDAO.getLastId();
    }

    @Override
    public boolean saveCourses(CourseDTO t) throws Exception {
        Optional<Course> course = courseDAO.findById(t.getCourse_id());
        if (course.isPresent()) {
            throw new DuplicateException("Course already exists");
        }
        return courseDAO.save(converter.getCourseEntity(t));
    }

    @Override
    public boolean updateCourses(CourseDTO t) throws Exception {
        Optional<Course> course = courseDAO.findById(t.getCourse_id());
        if (course.isEmpty()) {
            throw new NotFoundException("Course not found");
        }
        return courseDAO.update(converter.getCourseEntity(t));
    }

    @Override
    public boolean deleteCourses(String id) throws Exception {
        Optional<Course> course = courseDAO.findById(id);
        if (course.isEmpty()) {
            throw new NotFoundException("Course not found");
        }
        return courseDAO.delete(id);
    }

    @Override
    public List<String> getAllCourseIds() throws Exception {
        return courseDAO.getAllIds();
    }

    @Override
    public Optional<CourseDTO> findByCourseId(String id) throws Exception {
        Optional<Course> course = courseDAO.findById(id);
        if (course.isPresent()) {
            return Optional.of(converter.getCourseDTO(course.get()));
        }
        return Optional.empty();
    }

    @Override
    public String generateNewCourseId() {
        return courseDAO.generateNewId();
    }
}