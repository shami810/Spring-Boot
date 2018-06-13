package com.springDemo.Courses;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
		
	public List<Course> getAllCourses(String id){
		//return topics;
		List<Course> course = new ArrayList<>();
		courseRepository.findByTopicId(id).forEach(course::add);
		return course;
	}
	
	public Optional<Course> getCourses(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return courseRepository.findById(id);
	}
	
	public void addCourses(Course topic) {
		//topics.add(topic);
		courseRepository.save(topic);
	}
	
	public void updateCourses(Course topic) {
//		for(int i = 0; i<topics.size(); i++) {
//			Topic t = topics.get(i);
//			if(t.getId().equals(id)) {
//				topics.set(i, topic);
//				return;
//			}
//		}
		courseRepository.save(topic); //this methid does uodate and save all together by looking for id first
	}

	public void deleteCourses(String id) {
		//topics.removeIf(t -> t.getId().equals(id));
		courseRepository.deleteById(id);
	}
}
