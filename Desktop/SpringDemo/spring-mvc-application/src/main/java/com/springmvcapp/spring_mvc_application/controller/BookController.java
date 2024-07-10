package com.springmvcapp.spring_mvc_application.controller;

import com.springmvcapp.spring_mvc_application.model.BookModel;
import com.springmvcapp.spring_mvc_application.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    @GetMapping
    public String getBookPage(@RequestParam(required = false, name = "login") String login,
                              @RequestParam(required = false) String email,
                              Model model){
        model.addAttribute("userLogin",login);


        List<BookModel> books = bookService.getAllBooksByLogin(login);

        model.addAttribute("userBooks",books);

        return "book_page";
    }
}
