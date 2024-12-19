package com.example.addonservices.service;

import org.springframework.stereotype.Service;
import com.example.addonservices.model.AddonService;
import com.example.addonservices.repository.AddonServiceRepository;
import java.util.List;

@Service
public class AddonServiceService {
    private final AddonServiceRepository repository;

    public AddonServiceService(AddonServiceRepository repository) {
        this.repository = repository;
    }

    public AddonService addAddon(AddonService addon) {
        return repository.save(addon);
    }

    public List<AddonService> getAllAddons() {
        return repository.findAll();
    }

    public AddonService updateAddon(Long id, AddonService addonDetails) {
        AddonService addon = repository.findById(id).orElseThrow();
        addon.setName(addonDetails.getName());
        addon.setDescription(addonDetails.getDescription());
        addon.setPrice(addonDetails.getPrice());
        return repository.save(addon);
    }

    public void deleteAddon(Long id) {
        repository.deleteById(id);
    }
}
