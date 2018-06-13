package com.springDemo.topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicSrvice {
	
	@Autowired
	private TopicRepository topicRepository;
		
	public List<Topic> getAllTopics(){
		//return topics;
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics::add); //this inbuilt method gets all the data from database
		return topics;
	}
	
	public Optional<Topic> getTopic(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		
		return topicRepository.findById(id);
	}
	
	public void addtopic(Topic topic) {
		//topics.add(topic);
		topicRepository.save(topic);
	}
	
	public void updateTopic(Topic topic, String id) {
//		for(int i = 0; i<topics.size(); i++) {
//			Topic t = topics.get(i);
//			if(t.getId().equals(id)) {
//				topics.set(i, topic);
//				return;
//			}
//		}
		topicRepository.save(topic); //this methid does uodate and save all together by looking for id first
	}

	public void deleteTopic(String id) {
		//topics.removeIf(t -> t.getId().equals(id));
		topicRepository.deleteById(id);
	}
}
