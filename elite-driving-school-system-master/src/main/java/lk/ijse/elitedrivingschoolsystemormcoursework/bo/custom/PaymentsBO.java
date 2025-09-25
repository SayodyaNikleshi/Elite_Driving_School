package lk.ijse.elitedrivingschoolsystemormcoursework.bo.custom;

import lk.ijse.elitedrivingschoolsystemormcoursework.bo.SuperBO;
import lk.ijse.elitedrivingschoolsystemormcoursework.dto.PaymentsDTO;
import lk.ijse.elitedrivingschoolsystemormcoursework.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface PaymentsBO extends SuperBO {
    List<PaymentsDTO> getAllPayments() throws Exception;

    String getLastPaymentId() throws Exception;

    boolean savePayments(PaymentsDTO t) throws Exception;

    boolean updatePayments(PaymentsDTO t) throws Exception;

    boolean deletePayments(String id) throws Exception;

    List<String> getAllPaymentIds() throws Exception;

    Optional<PaymentsDTO> findByPaymentId(String id) throws Exception;

    String generateNewPaymentId();
}
