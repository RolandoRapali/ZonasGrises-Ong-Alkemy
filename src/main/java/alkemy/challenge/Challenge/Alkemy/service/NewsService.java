package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.model.News;
import alkemy.challenge.Challenge.Alkemy.repository.NewsRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public News bringById(long id) {
        return newsRepository.findById(id);
    }

    @Transactional
    public void delete(long id) {
        boolean exists = newsRepository.existsById(id);
        if (exists) {
            newsRepository.deleteById(id);
        } else {
            throw new IllegalStateException("El id " + id + "que buscas no existe");
        }
    }
}
