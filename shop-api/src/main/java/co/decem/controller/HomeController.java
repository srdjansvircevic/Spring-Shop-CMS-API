package co.decem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.decem.model.dto.HomepageDTO;
import co.decem.service.HomeService;

@RestController
@RequestMapping("/api/pages/home")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping()
    public HomepageDTO getHome() {
        return homeService.getHomePageData();
    }
    
}
