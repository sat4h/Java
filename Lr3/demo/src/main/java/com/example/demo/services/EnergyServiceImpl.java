package com.example.demo.services;

import com.example.demo.model.entity.Energy;
import com.example.demo.repository.EnergyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EnergyServiceImpl implements IService<Energy> {

    private final EnergyRepository energyRepository;

    @Autowired
    public EnergyServiceImpl(EnergyRepository energyRepository) {
        this.energyRepository = energyRepository;
    }

    @Override
    public Iterable<Energy> all() {
        return energyRepository.findAll();
    }

    @Override
    public Energy add(Energy entity) {
        return energyRepository.save(entity);
    }

    @Override
    public void delete(Energy entity) {
        energyRepository.delete(entity);
    }

    @Override
    public void edit(Energy entity) {
        Energy en = energyRepository.findById(entity.getId()).get();
        en.setCost(entity.getCost());
        en.setRate(entity.getCost());
        en.setTitle(en.getTitle());
    }

    @Override
    public Energy getById(int id) {
        return energyRepository.findById(id).get();
    }
}
