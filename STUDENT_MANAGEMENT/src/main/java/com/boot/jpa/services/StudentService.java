package com.boot.jpa.services;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.boot.jpa.model.Student;
import com.boot.jpa.dao.StudentRepository;
 
import java.util.List;
import java.util.Optional;
 
@Service
public class StudentService {
 
    private final StudentRepository studentRepository;
 
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
 
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
 
    public Student getStudentById(Integer id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        return optionalStudent.orElse(null);
    }
 
    public void addStudent(Student student) {
        studentRepository.save(student);
    }
 
//    public void updateStudent(Student student) {
//        // Check if the student with the given ID exists
//        Optional<Student> optionalExistingStudent = studentRepository.findById(student.getSid());
// 
//        if (optionalExistingStudent.isPresent()) {
//            // Update the existing student
//            Student existingStudent = optionalExistingStudent.get();
//            existingStudent.setfName(student.getfName());
//            existingStudent.setlName(student.getlName());
//            existingStudent.setEmail(student.getEmail());
//            existingStudent.setAge(student.getAge());
//            existingStudent.setCourse(student.getCourse());
//            studentRepository.save(existingStudent);
//        }
//        // Handle the case where the student with the given ID doesn't exist (optional)
//    }
    
    public void updateStudentDetails(Student updatedStudent) {
        studentRepository.save(updatedStudent);
    }
 
    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }
    public boolean studentExists(Integer studentId) {
        return studentRepository.existsById(studentId);
    }
}

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.boot.jpa.dao.StudentRepository;
//import com.boot.jpa.model.Student;
// 
//import java.util.List;
//import java.util.Optional;
// 
//@Service
//public class StudentService {
// 
//    private final StudentRepository studentRepository;
// 
//    @Autowired
//    public StudentService(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }
// 
//    public List<Student> getAllStudents() {
//        return studentRepository.findAll();
//    }
// 
//    public Student getStudentById(int studentId) {
//        return studentRepository.findById(studentId).orElse(null);
//    }
//    
//    public List<Student> getStudentsByFname(String name) {
//		return studentRepository.findStudentsByfName(name);
//	}
//    public void saveStudent(Student student) {
//        studentRepository.save(student);
//    }
// 
//    public void deleteStudent(int studentId) {
//        studentRepository.deleteById(studentId);
//    }
//
//    public String updateStudent(int studentId, Student updatedStudent) {
//        Optional<Student> existingStudent = studentRepository.findById(studentId);
// 
//        if (existingStudent.isPresent()) {
//            Student student = existingStudent.get();
//            student.setfName(updatedStudent.getfName());
//            student.setlName(updatedStudent.getlName());
//            student.setEmail(updatedStudent.getEmail());
//            student.setAge(updatedStudent.getAge());
//            student.setCourse(updatedStudent.getCourse());
//            studentRepository.save(student);
//            return updatedStudent+" updated successfully";
//        } else {
//            return "Student not found";
//        }
//    }
//
//	public List<Student> saveStudents(List<Student> students) {
//		return studentRepository.saveAll(students);
//	}
//}