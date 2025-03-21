package in.sp.main.Controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ch.qos.logback.core.model.Model;
import in.sp.main.Repository.CourseRepository;
import in.sp.main.entity.Course;
import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {
	
	@Autowired
	private CourseRepository CourseRepo;
	
	@GetMapping("/hello")
	public String show(org.springframework.ui.Model model) {
		List<Course>list=CourseRepo.findAll();
		   model.addAttribute("list", list);
		return "Index";
	}
	
	@PostMapping("/addcourse")
	public String UplodImage(@RequestParam int id,@RequestParam String course_name,@RequestParam String course_detail, @RequestParam MultipartFile image,HttpSession session) {
	Course course=new Course();
	course.setId(id);
	course.setCourse_name(course_name);
	course.setCourse_detail(course_detail);
	course.setImage(image.getOriginalFilename());
	Course UploadImage=CourseRepo.save(course);
	
	if(UploadImage!=null) {
		try {
			File savefile=new ClassPathResource("static/imagefile").getFile();
			Path path=Paths.get(savefile.getAbsolutePath()+File.separator+course+image.getOriginalFilename());
			System.out.println(path);
			Files.copy(image.getInputStream(),path,StandardCopyOption.REPLACE_EXISTING);
		}
		catch(Exception e) {
		e.printStackTrace()	;
		}
	}
	session.setAttribute("msg","image uploaded successfully");
		return "redirect:/";
		
	}

}
