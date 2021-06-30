//package pl.coderslab.charity.converter;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.convert.converter.Converter;
//import pl.coderslab.charity.entity.Category;
//import pl.coderslab.charity.repositories.CategoryRepository;
//
//
//public class CategoryConverter implements Converter<String, Category>{
//
//    @Autowired
//    private CategoryRepository categoryRepository;
//
//    @Autowired
//    public Category convert(String id) {
//        return categoryRepository.getOne(Long.parseLong(id));
//    }
//
//
//
//}
