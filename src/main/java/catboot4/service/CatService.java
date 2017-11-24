package catboot4.service;


import catboot4.model.Cat;
import catboot4.repository.CatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by USER on 06.11.2017.
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CatService {
    @Autowired
    CatRepository catRepository;
    public Cat create(Cat cat) {
    return catRepository.save(cat);
    }

    public Cat fetchById(int id) {
        return catRepository.findOne(id);
    }


    public void deleteById(int id) {
     catRepository.delete(id);
    }

    public List<Cat> catList() {
        return (List<Cat>) catRepository.findAll();
    }



}
