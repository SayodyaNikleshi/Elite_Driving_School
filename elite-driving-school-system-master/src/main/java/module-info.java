module lk.ijse.elitedrivingschoolsystemormcoursework {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires static lombok;
    requires java.sql;
    requires jakarta.persistence;
    requires java.desktop;
    requires javafx.graphics;
    requires jbcrypt;
    requires java.naming;
    requires javafx.base;


    opens lk.ijse.elitedrivingschoolsystemormcoursework.config to jakarta.persistence;
    opens lk.ijse.elitedrivingschoolsystemormcoursework.entity to org.hibernate.orm.core;
    opens lk.ijse.elitedrivingschoolsystemormcoursework.controller to javafx.fxml;
    opens lk.ijse.elitedrivingschoolsystemormcoursework.dto.tm to javafx.base;

    exports lk.ijse.elitedrivingschoolsystemormcoursework;
}