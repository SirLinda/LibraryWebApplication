package com.application.library.service;

import com.application.library.entity.Publisher;
import com.application.library.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    public List<Publisher> findAllPublishers(){
        return publisherRepository.findAll();
    }

    public Publisher findPublisherById(Long publisherId){
        Publisher publisher;
        publisher = publisherRepository.findById(publisherId)
                .orElseThrow(()->new RuntimeException("Publisher not found"));
        return publisher;
    }

    public void createPublisher(Publisher publisher){
        publisherRepository.save(publisher);
    }

    public void updatePublisher(Publisher publisher){
        publisherRepository.save(publisher);
    }

    public void deletePublisherById(Long publisherId){
        Publisher publisher;
        publisher = publisherRepository.findById(publisherId)
                .orElseThrow(()->new RuntimeException("Publisher not found"));
        publisherRepository.delete(publisher);
        //publisherRepository.deleteById(publisher.getId());
    }
}
