package com.very.first.spring.confernecedemo.controller;

import com.very.first.spring.confernecedemo.model.Session;
import com.very.first.spring.confernecedemo.model.Speaker;
import com.very.first.spring.confernecedemo.repositories.SessionsRepository;
import com.very.first.spring.confernecedemo.repositories.SpeakersRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/speakers")
public class SpeakersController {
    @Autowired
    private SpeakersRepository speakersRepository;

    @GetMapping
    public List<Speaker> getSessions(){
        return speakersRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id){
        return speakersRepository.getOne(id);
    }

    @PostMapping
    public Speaker create(@RequestBody Speaker speaker){
        return speakersRepository.saveAndFlush(speaker);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        speakersRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Speaker update(@PathVariable Long id, @RequestBody Session session){
        Speaker existingSpeaker = speakersRepository.getOne(id);
        BeanUtils.copyProperties(session,existingSpeaker,"session_id");
        return speakersRepository.saveAndFlush(existingSpeaker);
    }
}
