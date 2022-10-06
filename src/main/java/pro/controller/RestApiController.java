package pro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pro.dao.Student;
import pro.repository.StudentRepository;
import pro.service.StudentService;

@RestController
@RequestMapping("/Api")
public class RestApiController {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private StudentService studentService;

	@PostMapping("/addStudent")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) throws Exception {
		return new ResponseEntity<Student>(studentService.addStudent(student), HttpStatus.OK);
	}

	@GetMapping("/getStudentData")
	public ResponseEntity<List<Student>> getAllStudents() {
		return new ResponseEntity<List<Student>>(studentRepository.findAll(), HttpStatus.OK);
	}

	@GetMapping("/getStudent")
	public ResponseEntity<Student> getStudent(@RequestParam Long id) throws Exception {
		return new ResponseEntity<Student>(studentService.getStudentById(id), HttpStatus.OK);
	}

}
