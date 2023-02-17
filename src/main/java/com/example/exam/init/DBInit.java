//package com.example.exam.init;
//
//import com.example.exam.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//@Component
//@Transactional
//public class DBInit implements CommandLineRunner {

//      private final UserService userService;
////    private final MoodService moodService;
////    private final PostService postService;
//
//    @Autowired
//    public DBInit(MoodService moodService, UserService userService, PostService postService) {
//        this.moodService = moodService;
//        this.userService = userService;
//        this.postService = postService;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        this.userService.initUsersDB();
//        this.moodService.initMoodDB();
//        this.postService.initPostDB();
//
//    }
//}
