package si.damjanh.springpetclinic.formatters;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import si.damjanh.springpetclinic.model.PetType;
import si.damjanh.springpetclinic.services.PetTypeService;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

@Component
public class PetTypeFormatter implements Formatter<PetType> {

    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        Collection<PetType> petTypes = petTypeService.findAll();
        return petTypes.stream().filter(p -> p.getName().equals(text)).findFirst().orElse(PetType.builder().name("test").build());
                //.orElseThrow(() -> new ParseException("Type not found for: " + text, 0));
    }

    @Override
    public String print(PetType object, Locale locale) {
        return object.getName();
    }
}
