package com.very.first.spring.confernecedemo.controller;

import com.very.first.spring.confernecedemo.model.Session;
import com.very.first.spring.confernecedemo.model.Speaker;
import com.very.first.spring.confernecedemo.repositories.SessionsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/sessions")
public class SessionsController {
    @Autowired
    private SessionsRepository sessionsRepository;

    @GetMapping
    public List<Session> getSessions(){
        return sessionsRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id){
        return sessionsRepository.getOne(id);
    }

    @PostMapping
    public Session create(@RequestBody final Session session){
        return sessionsRepository.saveAndFlush(session);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        sessionsRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody Session session){
        Session existingSession = sessionsRepository.getOne(id);
        BeanUtils.copyProperties(session,existingSession,"session_id");
        return sessionsRepository.saveAndFlush(existingSession);
    }
}
