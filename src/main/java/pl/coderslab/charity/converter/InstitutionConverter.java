package pl.coderslab.charity.converter;

import org.springframework.stereotype.Component;
import pl.coderslab.charity.entity.Institution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.charity.repositories.InstitutionRepository;



public class InstitutionConverter implements Converter<String, Institution>{
    @Autowired
    private InstitutionRepository institutionRepository;

    @Override
    public Institution convert(String id) {
        return institutionRepository.getOne(Long.parseLong(id));
    }

}
