/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ctrl;

import com.example.util.ShelveGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    private static final Logger LOG = Logger.getLogger(WebController.class.getName());

    @Autowired
    public WebController() {
    }

    @GetMapping("/books")
    public String getBooks(Model model) {
        List<String> shelves = new ArrayList<>();
        LOG.log(Level.INFO, "BOOKS page aufgerufen");

        for (int i = 0; i < 5; i++) {
            shelves.add(ShelveGenerator.generateRandomShelf());
        }

        model.addAttribute("shelves", shelves);

        return "books";
    }
}
