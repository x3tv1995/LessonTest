package ru.maksmusic.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class TaskServiceTest {

    private TaskService taskService =  new TaskService();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }



    @Test
    void getTasksByMaxLength() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("12");
        list.add("123");
        list.add("1234");
        list.add("12345");
        list.add("123456");
        list.add("1234567");
        list.add("12345678");

        List<String> resultList = new ArrayList<>();
        resultList.add("1");
        resultList.add("12");
        resultList.add("123");
        resultList.add("1234");

        Assertions.assertIterableEquals(resultList,taskService.getTasksByMaxLength(list, 5));
    }

    @Test
    void getTasksWithLength() {
        List<String> list = new ArrayList<>();
        list.add("123");

        List<String> resultList = new ArrayList<>();
        resultList.add("123"+" "+3);
        Assertions.assertEquals(resultList,taskService.getTasksWithLength(list));
    }

    @Test
    void getTaskByKeyword() {
        List<String> listTask = new ArrayList<>();
        listTask.add("1");
        listTask.add("2");
        listTask.add("1");

        List<String> resultList = new ArrayList<>();
        resultList.add("1");
        resultList.add("1");
        Assertions.assertEquals(resultList, taskService.getTaskByKeyword(listTask, "1"));

    }




    @Test
    void searchTask() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("12");
        list.add("123");
        list.add("1234");
        list.add("12345");
        list.add("123456");
        list.add("1234567");
        list.add("12345678");


        boolean resultTrue = taskService.searchTask(list, "123");
        Assertions.assertTrue(resultTrue);
        Assertions.assertFalse(taskService.searchTask(list, "1233"));


    }
}