package com.gordons.urlshortener.controllers;

import com.gordons.urlshortener.models.URLData;
import com.gordons.urlshortener.services.URLService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {
  private URLService urlService;

  @Value("${baseURL}")
  private String baseURL;

  @Autowired
  public WebController(URLService urlService) {
    this.urlService = urlService;
  }

  @GetMapping("/login")
  public String renderLoginpage() {
    return "login";
  }

  @GetMapping("/")
  public String renderHomepage() {
    return "home";
  }

  @GetMapping("/home")
  public String renderMainpage() {
    return "home";
  }

  @GetMapping("/history")
  public String renderHistorypage(Model model) {
    model.addAttribute("urlList", urlService.findAll());
    return "history";
  }

  @PostMapping("/shorten")
  public String shortenURL(Model model, @RequestParam String pastedURL) {
    String shortURL = urlService.addURL(pastedURL);
    model.addAttribute("shortURL", baseURL+shortURL);
    String longURL = urlService.findId(shortURL);
    model.addAttribute("longURL", longURL);
    return "shortened";
  }

  @GetMapping("/{id}")
  public String searchID(@PathVariable String id, Model model) {
    String longURL = urlService.findId(id);
    return "redirect:"+longURL;
  }

  @GetMapping("/delete/{id}")
  public String deleteID(@PathVariable String id, Model model) {
    List<URLData> urlList = urlService.deleteId(id);
    model.addAttribute("urlList", urlList);
    return "history";
  }

}
