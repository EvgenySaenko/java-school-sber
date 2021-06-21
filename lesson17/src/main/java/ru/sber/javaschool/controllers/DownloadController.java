package ru.sber.javaschool.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sber.javaschool.services.DownloadService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/ringtones")
public class DownloadController {
    private final DownloadService downloadService;

    @PostMapping("/download")
    public String allSelectedUrls(Model model, @RequestParam(name = "urls", required = false) List<Long> urlId) {
        if (urlId == null) {
            return "error";
        }
        //model.addAttribute("urls", downloadService.getSelected(urlId));
        model.addAttribute("urls", downloadService.uploadFiles(urlId));
        return "completed";
    }


    @GetMapping("/all")
    public String allUrls(Model model) {
        model.addAttribute("urls", downloadService.getUrls());
        return "ringtones";
    }

}
