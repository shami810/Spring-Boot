package com.springDemo.topic;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> 
{
	//get all topics
	//get topic given an id
	//update topic which takes a topic id
	//delete topic using id
}
