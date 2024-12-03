package ru.maksmusic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskService {


    public  List<String> getTasksByMaxLength(List<String> tasks,int lengthTask) {
        List<String> list =  tasks.stream()
                .filter(task -> task.length() < lengthTask)
                .collect(Collectors.toList());

        return list;
    }

    public  List<String> getTasksWithLength(List<String>tasks){
        return tasks.stream().map(s-> s + " " + s.length()).collect(Collectors.toList());

    }



    public   List<String> getTaskByKeyword(List<String>tasks,String keyword){
        return tasks.stream()
                .filter(s->s.contains(keyword))
                .limit(2)
                .collect(Collectors.toList());

    }

    public  boolean searchTask(List<String>tasks,String word){
        return tasks.stream()
                .anyMatch(str->str.equals(word));
    }











}
