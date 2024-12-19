package com.example.addonservices.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.addonservices.model.AddonService;
import com.example.addonservices.service.AddonServiceService;

@Controller
@RequestMapping("/addons")
public class AddonController {
    private final AddonServiceService service;

    public AddonController(AddonServiceService service) {
        this.service = service;
    }

    @GetMapping("/view")
    public String viewAllAddons(Model model) {
        model.addAttribute("addons", service.getAllAddons());
        return "addon/list";
    }

    @GetMapping("/new")
    public String createAddonForm(Model model) {
        model.addAttribute("addon", new AddonService());
        return "addon/add";
    }

    @PostMapping("/new")
    public String createAddon(@ModelAttribute AddonService addonService) {
        service.addAddon(addonService);
        return "redirect:/addons/view";
    }

    @GetMapping("/modify/{id}")
    public String modifyAddonForm(@PathVariable Long id, Model model) {
        model.addAttribute("addon", service.getAllAddons().stream()
                .filter(a -> a.getId().equals(id)).findFirst().orElse(null));
        return "addon/modify";
    }

    @PostMapping("/modify/{id}")
    public String modifyAddon(@PathVariable Long id, @ModelAttribute AddonService addonService) {
        service.updateAddon(id, addonService);
        return "redirect:/addons/view";
    }

    @GetMapping("/remove/{id}")
    public String removeAddon(@PathVariable Long id) {
        service.deleteAddon(id);
        return "redirect:/addons/view";
    }
  }
