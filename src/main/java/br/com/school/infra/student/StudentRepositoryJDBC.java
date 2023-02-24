package br.com.school.infra.student;

import br.com.school.domain.student.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentRepositoryJDBC implements StudentRepository {

    private final Connection connection;

    public StudentRepositoryJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void register(Student student) {
        String sql = "INSERT INTO STUDENT VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, student.getCpf());
            ps.setString(2, student.getName());
            ps.setString(3, student.getEmail());
            ps.execute();

            sql = "INSERT INTO TELEPHONE VALUES (?, ?)";
            ps = connection.prepareStatement(sql);
            for (Telephone telephone : student.getTelephones()) {
                ps.setString(1, telephone.getDdd());
                ps.setString(2, telephone.getNumber());
                ps.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Student findByCpf(Cpf cpf) {
        try {
            String sql = "SELECT id, name, email FROM STUDENT WHERE cpf = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cpf.getCpf());


            ResultSet rs = ps.executeQuery();
            boolean isStudent = rs.next();

            if (!isStudent) {
                throw new StudentNotFound(cpf);
            }

            String name = rs.getString("name");
            Email email = new Email(rs.getString("email"));

            Student student = new Student(name, email, cpf);

            Long id = rs.getLong("id");
            sql = "SELECT ddd, number FROM TELEPHONE WHERE student_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                String number = rs.getString("number");
                String ddd = rs.getString("ddd");
                student.addTelephone(ddd, number);
            }
            return student;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> findAll() {
        return null;
    }
}
