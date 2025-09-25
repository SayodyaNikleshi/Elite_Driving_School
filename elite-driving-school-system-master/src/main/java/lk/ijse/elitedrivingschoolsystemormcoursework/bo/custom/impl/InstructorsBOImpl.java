package lk.ijse.elitedrivingschoolsystemormcoursework.bo.custom.impl;

import lk.ijse.elitedrivingschoolsystemormcoursework.bo.custom.InstructorsBO;
import lk.ijse.elitedrivingschoolsystemormcoursework.bo.exception.DuplicateException;
import lk.ijse.elitedrivingschoolsystemormcoursework.bo.exception.NotFoundException;
import lk.ijse.elitedrivingschoolsystemormcoursework.bo.util.EntityDTOConverter;
import lk.ijse.elitedrivingschoolsystemormcoursework.dao.DAOFactory;
import lk.ijse.elitedrivingschoolsystemormcoursework.dao.DAOTypes;
import lk.ijse.elitedrivingschoolsystemormcoursework.dao.custom.InstructorsDAO;
import lk.ijse.elitedrivingschoolsystemormcoursework.dto.InstructorsDTO;
import lk.ijse.elitedrivingschoolsystemormcoursework.entity.Instructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InstructorsBOImpl implements InstructorsBO {

    private final InstructorsDAO instructorsDAO = (InstructorsDAO) DAOFactory.getInstance().getDAO(DAOTypes.INSTRUCTORS);
    private final EntityDTOConverter converter = new EntityDTOConverter();

    @Override
    public List<InstructorsDTO> getAllInstructors() throws Exception {
        List<Instructors> instructorsList = instructorsDAO.getAll();
        List<InstructorsDTO> instructorsDTOList = new ArrayList<>();
        for (Instructors instructors : instructorsList) {
            instructorsDTOList.add(converter.getInstructorsDTO(instructors));
        }
        return instructorsDTOList;
    }

    @Override
    public String getLastInstructorId() throws Exception {
        return  instructorsDAO.getLastId();
    }

    @Override
    public boolean saveInstructors(InstructorsDTO t) throws Exception {
        Optional<Instructors> instructors = instructorsDAO.findById(t.getInstructor_id());
        if (instructors.isPresent()) {
            throw new DuplicateException("Instructor already exists");
        }
        return instructorsDAO.save(converter.getInstructorsEntity(t));
    }

    @Override
    public boolean updateInstructors(InstructorsDTO t) throws Exception {
        Optional<Instructors> instructors = instructorsDAO.findById(t.getInstructor_id());
        if (instructors.isEmpty()) {
            throw new NotFoundException("Instructor not found");
        }
        return instructorsDAO.update(converter.getInstructorsEntity(t));
    }

    @Override
    public boolean deleteInstructors(String id) throws Exception {
        Optional<Instructors> instructors = instructorsDAO.findById(id);
        if (instructors.isEmpty()) {
            throw new NotFoundException("Instructor not found");
        }
        return instructorsDAO.delete(id);
    }

    @Override
    public List<String> getAllInstructorIds() throws Exception {
        return instructorsDAO.getAllIds();
    }

    @Override
    public Optional<InstructorsDTO> findByInstructorId(String id) throws Exception {

        Optional<Instructors> instructors = instructorsDAO.findById(id);
        if (instructors.isPresent()) {
            return Optional.of(converter.getInstructorsDTO(instructors.get()));
        }
        return Optional.empty();
    }

    @Override
    public String generateNewInstructorsId() {
        return instructorsDAO.generateNewId();
    }
}
