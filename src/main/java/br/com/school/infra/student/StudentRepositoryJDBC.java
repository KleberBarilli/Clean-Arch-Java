package br.com.school.infra.student;

import br.com.school.domain.student.Cpf;
import br.com.school.domain.student.Student;
import br.com.school.domain.student.StudentRepository;
import br.com.school.domain.student.Telephone;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
        return null;
    }

    @Override
    public List<Student> findAll() {
        return null;
    }
}
