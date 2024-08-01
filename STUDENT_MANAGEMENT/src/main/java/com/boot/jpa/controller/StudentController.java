package com.boot.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.boot.jpa.model.Student;
import com.boot.jpa.services.StudentService;
 
import java.util.List;
 
@Controller
@CrossOrigin(origins="http://localhost:8080")
public class StudentController {
 
    private final StudentService studentService;
 
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
 
//    @GetMapping("/")
//    public String showStudentList(Model model) {
//        List<Student> students = studentService.getAllStudents();
//        model.addAttribute("students", students);
//        model.addAttribute("newStudent", new Student()); // for the add student form
//        model.addAttribute("editedStudent", new Student()); // for the edit student form
//        model.addAttribute("deletedStudent", new Student()); // for the delete student form
//        return "index";
//    }
    
    @GetMapping("/")
    public String showStudentList(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        model.addAttribute("newStudent", new Student()); // for the add student form
        model.addAttribute("updateStudent", new Student()); // for the update student form
        model.addAttribute("deleteStudent", new Student()); // for the delete student form
        return "index";
    }
 
    @PostMapping("/addStudent")
    public String addStudent(@ModelAttribute Student newStudent) {
        studentService.addStudent(newStudent);
        return "redirect:/";
    }
    @PostMapping("/deleteStudent")
    public String deleteStudent(@ModelAttribute Student deleteStudent, Model model) {
        Integer studentId = deleteStudent.getSid();
        if (studentService.studentExists(studentId)) {
            studentService.deleteStudent(studentId);
        } else {
            model.addAttribute("deleteStudentError", "Student with ID " + studentId + " does not exist.");
        }
        return "redirect:/";  
    }
    @PostMapping("/updateStudent")
    public String updateStudent(@ModelAttribute Student updateStudent, Model model) {
        Integer studentId = updateStudent.getSid();
        if (studentService.studentExists(studentId)) {
            studentService.updateStudentDetails(updateStudent);
        } else {
            model.addAttribute("updateStudentError", "Student with ID " + studentId + " does not exist.");
        }
        return "redirect:/";
    }
// 
//    @PostMapping("/edit/{id}")
//    public String showEditForm(@PathVariable Integer id, Model model) {
//        Student student = studentService.getStudentById(id);
//        model.addAttribute("editedStudent", student);
//        return "index";
//    }
// 
//    @PostMapping("/update")
//    public String updateStudent(@ModelAttribute Student editedStudent) {
//        studentService.updateStudent(editedStudent);
//        return "redirect:/";
//    }
// 
//    @PostMapping("/delete")
//    public String deleteStudent(@ModelAttribute Student deletedStudent) {
//        studentService.deleteStudent(deletedStudent.getSid());
//        return "redirect:/students";
//    }
}
















// 
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
// 
//import com.boot.jpa.model.Student;
//import com.boot.jpa.services.StudentService;
// 
//import java.util.List;
// 
//@RestController
//@RequestMapping("/students")
//public class StudentController {
// 
//    private final StudentService studentService;
// 
//    @Autowired
//    public StudentController(StudentService studentService) {
//        this.studentService = studentService;
//    }
// 
//    @GetMapping("/")
//    public String showStudentList(Model model) {
//        List<Student> students = studentService.getAllStudents();
//        model.addAttribute("students", students);
//        model.addAttribute("newStudent", new Student()); // for the add student form
//        return "index";
//    }
// 
//    @PostMapping("/students")
//    public String addStudent(@ModelAttribute Student newStudent) {
//        studentService.saveStudent(newStudent);
//        return "redirect:/";
//    }
////    @GetMapping("/getAllStudents")
////    public List<Student> getAllStudents() {
////        return studentService.getAllStudents();
////    }
//// 
////    @GetMapping("/getStudent/{id}")
////    public Student getStudentById(@PathVariable int id) {
////        return studentService.getStudentById(id);
////    }
////    
////    @GetMapping("/getStudents/{fname}")
////    public List<Student> getStudentByFname(@PathVariable String fname) {
////        return studentService.getStudentsByFname(fname);
////    }
//// 
////    @PostMapping("/saveStudent")
////    public String saveStudent(@RequestBody Student student) {
////        studentService.saveStudent(student);
////        return "Student data saved as : "+student;
////    }
////    
////    @PostMapping("/saveStudents")
////    public List<Student> saveStudents(@RequestBody List<Student> students) {
////        return studentService.saveStudents(students);
////    }
////    
////    @PutMapping("/updateStudent/{id}")
////    public String updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
////        String result = studentService.updateStudent(id, updatedStudent);
////        return result;
//////        if (result.equals("Student updated successfully")) {
//////            return updatedStudent;
//////        } else {
//////            return null;
//////        }
////    }
////    @DeleteMapping("/{id}")
////    public String deleteStudent(@PathVariable int id) {
////        studentService.deleteStudent(id);
////        return "Student deleted with id : " +id;
////    }
//}