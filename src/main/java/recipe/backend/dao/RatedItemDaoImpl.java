package recipe.backend.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import recipe.backend.entity.RatedItem;
import recipe.backend.repository.RatedItemRepository;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class RatedItemDaoImpl implements RatedItemDao{
    final RatedItemRepository ratedItemRepository;

    @Override
    public Page<RatedItem> getRatedItem(Integer pageSize, Integer page) {
        return ratedItemRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public RatedItem getRatedItem(Long id) {
        return ratedItemRepository.findById(id).orElse(null);
    }

    @Override
    public RatedItem save(RatedItem ratedItem) {
        return ratedItemRepository.save(ratedItem);
    }

}
